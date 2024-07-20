package com.console_project.command.collection_command;

import com.console_project.command.TypeOfCommand;
import com.console_project.io_util.CommandResponse;
import com.console_project.io_util.UserRequest;
import com.console_project.command.Command;
import lombok.AllArgsConstructor;
import com.console_project.storage.Storage;

import java.util.Map;

/**
 * Класс для команды group_counting_by_meters_above_sea_level, которая группирует элементы коллекции по значению
 * поля metersAboveSeaLevel и выводит количество элементов в каждой группе.
 */

@AllArgsConstructor
public class GroupCountingByMetersAboveSeaLevelCommand<T> implements Command<T> {

    private final Storage<T> storage;
    private final TypeOfCommand type;

    @Override
    public String getName() {
        return type.getName();
    }

    public CommandResponse execute(UserRequest<T> request) {
        if (storage.getSize() == 0) return new CommandResponse("OK", "Коллекция пуста");
        Map<Long, Long> answer = storage.groupCountingByMetersAboveSeaLevel();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, Long> entry : answer.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return new CommandResponse("OK", result.toString());
    }
}
