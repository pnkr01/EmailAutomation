package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.models.EmailThread;

import java.util.List;

public interface EmailThreadService {
    EmailThread saveEmailThread(EmailThread emailThread);
    List<EmailThread> getThreadsByEmailId(Long emailId);
}