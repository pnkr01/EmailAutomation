package com.gchackathon.emailTracking.models;

import jakarta.persistence.*;

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


    public AdminAddUser() {
    }

    public AdminAddUser(String name, String email, long assginedSMEId, AdminAddSme assignedSMEName) {
        this.name = name;
        this.email = email;
        this.assignedSMEName = assignedSMEName;
    }

    @Override
    public String toString() {
        return "AdminAddUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", assignedSMEName='" + assignedSMEName + '\'' +
                '}';
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


    public AdminAddSme getAssignedSMEName() {
        return assignedSMEName;
    }

    public void setAssignedSMEName(AdminAddSme assignedSMEName) {
        this.assignedSMEName = assignedSMEName;
    }
}
