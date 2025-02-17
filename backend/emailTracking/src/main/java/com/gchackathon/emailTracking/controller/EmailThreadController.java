package com.gchackathon.emailTracking.controller;
import com.gchackathon.emailTracking.models.EmailThread;
import com.gchackathon.emailTracking.service.EmailThreadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email-threads")
public class EmailThreadController {

    private final EmailThreadService emailThreadService;

    public EmailThreadController(EmailThreadService emailThreadService) {
        this.emailThreadService = emailThreadService;
    }

    @PostMapping
    public ResponseEntity<EmailThread> saveEmailThread(@RequestBody EmailThread emailThread) {
        return ResponseEntity.ok(emailThreadService.saveEmailThread(emailThread));
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<List<EmailThread>> getThreadsByEmail(@PathVariable Long emailId) {
        return ResponseEntity.ok(emailThreadService.getThreadsByEmailId(emailId));
    }
}
