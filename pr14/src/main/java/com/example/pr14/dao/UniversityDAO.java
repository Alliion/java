package com.example.pr14.dao;

import com.example.pr14.models.Student;
import com.example.pr14.models.University;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityDAO {
    private List<University> universityList = new ArrayList<>();
    {
        University university = new University();
        university.setId(1);
        university.setName("РТУ МИРЭА");
        university.setCreationDate("2015 год");
        universityList.add(university);
    }


    public void save(University university) {
        university.setId(universityList.size());
        universityList.add(university);
    }

    public void delete(int id) {
        for (int i = 0; i < universityList.size(); i++) {
            if (universityList.get(i).getId() == id) {
                universityList.remove(i);
                break;
            }
        }
    }

    public List<University> getAll() {
        return universityList;
    }
}
