package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequestDTO {
    private String name;
    private String phoneNumber;
    private String password;
}
