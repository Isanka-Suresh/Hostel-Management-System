package lk.ijse.dto;

import lk.ijse.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class RoomDTO implements Serializable {
    private String roomTypeId;
    private String roomType;
    private Double keyMoney;
    private Integer quantity;

    public RoomDTO() {
    }

}
