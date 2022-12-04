package dev.graham.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int created_by_id;
    private String create_by_name;
    private int approved_by_id;
    private String approved_by_name;
    private String description;
    private double amount;
    private String status;
    private boolean is_decided;





}
