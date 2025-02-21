package com.gchackathon.emailTracking.controller;
import com.gchackathon.emailTracking.dto.PowerBIMetricsDTO;
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

    @GetMapping("/getbymailid/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        return ResponseEntity.ok(emailService.getEmailById(id));
    }

    @GetMapping("/getallemail")
    public ResponseEntity<List<Email>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @DeleteMapping("/deletemailbyid/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getbyuserid/{id}")
    public ResponseEntity<List<Email>> getEmailByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(emailService.findByAssignedUserId(id));
    }

    @GetMapping("/getbyuseremail/{email}")
    public ResponseEntity<List<Email>> getEmailByEmail(@PathVariable String email) {
        return ResponseEntity.ok(emailService.findByAssignedUserEmail(email));
    }

    @GetMapping("/getQuery")
    public PowerBIMetricsDTO getEmailByQuery(@RequestParam long id) {
       return  emailService.powerBIMetricsDTO(id);
    }

}
