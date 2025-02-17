package com.gchackathon.emailTracking.service.impl;
import com.gchackathon.emailTracking.models.Ticket;
import com.gchackathon.emailTracking.models.User;
import com.gchackathon.emailTracking.repository.TicketRepository;
import com.gchackathon.emailTracking.repository.UserRepository;
import com.gchackathon.emailTracking.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket assignTicket(Long ticketId, Long userId) {
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (ticketOpt.isPresent() && userOpt.isPresent()) {
            Ticket ticket = ticketOpt.get();
            ticket.setAssignedUser(userOpt.get());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    @Override
    public Ticket escalateTicket(Long ticketId, Long userId) {
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (ticketOpt.isPresent() && userOpt.isPresent()) {
            Ticket ticket = ticketOpt.get();
            ticket.setEscalatedToUser(userOpt.get());
            ticket.setEscalatedTime(java.time.LocalDateTime.now());
            return ticketRepository.save(ticket);
        }
        return null;
    }
}
