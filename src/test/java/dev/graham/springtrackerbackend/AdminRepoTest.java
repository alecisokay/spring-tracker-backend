package dev.graham.springtrackerbackend;


import dev.graham.entities.Administrator;
import dev.graham.repos.AdminRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminRepoTest {

    @Autowired
    AdminRepo adminRepo;


    @Test
    void create_admin(){
        Administrator admin = new Administrator(0, "admin", "admin", "Admin@test.com", "123456");
        Administrator savedAdmin = this.adminRepo.save(admin);
        System.out.println(savedAdmin);
        //Assertions.assertEquals(1, savedAdmin.getId());

    }

    @Test
    void get_admin_by_id(){
        Administrator admin = this.adminRepo.findById(1).get();
        //System.out.println(admin);
        Assertions.assertEquals(admin.getFirst_name(), "admin");
    }


}
