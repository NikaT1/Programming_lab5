package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды remove_by_id, которая удаляет элемент из коллекции по его id.
 */

@AllArgsConstructor
public class RemoveByIdCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        CommandResponse response;
        try {
            int id = Integer.parseInt(request.params());
            storage.deleteById(id);
            response = new CommandResponse("OK", "Удаление завершено");
        } catch (NumberFormatException e) {
            response = new CommandResponse("ERROR", "Неправильный формат id");
        }
        return response;
    }
}
