package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {

    public List<UserDTO> getAllUser() throws Exception;
    public boolean addUser(UserDTO user) throws Exception;
    public boolean updateUser(UserDTO user) throws Exception;
    public boolean deleteUser(String id) throws Exception;
    public boolean searchUser(UserDTO user) throws Exception;

}
