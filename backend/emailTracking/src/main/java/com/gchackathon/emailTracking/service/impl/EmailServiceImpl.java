package com.gchackathon.emailTracking.service.impl;

import com.gchackathon.emailTracking.models.Email;
import com.gchackathon.emailTracking.models.EmailThread;
import com.gchackathon.emailTracking.repository.EmailRepository;
import com.gchackathon.emailTracking.repository.EmailThreadRepository;
import com.gchackathon.emailTracking.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final EmailRepository emailRepository;
    private final EmailThreadRepository emailThreadRepository;

    public EmailServiceImpl(EmailRepository emailRepository, EmailThreadRepository emailThreadRepository) {
        this.emailRepository = emailRepository;
        this.emailThreadRepository = emailThreadRepository;
    }

    @Override
    public Email saveEmail(Email email) {
        if (email.getEmailThreads() != null) {
            for (EmailThread thread : email.getEmailThreads()) {
                if (thread.getId() == null) {
                    thread.setEmail(email);
                    emailThreadRepository.save(thread);
                }
            }
        }
        return emailRepository.save(email);
    }

    @Override
    public Email getEmailById(Long id) {
        return emailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}