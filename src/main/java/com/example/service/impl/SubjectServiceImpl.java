package com.example.service.impl;

import com.example.dto.SubjectDTO;
import com.example.exception.ServiceException;
import com.example.mapper.SubjectToSubjectDTOMapper;
import com.example.repository.SubjectRepository;
import com.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectToSubjectDTOMapper subjectToSubjectDTOMapper;

    @Override
    public SubjectDTO getSubjectById(final Long id) {

        return subjectToSubjectDTOMapper.toDTO(subjectRepository.getSubjectById(id));
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.getAllSubjects().stream()
                .map(e -> subjectToSubjectDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO createSubject(final SubjectDTO subjectDTO) {
        if(subjectDTO.getId() != null){
            throw new ServiceException(400, "Subject shouldn't have an id ", null);
        }

        return subjectToSubjectDTOMapper.toDTO(subjectRepository.createSubject(subjectToSubjectDTOMapper.toEntity(subjectDTO)));
    }

    @Override
    public SubjectDTO updateSubject(final SubjectDTO subjectDTO) {
        if(subjectDTO.getId() == null){
            throw new ServiceException(400, "Subject have an id ", null);
        }

        return subjectToSubjectDTOMapper.toDTO(subjectRepository.updateSubject(subjectToSubjectDTOMapper.toEntity(subjectDTO)));
    }

    @Override
    public void deleteSubjectById(final Long id) {
        subjectRepository.deleteSubjectById(id);
    }
}
