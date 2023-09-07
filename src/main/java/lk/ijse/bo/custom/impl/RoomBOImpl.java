package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        List<RoomDTO> roomDTOList= new ArrayList<>();
        List<Room>rooms=roomDAO.getAll();
        for (Room room : rooms){
            roomDTOList.add(new RoomDTO(room.getRoomTypeId(),room.getRoomType(),room.getKeyMoney(),room.getQuantity()));
        }
        return roomDTOList;
    }

    @Override
    public boolean addRoom(RoomDTO room) throws Exception {
        return roomDAO.add(new Room(room.getRoomTypeId(),room.getRoomType(),room.getKeyMoney(),room.getQuantity()));
    }

    @Override
    public boolean updateRoom(RoomDTO room) throws Exception {
        return roomDAO.update(new Room(room.getRoomTypeId(),room.getRoomType(),room.getKeyMoney(),room.getQuantity()));
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDAO.delete(id);
    }
}
