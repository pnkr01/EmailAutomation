package com.gchackathon.emailTracking.dto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryTypeDTO {
    private String category;
    private long count;
}