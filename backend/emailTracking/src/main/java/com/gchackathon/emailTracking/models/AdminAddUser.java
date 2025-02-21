package com.gchackathon.emailTracking.models;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AdminAddUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "assignedSMEName_id")
    private AdminAddSme assignedSMEName;
}
