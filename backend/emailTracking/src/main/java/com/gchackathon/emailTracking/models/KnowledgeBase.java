package com.gchackathon.emailTracking.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
