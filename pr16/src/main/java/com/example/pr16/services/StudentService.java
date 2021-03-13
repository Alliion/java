package com.example.pr16.services;

import com.example.pr16.dao.StudentDAO;
import com.example.pr16.dao.UniversityDAO;
import com.example.pr16.dto.StudentDTO;
import com.example.pr16.models.Student;
import com.example.pr16.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
}
