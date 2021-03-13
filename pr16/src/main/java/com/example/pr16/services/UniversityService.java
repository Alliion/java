package com.example.pr16.services;

import com.example.pr16.dao.StudentDAO;
import com.example.pr16.dao.UniversityDAO;
import com.example.pr16.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    private final UniversityDAO universityDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public UniversityService(UniversityDAO universityDAO, StudentDAO studentDAO) {
        this.universityDAO = universityDAO;
        this.studentDAO = studentDAO;
    }

    public List<University> getAll() {
        return universityDAO.findAll();
    }

    public void delete(int id) {
        Optional<University> optionalUniversity = universityDAO.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        studentDAO.deleteAllByUniversity(optionalUniversity.get());
        universityDAO.deleteById(id);
    }

    public void save(University student) {
        universityDAO.save(student);
    }
}
