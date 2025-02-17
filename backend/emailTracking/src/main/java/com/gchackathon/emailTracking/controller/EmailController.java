package com.gchackathon.emailTracking.controller;
import com.gchackathon.emailTracking.models.Email;
import com.gchackathon.emailTracking.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Email> saveEmail(@RequestBody Email email) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emailService.saveEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        return ResponseEntity.ok(emailService.getEmailById(id));
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
