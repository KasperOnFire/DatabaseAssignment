package dbassignment;

import data.DataAccessObjectImpl;
import data.DBConnector;
import businessLogic.User;
import businessLogic.Team;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataAccessObjectTest {

    private static DBConnector connector;
    private static DataAccessObjectImpl dao;

    // Setup
    @BeforeClass
    public static void setUpClass() {
        try {
            connector = new DBConnector();
        } catch (Exception ex) {
            System.out.println(ex);
            fail();
        }
    }

    @Before
    public void setUp() {
        dao = new DataAccessObjectImpl(connector);
    }

    // Test teams
    @Test
    public void testGetTeamMembers() {
        // Positive test
        User user;

        ArrayList<User> teamMembers = dao.getTeamMembers(1);
        assertNotNull(teamMembers);
        assertFalse(teamMembers.isEmpty());
        assertEquals(teamMembers.size(), 3);

        user = teamMembers.get(0);
        assertEquals(user.getUser_id(), 2);
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);

        user = teamMembers.get(1);
        assertEquals(user.getUser_id(), 3);
        assertEquals(user.getUsername(), "Fedtmule");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);

        user = teamMembers.get(2);
        assertEquals(user.getUser_id(), 7);
        assertEquals(user.getUsername(), "Pluto");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);
    }

    @Test
    public void testGetTeamMembersInValidTeamID() {
        // Negative test
        ArrayList<User> teamMembers = dao.getTeamMembers(99);
        assertNotNull(teamMembers);
        assertTrue(teamMembers.isEmpty());
    }

    @Test
    public void testGetAllTeams() {
        ArrayList<Team> teams = dao.getTeams();
        assertNotNull(teams);
        assertFalse(teams.isEmpty());
        Team team = teams.get(0);
        assertEquals(team.getTeamname(), "A");
        assertEquals(team.getTeamMembers().size(), 3);
    }

    @Test
    public void testGetTeamByID() {
        // positive test
        Team team = dao.getTeam(1);
        assertNotNull(team);
        assertEquals(team.getTeamname(), "A");
        assertEquals(team.getTeamMembers().size(), 3);
    }

    @Test
    public void testGetTeamByInvalidID() {
        // Negative test
        Team team = dao.getTeam(99);
        assertNull(team);
    }

    @Test
    public void testGetTeamByTeamName() {
        // positive test
        Team team = dao.getTeam("A");
        assertNotNull(team);
        assertEquals(team.getTeam_id(), 1);
        assertEquals(team.getTeamMembers().size(), 3);
    }

    @Test
    public void testGetTeamByInvalidTeamName() {
        // negative test
        Team team = dao.getTeam("Not a team name!");
        assertNull(team);
    }

    // Test users
    @Test
    public void testGetAllUsers() {
        // positive test
        ArrayList<User> users = dao.getUsers();
        assertNotNull(users);
        assertEquals(users.size(), 8);
    }

    @Test
    public void testGetUserByID() {
        // positive test
        User testuser = dao.getUser(3);
        assertNotNull(testuser);
        assertEquals(testuser.getUser_id(), 3);
    }

    @Test
    public void testGetUserByInvalidID() {
        // negative test
        User testuser = dao.getUser(9);
        assertNull(testuser);
    }

    @Test
    public void testGetUserByName() {
        //positive test
        User testuser = dao.getUser("Anders And");
        assertNotNull(testuser);
        assertEquals(testuser.getUsername(), "Anders And");
    }

    @Test
    public void testGetUserByInvalidName() {
        //negative test
        User testuser = dao.getUser("Sergei Ivanov");
        assertNull(testuser);
    }
}
