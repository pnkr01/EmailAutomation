package com.gchackathon.emailTracking.service.impl;
import com.gchackathon.emailTracking.dto.*;
import com.gchackathon.emailTracking.models.Email;
import com.gchackathon.emailTracking.models.EmailThread;
import com.gchackathon.emailTracking.repository.EmailRepository;
import com.gchackathon.emailTracking.repository.EmailThreadRepository;
import com.gchackathon.emailTracking.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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

    public List<IndividualPerformanceDTO> powerBIMetricsDTO(){

        List<IndividualPerformanceDTO> teamPerformance = emailRepository.getTeamPerformance().stream()
                .map(row -> new IndividualPerformanceDTO(
                        (String) row[0],  // assignedUser.name
                        ((Number) row[1]).longValue(),  // COUNT(e) -> Long
                        ((Number) row[2]).longValue(),  // SUM() -> Long
                        (LocalDateTime) row[3],  // receivedAt -> LocalDateTime
                        (LocalDateTime) row[4],  // escalatedTime -> LocalDateTime
                        ((Number) row[5]).longValue()   // SUM() -> Long
                ))
                .collect(Collectors.toList());
        return teamPerformance;



//        return emailRepository.getEscalationTrendsLast7Days().stream()
//                .map(row -> new EscalationTrendDTO(row[0].toString(), ((Number) row[1]).intValue()))
//                .collect(Collectors.toList());

//        List<QueryTypeDTO> queryTypes;
//        queryTypes = emailRepository.getCommonQueryTypes().stream()
//                .map(row -> new QueryTypeDTO((String) row[0], (long)row[1]))
//                .collect(Collectors.toList());
//        return queryTypes;

//

    }



//    @Override
//    public QueryPriorityDTO powerBIMetricsDTO() {
//        List<QueryPriorityDTO> priorityTrends = emailRepository.getPriorityTrends().stream()
//                .map(row -> new QueryPriorityDTO(LocalDate.now().toString(),
//                        ((Priority) row[0] == Priority.P0 ? (int) row[1] : 0),
//                        ((Priority) row[0] == Priority.P4 ? (int) row[1] : 0),
//                        ((Priority) row[0] == Priority.P6 ? (int) row[1] : 0)))
//                .collect(Collectors.toList());
//
//        List<IndividualPerformanceDTO> teamPerformance = emailRepository.getTeamPerformance().stream()
//                .map(row -> new IndividualPerformanceDTO(
//                        (String) row[0], (int) row[1], (int) row[2], (double) row[3], (int) row[4]))
//                .collect(Collectors.toList());
//
//        List<QueryTypeDTO> queryTypes = emailRepository.getCommonQueryTypes().stream()
//                .map(row -> new QueryTypeDTO((String) row[0], (int) row[1]))
//                .collect(Collectors.toList());
//
//        List<EscalationTrendDTO> escalationTrends = emailRepository.getEscalationTrends().stream()
//                .map(row -> new EscalationTrendDTO((String) row[0], (int) row[1]))
//                .collect(Collectors.toList());
//
//        List<ResolutionTrendDTO> resolutionTrends = emailRepository.getResolutionTrends().stream()
//                .map(row -> new ResolutionTrendDTO((String) row[0], (int) row[1]))
//                .collect(Collectors.toList());
//
//        return priorityTrends;
//    }


}