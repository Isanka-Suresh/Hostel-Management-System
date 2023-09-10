package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.User;
import lk.ijse.util.FactoryConfiguration;
import lk.ijse.util.GenerateId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Room> list = session.createNativeQuery("SELECT * FROM Room", Room.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String id) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        boolean isExist = session.get(Room.class,id) != null;
        transaction.commit();
        session.close();
        return isExist;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Room WHERE roomId=\'"+id+"\'", Room.class);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String newId() throws Exception {
        String id = "R001";
        if(exist(id)){
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            List<Room>rooms = session.createNativeQuery("SELECT * FROM Room ORDER BY roomTypeId DESC LIMIT 1", Room.class).list();
            id=rooms.get(0).getRoomTypeId();
            transaction.commit();
            session.close();

            return GenerateId.setId(id);
        }
        return id;
    }

    @Override
    public Room search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, id);

        transaction.commit();
        session.close();

        return room;
    }

    @Override
    public int totalQuantity(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("SELECT COUNT(*) FROM reservation WHERE room_roomTypeId = ?1");
        nativeQuery.setParameter(1, id);
        Long result = (Long) nativeQuery.uniqueResult();

        transaction.commit();
        session.close();

        return Math.toIntExact(result);
    }
}
