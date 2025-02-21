package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.AdminAddSme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminAddSme,Integer> {
    AdminAddSme findByEmail(String email);
}
