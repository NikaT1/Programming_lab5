package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import com.console_project.file_util.FileReaderWriter;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды save, которая сохраняет в файл коллекцию.
 */

@AllArgsConstructor
public class SaveCommand<T> implements Command<T> {

    private final FileReaderWriter readerWriter;
    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        CommandResponse response;
        try {
            readerWriter.write(storage.getCollectionStream());
            response = new CommandResponse("OK", "Коллекция сохранена");
        } catch (Exception e) {
            response = new CommandResponse("ERROR", e.getMessage());
        }
        return response;
    }
}
