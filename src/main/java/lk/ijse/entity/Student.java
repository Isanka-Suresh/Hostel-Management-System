package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Student {
    @Id
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private boolean isMale;

    public Student() {
    }

    public Student(String studentId, String name, String address, String contact, LocalDate dob, boolean isMale) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.isMale = isMale;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
