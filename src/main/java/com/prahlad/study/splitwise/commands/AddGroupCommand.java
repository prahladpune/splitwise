package com.prahlad.study.splitwise.commands;

import com.prahlad.study.splitwise.controller.GroupController;
import com.prahlad.study.splitwise.dto.AddGroupRequestDTO;
import com.prahlad.study.splitwise.dto.AddGroupResponseDTO;
import com.prahlad.study.splitwise.models.CommandNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddGroupCommand implements Command {

    private final GroupController groupController;

    @Override
    public void execute(String inputString) {
        String[] inputs = inputString.split(" ");
        AddGroupResponseDTO addGroupResponseDTO = groupController.addGroup(AddGroupRequestDTO.builder().groupName(inputs[1]).build()).getBody();
        log.info(Objects.requireNonNull(addGroupResponseDTO).toString());

    }

    @Override
    public boolean matches(String inputString) {
        String[] inputs = inputString.split(" ");

        return inputs.length == 2 && inputs[0].equals(CommandNames.AddGroup.getCommandName());

    }
}
