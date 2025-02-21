package com.gchackathon.emailTracking.models;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryCategoryDistributionDTO {
    private String category;
    private Long count;
}
