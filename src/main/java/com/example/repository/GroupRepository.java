package com.example.repository;

import com.example.entity.Subject;
import com.example.entity.Group;
import com.example.entity.Student;
import com.example.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GroupRepository {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init(){
        savedGroups = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Group> savedGroups;

    public List<Group> getGroupsByStudentId(final Long id){

        final Student student = studentRepository.getStudentById(id);

        return student.getGroups();
    }

    public Group getGroupById(final Long id){
        return savedGroups.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Group with id: " + id + " not found ", null));
    }

    public List<Group> getAllGroups(){
        return savedGroups;
    }

    public Group createGroup(final Group group){
        if(group.getId() != null){
            throw new ServiceException(400, "Group shouldn't have an id ", null);
        }

        ++lastId;
        group.setId(lastId);

        savedGroups.add(group);


        group.getStudent().getGroups().add(group);


        return group;
    }

    public Group updateGroup(final Group group){
        if(group.getId() == null){
            throw new ServiceException(400, "Group shouldn't have an id ", null);
        }

        final Group savedGroup = getGroupById(group.getId());

        savedGroup.setStudent(group.getStudent());
        savedGroup.setGroupDetails(group.getGroupDetails());
        savedGroup.setGroupDetails(group.getGroupDetails());

        return savedGroup;
    }

    public void deleteGroupById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedGroups.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Group with id: " + id + " not found ", null));

        savedGroups = savedGroups.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }

}
