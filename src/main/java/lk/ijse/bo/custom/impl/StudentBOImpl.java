package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        List<StudentDTO> studentDTOList= new ArrayList<>();
        List<Student> students= studentDAO.getAll();
        for (Student student:students){
            studentDTOList.add(new StudentDTO(student.getStudentId(),student.getName(),
                    student.getAddress(),student.getContact(),student.getDob(),student.isMale()));
        }
        return studentDTOList;
    }

    @Override
    public boolean addStudent(StudentDTO student) throws Exception {
        return studentDAO.add(new Student(student.getStudentId(),student.getName(),
                student.getAddress(),student.getContact(),student.getDob(),student.isMale()));
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws Exception {
        return studentDAO.update(new Student(student.getStudentId(),student.getName(),student.getAddress(),student.getContact(),
                student.getDob(),student.isMale()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }
}
