package com.example.pr17.dao;

import com.example.pr17.models.Student;
import com.example.pr17.models.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentFilterDAO {
    @PersistenceContext
    EntityManager em;

    public List<Student> findAllStudentsByUniversityNameAndFirstNameAndMiddleNameAndLastName(
            String universityName, String firstName, String middleName, String lastName
    ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!universityName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("university").get("name"), universityName));
        }

        if (!firstName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("firstName"), firstName));
        }

        if (!middleName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("middleName"), middleName));
        }

        if (!lastName.equals("")) {
            predicates.add(cb.equal(studentRoot.get("lastName"), lastName));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}
