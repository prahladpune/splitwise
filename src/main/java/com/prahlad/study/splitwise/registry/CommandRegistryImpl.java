package com.prahlad.study.splitwise.registry;

import com.prahlad.study.splitwise.commands.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandRegistryImpl implements CommandRegistry {

    private final List<Command> commands;

    @Override
    public void register(Command command) {
        commands.add(command);
    }

    @Override
    public void execute(String inputString) {
        for (Command command : commands) {
            if (command.matches(inputString)) {
                command.execute(inputString);
                return;
            }
        }

        throw new RuntimeException("Invalid command " + inputString);
    }
}
