package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
