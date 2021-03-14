package com.example.pr22.services;

import com.example.pr22.dao.StudentDAO;
import com.example.pr22.dao.UniversityDAO;
import com.example.pr22.models.Student;
import com.example.pr22.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@ManagedResource(objectName = "pr22MBeans:category=MBeans,name=SchedulerService")
public class SchedulerService {
    @Value("${folder.data.path}")
    private String pathToDataFolder;

    private final FileService fileService;

    private final UniversityDAO universityDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public SchedulerService(FileService fileService, UniversityDAO universityDAO, StudentDAO studentDAO) {
        this.fileService = fileService;
        this.universityDAO = universityDAO;
        this.studentDAO = studentDAO;
    }

    @Scheduled(fixedRate = 1800000)
    @ManagedOperation
    public void saveDataFromDBToFolder() {
        fileService.deleteAllFilesFolder(pathToDataFolder);

        StringBuilder stringStudents = new StringBuilder();
        for (Student student: studentDAO.findAll()) {
            stringStudents.append(student.toString()).append("\n");
        }
        fileService.writeToFile(pathToDataFolder + "\\student.txt", stringStudents.toString());

        StringBuilder stringUniversity = new StringBuilder();
        for (University university: universityDAO.findAll()) {
            stringUniversity.append(university.toString()).append("\n");
        }
        fileService.writeToFile(pathToDataFolder + "\\university.txt", stringUniversity.toString());
    }
}
