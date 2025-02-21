package com.gchackathon.emailTracking.dto;

import java.time.LocalDateTime;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IndividualPerformanceDTO {
    private String teamMember;
    private long queriesSolved;
    private long slaMet;
    private double avgResponseTime;
    private long escalations;
    private LocalDateTime escalatedTime;
    private LocalDateTime escalatedTime2;
    private long ll;
}