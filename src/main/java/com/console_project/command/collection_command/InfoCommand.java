package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды info, которая выводит в стандартный поток вывода информацию о коллекции.
 */

@AllArgsConstructor
public class InfoCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        String result = "тип: PriorityQueue" + "\nдата инициализации: " + storage.getCreationDate() +
                "\nколичество элементов: " + storage.getSize();
        return new CommandResponse("OK", result);
    }
}
