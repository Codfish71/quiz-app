package com.app.quiz.service;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.model.quiz.Subject;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface IQuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestionById(Long id);

    Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException;

    List<Question> deleteQuestion(Long id);

    List<Subject> getAllSubjects();

    List<Question> getQuestionsForTest(Long testId);

    List<Question> getQuestionsForSubject(Integer numberOfQuestions, String subject);

    List<Question> getQuestionsForTopic(Integer numberOfQuestions, String topic);

    List<Question> createListOfQuestions(@Valid List<Question> questionList);

    Optional<Subject> getSubject(int id);

    Subject saveSubject(Subject subject);

    List<Question> getQuestionsForSubjectAndTopic(String subject, String subject1, Integer numberOfQuestions);

    Set<String> getAllTopicsForSubjects(String subject);
}
