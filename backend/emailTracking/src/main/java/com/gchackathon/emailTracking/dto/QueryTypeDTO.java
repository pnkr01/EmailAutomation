package com.gchackathon.emailTracking.dto;
import lombok.*;

public class QueryTypeDTO {
    private String category;
    private long count;

    public QueryTypeDTO() {
    }

    public QueryTypeDTO(String category, long count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "QueryTypeDTO{" +
                "category='" + category + '\'' +
                ", count=" + count +
                '}';
    }
}