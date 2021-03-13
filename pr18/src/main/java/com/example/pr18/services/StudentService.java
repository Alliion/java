package com.example.pr18.services;

import com.example.pr18.dao.StudentDAO;
import com.example.pr18.dao.UniversityDAO;
import com.example.pr18.dto.StudentDTO;
import com.example.pr18.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDAO studentDAO;
    private final UniversityDAO universityDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO, UniversityDAO universityDAO) {
        this.studentDAO = studentDAO;
        this.universityDAO = universityDAO;
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
        return studentDAO
                .findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName(
                        universityName, firstName, middleName, lastName);
    }
}
