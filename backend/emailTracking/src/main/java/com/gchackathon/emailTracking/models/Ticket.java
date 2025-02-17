package com.gchackathon.emailTracking.models;
import com.gchackathon.emailTracking.enums.Priority;
import com.gchackathon.emailTracking.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id", nullable = false)
    private User assignedUser;

    @Enumerated(EnumType.STRING)
    private Priority ticketPriority;

    private int usedKbId;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "escalated_to_user_id")
    private User escalatedToUser;

    private LocalDateTime escalatedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
