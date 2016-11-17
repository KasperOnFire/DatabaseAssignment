package dbassignment;

import java.util.ArrayList;

public abstract class Team implements DataAccessObject {

    private int team_id;
    private String teamname;

    public Team(int team_id, String teamname) {
        this.team_id = team_id;
        this.teamname = teamname;
    }

    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        return null;
    }

    @Override
    public ArrayList<Team> getTeams() {
        return null;
    }

    @Override
    public Team getTeam(int id) {
        return null;
    }

    @Override
    public Team getTeam(String teamname) {
        return null;
    }

    public int getTeam_id() {
        return team_id;
    }

    public String getTeamname() {
        return teamname;
    }

}
