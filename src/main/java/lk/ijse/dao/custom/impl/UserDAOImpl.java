package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
import lk.ijse.entity.User;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM user", User.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        boolean isExist =session.get(User.class,id) !=null;
        transaction.commit();
        session.close();
        return isExist;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM User WHERE userName ='"+id+"'", User.class);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String newId() {
        return null;
    }

    @Override
    public boolean checkUser(String userName, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM user WHERE userName=\'"+userName+"\' AND password=\'"+password+"\'", User.class).list();
        transaction.commit();
        session.close();
        for (Object o : list) {return true;}
        return false;
    }

    @Override
    public User search(String userName, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM user WHERE userName=\'"+userName+"\' AND password=\'"+password+"\'", User.class).list();
        transaction.commit();
        session.close();
        return list.get(0);
    }

    @Override
    public User search(String userName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, userName);

        transaction.commit();
        session.close();

        return user;
    }
}
