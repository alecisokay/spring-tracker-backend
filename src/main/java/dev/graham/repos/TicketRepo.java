package dev.graham.repos;

import dev.graham.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepo extends JpaRepository<Tickets, Integer> {
    List<Tickets> findAllByStatus(String Status);

    @Query("SELECT u FROM Tickets u WHERE u.created_by_id = ?1")
    List<Tickets> findAllByCreatedById(int id);

}
