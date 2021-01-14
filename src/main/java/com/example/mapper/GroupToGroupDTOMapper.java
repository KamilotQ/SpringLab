package com.example.mapper;

import com.example.dto.GroupDTO;
import com.example.entity.Group;
import com.example.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class GroupToGroupDTOMapper {

    public Group toEntity(final GroupDTO groupDTO, final Student student){
        final Group group = new Group();

        group.setId(groupDTO.getId());
        group.setGroupDetails(group.getGroupDetails());
        group.setStudent(student);

        return group;
    }

    public GroupDTO toDTO(final Group group){
        final GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId(group.getId());

        if(group.getStudent() != null){
//            groupDTO.setStudentFirstname(group.getStudent().getFirstname());
//            groupDTO.setStudentLastname(group.getStudent().getLastname());
        }

        return groupDTO;
    }
}
