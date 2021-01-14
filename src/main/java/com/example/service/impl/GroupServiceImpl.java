package com.example.service.impl;

import com.example.dto.GroupDTO;
import com.example.exception.ServiceException;
import com.example.mapper.GroupToGroupDTOMapper;
import com.example.repository.GroupRepository;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupToGroupDTOMapper groupMapper;

    @Override
    public GroupDTO getGroupById(final Long id) {
        return groupMapper.toDTO(groupRepository.getGroupById(id));
    }

    @Override
    public List<GroupDTO> getAllGroups() {
        return groupRepository.getAllGroups().stream()
                .map(e -> groupMapper.toDTO(e))
                .collect(Collectors.toList());    }

    @Override
    public GroupDTO createGroup(final GroupDTO groupDTO) {

        if(groupDTO.getId() != null){
            throw new ServiceException(400, "Group shouldn't have an id ", null);
        }

        return groupMapper.toDTO(groupRepository.createGroup(groupMapper.toEntity(groupDTO, null)));
    }

    @Override
    public GroupDTO updateGroup(final GroupDTO groupDTO) {
        if(groupDTO.getId() == null){
            throw new ServiceException(400, "Group have an id ", null);
        }

        return groupMapper.toDTO(groupRepository.updateGroup(groupMapper.toEntity(groupDTO, null)));
    }

    @Override
    public void deleteGroupById(final Long id) {
        groupRepository.deleteGroupById(id);
    }
}
