package com.example.resource;

import com.example.dto.GroupDTO;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GroupResource {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups/{id}")
    public GroupDTO getGroupById(final @PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @GetMapping("/groups")
    public List<GroupDTO> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PostMapping("/groups")
    public GroupDTO createGroup(final @Valid @RequestBody GroupDTO groupDTO){
        return groupService.createGroup(groupDTO);
    }

    @PutMapping("/groups")
    public GroupDTO getGroupById(final @RequestBody GroupDTO groupDTO){
        return groupService.updateGroup(groupDTO);
    }

    @DeleteMapping("/groups/{id}")
    public void deleteGroupById(final @PathVariable Long id){
        groupService.deleteGroupById(id);
    }
}
