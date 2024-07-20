package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды remove_head, которая выводит и удаляет первый элемент из коллекции.
 */

@AllArgsConstructor
public class RemoveHeadCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }
    public CommandResponse execute(UserRequest<T> request) {
        if (storage.getSize() == 0) return new CommandResponse("OK", "Коллекция пуста");
        T t = storage.removeHead();
        return new CommandResponse("OK", "Удаление элемента успешно завершено: " + t.toString());
    }
}
