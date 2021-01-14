package com.example.service;

import com.example.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    void deleteStudentById(Long id);


}
