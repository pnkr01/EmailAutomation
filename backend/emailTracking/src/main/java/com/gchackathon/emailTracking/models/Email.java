package com.gchackathon.emailTracking.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gchackathon.emailTracking.enums.Priority;
import com.gchackathon.emailTracking.enums.TeamKeyword;
import com.gchackathon.emailTracking.enums.TicketStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Builder
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String sender;

    private LocalDateTime receivedAt;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NonNull
    private String keywords;

    @Enumerated(EnumType.STRING)
    private TeamKeyword assignedTeam;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "used_kb_id")
    private KnowledgeBase usedKbId;

    @Nullable
    private LocalDateTime escalatedTime;


    @Nullable
    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<EmailThread> emailThreads;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "escalated_to_user_id")
    private User escalatedToUser;

    @Nullable
    private LocalDateTime solvedAt;

    @Nullable
    private LocalDateTime lastUpdatedAt;
}
