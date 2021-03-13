package com.example.pr18.dao;

import com.example.pr18.models.Student;
import com.example.pr18.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
    @Transactional
    void deleteAllByUniversity(University university);

    @Query(value = "select student.* from student join university on university.id = student.university_id " +
            "where ('' = :firstName or first_name = :firstName) and " +
            "('' = :middleName or middle_name = :middleName) and " +
            "('' = :lastName or last_name = :lastName) and " +
            "('' = :universityName or university.name = :universityName)", nativeQuery = true)
    List<Student> findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName(
            String universityName, String firstName, String middleName, String lastName
    );
}
