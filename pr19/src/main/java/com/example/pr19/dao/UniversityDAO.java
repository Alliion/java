package com.example.pr19.dao;

import com.example.pr19.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityDAO extends JpaRepository<University, Integer> {
    University findByName(String name);
}
