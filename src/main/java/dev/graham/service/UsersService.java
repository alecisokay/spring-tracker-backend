package dev.graham.service;

import dev.graham.entities.Users;

import java.util.List;

public interface UsersService {
    Users registerUser(Users user);
    Users findByEmail(Users user);
    Users findByAuth(Users user);
    Users getUserById(int id);

    Boolean isUserAdmin(Users user);
    List<Users> getAllUsers();
    Boolean validateUser(String email, String Password);
}
