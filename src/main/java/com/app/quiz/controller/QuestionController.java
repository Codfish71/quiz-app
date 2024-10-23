package com.app.quiz.controller;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.model.quiz.QuizData;
import com.app.quiz.model.quiz.Subject;
import com.app.quiz.service.IQuestionService;
import com.app.quiz.service.IQuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IQuizService quizService;

    @PostMapping("/savequestion")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    @PostMapping("saveallquestions")
    public ResponseEntity<List<Question>> createQuestionList(@Valid @RequestBody List<Question> questionList) {
        List<Question> questions = questionService.createListOfQuestions(questionList);
        return ResponseEntity.status(HttpStatus.CREATED).body(questions);
    }

    @GetMapping("/getallquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions());
    }

    @GetMapping("/getquestionbyid/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionById(id));
    }

    @PutMapping("/updatequestion/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") Long id, @Valid @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.updateQuestion(id, question));
    }

    @GetMapping("/getquestionsbysubject")
    public ResponseEntity<List<Question>> getQuestionsBySubject(@RequestParam(name = "numberofquestions") int numberOfQuestion, @RequestParam(name = "subject") String subject) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsForSubject(numberOfQuestion, subject));
    }

    @GetMapping("/getquestionsbysubjectandtopic")
    public ResponseEntity<List<Question>> getQuestionsBySubjectAndTopic( @RequestParam(name = "subject") String subject, @RequestParam(name = "topic") String topic, @RequestParam(name = "numberofquestions") int numberOfQuestion) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsForSubjectAndTopic(subject, topic, numberOfQuestion));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Question>> deleteQuestionById(@RequestParam(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(questionService.deleteQuestion(id));
    }

    @GetMapping("/gettopics/{id}")
    public ResponseEntity<Optional<Subject>> getTopicsBySubject(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getSubject(id));
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllSubjects());
    }

    @GetMapping("/topics")
    public ResponseEntity<Set<String>> getAllTopicsForSubjects(@RequestParam String subject) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllTopicsForSubjects(subject));
    }

    @PostMapping("/submitquiz")
    public ResponseEntity<String> submitQuiz(@RequestBody QuizData quizData) {
        try {
            // Save quiz result to database
            quizService.saveQuizResult(quizData);
            return ResponseEntity.status(HttpStatus.OK).body("QUiz Submitted SUccessfully");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save quiz result", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/quiz-results/{userId}/{quizId}")
    public ResponseEntity<QuizData> getQuizResultByUserIdAndQuizId(@PathVariable String userId, @PathVariable Long quizId) {
        try {
            Optional<QuizData> quizResult = quizService.getQuizResultByUserIdAndQuizId(userId, quizId);
            return quizResult.map(quizData -> new ResponseEntity<>(quizData, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/quizzes/{userId}")
    public ResponseEntity<List<QuizData>> getAllQuizzesByUserId(@PathVariable String userId) {
        try {
            List<QuizData> quizzes = quizService.getAllQuizzesByUserId(userId);
            return new ResponseEntity<>(quizzes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
