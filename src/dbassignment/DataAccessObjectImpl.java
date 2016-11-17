package dbassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObjectImpl implements DataAccessObject {

    private DBConnector db = null;
    private Connection conn = null;

    //The class constructor gives access to the getters in the class, 
    //which give access to the database. The constructor also opens a 
    //connection to the database.
    public DataAccessObjectImpl(DBConnector inputcon) {
        try {
            db = inputcon;
            conn = db.getConnection();

        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //The getter methods are relatively self-explanatory due to proper naming.
    //getTeamMembers returns the users in the database that are members 
    //of the selected team.
    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> teamusers = new ArrayList<>();
        String sql = "select * from team_member natural join user where team_id =" + team_id;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt("user_id");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                boolean adm = rs.getBoolean("admin");
                User returner = new User(uid, name, pw, adm);
                teamusers.add(returner);
            }
            return teamusers;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //getTeams returns all teams, including an ArrayList containing
    //their members.
    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> returnList = new ArrayList();
        String sql = "select * from team";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("team_id");
                String name = rs.getString("teamname");
                Team team = new Team(tid, name, getTeamMembers(tid));
                returnList.add(team);

            }
            return returnList;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //getTeam returns a specific team, including its members.
    //There are two versons of getTeam, this one searches by team id.
    @Override
    public Team getTeam(int id) {
        String sql = "select * from team where team_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int tid = rs.getInt("team_id");
                String name = rs.getString("teamname");
                Team returner = new Team(tid, name, getTeamMembers(id));
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //And this one searches by teamname.
    @Override
    public Team getTeam(String teamname) {
        String sql = "select * from team where teamname=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, teamname);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int tid = rs.getInt("team_id");
                String name = rs.getString("teamname");
                Team returner = new Team(tid, name, getTeamMembers(tid));
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //getUsers returns all users and stores them in an ArrayList.
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> returnList = new ArrayList();
        String sql = "select * from user";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt("user_id");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                boolean adm = rs.getBoolean("admin");
                User user = new User(uid, name, pw, adm);
                returnList.add(user);

            }
            return returnList;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //getUser searhes for a specific user.
    //As with getTeam, there are two versions.
    //This one searches by user id.
    @Override
    public User getUser(int id) {
        String sql = "select * from user where user_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int uid = rs.getInt("user_id");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                boolean adm = rs.getBoolean("admin");
                User returner = new User(uid, name, pw, adm);
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //This getUser version searches by username.
    @Override
    public User getUser(String username) {
        String sql = "select * from user where username=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int uid = rs.getInt("user_id");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                boolean adm = rs.getBoolean("admin");
                User returner = new User(uid, name, pw, adm);
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
