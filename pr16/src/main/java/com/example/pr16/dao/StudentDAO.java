package com.example.pr16.dao;

import com.example.pr16.models.Student;
import com.example.pr16.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
    @Transactional
    void deleteAllByUniversity(University university);
}
