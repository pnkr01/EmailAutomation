package com.gchackathon.emailTracking.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String sender;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;
}
