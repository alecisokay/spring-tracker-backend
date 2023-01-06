package dev.graham.controllers;


import dev.graham.entities.Tickets;
import dev.graham.repos.TicketRepo;
import dev.graham.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {



    @Autowired
    TicketService ticketService;

    @Autowired
    TicketRepo ticketRepo;

    @GetMapping("/updateticket")
    @ResponseBody
    public Tickets ticketUpdate(@RequestBody Tickets body){
       return this.ticketService.decideTicket(body);
    }
}
