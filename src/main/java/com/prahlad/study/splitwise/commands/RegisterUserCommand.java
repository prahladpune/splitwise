package com.prahlad.study.splitwise.commands;

import com.prahlad.study.splitwise.controller.UserController;
import com.prahlad.study.splitwise.dto.RegisterUserRequestDTO;
import com.prahlad.study.splitwise.dto.RegisterUserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.prahlad.study.splitwise.models.CommandNames.RegisterUser;

@Component
@RequiredArgsConstructor
public class RegisterUserCommand implements Command {

    private final UserController userController;
    @Override
    public void execute(String inputString) {

        List<String> inputList = Arrays.stream(inputString.split(" ")).collect(Collectors.toList());
        String username = inputList.get(1);
        String phoneNumber = inputList.get(2);
        String password = inputList.get(3);

        RegisterUserResponseDTO response = userController.registerUser(
                RegisterUserRequestDTO.builder()
                        .name(username)
                        .phoneNumber(phoneNumber)
                        .password(password)
                        .build()).getBody();
        System.out.println("UserId " + Objects.requireNonNull(response).getUserId());

    }

    @Override
    public boolean matches(String inputString) {

        String[] inputs = inputString.split(" ");

        return inputs.length == 4 && inputs[0].equals(RegisterUser.getCommandName());
    }
}
