package com.gchackathon.emailTracking.dto;


public class QueryPriorityDTO {
    private String date;
    private int high;
    private int medium;
    private int low;

    public QueryPriorityDTO() {
    }

    public QueryPriorityDTO(String date, int high, int medium, int low) {
        this.date = date;
        this.high = high;
        this.medium = medium;
        this.low = low;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "QueryPriorityDTO{" +
                "date='" + date + '\'' +
                ", high=" + high +
                ", medium=" + medium +
                ", low=" + low +
                '}';
    }
}