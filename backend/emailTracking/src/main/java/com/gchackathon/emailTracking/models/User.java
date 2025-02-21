package com.gchackathon.emailTracking.models;

import com.gchackathon.emailTracking.enums.Role;
import com.gchackathon.emailTracking.enums.TeamKeyword;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "assignedSMEName_id")
    private AdminAddSme adminAddSme;

    @Enumerated(EnumType.STRING)
    private TeamKeyword team;

    private boolean isAvailable;

    private int currentTickets;

    private LocalDateTime shiftStart;

    private LocalDateTime shiftEnd;
}
