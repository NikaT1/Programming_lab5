package com.console_project.io_util;

import lombok.AllArgsConstructor;
import com.console_project.command.TypeOfCommand;

/**
 * Класс для распознавания введенных комманд.
 */

@AllArgsConstructor
public class UserInput<T> {

    private final String INIT_MESSAGE = "Введите команду (список команд - help):";
    private final String EXIT_MESSAGE = "Вы точно хотите завершить выполнение программы?";
    private final String COMMAND_NOT_FOUND_MESSAGE = "Команда не найдена!";
    private final IOutil<T> ioUtil;

    /**
     * Метод, отвечающий за распознавание команд и формирование userRequest.
     */
    public UserRequest<T> getUserRequest() {
        UserRequest<T> request = null;
        while (request == null) {
            String line = ioUtil.readField(INIT_MESSAGE);
            String[] args = line.split(" ");
            TypeOfCommand typeOfCommand = null;
            try {
                typeOfCommand = TypeOfCommand.valueOf(args[0].toUpperCase());
            } catch (IllegalArgumentException e) {
                ioUtil.write(COMMAND_NOT_FOUND_MESSAGE);
                continue;
            }

            T t = null;
            if (typeOfCommand.isNeedObject()) {
                t = ioUtil.readObject();
            }

            String params = "";
            if (args.length > 1) {
                params = args[1];
            }

            request = new UserRequest<>(params, typeOfCommand.getName(), t);
        }
        return request;
    }

    public boolean checkBeforeExit() {
        return ioUtil.readAnswer(EXIT_MESSAGE);
    }
}
