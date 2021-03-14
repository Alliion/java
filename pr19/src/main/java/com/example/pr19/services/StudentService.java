package com.example.pr19.services;

import com.example.pr19.dao.StudentDAO;
import com.example.pr19.dao.UniversityDAO;
import com.example.pr19.dto.StudentDTO;
import com.example.pr19.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentDAO studentDAO;
    private final UniversityDAO universityDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO, UniversityDAO universityDAO) {
        this.studentDAO = studentDAO;
        this.universityDAO = universityDAO;
    }

    public List<Student> getAll() {
        log.info("Find all srudents");
        return studentDAO.findAll();
    }

    public void delete(int id) {
        log.info("Delete student by id: " + id);
        studentDAO.deleteById(id);
    }

    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityDAO.findByName(studentDTO.getNameUniversity()));

        log.info("Save student with id: " + student.getId());

        studentDAO.save(student);
    }

    public List<Student> filterStudents(
            String universityName, String firstName, String middleName, String lastName
    ) {
        log.info("Filter students by universityName=" + universityName +
                ", firstName=" + firstName +
                ", middleName=" + middleName +
                ", lastName=" + lastName);

        return studentDAO
                .findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName(
                        universityName, firstName, middleName, lastName);
    }
}
