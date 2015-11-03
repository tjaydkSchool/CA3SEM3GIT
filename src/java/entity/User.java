package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    
    @Id
    private String username;
    private String password; //Remember to hash me
    @ElementCollection
    private Collection<String> companyList = new ArrayList<String>();
    
    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<String> companyList) {
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

    
    public Collection<String> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<String> companyList) {
        this.companyList = companyList;
    }
    
    public void addCompanyToList(String cvr) {
        companyList.add(cvr);
    }
    
    public void removeCompanyFromList(String cvr) {
        companyList.remove(cvr);
    }
    
}
