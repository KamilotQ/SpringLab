package com.example.mapper;

import com.example.dto.StudentDTO;
import com.example.entity.Group;
import com.example.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentToStudentDTOMapper {
    public Student toEntity(final StudentDTO studentDTO, final List<Group> groupListList){
        final Student student = new Student();

        student.setId(studentDTO.getId());
        student.setFirstname(studentDTO.getFirstname());
        student.setLastname(studentDTO.getLastname());
        student.setBirth(studentDTO.getBirth());
        student.setGroups(groupListList);

        return student;
    }

    public StudentDTO toDto(final Student student){
        final StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setBirth(student.getBirth());

        return studentDTO;
    }
}
