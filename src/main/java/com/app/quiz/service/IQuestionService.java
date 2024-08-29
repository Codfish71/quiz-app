package com.app.quiz.service;

import com.app.quiz.model.quiz.Question;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IQuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestionById(Long id);

    Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException;

    void deleteQuestion(Long id);

    List<String> getAllSubjects();

    List<Question> getQuestionsForTest(Long testId);

    List<Question> getQuestionsForSubject(Integer numberOfQuestions, String subject);

}
