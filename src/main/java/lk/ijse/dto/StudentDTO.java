package lk.ijse.dto;

import lk.ijse.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO implements Serializable {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private boolean isMale;

    public StudentDTO() {}

}
