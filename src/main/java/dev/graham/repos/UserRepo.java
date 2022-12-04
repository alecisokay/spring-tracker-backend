package dev.graham.repos;


import dev.graham.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    //<Entity, Datatype of primary key
}
