package com.gchackathon.emailTracking.repository;

import com.gchackathon.emailTracking.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByAssignedUserId(long userId);
    @Query("SELECT e from Email e where e.assignedUser.email = :email")
    List<Email> findByAssignedUserEmail(String email);

}
