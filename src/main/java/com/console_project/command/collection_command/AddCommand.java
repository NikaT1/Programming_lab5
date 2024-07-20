package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import com.console_project.exception.TooMuchElementsException;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

import java.util.NoSuchElementException;

/**
 * Класс для команды add, которая добавляет новый элемент в коллекцию.
 */

@AllArgsConstructor
public class AddCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }
    @Override
    public CommandResponse execute(UserRequest<T> request) {
        CommandResponse response;
        try {
            storage.addElement(request.object());
            response = new CommandResponse("OK", "В коллекцию добавлен новый элемент");
        } catch (TooMuchElementsException e) {
            response = new CommandResponse("ERROR", "Ошибка: в коллекции слишком много элементов;" +
                    " объект коллекции не создан");
        } catch (NoSuchElementException e) {
            response = new CommandResponse("ERROR", "Не указаны значения для создания " +
                    "элемента коллекции. Команда add не выполнена");
        }
        return response;
    }

}
