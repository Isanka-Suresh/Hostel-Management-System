package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String userName;
    private String passwordl;

    public User() {
    }

    public User(String userName, String passwordl) {
        this.userName = userName;
        this.passwordl = passwordl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordl() {
        return passwordl;
    }

    public void setPasswordl(String passwordl) {
        this.passwordl = passwordl;
    }
}
