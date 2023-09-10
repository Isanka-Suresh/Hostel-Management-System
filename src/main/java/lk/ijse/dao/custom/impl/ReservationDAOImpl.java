package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
import lk.ijse.entity.User;
import lk.ijse.util.FactoryConfiguration;
import lk.ijse.util.GenerateId;
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
        session.persist(entity);
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
    public boolean exist(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        boolean isExist =session.get(Reservation.class,id) !=null;
        transaction.commit();
        session.close();
        return isExist;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Reservation WHERE reservationId =\'"+id+"\'", Reservation.class);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public String newId() throws Exception {
        String id = "RS-0001";
        if(exist(id)){
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            List<Reservation>rs = session.createNativeQuery("FROM Reservation ORDER BY reservationId DESC LIMIT 1", Reservation.class).list();
            id=rs.get(0).getReservationId();
            transaction.commit();
            session.close();

            return GenerateId.setId(id);
        }
        return id;
    }

    @Override
    public Reservation search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Reservation Reservation = session.get(Reservation.class, id);

        transaction.commit();
        session.close();

        return Reservation;
    }
}
