package dev.graham.repos;


import dev.graham.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    //<Entity, Datatype of primary key



    Users findByEmail(String email);
    Users findByAuth(String auth);



}
