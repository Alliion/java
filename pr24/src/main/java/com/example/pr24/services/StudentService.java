package com.example.pr24.services;

import com.example.pr24.annotations.LogTime;
import com.example.pr24.dao.StudentDAO;
import com.example.pr24.dao.UniversityDAO;
import com.example.pr24.dto.StudentDTO;
import com.example.pr24.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentDAO studentDAO;
    private final UniversityDAO universityDAO;

    private final EmailService emailService;

    @Autowired
    public StudentService(StudentDAO studentDAO, UniversityDAO universityDAO, EmailService emailService) {
        this.studentDAO = studentDAO;
        this.universityDAO = universityDAO;
        this.emailService = emailService;
    }

    /**
     * Выводит всех студентов из бд
     * @return
     */
    @LogTime
    @Transactional
    public List<Student> getAll() {
        log.info("Find all srudents");
        return studentDAO.findAll();
    }

    /**
     * Удаляет студента по id
     * @param id id студента
     */
    @LogTime
    @Transactional
    public void delete(int id) {
        log.info("Delete student by id: " + id);
        studentDAO.deleteById(id);
    }

    /**
     * Создаёт нового или обновляет старого студента
     * у которого id равен с studentDTO.id
     * @param studentDTO данные нового
     */
    @LogTime
    @Transactional
    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityDAO.findByName(studentDTO.getNameUniversity()));

        log.info("Save student with id: " + student.getId());
        emailService.sendInfoAboutSaveObject("Save: " + student.toString());

        studentDAO.save(student);
    }

    /**
     * Фильтрует студентов по параметрам, указанные в методе
     * @param universityName название университета
     * @param firstName имя студента
     * @param middleName отчество студента
     * @param lastName фамилия студента
     * @return отфильтрованный список студентов
     */
    @LogTime
    @Transactional
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
