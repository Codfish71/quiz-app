package com.app.quiz.repository;

import com.app.quiz.model.quiz.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findBySubjectName(String subjectName);
}
