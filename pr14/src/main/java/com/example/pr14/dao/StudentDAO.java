package com.example.pr14.dao;

import com.example.pr14.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {
    private List<Student> studentList = new ArrayList<>();
    {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Жилин");
        student.setLastName("Демьян");
        student.setMiddleName("Григорьевич");
        studentList.add(student);
    }


    public void save(Student student) {
        student.setId(studentList.size());
        studentList.add(student);
    }

    public void delete(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                break;
            }
        }
    }

    public List<Student> getAll() {
        return studentList;
    }
}
