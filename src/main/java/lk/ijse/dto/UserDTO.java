package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String userName;
    private String password;

    public UserDTO() {
    }

}
