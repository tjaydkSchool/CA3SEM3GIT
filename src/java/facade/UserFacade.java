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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA3SEM3ServerPUTest");
    private EntityManager em = emf.createEntityManager();
    private PasswordHash ph = new PasswordHash();
    
    public UserFacade() {
    }
    
    
    /**
     * Create a user and persist in database, the password is Hashed for security before being stored.
     * 
     * @param username
     * @param password 
     */
    public void createUser(String username, String password) {
        try {
            User user = new User(username, ph.createHash(password));
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
    public User getUser(Long id) {
        return em.find(User.class, id);
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
    public void deleteUser(User user) {
        em.remove(user);
    }
    
    /**
     * Add company to a users list of companies followed
     * 
     * @param user
     * @param cvr 
     */
    public void addCompanyToUserList(User user, String cvr) {
        user.addCompanyToList(em.find(Company.class, cvr));
    }
    
    /**
     * Remove company from users list of companies followed
     * 
     * @param user
     * @param cvr 
     */
    public void removeCompanyFromUserList(User user, String cvr) {
        user.removeCompanyFromList(em.find(Company.class, cvr));
    }
    
}
