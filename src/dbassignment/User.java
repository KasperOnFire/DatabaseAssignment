package dbassignment;

import java.util.ArrayList;

public abstract class User implements DataAccessObject {

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

    public ArrayList<User> getUsers() {
        return null;
    }

    public User getUser(int id) {
        return null;
    }

    public User getUser(String username) {
        return null;
    }

}
