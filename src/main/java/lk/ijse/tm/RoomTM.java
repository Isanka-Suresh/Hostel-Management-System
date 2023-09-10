package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class RoomTM {
    private String roomId;
    private String roomType;
    private double keyMoney;
    private int quantity;
    private int availableRooms;
    private int reservedRooms;
}
