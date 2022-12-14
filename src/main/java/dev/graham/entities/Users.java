package dev.graham.entities;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="first_name")
    private String first_name;
    @Column(name ="last_name")
    private String last_name;
    @Column(name ="email")
    private String email;
    @Column(name ="password")
    private String password;
    @Column(name="is_admin")
    private String is_admin;
    @Column(name="auth")
    private String auth;


    public Users() {
    }

    public Users(int id, String first_name, String last_name, String email, String password, String is_admin) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public Users(int id, String first_name, String last_name, String email, String password, String is_admin, String auth) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.auth = auth;
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String auth) {
        this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_admin='" + is_admin + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
