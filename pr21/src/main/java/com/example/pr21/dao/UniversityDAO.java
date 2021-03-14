package com.example.pr21.dao;

import com.example.pr21.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityDAO extends JpaRepository<University, Integer> {
    University findByName(String name);
}
