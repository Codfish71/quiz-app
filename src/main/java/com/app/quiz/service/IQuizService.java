package com.app.quiz.service;

import com.app.quiz.model.quiz.QuizData;

import java.util.List;
import java.util.Optional;

public interface IQuizService {
    QuizData saveQuizResult(QuizData quizData);

    Optional<QuizData> getQuizResultByUserIdAndQuizId(String userId, Long quizId);

    List<QuizData> getAllQuizzesByUserId(String userId);
}
