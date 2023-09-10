package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public List<StudentDTO> getAllStudent() throws Exception;
    public boolean addStudent(StudentDTO student) throws Exception;
    public boolean updateStudent(StudentDTO student) throws Exception;
    public boolean deleteStudent(String id) throws Exception;
    public String newId() throws Exception;
    public StudentDTO getStudent(String id) throws Exception;
}
