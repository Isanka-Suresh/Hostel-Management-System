package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ReservationTM {
    private String reservationId;
    private String studentId;
    private String roomId;
    private LocalDate date;
    private String status;
}
