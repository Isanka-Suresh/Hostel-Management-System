package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.entity.Room;

import java.util.List;

public interface RoomBO extends SuperBO {
    public List<RoomDTO> getAllRoom() throws Exception;
    public boolean addRoom(RoomDTO room) throws Exception;
    public boolean updateRoom(RoomDTO room) throws Exception;
    public boolean deleteRoom(String id) throws Exception;
    public String newId() throws Exception;
    public int getTotalRoomQty(String id)throws Exception;

    RoomDTO getRoom(String value) throws Exception;
}
