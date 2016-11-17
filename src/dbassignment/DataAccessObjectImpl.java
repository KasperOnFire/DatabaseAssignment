package dbassignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObjectImpl implements DataAccessObject {

    private DBConnector db = null;
    private Connection conn = null;
    private String sql = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DataAccessObjectImpl(DBConnector inputcon) {
        try {
            db = inputcon;
            conn = db.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> teamusers = new ArrayList<>();
        sql = "select * from team_member natural join user where team_id =" + team_id;
        try {
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
        sql = "select * from team";
        try {
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
        sql = "select * from team where team_id=" + id;
        try {
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
        sql = "select * from team where teamname=" + teamname;
        try {
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
        sql = "select * from user";
        try {
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
        sql = "select * from user where user_id=" + id;
        try {
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
        sql = "select * from user where username=" + username;
        try {
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
