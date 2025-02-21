package com.gchackathon.emailTracking.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EscalationTrendDTO {
    private String date;
    private int escalations;
}

