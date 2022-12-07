package dev.graham.service;

import dev.graham.entities.Users;
import dev.graham.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepo userRepo;

    @Override
    public Users registerUser(Users user) {
        try {this.userRepo.save(user); return user;}
        catch (Exception e) {throw new RuntimeException("registration failed");}
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users validateUser(String email, String password) {
        Users user1 = this.userRepo.findByEmail(email);
        if(user1.getPassword().equals(password)) return user1;
        else return null;
    }
}
