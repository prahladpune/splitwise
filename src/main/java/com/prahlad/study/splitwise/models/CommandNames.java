package com.prahlad.study.splitwise.models;

public enum CommandNames {

    RegisterUser("Register"),
    UpdateUserProfile("UpdateProfile"),
    AddGroup("AddGroup")
    ;

    private final String commandName;
    CommandNames(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return this.commandName;
    }
}
