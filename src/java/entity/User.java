package entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password; //Remember to hash me
    @ElementCollection
    private Collection<Company> companyList = new ArrayList<Company>();
    
    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Collection<Company> companyList) {
        this.username = username;
        this.password = password;
        this.companyList = companyList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Collection<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(Collection<Company> companyList) {
        this.companyList = companyList;
    }
    
    public void addCompanyToList(Company comp) {
        companyList.add(comp);
    }
    
    public void removeCompanyFromList(Company comp) {
        companyList.remove(comp);
    }
    
}
