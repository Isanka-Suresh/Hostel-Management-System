package lk.ijse.bo;

import lk.ijse.bo.custom.impl.ReservationBOImpl;
import lk.ijse.bo.custom.impl.RoomBOImpl;
import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getBOFactory(){
        return boFactory==null ? boFactory=new BOFactory():boFactory;
    }

    public enum BOTypes{
        STUDENT,ROOM,RESERVATION,USER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:return new StudentBOImpl();
            case ROOM:return new RoomBOImpl();
            case USER:return new UserBOImpl();
            case RESERVATION:return new ReservationBOImpl();
            default:return null;
        }
    }
}
