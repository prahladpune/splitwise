package com.prahlad.study.splitwise.commands;

import com.prahlad.study.splitwise.controller.UserController;
import com.prahlad.study.splitwise.dto.UpdateUserProfileRequestDTO;
import com.prahlad.study.splitwise.dto.UpdateUserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.prahlad.study.splitwise.models.CommandNames.UpdateUserProfile;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateUserProfileCommand implements Command {

    private final UserController userController;

    @Override
    public void execute(String inputString) {

        String[] inputs = inputString.split(" ");
        UpdateUserProfileResponseDTO updateUserProfileResponseDTO = userController.updateUserProfile(UpdateUserProfileRequestDTO.builder().build()).getBody();
        log.info("command updateProfile executed successfully");

    }

    @Override
    public boolean matches(String inputString) {
        String[] inputs = inputString.split(" ");

        return inputs.length == 2 && inputs[1].equals(UpdateUserProfile.getCommandName());
    }
}
