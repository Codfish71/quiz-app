package com.app.quiz.model.quiz;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "question", unique=true)
    private String question;

    @NotBlank
    private String subject;

    @NotBlank
    private String questionType;

    @NotBlank
    private String difficulty;

    @NotNull
    @ElementCollection
    private List<String> choices;

    @NotNull
    @ElementCollection
    private List<String> answers;

    public Question(Long id, String question, String subject, String questionType, List<String> choices, List<String> answers, String difficulty) {
        this.id = id;
        this.question = question;
        this.subject = subject;
        this.questionType = questionType;
        this.choices = choices;
        this.answers = answers;
        this.difficulty = difficulty;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(id, question1.id) && Objects.equals(question, question1.question) && Objects.equals(subject, question1.subject) && Objects.equals(questionType, question1.questionType) && Objects.equals(choices, question1.choices) && Objects.equals(answers, question1.answers) && Objects.equals(difficulty, question1.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, subject, questionType, choices, answers, difficulty);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", subject='" + subject + '\'' +
                ", questionType='" + questionType + '\'' +
                ", choices=" + choices +
                ", answers=" + answers +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
