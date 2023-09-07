package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = session.createNativeQuery("SELECT * FROM Student", Student.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(Student entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Student WHERE studentId='"+id+"'");
        transaction.commit();
        session.close();
        return true;
    }
}
