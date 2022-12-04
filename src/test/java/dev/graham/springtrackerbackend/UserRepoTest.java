package dev.graham.springtrackerbackend;


import dev.graham.entities.Users;
import dev.graham.repos.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    void create_user(){
        Users user = new Users(0, "admin", "admin", "Admin@test.com", "123456");
        Users savedUser = this.userRepo.save(user);
        System.out.println(savedUser);
        Assertions.assertNotEquals(0, savedUser.getId());
    }

    @Test
    void get_user(){
        Users user = this.userRepo.findById(1).get();
        Assertions.assertEquals(user.getFirst_name(), "admin");
    }

    @Test
    void validate_user(){
        Users user = this.userRepo.findByEmail("Admin@test.com");
        if (user.getPassword().equals("123456")) System.out.println("passwords match!");
    }
}
