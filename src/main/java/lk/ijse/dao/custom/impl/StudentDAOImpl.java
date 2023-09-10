package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lk.ijse.util.FactoryConfiguration;
import lk.ijse.util.GenerateId;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> list = session.createNativeQuery("SELECT * FROM student", Student.class).list();
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
    public boolean exist(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        boolean isExist =session.get(Student.class,id) !=null;
        transaction.commit();
        session.close();
        return isExist;
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

    @Override
    public String newId() throws Exception {
        String id = "S001";
        if(exist(id)){
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            List<Student>students = session.createNativeQuery("SELECT * FROM Student ORDER BY studentId DESC LIMIT 1", Student.class).list();
            id=students.get(0).getStudentId();
            transaction.commit();
            session.close();

            return GenerateId.setId(id);
        }
        return id;
    }

    @Override
    public Student search(String id) throws Exception {
        return null;
    }
}
