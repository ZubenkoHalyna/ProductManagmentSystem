package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name ="login")
    private String login;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private UserRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public void setValue(String field, String value) {
        switch (field){
            case "login": setLogin(value); break;
            case "password": setPassword(value); break;
            case "role": setRole(UserRole.getUserRole((value.equalsIgnoreCase("User"))? 0:1)); break;
            case "id": setId(Integer.parseInt(value)); break;
        }
    }
}
