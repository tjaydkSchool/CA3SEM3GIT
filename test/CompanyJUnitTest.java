/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Company;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asnorrason
 */
public class CompanyJUnitTest {
    
    public CompanyJUnitTest() {
    }

    @Test
    public void CreateCompanyTest(){
        Company comp = new Company();
        
        comp.setCvr("12345678");
        comp.setStock(50.45);
        
        assertEquals(comp.getCvr(), "12345678");
    }
}
