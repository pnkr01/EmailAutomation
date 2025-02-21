package com.gchackathon.emailTracking.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeamPerformanceDTO {
    private String teamMember;
    private int resolvedQueries = 0;
    private int missedSla = 0;
    private double missedResponseTime = 0;
    private double solvedResponseTime = 0;
    private double missedResponseRatePerQuery = 0;
    private double solvedResponseRatePerQuery = 0;


    public  TeamPerformanceDTO(String teamMember){}
    public void incrementResolvedQueries() {
        this.resolvedQueries++;
    }

    public void addSolvedTime(long solvedResponseTime) {
        this.solvedResponseTime += solvedResponseTime;
    }

    public void addMissedTime(long missedResponseTime) {
        this.missedResponseTime += missedResponseTime;
    }

    public void incrementMissedSla() {
        this.missedSla++;
    }

    public  double missedResponseRatePerQuery(){
        return missedResponseTime/missedSla;
    }

    public double solvedResponseRatePerQuery() {
       return solvedResponseTime/resolvedQueries;
    }
}
