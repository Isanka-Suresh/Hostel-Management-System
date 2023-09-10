package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@Entity
public class Room {
    @Id
    private String roomTypeId;
    private String roomType;
    private double keyMoney;
    private int quantity;
    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER,targetEntity= Reservation.class)
        private List<Reservation> reservations;

    public Room() {
    }

}
