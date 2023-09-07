package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public List<Reservation> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Reservation> list= session.createNativeQuery("SELECT * FROM Reservation", Reservation.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Reservation entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(Reservation entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Reservation WHERE reservationId ='"+id+"'", Reservation.class);
        transaction.commit();
        session.close();
        return false;
    }
}
