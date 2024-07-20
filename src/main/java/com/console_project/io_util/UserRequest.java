package com.console_project.io_util;

public record UserRequest<T> (
        String params,
        String command,
        T object
) {}
