package dev.graham.controllers;



import dev.graham.entities.Users;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import dev.graham.service.UsersService;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UsersService usersService;


    @GetMapping("/users")
    @ResponseBody
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }


    @PostMapping("/createuser")
    @ResponseBody
    public Users registerUser(@RequestBody Users user){
        return this.usersService.registerUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public Users login(@RequestBody Users user, HttpServletResponse response){
        Boolean validated = usersService.validateUser(user.getEmail(), user.getPassword());

        if(!validated) {
            System.out.println("incorrect username or password");
            return user;
        }
        else{

            Users loggedUser = usersService.findByEmail(user);
            Cookie cookie = new Cookie("jwt", loggedUser.getAuth());

            //to set secure cookies when you have https enabled onlys
            // cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
            //cookie.setSecure(true);

            response.addCookie(cookie);

            System.out.println(loggedUser.getAuth());

            System.out.println(loggedUser);

            return loggedUser;
        }


}

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        //cookie.setMaxAge(0);
        //cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        //add cookie to response
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

}




