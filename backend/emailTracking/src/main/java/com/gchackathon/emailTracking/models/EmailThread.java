package com.gchackathon.emailTracking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
public class EmailThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String sender;

    private LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;

    public EmailThread() {
    }

    public EmailThread(Long id, String message, String sender, LocalDateTime timestamp, Email email) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.timestamp = timestamp;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EmailThread{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                ", timestamp=" + timestamp +
                ", email=" + email +
                '}';
    }
}
