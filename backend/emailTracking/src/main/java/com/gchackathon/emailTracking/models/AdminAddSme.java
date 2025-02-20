package com.gchackathon.emailTracking.models;

import com.gchackathon.emailTracking.enums.Role;
import com.gchackathon.emailTracking.enums.SmeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminAddSme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    private String email;
    private SmeRole role;

    public AdminAddSme() {
    }

    public AdminAddSme(String name, String email, SmeRole role) {
        this.aid = aid;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SmeRole getRole() {
        return role;
    }

    public void setRole(SmeRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AdminAddSme{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
