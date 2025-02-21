package com.gchackathon.emailTracking.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryPriorityDTO {
    private String date;
    private int high;
    private int medium;
    private int low;
}