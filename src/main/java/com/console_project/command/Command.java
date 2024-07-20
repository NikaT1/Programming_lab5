package com.console_project.command;

import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;

public interface Command<T> {
    CommandResponse execute(UserRequest<T> request);

    String getName();
}
