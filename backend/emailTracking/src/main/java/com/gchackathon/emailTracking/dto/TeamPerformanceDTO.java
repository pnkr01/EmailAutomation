//package com.gchackathon.emailTracking.dto;
//import lombok.*;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class TeamPerformanceDTO {
//    private String teamMember;
//    private int resolvedQueries;
//    private int missedSla;
//    private double avgResponseTime;
//
//    public TeamPerformanceDTO(String teamMember, int resolvedQueries, int missedSla, double avgResponseTime) {
//        this.teamMember = teamMember;
//        this.resolvedQueries = resolvedQueries;
//        this.missedSla = missedSla;
//        this.avgResponseTime = avgResponseTime;
//    }
//
//    public TeamPerformanceDTO() {
//    }
//
//    public String getTeamMember() {
//        return teamMember;
//    }
//
//    public void setTeamMember(String teamMember) {
//        this.teamMember = teamMember;
//    }
//
//    public int getResolvedQueries() {
//        return resolvedQueries;
//    }
//
//    public void setResolvedQueries(int resolvedQueries) {
//        this.resolvedQueries = resolvedQueries;
//    }
//
//    public int getMissedSla() {
//        return missedSla;
//    }
//
//    public void setMissedSla(int missedSla) {
//        this.missedSla = missedSla;
//    }
//
//    public double getAvgResponseTime() {
//        return avgResponseTime;
//    }
//
//    public void setAvgResponseTime(double avgResponseTime) {
//        this.avgResponseTime = avgResponseTime;
//    }
//
//    @Override
//    public String toString() {
//        return "TeamPerformanceDTO{" +
//                "teamMember='" + teamMember + '\'' +
//                ", resolvedQueries=" + resolvedQueries +
//                ", missedSla=" + missedSla +
//                ", avgResponseTime=" + avgResponseTime +
//                '}';
//    }
//}