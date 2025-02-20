package com.gchackathon.emailTracking.dto;

import lombok.*;

public class EscalationTrendDTO {
    private String date;
    private int escalations;

    public void setDate(String date) {
        this.date = date;
    }

    public void setEscalations(int escalations) {
        this.escalations = escalations;
    }

    public String getDate() {
        return date;
    }

    public int getEscalations() {
        return escalations;
    }

    public EscalationTrendDTO() {
    }

    public EscalationTrendDTO(String date, int escalations) {
        this.date = date;
        this.escalations = escalations;
    }

    @Override
    public String toString() {
        return "EscalationTrendDTO{" +
                "date='" + date + '\'' +
                ", escalations=" + escalations +
                '}';
    }
}

