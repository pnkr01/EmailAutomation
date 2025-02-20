package com.gchackathon.emailTracking.dto;

import lombok.*;


public class ResolutionTrendDTO {
    private String date;
    private int resolvedQueries;

    public ResolutionTrendDTO() {

    }

    public ResolutionTrendDTO(String date, int resolvedQueries) {
        this.date = date;
        this.resolvedQueries = resolvedQueries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getResolvedQueries() {
        return resolvedQueries;
    }

    public void setResolvedQueries(int resolvedQueries) {
        this.resolvedQueries = resolvedQueries;
    }

    @Override
    public String toString() {
        return "ResolutionTrendDTO{" +
                "date='" + date + '\'' +
                ", resolvedQueries=" + resolvedQueries +
                '}';
    }
}