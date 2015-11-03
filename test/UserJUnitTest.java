/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Company;
import entity.User;
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
    
    public UserJUnitTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
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
        user.addCompanyToList(comp);
        
        assertTrue(user.getCompanyList().size() > 0);
    }
    
    @Test
    public void testRemoveCompanyFromUserEntityCompanyList() {
        User user = new User();
        Company comp = new Company();
        user.addCompanyToList(comp);
        
        assertTrue(user.getCompanyList().size() > 0);
        
        user.removeCompanyFromList(comp);
        assertTrue(user.getCompanyList().size() == 0);
    }
}
