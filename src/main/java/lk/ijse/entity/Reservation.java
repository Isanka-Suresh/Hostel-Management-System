package lk.ijse.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    private String reservationId;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Room room;
    private LocalDate date;
    private String status;

    public Reservation(){}
}
