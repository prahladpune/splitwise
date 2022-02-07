package com.prahlad.study.splitwise.dto;

import com.prahlad.study.splitwise.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AddMemberResponseDTO {
    private Long groupId;
    private String groupName;
    private List<User> members;
}
