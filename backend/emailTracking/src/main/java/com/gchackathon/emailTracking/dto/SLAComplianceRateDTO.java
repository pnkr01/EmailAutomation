package com.gchackathon.emailTracking.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SLAComplianceRateDTO {
    private String date;
    private double complianceRate;
}