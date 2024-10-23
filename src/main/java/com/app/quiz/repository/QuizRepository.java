package com.app.quiz.repository;

import com.app.quiz.model.quiz.QuizData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<QuizData, Long> {
    Optional<QuizData> findByUserIdAndQuizId(String userId, Long quizId);

    List<QuizData> findByUserId(String userId);
}
