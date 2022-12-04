package dev.graham.UsersService;

import dev.graham.entities.Users;

import java.util.List;

public interface UsersService {
    Users registerUser(Users user);
    Users getUserById(int id);
    List<Users> getAllUsers();
    Users validateUser(String email, String Password);
}
