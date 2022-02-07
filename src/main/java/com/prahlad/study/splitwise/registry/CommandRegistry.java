package com.prahlad.study.splitwise.registry;

import com.prahlad.study.splitwise.commands.Command;

public interface CommandRegistry {

    void register(Command command);
    void execute(String inputString);
}
