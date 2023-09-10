package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public List<ReservationDTO> getAllReservation() throws Exception;
    public RoomDTO getRoom(String roomId) throws Exception;
    public boolean addReservation(ReservationDTO reservation) throws Exception;
    public boolean updateReservation(ReservationDTO reservation) throws Exception;
    public boolean deleteReservation(String id) throws Exception;
    public String newReservationId() throws Exception;
}
