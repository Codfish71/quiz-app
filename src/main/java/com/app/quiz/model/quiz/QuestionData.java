package com.app.quiz.model.quiz;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "question_data")
public class QuestionData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionDataId;
    private String question;
    private String selectedAnswer;
    private String correctAnswer;
    private String[] choices;
    private String difficulty;

    // Constructors
    public QuestionData() {}

    public QuestionData(String question, String selectedAnswer, String correctAnswer, String[] choices, String difficulty) {
        this.question = question;
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
        this.choices = choices;
        this.difficulty = difficulty;
    }

    // Getters and Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[]choices) {
        this.choices = choices;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "question='" + question + '\'' +
                ", selectedAnswer='" + selectedAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", choices=" + choices +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}

