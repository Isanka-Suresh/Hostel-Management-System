package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.entity.Reservation;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public List<ReservationDTO> getAllReservation() throws Exception;
    public boolean addReservation(ReservationDTO reservation) throws Exception;
    public boolean updateReservation(ReservationDTO reservation) throws Exception;
    public boolean deleteReservation(String id) throws Exception;
}
