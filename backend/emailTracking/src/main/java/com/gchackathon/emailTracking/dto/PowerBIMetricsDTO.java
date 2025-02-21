package com.gchackathon.emailTracking.dto;
import com.gchackathon.emailTracking.models.QueryCategoryDistributionDTO;
import com.gchackathon.emailTracking.models.QueryResolutionRateDTO;
import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PowerBIMetricsDTO {
    private List<ResolutionTrendDTO> resolutionTrend;
    private List<EscalationTrendDTO> escalationTrends;
    private  List<QueryTypeDTO> queryTypes;
    List<QueryCategoryDistributionDTO> queryCategoryDistributionDTOS;
    List<QueryResolutionRateDTO> queryResolutionRateDTOS;
    List<SLAComplianceRateDTO> slaComplianceRateDTOS;
    List<TeamPerformanceDTO> teamPerformance;
}
