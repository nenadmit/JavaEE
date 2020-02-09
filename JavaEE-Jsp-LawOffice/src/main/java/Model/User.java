package Model;


import javax.persistence.*;

@Entity

public class User {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String lastLogedIn;
    private String role;

    public User(String username, String password, String lastLogedIn, String role) {
        this.username = username;
        this.password = password;
        this.lastLogedIn = lastLogedIn;
        this.role = role;
    }
    public User(){

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogedIn() {
        return lastLogedIn;
    }

    public void setLastLogedIn(String lastLogedIn) {
        this.lastLogedIn = lastLogedIn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
