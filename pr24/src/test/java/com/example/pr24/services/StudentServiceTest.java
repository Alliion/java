package com.example.pr24.services;

import com.example.pr24.dao.StudentDAO;
import com.example.pr24.dao.UniversityDAO;
import com.example.pr24.dto.StudentDTO;
import com.example.pr24.models.Student;
import com.example.pr24.models.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentDAO studentDAO;
    @Mock
    private UniversityDAO universityDAO;
    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Student> captor;

    @Test
    public void getAll() {
        Student student1 = new Student();
        student1.setFirstName("1");
        Student student2 = new Student();
        student2.setFirstName("2");

        Mockito.when(studentDAO.findAll()).thenReturn(List.of(student1, student2));

        StudentService studentService = new StudentService(studentDAO,
                universityDAO, emailService);

        Assertions.assertEquals(2, studentService.getAll().size());
        Assertions.assertEquals("1", studentService.getAll().get(0).getFirstName());
    }

    @Test
    public void save() {
        University university = new University();
        university.setName("университет");

        StudentDTO student = new StudentDTO();
        student.setFirstName("1");
        student.setNameUniversity(university.getName());

        Mockito.when(universityDAO.findByName(university.getName())).thenReturn(university);

        StudentService studentService = new StudentService(studentDAO,
                universityDAO, emailService);
        studentService.save(student);

        Mockito.verify(studentDAO).save(captor.capture());

        Student captured = captor.getValue();
        Assertions.assertEquals("1", captured.getFirstName());
    }

    @Test
    public void filterStudents() {
        Student student1 = new Student();
        student1.setFirstName("1");
        Student student2 = new Student();
        student2.setFirstName("2");

        Mockito.when(studentDAO
                .findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName("", "1", "", "")
        ).thenReturn(List.of(student1));

        Mockito.when(studentDAO
                .findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName("", "2", "", "")
        ).thenReturn(List.of(student2));

        StudentService studentService = new StudentService(studentDAO,
                universityDAO, emailService);

        List<Student> students1 = studentService.filterStudents("", "1", "", "");
        List<Student> students2 = studentService.filterStudents("", "2", "", "");

        Assertions.assertEquals(1, students1.size());
        Assertions.assertEquals("1", students1.get(0).getFirstName());
        Assertions.assertEquals(1, students2.size());
        Assertions.assertEquals("2", students2.get(0).getFirstName());
    }
}
