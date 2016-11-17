package dbassignment;

import java.util.ArrayList;

public interface DataAccessObject {

    // Team
    public ArrayList<User> getTeamMembers(int team_id);

    public ArrayList<Team> getTeams();

    public Team getTeam(int id);

    public Team getTeam(String teamname);

    // User
    public ArrayList<User> getUsers();

    public User getUser(int id);

    public User getUser(String username);

    // Access SQL
}
