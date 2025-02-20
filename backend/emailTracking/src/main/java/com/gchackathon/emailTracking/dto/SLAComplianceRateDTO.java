package com.gchackathon.emailTracking.dto;
import lombok.*;

public class SLAComplianceRateDTO {
    private String date;
    private int complianceRate;

    public SLAComplianceRateDTO() {

    }

    public SLAComplianceRateDTO(String date, int complianceRate) {
        this.date = date;
        this.complianceRate = complianceRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getComplianceRate() {
        return complianceRate;
    }

    public void setComplianceRate(int complianceRate) {
        this.complianceRate = complianceRate;
    }

    @Override
    public String toString() {
        return "SLAComplianceRateDTO{" +
                "date='" + date + '\'' +
                ", complianceRate=" + complianceRate +
                '}';
    }
}