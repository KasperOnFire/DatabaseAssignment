package businessLogic;

import java.util.ArrayList;

public class User {

    private int user_id;
    private String username;
    private String password;
    private boolean admin;

    public User(int user_id, String username, String password, boolean admin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

}
