package com.example.mapper;

import com.example.dto.SubjectDTO;
import com.example.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectToSubjectDTOMapper {
    public Subject toEntity(final SubjectDTO subjectDTO){
        final Subject subject = new Subject();

        subject.setId(subjectDTO.getId());
        subject.setFaculty(subjectDTO.getFaculty());
        subject.setTitle(subjectDTO.getTitle());

        return subject;
    }

    public SubjectDTO toDTO(final Subject subject){
        final SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setId(subject.getId());
        subjectDTO.setFaculty(subject.getFaculty());
        subjectDTO.setTitle(subject.getTitle());

        return subjectDTO;
    }
}
