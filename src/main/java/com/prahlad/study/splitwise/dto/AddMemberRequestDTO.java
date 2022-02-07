package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddMemberRequestDTO {
    private Long groupId;
    private String groupName;
    private Long memberId;
}
