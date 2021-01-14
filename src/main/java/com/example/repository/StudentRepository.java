package com.example.repository;

import com.example.entity.Group;
import com.example.entity.Student;
import com.example.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    @PostConstruct
    public void init(){
        savedStudent = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Student> savedStudent;

    public Student getStudentById(final Long id){
        return savedStudent.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Student with id: " + id + " not found ", null));
    }

    public List<Student> getAllStudents(){
        return savedStudent;
    }

    public Student createStudent(final Student student){
        if(student.getId() != null){
            throw new ServiceException(400, "Student shouldn't have an id ", null);
        }

        ++lastId;
        student.setId(lastId);

        savedStudent.add(student);

        return student;
    }

    public Student updateStudent(final Student student){
        if(student.getId() == null){
            throw new ServiceException(400, "Student shouldn't have an id ", null);
        }

        final Student savedStudent = getStudentById(student.getId());

        savedStudent.setGroups(student.getGroups());
        savedStudent.setBirth(student.getBirth());
        savedStudent.setLastname(student.getLastname());
        savedStudent.setFirstname(student.getFirstname());

        return savedStudent;
    }

    public void deleteStudentById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedStudent.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Student with id: " + id + " not found ", null));

        savedStudent = savedStudent.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }

}
