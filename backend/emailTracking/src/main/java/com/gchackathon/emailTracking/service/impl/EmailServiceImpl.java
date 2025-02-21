package com.gchackathon.emailTracking.service.impl;
import com.gchackathon.emailTracking.dto.*;
import com.gchackathon.emailTracking.enums.TicketStatus;
import com.gchackathon.emailTracking.models.Email;
import com.gchackathon.emailTracking.models.EmailThread;
import com.gchackathon.emailTracking.models.QueryCategoryDistributionDTO;
import com.gchackathon.emailTracking.models.QueryResolutionRateDTO;
import com.gchackathon.emailTracking.repository.EmailRepository;
import com.gchackathon.emailTracking.repository.EmailThreadRepository;
import com.gchackathon.emailTracking.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {
    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final EmailRepository emailRepository;
    private final EmailThreadRepository emailThreadRepository;

    public EmailServiceImpl(EmailRepository emailRepository, EmailThreadRepository emailThreadRepository) {
        this.emailRepository = emailRepository;
        this.emailThreadRepository = emailThreadRepository;
    }

    @Override
    public Email saveEmail(Email email) {
        if (email.getEmailThreads() != null) {
            for (EmailThread thread : email.getEmailThreads()) {
                if (thread.getId() == null) {
                    thread.setEmail(email);
                    emailThreadRepository.save(thread);
                }
            }
        }
        return emailRepository.save(email);
    }

    @Override
    public Email getEmailById(Long id) {
        return emailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }

    @Override
    public List<Email> findByAssignedUserId(Long id) {
      return emailRepository.findByAssignedUserId(id);
    }

    @Override
    public List<Email> findByAssignedUserEmail(String email) {
        return List.of();
    }

//    @Override
//    public double getQueryResolutionRate() {
//        long solvedCount = emailRepository.getSolvedQueries().size();
//        long totalCount = emailRepository.getTotalQueryCount();
//
//        if (totalCount == 0) {
//            return 0.0; // Avoid division by zero
//        }
//
//        return (double) solvedCount / totalCount * 100;
//    }

    public double getAverageResponseTime() {
        List<Email> emails = emailRepository.findAll();

        long totalResponseTime = 0;
        int count = 0;

        for (Email email : emails) {
            if (email.getEscalatedTime() != null && email.getReceivedAt() != null) {
                Duration duration = Duration.between(email.getReceivedAt(), email.getEscalatedTime());
                totalResponseTime += duration.toHours();
                count++;
            }
        }

        return count == 0 ? 0.0 : (double) totalResponseTime / count;
    }

    public PowerBIMetricsDTO powerBIMetricsDTO(long id){

//        List<IndividualPerformanceDTO> teamPerformance = emailRepository.getTeamPerformance().stream()
//                .map(row -> new IndividualPerformanceDTO(
//                        (String) row[0],  // assignedUser.name
//                        ((Number) row[1]).longValue(),  // COUNT(e) -> Long
//                        ((Number) row[2]).longValue(),  // SUM() -> Long
//                        (LocalDateTime) row[3],  // receivedAt -> LocalDateTime
//                        (LocalDateTime) row[4],  // escalatedTime -> LocalDateTime
//                        ((Number) row[5]).longValue()   // SUM() -> Long
//                ))
//                .collect(Collectors.toList());
//        return teamPerformance;


        List<ResolutionTrendDTO> resolutionTrends = emailRepository.getQueryResolutionTrend()
                .stream()
                .map(row -> {
                    System.out.println(row);
                   return new ResolutionTrendDTO(row[0].toString(), ((Number) row[1]).intValue());
                })
                .collect(Collectors.toList());
//
//        System.out.println(resolutionTrends);
//
//
//        return  resolutionTrends;


        List<EscalationTrendDTO> escalationTrends = emailRepository.getEscalationTrendsLast7Days().stream()
                .map(row -> new EscalationTrendDTO(row[0].toString(), ((Number) row[1]).intValue()))
                .collect(Collectors.toList());

        List<QueryTypeDTO> queryTypes = emailRepository.getCommonQueryTypes().stream()
                .map(row -> new QueryTypeDTO((String) row[0], (long)row[1]))
                .collect(Collectors.toList());

        List<Object[]> results = emailRepository.getCategoryDistribution();
        List<QueryCategoryDistributionDTO> queryCategoryDistributionDTOS = results.stream()
                .map(obj -> new QueryCategoryDistributionDTO((String) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());

        List<Object[]> resolutionRate = emailRepository.getQueryResolutionRate();
        List<QueryResolutionRateDTO> queryResolutionRateDTOS = resolutionRate.stream()
                .map(obj -> new QueryResolutionRateDTO(obj[0].toString(), ((Number) obj[1]).doubleValue()))
                .collect(Collectors.toList());

        List<Object[]> slaComplianceRate = emailRepository.getSLAComplianceRate();
        List<SLAComplianceRateDTO> slaComplianceRateDTOS = slaComplianceRate.stream()
                .map(obj -> new SLAComplianceRateDTO(obj[0].toString(), ((Number) obj[1]).doubleValue()))
                .collect(Collectors.toList());

        List<TeamPerformanceDTO> teamPerformance = getTeamPerformance(emailRepository.getEmailData(id));

        return new PowerBIMetricsDTO(resolutionTrends,escalationTrends,queryTypes,queryCategoryDistributionDTOS,queryResolutionRateDTOS, slaComplianceRateDTOS,teamPerformance);
    }


    public List<TeamPerformanceDTO> getTeamPerformance(List<Object[]> data) {
        Map<String, TeamPerformanceDTO> teamPerformanceMap = new HashMap<>();

        //missed resp time , solved resp time

        for (Object[] row : data) {
            String teamMember = (String) row[0]; // Name from the first row
            LocalDateTime receivedAt = (LocalDateTime) row[1];
            LocalDateTime lastUpdatedAt = (LocalDateTime) row[2]; // Updated timestamp
            LocalDateTime solvedAt = (LocalDateTime) row[3];

            TicketStatus status;
            if (row[3] instanceof TicketStatus) {
                status = (TicketStatus) row[4]; // Already an enum, cast directly
            } else {
                status = TicketStatus.valueOf(row[4].toString()); // Convert from String if needed
            }// Ticket status (Solved, Closed, Escalated, etc.)
            boolean isEscalated = status == TicketStatus.ESCALATED;
            boolean isSolved = status == TicketStatus.SOLVED;

            teamPerformanceMap.putIfAbsent(teamMember, new TeamPerformanceDTO(teamMember));
            TeamPerformanceDTO dto = teamPerformanceMap.get(teamMember);
            dto.setTeamMember(teamMember);

            if (status == TicketStatus.SOLVED) {
                dto.incrementResolvedQueries();
            }

            System.out.println(receivedAt);
            System.out.println("lastUpdatedAt"+lastUpdatedAt);
            if(isSolved){
                long solvedResponseTime = ChronoUnit.HOURS.between(receivedAt, solvedAt);
                dto.addSolvedTime(solvedResponseTime);
            }else{
                if(isPast24Hr(receivedAt,lastUpdatedAt)){
                    long responseTime = ChronoUnit.HOURS.between(receivedAt, lastUpdatedAt);
                    dto.addMissedTime(responseTime);
                }
            }

            if (status != TicketStatus.CLOSED && !isEscalated && isPast24Hr(receivedAt,lastUpdatedAt)) {
                dto.incrementMissedSla();
            }
        }

        for (TeamPerformanceDTO dto : teamPerformanceMap.values()) {
            dto.setMissedResponseRatePerQuery(dto.missedResponseRatePerQuery());
            dto.setSolvedResponseRatePerQuery(dto.solvedResponseRatePerQuery());
        }


        return new ArrayList<>(teamPerformanceMap.values());

    }


    public boolean isPast24Hr(LocalDateTime receivedAt, LocalDateTime solvedAt){
        return ChronoUnit.HOURS.between(receivedAt, solvedAt) >=24;
    }
}