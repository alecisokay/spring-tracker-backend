package dev.graham.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="created_by_id")
    private int created_by_id;
    @Column(name="created_by_name")
    private String create_by_name;
    @Column(name="approved_by_id")
    private int approved_by_id;
    @Column(name="approved_by_name")
    private String approved_by_name;
    @Column(name="description")
    private String description;
    @Column(name="amount")
    private double amount;
    @Column(name="status")
    private String status;
    @Column(name="is_decided")
    private boolean is_decided;

    public Tickets() {
    }

    public Tickets(int id, int created_by_id, String create_by_name, int approved_by_id, String approved_by_name, String description, double amount, String status, boolean is_decided) {
        this.id = id;
        this.created_by_id = created_by_id;
        this.create_by_name = create_by_name;
        this.approved_by_id = approved_by_id;
        this.approved_by_name = approved_by_name;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.is_decided = is_decided;
    }


    public Tickets(int id, int approved_by_id, String status) {
        this.id = id;
        this.approved_by_id = approved_by_id;
        this.status = status;
    }

    public Tickets(int id, int approved_by_id, boolean is_decided) {
        this.id = id;
        this.approved_by_id = approved_by_id;
        this.is_decided = is_decided;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreated_by_id() {
        return created_by_id;
    }

    public void setCreated_by_id(int created_by_id) {
        this.created_by_id = created_by_id;
    }

    public String getCreate_by_name() {
        return create_by_name;
    }

    public void setCreate_by_name(String create_by_name) {
        this.create_by_name = create_by_name;
    }

    public int getApproved_by_id() {
        return approved_by_id;
    }

    public void setApproved_by_id(int approved_by_id) {
        this.approved_by_id = approved_by_id;
    }

    public String getApproved_by_name() {
        return approved_by_name;
    }

    public void setApproved_by_name(String approved_by_name) {
        this.approved_by_name = approved_by_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIs_decided() {
        return is_decided;
    }

    public void setIs_decided(boolean is_decided) {
        this.is_decided = is_decided;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", created_by_id=" + created_by_id +
                ", create_by_name='" + create_by_name + '\'' +
                ", approved_by_id=" + approved_by_id +
                ", approved_by_name='" + approved_by_name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", is_decided=" + is_decided +
                '}';
    }
}
