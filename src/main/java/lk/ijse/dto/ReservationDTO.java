package lk.ijse.dto;

import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@Getter
public class ReservationDTO implements Serializable {
    private String reservationId;
    private Student student;
    private Room room;
    private LocalDate date;
    private String status;

    public ReservationDTO() {
    }

}
