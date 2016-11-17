package dbassignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void test() {
        try {
            DBConnector db = new DBConnector();
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from dept where loc = 'CHICAGO'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Dept no: " + rs.getInt("deptno"));
            }

        } catch (Exception ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
