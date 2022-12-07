package dev.graham.controllers;



import dev.graham.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import dev.graham.service.UsersService;
import java.util.List;

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
        Users savedUser = this.usersService.registerUser(user);
        return savedUser;
    }


}
