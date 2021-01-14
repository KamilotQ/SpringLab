package com.example.repository;

import com.example.entity.Subject;
import com.example.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubjectRepository {

    @PostConstruct
    public void init(){
        savedSubjects = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Subject> savedSubjects;

    public Subject getSubjectById(final Long id){
        return savedSubjects.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Subject with id: " + id + " not found ", null));
    }

    public List<Subject> getAllSubjects(){
        return savedSubjects;
    }

    public Subject createSubject(final Subject subject){
        if(subject.getId() != null){
            throw new ServiceException(400, "Subject shouldn't have an id ", null);
        }

        ++lastId;
        subject.setId(lastId);

        savedSubjects.add(subject);

        return subject;
    }

    public Subject updateSubject(final Subject subject){
        if(subject.getId() == null){
            throw new ServiceException(400, "Student shouldn't have an id ", null);
        }

        final Subject savedSubject= getSubjectById(subject.getId());


        savedSubject.setTitle(subject.getTitle());
        savedSubject.setFaculty(subject.getFaculty());

        return savedSubject;
    }

    public void deleteSubjectById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedSubjects.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Subject with id: " + id + " not found ", null));

        savedSubjects = savedSubjects.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
