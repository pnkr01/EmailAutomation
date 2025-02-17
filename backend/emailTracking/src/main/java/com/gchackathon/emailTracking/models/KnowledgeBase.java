package com.gchackathon.emailTracking.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class KnowledgeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keywords;

    private boolean visibility;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "approved_by_id")
    private User approvedBy;

    @Column(columnDefinition = "TEXT")
    private String solutionText;

    private LocalDateTime publishedDate;

    private int likeCount;

    private int dislikeCount;

    @ElementCollection
    private List<String> kbKeywords;

    public KnowledgeBase() {
    }

    public KnowledgeBase(Long id, String keywords, boolean visibility, User owner, User approvedBy, String solutionText, LocalDateTime publishedDate, int likeCount, int dislikeCount, List<String> kbKeywords) {
        this.id = id;
        this.keywords = keywords;
        this.visibility = visibility;
        this.owner = owner;
        this.approvedBy = approvedBy;
        this.solutionText = solutionText;
        this.publishedDate = publishedDate;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.kbKeywords = kbKeywords;
    }

    public Long getId() {
        return id;
    }

    public String getKeywords() {
        return keywords;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public User getOwner() {
        return owner;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public String getSolutionText() {
        return solutionText;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public List<String> getKbKeywords() {
        return kbKeywords;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setSolutionText(String solutionText) {
        this.solutionText = solutionText;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public void setKbKeywords(List<String> kbKeywords) {
        this.kbKeywords = kbKeywords;
    }

    @Override
    public String toString() {
        return "KnowledgeBase{" +
                "id=" + id +
                ", keywords='" + keywords + '\'' +
                ", visibility=" + visibility +
                ", owner=" + owner +
                ", approvedBy=" + approvedBy +
                ", solutionText='" + solutionText + '\'' +
                ", publishedDate=" + publishedDate +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", kbKeywords=" + kbKeywords +
                '}';
    }
}
