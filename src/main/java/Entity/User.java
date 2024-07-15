package Entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String login;
    private String password;

    private List<Role> roles = new ArrayList<>();

    public User() {
    }
    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public void addRole(Role role){
        roles.add(role);
    }

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
}
