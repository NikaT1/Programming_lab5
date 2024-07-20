package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды update, которая обновляет значение элемента коллекции по его id.
 */

@AllArgsConstructor
public class UpdateIdCommand<T> implements Command<T> {

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
            if (storage.updateById(id, request.object())) {
                response = new CommandResponse("OK", "Обновление проведено");
            } else {
                response = new CommandResponse("OK", "Объект не найден");
            }
        } catch (NumberFormatException e) {
            response = new CommandResponse("ERROR", "Неправильный формат id");
        }
        return response;
    }
}
