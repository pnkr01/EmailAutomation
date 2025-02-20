package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.AdminAddUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminAddUser, Long> {
}
