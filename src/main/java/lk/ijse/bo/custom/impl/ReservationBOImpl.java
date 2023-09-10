package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    RoomDAO roomDAO= (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        List<ReservationDTO>reservationDTOS=new ArrayList<>();
        List<Reservation>reservations=reservationDAO.getAll();
        for (Reservation r:reservations){
            reservationDTOS.add(
                    new ReservationDTO(
                            r.getReservationId(),
                            r.getStudent(),
                            r.getRoom(),
                            r.getDate(),
                            r.getStatus()
                    ));
        }
        return reservationDTOS;
    }

    @Override
    public RoomDTO getRoom(String roomId) throws Exception {
        Room room = roomDAO.search(roomId);
        return new RoomDTO(room.getRoomTypeId(), room.getRoomType(),room.getKeyMoney(),room.getQuantity());
    }

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) throws Exception {
        return reservationDAO.add(new Reservation(
                reservationDTO.getReservationId(),
                reservationDTO.getStudent(),
                reservationDTO.getRoom(),
                reservationDTO.getDate(),
                reservationDTO.getStatus()
        ));
    }

    @Override
    public boolean updateReservation(ReservationDTO reservation) throws Exception {
        return false;
    }

    @Override
    public boolean deleteReservation(String id) throws Exception {
        return false;
    }

    @Override
    public String newReservationId() throws Exception {
        return reservationDAO.newId();
    }
}
