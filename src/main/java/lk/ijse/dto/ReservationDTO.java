package lk.ijse.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ReservationDTO implements Serializable {
    private String reservationId;
    private String studentId;
    private String roomId;
    private LocalDate date;
    private boolean status;

    public ReservationDTO() {
    }

    public ReservationDTO(String reservationId, String studentId, String roomId, LocalDate date, boolean status) {
        this.reservationId = reservationId;
        this.studentId = studentId;
        this.roomId = roomId;
        this.date = date;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
