package dev.graham.repos;

import dev.graham.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepo extends JpaRepository<Tickets, Integer> {
}
