package lk.ijse.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String userName;
    private String passwordl;

    public UserDTO() {
    }

    public UserDTO(String userName, String passwordl) {
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
