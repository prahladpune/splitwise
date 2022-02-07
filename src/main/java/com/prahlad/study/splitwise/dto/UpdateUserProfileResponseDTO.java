package com.prahlad.study.splitwise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserProfileResponseDTO {
    private Long userId;
    private String userName;
    private String phoneNumber;
    private String password;
}
