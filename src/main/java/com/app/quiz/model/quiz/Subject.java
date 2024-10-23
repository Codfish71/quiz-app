package com.app.quiz.model.quiz;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subjectName;

    @ElementCollection
    private Set<String> topic;

    public Subject() {
    }

    public Subject(String subjectName, Set<String> topic) {
        this.subjectName = subjectName;
        this.topic = topic;
    }

    public Set<String> getTopic() {
        return topic;
    }

    public void setTopic(Set<String> topic) {
        this.topic = topic;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
