package com.gchackathon.emailTracking.repository;
import com.gchackathon.emailTracking.models.EmailThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailThreadRepository extends JpaRepository<EmailThread, Long> {
    List<EmailThread> findByEmailId(Long emailId);
}