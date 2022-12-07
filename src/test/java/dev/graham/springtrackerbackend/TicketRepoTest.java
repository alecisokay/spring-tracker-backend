package dev.graham.springtrackerbackend;


import dev.graham.entities.Tickets;
import dev.graham.repos.TicketRepo;
import dev.graham.service.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketRepoTest {

    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    TicketService ticketService;


    @Test
    void create_ticket(){
        Tickets ticket = new Tickets(0,1,"test@test.com",0, null, "this is a ticket for tacos y burritos", 501.00, "pending", false);

        Tickets savedTicket = this.ticketRepo.save(ticket);
        Assertions.assertNull(savedTicket.getApproved_by_name());
    }

    @Test
    void decide_ticket(){
        Tickets ticket = this.ticketRepo.findById(2).get();
        System.out.println(ticket);

        //this.ticketService.decideTicket(ticket, true, 2);


    }

}
