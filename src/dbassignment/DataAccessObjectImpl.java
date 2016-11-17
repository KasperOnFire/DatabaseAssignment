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

    public DataAccessObjectImpl() {
        try {
            db = new DBConnector();
            conn = db.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<User> getTeamMembers(int team_id) {

    }

    @Override
    public ArrayList<Team> getTeams() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Team getTeam(int id) {
        
    }

    @Override
    public Team getTeam(String teamname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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