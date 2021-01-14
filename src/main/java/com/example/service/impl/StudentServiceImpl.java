package com.example.service.impl;

import com.example.dto.StudentDTO;
import com.example.exception.ServiceException;
import com.example.mapper.StudentToStudentDTOMapper;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentToStudentDTOMapper studentMapper;

    @Override
    public StudentDTO getStudentById(final Long id) {
        return studentMapper.toDto(studentRepository.getStudentById(id));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.getAllStudents().stream()
                .map(e -> studentMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(final StudentDTO studentDTO) {

        if(studentDTO.getId() != null){
            throw new ServiceException(400, "Student shouldn't have an id ", null);
        }

        return studentMapper.toDto(studentRepository.createStudent(studentMapper.toEntity(studentDTO, null)));
    }

    @Override
    public StudentDTO updateStudent(final StudentDTO studentDTO) {

        if(studentDTO.getId() == null){
            throw new ServiceException(400, "Student have an id ", null);
        }

        return studentMapper.toDto(studentRepository.updateStudent(studentMapper.toEntity(studentDTO, null)));
    }

    @Override
    public void deleteStudentById(final Long id) {
        studentRepository.deleteStudentById(id);
    }
}
