package facade;

import entity.Company;
import entity.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordHash;

public class UserFacade {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA3SEM3ServerPUTest");;
    private EntityManager em = emf.createEntityManager();
    private PasswordHash ph = new PasswordHash();
    
    public UserFacade() {
    }
    
    
    
    public static void main(String[] args) {
        UserFacade uf = new UserFacade();
        uf.createDB();
        
    }
    
    public void createDB() {
        User user = new User("alju", "hara");
        Company comp = new Company("1234", 100.2D);
        user.addCompanyToList("1234");
        em.getTransaction().begin();
        em.persist(comp);
        em.persist(user);
        em.getTransaction().commit();
    }
    
    
    /**
     * Create a user and persist in database, the password is Hashed for security before being stored.
     * 
     * @param username
     * @param password 
     */
    public void createUser(User userData) {
        try {
            User user = new User(userData.getUsername(), ph.createHash(userData.getPassword()));
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Return a user from database by user id
     * 
     * @param id
     * @return User
     */
    public User getUser(String username) {
        return em.find(User.class, username);
    }
    
    /**
     * Update user in database
     * 
     * @param user 
     */
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    
    /**
     * Delete user from database
     * 
     * @param user 
     */
    public void deleteUser(String username) {
        User user = em.find(User.class, username);
        System.out.println(user.getPassword());
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
    
    /**
     * Add company to a users list of companies followed
     * 
     * @param user
     * @param cvr 
     */
    public void addCompanyToUserList(User user, String cvr) {
        user.addCompanyToList(cvr);
    }
    
    /**
     * Remove company from users list of companies followed
     * 
     * @param user
     * @param cvr 
     */
    public void removeCompanyFromUserList(User user, String cvr) {
        user.removeCompanyFromList(cvr);
    }
    
}
