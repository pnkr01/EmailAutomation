package com.gchackathon.emailTracking.controller;
import com.gchackathon.emailTracking.models.Ticket;
import com.gchackathon.emailTracking.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PutMapping("/{ticketId}/assign/{userId}")
    public ResponseEntity<Ticket> assignTicket(@PathVariable Long ticketId, @PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.assignTicket(ticketId, userId));
    }

    @PutMapping("/{ticketId}/escalate/{userId}")
    public ResponseEntity<Ticket> escalateTicket(@PathVariable Long ticketId, @PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.escalateTicket(ticketId, userId));
    }
}
