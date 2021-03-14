package com.example.pr19.services;

import com.example.pr19.dao.StudentDAO;
import com.example.pr19.dao.UniversityDAO;
import com.example.pr19.models.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UniversityService {
    private final UniversityDAO universityDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public UniversityService(UniversityDAO universityDAO, StudentDAO studentDAO) {
        this.universityDAO = universityDAO;
        this.studentDAO = studentDAO;
    }

    public List<University> getAll() {
        log.info("Find all universities");
        return universityDAO.findAll();
    }

    public void delete(int id) {
        log.info("Delete user by id: " + id);
        Optional<University> optionalUniversity = universityDAO.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        studentDAO.deleteAllByUniversity(optionalUniversity.get());
        universityDAO.deleteById(id);
    }

    public void save(University university) {
        log.info("Save user with id: " + university.getId());
        universityDAO.save(university);
    }
}
