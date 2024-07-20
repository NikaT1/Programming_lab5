package com.console_project;

import com.console_project.command.CommandInvoker;
import com.console_project.configuration.CommandConfiguration;
import com.console_project.file_util.CSVFileCityReaderWriter;
import com.console_project.file_util.FileReaderWriter;
import com.console_project.io_util.IOutil;
import com.console_project.io_util.IOutilImpl;
import com.console_project.io_util.UserInput;
import com.console_project.io_util.UserRequest;
import com.console_project.model.City;
import com.console_project.storage.InMemoryStorage;
import com.console_project.storage.Storage;

import java.util.Scanner;

/**
 * Главный класс программы.
 *
 * @author Troynikova Veronika
 */

public class Client {

    private final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Требуется аргумент для запуска - путь к файлу");
            return;
        }
        new Client().run(args[0]);
    }

    private void run(String filePath) {
        CommandInvoker<City> commandInvoker = init(filePath);
        IOutil<City> ioUtil = new IOutilImpl(new Scanner(System.in));
        UserInput<City> userInput = new UserInput<>(ioUtil);
        boolean isRunning = true;
        while (isRunning) {
            UserRequest<City> request = userInput.getUserRequest();
            if (request.command().equals(EXIT_COMMAND) && userInput.checkBeforeExit()) {
                isRunning = false;
            } else {
                ioUtil.write(commandInvoker.processRequest(request).message());
            }
        }
    }

    private CommandInvoker<City> init(String filePath) {
        FileReaderWriter<City> fileReaderWriter = new CSVFileCityReaderWriter(filePath);
        Storage<City> storage = new InMemoryStorage(fileReaderWriter.parse());
        return CommandConfiguration.getCommandsInvoker(storage, fileReaderWriter);
    }

}
