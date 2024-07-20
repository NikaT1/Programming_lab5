package com.console_project.command;

import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;

import java.util.HashMap;

public class CommandInvoker<T> {

    private final HashMap<String, Command<T>> commands = new HashMap<>();

    public void registerCommand(Command<T> command) {
        commands.put(command.getName(), command);
    }

    public CommandResponse processRequest(UserRequest<T> request) {
        return commands.get(request.command()).execute(request);
    }
}
