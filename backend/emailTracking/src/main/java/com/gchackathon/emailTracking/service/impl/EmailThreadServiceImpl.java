package com.gchackathon.emailTracking.service.impl;

import com.gchackathon.emailTracking.models.EmailThread;
import com.gchackathon.emailTracking.repository.EmailThreadRepository;
import com.gchackathon.emailTracking.service.EmailThreadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailThreadServiceImpl implements EmailThreadService {

    private final EmailThreadRepository emailThreadRepository;

    public EmailThreadServiceImpl(EmailThreadRepository emailThreadRepository) {
        this.emailThreadRepository = emailThreadRepository;
    }

    @Override
    public EmailThread saveEmailThread(EmailThread emailThread) {
        return emailThreadRepository.save(emailThread);
    }

    @Override
    public List<EmailThread> getThreadsByEmailId(Long emailId) {
        return emailThreadRepository.findByEmailId(emailId);
    }
}
