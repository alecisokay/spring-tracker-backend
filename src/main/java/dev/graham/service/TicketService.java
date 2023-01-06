package dev.graham.service;

import dev.graham.entities.Tickets;

import java.util.List;

public interface TicketService {

    List<Tickets> getAllPendingTickets(String status);

    Tickets getTicketById(int id);
    Tickets createTicket(Tickets ticket);


    Tickets decideTicket(Tickets ticket);
}
