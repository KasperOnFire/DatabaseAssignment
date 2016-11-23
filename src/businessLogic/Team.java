package businessLogic;

import java.util.ArrayList;

public class Team {

    private int team_id;
    private String teamname;
    private ArrayList<User> teamMembers;

    public Team(int team_id, String teamname, ArrayList users) {
        this.team_id = team_id;
        this.teamname = teamname;
        this.teamMembers = users;
    }

    public int getTeam_id() {
        return team_id;
    }

    public String getTeamname() {
        return teamname;
    }

    public ArrayList<User> getTeamMembers() {
        return teamMembers;
    }

}
