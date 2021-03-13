package com.example.pr17.services;

import com.example.pr17.dao.StudentDAO;
import com.example.pr17.dao.StudentFilterDAO;
import com.example.pr17.dao.UniversityDAO;
import com.example.pr17.dto.StudentDTO;
import com.example.pr17.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDAO studentDAO;
    private final UniversityDAO universityDAO;
    private final StudentFilterDAO studentFilterDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO, UniversityDAO universityDAO, StudentFilterDAO studentFilterDAO) {
        this.studentDAO = studentDAO;
        this.universityDAO = universityDAO;
        this.studentFilterDAO = studentFilterDAO;
    }

    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    public void delete(int id) {
        studentDAO.deleteById(id);
    }

    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityDAO.findByName(studentDTO.getNameUniversity()));
        studentDAO.save(student);
    }

    public List<Student> filterStudents(
            String universityName, String firstName, String middleName, String lastName
    ) {
        return studentFilterDAO
                .findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName(
                        universityName, firstName, middleName, lastName);
    }
}
