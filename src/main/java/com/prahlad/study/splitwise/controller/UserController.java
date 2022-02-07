package com.prahlad.study.splitwise.controller;

import com.prahlad.study.splitwise.dto.RegisterUserRequestDTO;
import com.prahlad.study.splitwise.dto.RegisterUserResponseDTO;
import com.prahlad.study.splitwise.dto.UpdateUserProfileRequestDTO;
import com.prahlad.study.splitwise.dto.UpdateUserProfileResponseDTO;
import com.prahlad.study.splitwise.models.User;
import com.prahlad.study.splitwise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<RegisterUserResponseDTO> registerUser(RegisterUserRequestDTO registerUserDTO) {
        User user = userService.registerUser(registerUserDTO.getName(), registerUserDTO.getPhoneNumber(), registerUserDTO.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(RegisterUserResponseDTO.builder().userId(user.getId()).build());

    }

    public ResponseEntity<UpdateUserProfileResponseDTO> updateUserProfile(UpdateUserProfileRequestDTO updateUserProfileRequestDTO) {

        User user = userService.updateUserProfile(updateUserProfileRequestDTO.getUserId(), updateUserProfileRequestDTO.getNewPassword());

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(UpdateUserProfileResponseDTO.builder().userId(user.getId()).userName(user.getName()).build());
    }
}
