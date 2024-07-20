package com.console_project.io_util;

public interface IOutil<T> {

    T readObject();

    String readField(String message);

    boolean readAnswer(String message);

    void write(String s);
}
