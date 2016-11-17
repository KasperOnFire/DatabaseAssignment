package dbexamplesolution;


import java.util.ArrayList;
import dbassignment.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataAccessObjectTest {


    private static DBConnector connector;
    private static DataAccessObjectInterface dao;


    // Setup
    @BeforeClass
    public static void setUpClass() {
        try {
            connector = new DBConnector();
        } catch (Exception ex) {
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
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);


        user = teamMembers.get(1);
        assertEquals(user.getId(), 3);
        assertEquals(user.getUsername(), "Fedtmule");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);


        user = teamMembers.get(2);
        assertEquals(user.getId(), 7);
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
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
    }


    @Test
    public void testGetTeamByID() {
        // positive test
        Team team = dao.getTeam(1);
        assertNotNull(team);
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
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
        assertEquals(team.getId(), 1);
        assertEquals(team.getMembers().size(), 3);
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
        fail();
    }


    @Test
    public void testGetUserByID() {
        fail();
    }


    @Test
    public void testGetUserByName() {
        fail();
    }
}




