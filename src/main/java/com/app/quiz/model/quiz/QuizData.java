package com.app.quiz.model.quiz;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quiz_data")
public class QuizData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long quizId;
    private String userId;
    private String subject;
    private String topic;
    private int marks;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quiz_id")
    private List<QuestionData> questions;

    // Constructors
    public QuizData() {}

    public QuizData( String userId, String subject, String topic, int marks, List<QuestionData> questions) {

        this.userId = userId;
        this.subject = subject;
        this.topic = topic;
        this.marks = marks;
        this.questions = questions;
    }

    public Long getQuizId() {
        return quizId;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<QuestionData> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionData> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuizData{" +
                "userId=" + userId +
                ", subject='" + subject + '\'' +
                ", topic='" + topic + '\'' +
                ", marks=" + marks +
                ", questions=" + questions +
                '}';
    }
}
