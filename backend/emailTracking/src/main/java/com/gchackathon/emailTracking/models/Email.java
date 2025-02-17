package com.gchackathon.emailTracking.models;
import com.gchackathon.emailTracking.enums.Priority;
import com.gchackathon.emailTracking.enums.TeamKeyword;
import com.gchackathon.emailTracking.enums.TicketStatus;
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
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String sender;

    private LocalDateTime receivedAt;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String keywords;

    @Enumerated(EnumType.STRING)
    private TeamKeyword assignedTeam;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmailThread> emailThreads;
}
