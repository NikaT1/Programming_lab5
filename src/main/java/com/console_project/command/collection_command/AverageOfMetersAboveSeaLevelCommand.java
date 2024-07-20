package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

/**
 * Класс для команды average_of_meters_above_sea_level, которая выводит среднее значение поля metersAboveSeaLevel
 * для всех элементов коллекции.
 */

@AllArgsConstructor
public class AverageOfMetersAboveSeaLevelCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        if (storage.getSize() == 0) return new CommandResponse("OK", "Коллекция пуста");
        double result = storage.averageOfMetersAboveSeaLevel();
        return new CommandResponse("OK", "Значение получено: " + result);
    }
}
