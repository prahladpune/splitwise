package com.prahlad.study.splitwise.commands;

import org.springframework.stereotype.Component;

@Component
public interface Command {

    void execute(String inputString);

    boolean matches(String inputString);
}
