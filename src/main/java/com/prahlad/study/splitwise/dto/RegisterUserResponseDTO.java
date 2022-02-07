package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class RegisterUserResponseDTO {
    private Long userId;
}
