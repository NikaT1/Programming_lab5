package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для команды print_ascending, которая выводит элементы коллекции в порядке возрастания.
 */

@AllArgsConstructor
public class PrintAscendingCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        Stream<T> stream = storage.getCollectionSortedStream();
        String result = stream.map(Object::toString)
                .collect(Collectors.joining(";\n", "Текущая коллекция\n", ""));
        return new CommandResponse("OK", result);
    }
}
