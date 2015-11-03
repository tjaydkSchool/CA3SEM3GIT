/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Company;
import entity.User;
import facade.UserFacade;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dennis
 */
public class UserJUnitTest {

    UserFacade facade;

    public UserJUnitTest() {
    }

    @Before
    public void setUp() {
        facade = new UserFacade();
    }

    @After
    public void tearDown() {
    }

    /*
     ===========================================================================
     ================= START OF TEST OF ENTITY CLASS ===========================
     ===========================================================================
     */
    @Test
    public void testCreateUserEntity() {
        String username = "user";
        String password = "pass";

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), password);

    }

    @Test
    public void testAddCompanyToUserEntityCompanyList() {
        User user = new User();
        Company comp = new Company();
        user.addCompanyToList("9999");

        assertTrue(user.getCompanyList().size() > 0);
    }

    @Test
    public void testRemoveCompanyFromUserEntityCompanyList() {
        User user = new User();
        user.addCompanyToList("9999");

        assertTrue(user.getCompanyList().size() > 0);

        user.removeCompanyFromList("9999");
        assertTrue(user.getCompanyList().size() == 0);
    }

    /*
     ================= END OF TEST OF ENTITY CLASS =============================
     */
    /*
     ===========================================================================
     ================= START OF TEST OF PERSISTENCE ============================
     ===========================================================================
     */
    @Test
    public void testCreateUserInDatabase() {
        User user = new User("tester", "tester");
        facade.createUser(user);
        User userFromDB = facade.getUser("tester");
        assertEquals(user.getUsername(), userFromDB.getUsername());
        
        facade.deleteUser(user.getUsername());
    }

    /*
     ================= END OF TEST OF PERSISTENCE ==============================
     */
}