package com.gchackathon.emailTracking.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResolutionTrendDTO {
    private String date;
    private int resolvedQueries;
}