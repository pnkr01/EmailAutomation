package com.gchackathon.emailTracking.dto;
import lombok.*;
import java.util.List;


public class PowerBIMetricsDTO {
    private List<QueryPriorityDTO> queriesByPriority;
//    private List<IndividualPerformanceDTO> individualPerformance;
    private List<QueryTypeDTO> queryTypes;
//    private List<TeamPerformanceDTO> teamPerformance;
    private List<EscalationTrendDTO> escalationTrend;
//    private List<SLAComplianceRateDTO> slaComplianceRate;
    private List<ResolutionTrendDTO> resolutionTrend;

    public List<QueryPriorityDTO> getQueriesByPriority() {
        return queriesByPriority;
    }

    public void setQueriesByPriority(List<QueryPriorityDTO> queriesByPriority) {
        this.queriesByPriority = queriesByPriority;
    }

//    public List<IndividualPerformanceDTO> getIndividualPerformance() {
//        return individualPerformance;
//    }
//
//    public void setIndividualPerformance(List<IndividualPerformanceDTO> individualPerformance) {
//        this.individualPerformance = individualPerformance;
//    }

    public List<QueryTypeDTO> getQueryTypes() {
        return queryTypes;
    }

    public void setQueryTypes(List<QueryTypeDTO> queryTypes) {
        this.queryTypes = queryTypes;
    }

//    public List<TeamPerformanceDTO> getTeamPerformance() {
//        return teamPerformance;
//    }
//
//    public void setTeamPerformance(List<TeamPerformanceDTO> teamPerformance) {
//        this.teamPerformance = teamPerformance;
//    }

    public List<EscalationTrendDTO> getEscalationTrend() {
        return escalationTrend;
    }

    public void setEscalationTrend(List<EscalationTrendDTO> escalationTrend) {
        this.escalationTrend = escalationTrend;
    }

//    public List<SLAComplianceRateDTO> getSlaComplianceRate() {
//        return slaComplianceRate;
//    }
//
//    public void setSlaComplianceRate(List<SLAComplianceRateDTO> slaComplianceRate) {
//        this.slaComplianceRate = slaComplianceRate;
//    }

    public List<ResolutionTrendDTO> getResolutionTrend() {
        return resolutionTrend;
    }

    public void setResolutionTrend(List<ResolutionTrendDTO> resolutionTrend) {
        this.resolutionTrend = resolutionTrend;
    }

    public PowerBIMetricsDTO(List<QueryPriorityDTO> queriesByPriority,
//                             List<IndividualPerformanceDTO> individualPerformance,
                             List<QueryTypeDTO> queryTypes,
                             List<EscalationTrendDTO> escalationTrend,
                             List<ResolutionTrendDTO> resolutionTrend) {
        this.queriesByPriority = queriesByPriority;
//        this.individualPerformance = individualPerformance;
        this.queryTypes = queryTypes;
//        this.teamPerformance = teamPerformance;
        this.escalationTrend = escalationTrend;
//        this.slaComplianceRate = slaComplianceRate;
        this.resolutionTrend = resolutionTrend;
    }

    public PowerBIMetricsDTO() {
    }

}
