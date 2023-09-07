package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public List<UserDTO> getAllUser() throws Exception {
        List<UserDTO>userList= new ArrayList<>();
        List<User>users=userDAO.getAll();
        for (User user:users){
            userList.add(new UserDTO(user.getUserName(),user.getPasswordl()));
        }
        return userList;
    }

    @Override
    public boolean addUser(UserDTO user) throws Exception {
        return userDAO.add(new User(user.getUserName(), user.getPasswordl()));
    }

    @Override
    public boolean updateUser(UserDTO user) throws Exception {
        return userDAO.update(new User(user.getUserName(), user.getPasswordl()));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public boolean searchUser(UserDTO user) throws Exception {
        return userDAO.exist(new User(user.getUserName(), user.getPasswordl()));
    }
}
