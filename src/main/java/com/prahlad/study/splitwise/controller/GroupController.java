package com.prahlad.study.splitwise.controller;

import com.prahlad.study.splitwise.dto.AddGroupRequestDTO;
import com.prahlad.study.splitwise.dto.AddGroupResponseDTO;
import com.prahlad.study.splitwise.dto.AddMemberRequestDTO;
import com.prahlad.study.splitwise.dto.AddMemberResponseDTO;
import com.prahlad.study.splitwise.models.Group;
import com.prahlad.study.splitwise.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    public ResponseEntity<AddGroupResponseDTO> addGroup(AddGroupRequestDTO addGroupRequestDTO) {

        Group group = groupService.addGroup(addGroupRequestDTO.getGroupName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AddGroupResponseDTO
                        .builder()
                        .groupId(group.getId())
                        .groupName(group.getName())
                        .build());
    }

    public ResponseEntity<AddMemberResponseDTO> addMember(AddMemberRequestDTO addMemberRequestDTO){

        Group group = groupService.addMember(addMemberRequestDTO.getGroupId(), addMemberRequestDTO.getMemberId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AddMemberResponseDTO
                        .builder()
                        .members(group.getMembers())
                        .groupName(group.getName())
                        .groupId(group.getId())
                        .build());
    }

}
