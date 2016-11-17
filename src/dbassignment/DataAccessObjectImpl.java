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

    public DataAccessObjectImpl(DBConnector inputcon) {
        try {
            db = inputcon;
            conn = db.getConnection();

        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
                Team team = new Team(tid, name);
                returnList.add(team);

            }
            return returnList;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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
                Team returner = new Team(tid, name);
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

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
                Team returner = new Team(tid, name);
                return returner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

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
