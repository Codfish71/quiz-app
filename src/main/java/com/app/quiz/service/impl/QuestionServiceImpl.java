package com.app.quiz.service.impl;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.repository.QuestionRepository;
import com.app.quiz.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public List<String> getAllSubjects() {
        return List.of();
    }

    @Override
    public List<Question> getQuestionsForTest(Long testId) {
        return List.of();
    }

    @Override
    public List<Question> getQuestionsForSubject(Integer numberOfQuestions, String subject) {
        return List.of();
    }
}
