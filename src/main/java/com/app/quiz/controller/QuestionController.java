package com.app.quiz.controller;

import com.app.quiz.model.quiz.Question;
import com.app.quiz.service.IQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

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

}
