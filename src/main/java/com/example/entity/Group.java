package com.example.entity;


import java.util.HashMap;
import java.util.Map;

public class Group {
    private Long id;
    private Student student;
    private Map<Subject, Integer> groupDetails = new HashMap<>();

    public Group() {
    }

    public Group(final Long id, final Student student, final Map<Subject, Integer> groupDetails) {
        this.id = id;
        this.student = student;
        this.groupDetails = groupDetails;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }

    public Map<Subject, Integer> getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(final Map<Subject, Integer> groupDetails) {
        this.groupDetails = groupDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}