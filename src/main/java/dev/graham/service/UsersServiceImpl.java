package dev.graham.service;

import dev.graham.entities.Users;
import dev.graham.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepo userRepo;

    @Override
    public Users registerUser(Users user) {

        UUID randomUUID = UUID.randomUUID();
        user.setAuth(randomUUID.toString().replaceAll("-", ""));
        try {this.userRepo.save(user); return user;}
        catch (Exception e) {throw new RuntimeException("registration failed");}
    }

    @Override
    public Users findByEmail(Users user) {
        return this.userRepo.findByEmail(user.getEmail());
    }

    @Override
    public Users findByAuth(Users user) {
        return this.userRepo.findByAuth(user.getAuth());
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }

    @Override
    public Boolean isUserAdmin(Users user) {
        return user.getIs_admin().equals("IKDN98HF765DS");
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Boolean validateUser(String email, String password) {
        Users user1 = this.userRepo.findByEmail(email);
        if(user1.getPassword().equals(password)) return true;
        else return false;
    }
}
