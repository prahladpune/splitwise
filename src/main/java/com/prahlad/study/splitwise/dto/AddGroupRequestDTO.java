package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddGroupRequestDTO {
    private String groupName;
}
