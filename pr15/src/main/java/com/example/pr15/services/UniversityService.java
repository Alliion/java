package com.example.pr15.services;

import com.example.pr15.dao.StudentDAO;
import com.example.pr15.dao.UniversityDAO;
import com.example.pr15.models.Student;
import com.example.pr15.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    private final UniversityDAO universityDAO;

    @Autowired
    public UniversityService(UniversityDAO universityDAO) {
        this.universityDAO = universityDAO;
    }

    public List<University> getAll() {
        return universityDAO.findAll();
    }

    public void delete(int id) {
        universityDAO.deleteById(id);
    }

    public void save(University student) {
        universityDAO.save(student);
    }
}
