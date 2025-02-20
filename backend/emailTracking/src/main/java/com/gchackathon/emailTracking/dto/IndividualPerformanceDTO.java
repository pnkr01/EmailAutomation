package com.gchackathon.emailTracking.dto;

import java.time.LocalDateTime;

public class IndividualPerformanceDTO {
    private String teamMember;
    private long queriesSolved;
    private long slaMet;
    private double avgResponseTime;
    private long escalations;

    public IndividualPerformanceDTO(String teamMember, long queriesSolved, long slaMet, double avgResponseTime, long escalations) {
        this.teamMember = teamMember;
        this.queriesSolved = queriesSolved;
        this.slaMet = slaMet;
        this.avgResponseTime = avgResponseTime;
        this.escalations = escalations;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public long getQueriesSolved() {
        return queriesSolved;
    }

    public void setQueriesSolved(int queriesSolved) {
        this.queriesSolved = queriesSolved;
    }

    public long getSlaMet() {
        return slaMet;
    }

    public void setSlaMet(int slaMet) {
        this.slaMet = slaMet;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }

    public long getEscalations() {
        return escalations;
    }

    public void setEscalations(int escalations) {
        this.escalations = escalations;
    }

    @Override
    public String toString() {
        return "IndividualPerformanceDTO{" +
                "teamMember='" + teamMember + '\'' +
                ", queriesSolved=" + queriesSolved +
                ", slaMet=" + slaMet +
                ", avgResponseTime=" + avgResponseTime +
                ", escalations=" + escalations +
                '}';
    }
}