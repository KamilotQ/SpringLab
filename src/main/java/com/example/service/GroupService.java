package com.example.service;

import com.example.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    GroupDTO getGroupById(Long id);
    List<GroupDTO> getAllGroups();
    GroupDTO createGroup(GroupDTO groupDTO);
    GroupDTO updateGroup(GroupDTO groupDTO);
    void deleteGroupById(Long id);
}
