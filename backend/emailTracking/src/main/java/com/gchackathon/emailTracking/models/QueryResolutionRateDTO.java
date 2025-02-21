package com.gchackathon.emailTracking.models;

public class QueryResolutionRateDTO {
    private String date;
    private Double resolutionRate;

    public QueryResolutionRateDTO() {
    }

    public QueryResolutionRateDTO(String date, Double resolutionRate) {
        this.date = date;
        this.resolutionRate = resolutionRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getResolutionRate() {
        return resolutionRate;
    }

    public void setResolutionRate(Double resolutionRate) {
        this.resolutionRate = resolutionRate;
    }
}