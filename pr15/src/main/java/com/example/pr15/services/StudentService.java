package com.example.pr15.services;

import com.example.pr15.dao.StudentDAO;
import com.example.pr15.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    public void delete(int id) {
        studentDAO.deleteById(id);
    }

    public void save(Student student) {
        studentDAO.save(student);
    }
}
