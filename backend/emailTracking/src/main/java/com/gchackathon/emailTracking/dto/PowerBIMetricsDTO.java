package com.gchackathon.emailTracking.dto;
import com.gchackathon.emailTracking.models.QueryCategoryDistributionDTO;
import com.gchackathon.emailTracking.models.QueryResolutionRateDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class PowerBIMetricsDTO {
    private List<ResolutionTrendDTO> resolutionTrend;
    private List<EscalationTrendDTO> escalationTrends;
    private  List<QueryTypeDTO> queryTypes;
    List<QueryCategoryDistributionDTO> queryCategoryDistributionDTOS;
    List<QueryResolutionRateDTO> queryResolutionRateDTOS;
    List<SLAComplianceRateDTO> slaComplianceRateDTOS;
    List<TeamPerformanceDTO> teamPerformance;

    public PowerBIMetricsDTO(List<ResolutionTrendDTO> resolutionTrend, List<EscalationTrendDTO> escalationTrends, List<QueryTypeDTO> queryTypes,List<QueryCategoryDistributionDTO> queryCategoryDistributionDTOS,  List<QueryResolutionRateDTO> queryResolutionRateDTOS,List<SLAComplianceRateDTO> slaComplianceRateDTOS, List<TeamPerformanceDTO> teamPerformance) {
        this.resolutionTrend = resolutionTrend;
        this.escalationTrends = escalationTrends;
        this.queryTypes = queryTypes;
        this.queryCategoryDistributionDTOS = queryCategoryDistributionDTOS;
        this.queryResolutionRateDTOS = queryResolutionRateDTOS;
        this.slaComplianceRateDTOS = slaComplianceRateDTOS;
        this.teamPerformance = teamPerformance;
    }

    public PowerBIMetricsDTO() {
    }


    public List<TeamPerformanceDTO> getTeamPerformance() {
        return teamPerformance;
    }

    public void setTeamPerformance(List<TeamPerformanceDTO> teamPerformance) {
        this.teamPerformance = teamPerformance;
    }

    public List<SLAComplianceRateDTO> getSlaComplianceRateDTOS() {
        return slaComplianceRateDTOS;
    }

    public void setSlaComplianceRateDTOS(List<SLAComplianceRateDTO> slaComplianceRateDTOS) {
        this.slaComplianceRateDTOS = slaComplianceRateDTOS;
    }

    public List<QueryResolutionRateDTO> getQueryResolutionRateDTOS() {
        return queryResolutionRateDTOS;
    }

    public void setQueryResolutionRateDTOS(List<QueryResolutionRateDTO> queryResolutionRateDTOS) {
        this.queryResolutionRateDTOS = queryResolutionRateDTOS;
    }

    public List<ResolutionTrendDTO> getResolutionTrend() {
        return resolutionTrend;
    }

    public void setResolutionTrend(List<ResolutionTrendDTO> resolutionTrend) {
        this.resolutionTrend = resolutionTrend;
    }

    public List<EscalationTrendDTO> getEscalationTrends() {
        return escalationTrends;
    }

    public void setEscalationTrends(List<EscalationTrendDTO> escalationTrends) {
        this.escalationTrends = escalationTrends;
    }

    public List<QueryTypeDTO> getQueryTypes() {
        return queryTypes;
    }

    public void setQueryTypes(List<QueryTypeDTO> queryTypes) {
        this.queryTypes = queryTypes;
    }

    public List<QueryCategoryDistributionDTO> getQueryCategoryDistributionDTOS() {
        return queryCategoryDistributionDTOS;
    }

    public void setQueryCategoryDistributionDTOS(List<QueryCategoryDistributionDTO> queryCategoryDistributionDTOS) {
        this.queryCategoryDistributionDTOS = queryCategoryDistributionDTOS;
    }

    @Override
    public String toString() {
        return "PowerBIMetricsDTO{" +
                "resolutionTrend=" + resolutionTrend +
                ", escalationTrends=" + escalationTrends +
                ", queryTypes=" + queryTypes +
                ", queryCategoryDistributionDTOS=" + queryCategoryDistributionDTOS +
                ", queryResolutionRateDTOS=" + queryResolutionRateDTOS +
                ", slaComplianceRateDTOS=" + slaComplianceRateDTOS +
                ", teamPerformance=" + teamPerformance +
                '}';
    }
}
