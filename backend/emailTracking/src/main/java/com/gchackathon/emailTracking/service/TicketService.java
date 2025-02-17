package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
    Ticket assignTicket(Long ticketId, Long userId);
    Ticket escalateTicket(Long ticketId, Long userId);
}