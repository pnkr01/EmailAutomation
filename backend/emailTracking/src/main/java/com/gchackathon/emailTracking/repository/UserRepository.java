package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}