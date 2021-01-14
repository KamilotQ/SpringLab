package com.example.resource;

import com.example.dto.SubjectDTO;
import com.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectResource {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects/{id}")
    public SubjectDTO getSubjectById(final @PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/subjects")
    public List<SubjectDTO> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping("/subjects")
    public SubjectDTO createSubject(final @RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }

    @PutMapping("/subjects")
    public SubjectDTO updateSubject(final @RequestBody SubjectDTO subjectDTO){
        return subjectService.updateSubject(subjectDTO);
    }

    @DeleteMapping("/subjects/{id}")
    public void deleteSubjectById(final @PathVariable Long id){
        subjectService.deleteSubjectById(id);
    }
}
