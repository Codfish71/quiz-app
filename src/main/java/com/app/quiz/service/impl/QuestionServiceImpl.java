package com.app.quiz.service.impl;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.model.quiz.Subject;
import com.app.quiz.repository.QuestionRepository;
import com.app.quiz.repository.SubjectRepository;
import com.app.quiz.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Question createQuestion(Question question) {
        createSubjectForQuestions(question.getSubject(), question.getTopic());
        return questionRepository.save(question);
    }

    @Override
    public List<Question> createListOfQuestions(List<Question> questionList) {
        createSubjectForQuestions(questionList.get(0).getSubject(), questionList.get(0).getTopic());
        return questionRepository.saveAll(questionList);
    }

    private void createSubjectForQuestions(String subjectName, String topic){
        Subject subject = new Subject(subjectName, new HashSet<String>());
        Subject subjectFromDb = subjectRepository.findBySubjectName(subjectName);
            if(subjectFromDb !=null) {
                Set<String> oldTopicList = subjectFromDb.getTopic();
                oldTopicList.add(topic);
                subjectFromDb.setTopic(oldTopicList);
                saveSubject(subjectFromDb);
            } else {
                subject.setSubjectName(subjectName);
                Set<String> newTopicList = new HashSet<String>();
                newTopicList.add(topic);
                subject.setTopic(newTopicList);
                saveSubject(subject);
            }

//        }
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
            questionFromDB.setTopic(question.getTopic());
            questionRepository.save(questionFromDB);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
        return null;
    }

    @Override
    public List<Question> deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return getAllQuestions();
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
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

    @Override
    public List<Question> getQuestionsForTopic(Integer numberOfQuestions, String topic) {
        Pageable pageable = PageRequest.of(0, numberOfQuestions);
        return questionRepository.findByTopic(topic, pageable).getContent();
    }

    @Override
    public Optional<Subject> getSubject(int id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Question> getQuestionsForSubjectAndTopic(String subject, String topic, Integer numberOfQuestions) {
        Pageable pageable = PageRequest.of(0, numberOfQuestions);
        return questionRepository.findBySubjectAndTopic(subject, topic, pageable).getContent();
    }

    @Override
    public Set<String> getAllTopicsForSubjects(String subject) {
        Subject subjectFromDb = subjectRepository.findBySubjectName(subject);
        if (subjectFromDb != null) {
            return subjectFromDb.getTopic();
        } else {
            throw new RuntimeException("Subject doenst exist");
        }
    }
}
