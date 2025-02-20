package com.gchackathon.emailTracking.dto;

import java.time.LocalDateTime;

public class IndividualPerformanceDTO {
    private String teamMember;
    private long queriesSolved;
    private long slaMet;
    private double avgResponseTime;
    private long escalations;
    private LocalDateTime escalatedTime;
    private LocalDateTime escalatedTime2;
    private long ll;

    public IndividualPerformanceDTO(String teamMember, long queriesSolved, long slaMet, double avgResponseTime, long escalations) {
        this.teamMember = teamMember;
        this.queriesSolved = queriesSolved;
        this.slaMet = slaMet;
        this.avgResponseTime = avgResponseTime;
        this.escalations = escalations;
    }

    public IndividualPerformanceDTO(String teamMember, long queriesSolved, long slaMet, LocalDateTime localDateTime, LocalDateTime localDateTime1, long l) {
        this.teamMember = teamMember;
        this.queriesSolved = queriesSolved;
        this.slaMet = slaMet;
        this.escalatedTime = localDateTime;
        this.escalatedTime2 = localDateTime1;
        this.ll = l;
    }

    public void setQueriesSolved(long queriesSolved) {
        this.queriesSolved = queriesSolved;
    }

    public void setSlaMet(long slaMet) {
        this.slaMet = slaMet;
    }

    public void setEscalations(long escalations) {
        this.escalations = escalations;
    }

    public LocalDateTime getEscalatedTime() {
        return escalatedTime;
    }

    public void setEscalatedTime(LocalDateTime escalatedTime) {
        this.escalatedTime = escalatedTime;
    }

    public LocalDateTime getEscalatedTime2() {
        return escalatedTime2;
    }

    public void setEscalatedTime2(LocalDateTime escalatedTime2) {
        this.escalatedTime2 = escalatedTime2;
    }

    public long getLl() {
        return ll;
    }

    public void setLl(long ll) {
        this.ll = ll;
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