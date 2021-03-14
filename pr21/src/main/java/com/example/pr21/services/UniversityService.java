package com.example.pr21.services;

import com.example.pr21.annotations.LogTime;
import com.example.pr21.dao.StudentDAO;
import com.example.pr21.dao.UniversityDAO;
import com.example.pr21.models.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UniversityService {
    private final UniversityDAO universityDAO;
    private final StudentDAO studentDAO;

    private final EmailService emailService;

    @Autowired
    public UniversityService(UniversityDAO universityDAO, StudentDAO studentDAO, EmailService emailService) {
        this.universityDAO = universityDAO;
        this.studentDAO = studentDAO;
        this.emailService = emailService;
    }

    @LogTime
    @Transactional
    public List<University> getAll() {
        log.info("Find all universities");
        return universityDAO.findAll();
    }

    @LogTime
    @Transactional
    public void delete(int id) {
        log.info("Delete user by id: " + id);
        Optional<University> optionalUniversity = universityDAO.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        studentDAO.deleteAllByUniversity(optionalUniversity.get());
        universityDAO.deleteById(id);
    }

    @LogTime
    @Transactional
    public void save(University university) {
        log.info("Save user with id: " + university.getId());
        emailService.sendInfoAboutSaveObject("Save: " + university.toString());
        universityDAO.save(university);
    }
}
