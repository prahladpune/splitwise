package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class AddGroupResponseDTO {

    private Long groupId;
    private String groupName;
}
