package com.gchackathon.emailTracking.models;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryResolutionRateDTO {
    private String date;
    private Double resolutionRate;

}