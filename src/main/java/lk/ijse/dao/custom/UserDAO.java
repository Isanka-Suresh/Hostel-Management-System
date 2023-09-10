package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

public interface UserDAO extends CrudDAO<User> {
    boolean checkUser(String userName,String password);
    User search(String userName,String password);
    User search(String userName);
}
