package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        List<ReservationDTO> reservationList = new ArrayList<>();
        List<Reservation> all = reservationDAO.getAll();
        for (Reservation reservation : all){
            reservationList.add(new ReservationDTO(reservation.getReservationId(),reservation.getStudentId(),
                    reservation.getRoomId(),reservation.getDate(),reservation.isStatus()));
        }
        return reservationList;
    }

    @Override
    public boolean addReservation(ReservationDTO reservation) throws Exception {
        return reservationDAO.add(new Reservation(reservation.getReservationId(),reservation.getStudentId(),
                reservation.getRoomId(),reservation.getDate(),reservation.isStatus()));
    }

    @Override
    public boolean updateReservation(ReservationDTO reservation) throws Exception {
        return reservationDAO.update(new Reservation(reservation.getReservationId(),reservation.getStudentId(),
                reservation.getRoomId(),reservation.getDate(),reservation.isStatus()));
    }

    @Override
    public boolean deleteReservation(String id) throws Exception {
        return reservationDAO.delete(id);
    }
}
