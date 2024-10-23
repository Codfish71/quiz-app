package com.app.quiz.service.impl;

import com.app.quiz.model.quiz.QuizData;
import com.app.quiz.repository.QuizRepository;
import com.app.quiz.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements IQuizService {

    @Autowired
    private QuizRepository quizRepository;

    public QuizData saveQuizResult(QuizData quizData) {
        return quizRepository.save(quizData);
    }

    public Optional<QuizData> getQuizResultByUserIdAndQuizId(String userId, Long quizId) {
        return quizRepository.findByUserIdAndQuizId(userId, quizId);
    }

    public List<QuizData> getAllQuizzesByUserId(String userId) {
        return quizRepository.findByUserId(userId);
    }
}
