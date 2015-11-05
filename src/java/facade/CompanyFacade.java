/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CompanyFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("INSERT PU HERE!!");
    EntityManager em = emf.createEntityManager();
    
    /**
     * Create a Company and persist in database
     *
     * @param company
     */
    public void CreateCompany(Company company){
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit(); 
    }
    
    /**
     * Get a single company from database 
     *
     * @return
     */
    public Company getCompany(){
        TypedQuery<Company> q = em.createQuery("INSERT QUERY HERE TO GET A COMPANY", Company.class);
        return q.getSingleResult();
    }
    
    /**
     * Get all companies from database
     *
     * @return
     */
    public List<Company> getAllCompanies(){
        TypedQuery<Company> q = em.createQuery("INSERT QUERY HERE TO GET ALL COMPANIES", Company.class);
        return q.getResultList();
    }
    
    /**
     * Update a single company and persist in database
     *
     * @param company
     */
    public void updateCompany(Company company){
        if(em.find(Company.class, company.getCvr()) != null){
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
        }
    }
    
    /**
     * Delete a single company from database
     *
     * @param company
     */
    public void deleteCompany(Company company){
        if(em.find(Company.class, company.getCvr()) != null){
            em.getTransaction().begin();
            em.remove(company);
            em.getTransaction().commit();
        }
    }
    
}
