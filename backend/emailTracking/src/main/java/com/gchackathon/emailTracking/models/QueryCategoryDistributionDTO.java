package com.gchackathon.emailTracking.models;

public class QueryCategoryDistributionDTO {
    private String category;
    private Long count;

    public QueryCategoryDistributionDTO(String category, Long count) {
        this.category = category;
        this.count = count;
    }
    public QueryCategoryDistributionDTO(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
