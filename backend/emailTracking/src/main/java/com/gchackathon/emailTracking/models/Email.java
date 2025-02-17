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

    public Email(Long id, @NonNull String subject, String body, String sender, LocalDateTime receivedAt, Priority priority, @NonNull String keywords, TeamKeyword assignedTeam, User assignedUser, TicketStatus status, KnowledgeBase usedKbId, LocalDateTime escalatedTime, List<EmailThread> emailThreads, User escalatedToUser) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.receivedAt = receivedAt;
        this.priority = priority;
        this.keywords = keywords;
        this.assignedTeam = assignedTeam;
        this.assignedUser = assignedUser;
        this.status = status;
        this.usedKbId = usedKbId;
        this.escalatedTime = escalatedTime;
        this.emailThreads = emailThreads;
        this.escalatedToUser = escalatedToUser;
    }

    public void setUsedKbId(KnowledgeBase usedKbId) {
        this.usedKbId = usedKbId;
    }

    public void setEscalatedTime(LocalDateTime escalatedTime) {
        this.escalatedTime = escalatedTime;
    }

    public void setEscalatedToUser(User escalatedToUser) {
        this.escalatedToUser = escalatedToUser;
    }

    public KnowledgeBase getUsedKbId() {
        return usedKbId;
    }

    public LocalDateTime getEscalatedTime() {
        return escalatedTime;
    }

    public User getEscalatedToUser() {
        return escalatedToUser;
    }

    public Email() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(@NonNull String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setKeywords(@NonNull String keywords) {
        this.keywords = keywords;
    }

    public void setAssignedTeam(TeamKeyword assignedTeam) {
        this.assignedTeam = assignedTeam;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setEmailThreads(List<EmailThread> emailThreads) {
        this.emailThreads = emailThreads;
    }

    public Long getId() {
        return id;
    }

    public @NonNull String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public @NonNull String getKeywords() {
        return keywords;
    }

    public TeamKeyword getAssignedTeam() {
        return assignedTeam;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public List<EmailThread> getEmailThreads() {
        return emailThreads;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", sender='" + sender + '\'' +
                ", receivedAt=" + receivedAt +
                ", priority=" + priority +
                ", keywords='" + keywords + '\'' +
                ", assignedTeam=" + assignedTeam +
                ", assignedUser=" + assignedUser +
                ", status=" + status +
                ", usedKbId=" + usedKbId +
                ", escalatedTime=" + escalatedTime +
                ", emailThreads=" + emailThreads +
                ", escalatedToUser=" + escalatedToUser +
                '}';
    }
}
