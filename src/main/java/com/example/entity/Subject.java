package com.example.entity;

public class Subject {
    private Long id;
    private String title;
    private String faculty;

    public Subject() {
    }

    public Subject(final Long id, final String title, final String faculty) {
        this.id = id;
        this.title = title;
        this.faculty = faculty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(final String faculty) {
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}