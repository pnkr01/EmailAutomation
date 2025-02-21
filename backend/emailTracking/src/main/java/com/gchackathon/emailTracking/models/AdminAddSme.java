package com.gchackathon.emailTracking.models;

import com.gchackathon.emailTracking.enums.Role;
import com.gchackathon.emailTracking.enums.SmeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class AdminAddSme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    private String email;
    private SmeRole role;
}
