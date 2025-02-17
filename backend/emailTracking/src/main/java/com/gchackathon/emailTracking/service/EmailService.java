package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.models.Email;

import java.util.List;

public interface EmailService {
    Email saveEmail(Email email);
    Email getEmailById(Long id);
    List<Email> getAllEmails();
    void deleteEmail(Long id);
    List<Email> findByAssignedUserId(Long id);
    List<Email> findByAssignedUserEmail(String email);
}