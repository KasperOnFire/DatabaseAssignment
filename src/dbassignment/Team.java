package dbassignment;

public class Team {

    private int team_id;
    private String teamname;

    public Team(int team_id, String teamname) {
        this.team_id = team_id;
        this.teamname = teamname;
    }

    public int getTeam_id() {
        return team_id;
    }

    public String getTeamname() {
        return teamname;
    }

}
