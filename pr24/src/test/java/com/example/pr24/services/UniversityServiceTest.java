package com.example.pr24.services;


import com.example.pr24.dao.StudentDAO;
import com.example.pr24.dao.UniversityDAO;
import com.example.pr24.models.University;
import com.example.pr24.models.User;
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
public class UniversityServiceTest {
    @Mock
    private UniversityDAO universityDAO;
    @Mock
    private StudentDAO studentDAO;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<University> captor;

    @Test
    public void getAll() {
        University university1 = new University();
        university1.setName("1");
        University university2 = new University();
        university2.setName("2");

        Mockito.when(universityDAO.findAll()).thenReturn(List.of(university1, university2));

        UniversityService universityService = new UniversityService(universityDAO,
                studentDAO, emailService);

        Assertions.assertEquals(2, universityService.getAll().size());
        Assertions.assertEquals("1", universityService.getAll().get(0).getName());
    }

    @Test
    public void save() {
        University university = new University();
        university.setName("1");

        UniversityService universityService = new UniversityService(universityDAO,
                studentDAO, emailService);
        universityService.save(university);

        Mockito.verify(universityDAO).save(captor.capture());

        University captured = captor.getValue();
        Assertions.assertEquals("1", captured.getName());
    }
}
