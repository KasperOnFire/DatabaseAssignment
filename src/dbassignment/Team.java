package dbassignment;

import java.util.ArrayList;

public abstract class Team implements DataAccessObject {

    private int team_id;
    private String teamname;

    public Team(int team_id, String teamname) {
        this.team_id = team_id;
        this.teamname = teamname;
    }

    public ArrayList<User> getTeamMembers(int team_id) {
        return null;
    }

    public ArrayList<Team> getTeams() {
        return null;
    }

    public Team getTeam(int id) {
        return null;
    }

    public Team getTeam(String teamname) {
        return null;
    }
    
    @Override
    public String toString()
    {
        return "team_id " + team_id + ", teamname " + teamname;
    }

}
