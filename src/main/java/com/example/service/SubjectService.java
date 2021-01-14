package com.example.service;

import com.example.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {
    SubjectDTO getSubjectById(Long id);
    List<SubjectDTO> getAllSubjects();
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectDTO updateSubject(SubjectDTO subjectDTO);
    void deleteSubjectById(Long id);

}
