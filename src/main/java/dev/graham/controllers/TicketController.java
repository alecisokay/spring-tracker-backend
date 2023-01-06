package dev.graham.controllers;


import dev.graham.entities.Tickets;
import dev.graham.entities.Users;
import dev.graham.repos.TicketRepo;
import dev.graham.repos.UserRepo;
import dev.graham.service.TicketService;
import dev.graham.service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class TicketController {



    @Autowired
    TicketService ticketService;

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    UsersService usersService;

    @Autowired
    UserRepo userRepo;


    @PostMapping("/createticket")
    @ResponseBody
    public Tickets createTicket(@RequestBody Tickets tickets, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String jwt = "";
        if (cookies != null) {

            String cookieList = Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
//            System.out.println(cookieList);
            String[] result = cookieList.split(", ");

            for (String i: result){
                Pattern pattern = Pattern.compile("jwt=*", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(i);
                boolean matchFound = matcher.find();
                if(matchFound) {
                    System.out.println("Match found");
                    //System.out.println(i);
                    jwt = i.substring(4);
                }
            }
            //return "no cookies";
            System.out.println(jwt);
            Users user = new Users(jwt);
            System.out.println(user);
            Users userFound = usersService.findByAuth(user);
            System.out.println();
            System.out.println(userFound);

            Tickets passedTicket = tickets;
            //System.out.println(passedTicket);
            passedTicket.setCreated_by_id(userFound.getId());
            passedTicket.setCreate_by_name(userFound.getEmail());
            passedTicket.setStatus("pending");
            ticketService.createTicket(passedTicket);
            System.out.println(passedTicket);

            return passedTicket;

        }
        else {
            return tickets;
        }

    }

    @GetMapping("/updateticket")
    @ResponseBody
    public Tickets ticketUpdate(@RequestBody Tickets body){
       return this.ticketService.decideTicket(body);
    }

    @GetMapping("/mytickets")
    @ResponseBody
    public List<Tickets> userTickets(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String jwt = "";
        if (cookies != null) {
            String cookieList = Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
//            System.out.println(cookieList);
            String[] result = cookieList.split(", ");

            for (String i: result){
                Pattern pattern = Pattern.compile("jwt=*", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(i);
                boolean matchFound = matcher.find();
                if(matchFound) {
                    System.out.println("Match found");
                    //System.out.println(i);
                    jwt = i.substring(4);
                }
            }
            //return "no cookies";
            System.out.println(jwt);
            Users user = new Users(jwt);
            System.out.println(user);
            Users userFound = usersService.findByAuth(user);
            List<Tickets> ticketsList = this.ticketRepo.findAllByCreatedById(userFound.getId());
            return ticketsList;

        }
        else {
            return null;
        }
    }
}
