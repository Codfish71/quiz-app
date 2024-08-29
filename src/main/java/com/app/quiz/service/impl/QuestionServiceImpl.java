package com.app.quiz.service.impl;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.repository.QuestionRepository;
import com.app.quiz.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if(questionOptional.isPresent()) {
            Question questionFromDB = questionOptional.get();
            questionFromDB.setQuestion(question.getQuestion());
            questionFromDB.setQuestionType(question.getQuestionType());
            questionFromDB.setAnswers(question.getAnswers());
            questionFromDB.setChoices(question.getChoices());
            questionFromDB.setSubject(question.getSubject());
            questionFromDB.setDifficulty(question.getDifficulty());
            questionRepository.save(questionFromDB);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
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
        Pageable pageable = PageRequest.of(0, numberOfQuestions);

        return questionRepository.findBySubject(subject, pageable).getContent();
    }
}
