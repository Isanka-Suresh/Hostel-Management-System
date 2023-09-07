package lk.ijse.dao;

import lk.ijse.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.dao.custom.impl.RoomDAOImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;
import lk.ijse.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return daoFactory==null ? daoFactory= new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,RESERVATION,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case USER:return new UserDAOImpl();
            case ROOM:return new RoomDAOImpl();
            case STUDENT:return new StudentDAOImpl();
            case RESERVATION:return new ReservationDAOImpl();
            default:return null;
        }
    }
}
