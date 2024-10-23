package com.app.quiz.repository;

import com.app.quiz.model.quiz.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findBySubject(String subject, Pageable pageable);

    Page<Question> findByTopic(String topic, Pageable pageable);

    Page<Question> findBySubjectAndTopic(String subject, String topic, Pageable pageable);


}
