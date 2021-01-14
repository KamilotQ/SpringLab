package com.example.resource;

import com.example.dto.StudentDTO;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public StudentDTO getStudentById(final @PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public StudentDTO createStudent(final @Valid @RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/students")
    public StudentDTO getStudentById(final @Valid @RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(final @PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}
