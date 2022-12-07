package dev.graham.service;

import dev.graham.entities.Tickets;
import dev.graham.entities.Users;
import dev.graham.repos.TicketRepo;
import dev.graham.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    UserRepo userRepo;


    @Override
    public List<Tickets> getAllPendingTickets(String status) {
        List<Tickets> pendingTickets = this.ticketRepo.findAllByStatus("pending");
        return pendingTickets;
    }

    @Override
    public Tickets getTicketById(int id) {
        return null;
    }

    @Override
    public Tickets decideTicket(int ticketId, Boolean decision, int id) {
        Tickets decidedTicket = this.ticketRepo.findById(ticketId).get();
        System.out.println(decidedTicket);
        Users adminUser = this.userRepo.findById(id).get();
        System.out.println(decidedTicket);
        System.out.println(adminUser.getIs_admin());
        if (!decidedTicket.isIs_decided() && adminUser.getIs_admin().toString().equals("IKDN98HF765DS") && decidedTicket.getCreated_by_id() != id){
            System.out.println("this user  is an admin");
            decidedTicket.setIs_decided(decision);
            decidedTicket.setStatus(decision.toString());
            decidedTicket.setApproved_by_id(id);
            decidedTicket.setApproved_by_name(adminUser.getEmail());
            this.ticketRepo.saveAndFlush(decidedTicket);
            System.out.println(decidedTicket);
            return decidedTicket;
        }
        else System.out.println("sorry cant change this ticket");
        return null;


    }
}
