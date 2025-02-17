package com.gchackathon.emailTracking.models;
import com.gchackathon.emailTracking.enums.Priority;
import com.gchackathon.emailTracking.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
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

    public Ticket(Long id, Email email, User assignedUser, Priority ticketPriority, int usedKbId, String comment, TicketStatus status, User escalatedToUser, LocalDateTime escalatedTime, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.assignedUser = assignedUser;
        this.ticketPriority = ticketPriority;
        this.usedKbId = usedKbId;
        this.comment = comment;
        this.status = status;
        this.escalatedToUser = escalatedToUser;
        this.escalatedTime = escalatedTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Ticket() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setTicketPriority(Priority ticketPriority) {
        this.ticketPriority = ticketPriority;
    }

    public void setUsedKbId(int usedKbId) {
        this.usedKbId = usedKbId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setEscalatedToUser(User escalatedToUser) {
        this.escalatedToUser = escalatedToUser;
    }

    public void setEscalatedTime(LocalDateTime escalatedTime) {
        this.escalatedTime = escalatedTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public Priority getTicketPriority() {
        return ticketPriority;
    }

    public int getUsedKbId() {
        return usedKbId;
    }

    public String getComment() {
        return comment;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public User getEscalatedToUser() {
        return escalatedToUser;
    }

    public LocalDateTime getEscalatedTime() {
        return escalatedTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", email=" + email +
                ", assignedUser=" + assignedUser +
                ", ticketPriority=" + ticketPriority +
                ", usedKbId=" + usedKbId +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                ", escalatedToUser=" + escalatedToUser +
                ", escalatedTime=" + escalatedTime +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
