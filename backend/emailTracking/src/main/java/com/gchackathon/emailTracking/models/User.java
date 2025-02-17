package com.gchackathon.emailTracking.models;

import com.gchackathon.emailTracking.enums.Role;
import com.gchackathon.emailTracking.enums.TeamKeyword;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    public User() {
    }

    public User(Long id, String name, String gender, String email, Role role, TeamKeyword team, boolean isAvailable, int currentTickets, LocalDateTime shiftStart, LocalDateTime shiftEnd) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.team = team;
        this.isAvailable = isAvailable;
        this.currentTickets = currentTickets;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private TeamKeyword team;

    private boolean isAvailable;

    private int currentTickets;

    private LocalDateTime shiftStart;

    private LocalDateTime shiftEnd;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public TeamKeyword getTeam() {
        return team;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCurrentTickets() {
        return currentTickets;
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public LocalDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setTeam(TeamKeyword team) {
        this.team = team;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCurrentTickets(int currentTickets) {
        this.currentTickets = currentTickets;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public void setShiftEnd(LocalDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", team=" + team +
                ", isAvailable=" + isAvailable +
                ", currentTickets=" + currentTickets +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                '}';
    }
}
