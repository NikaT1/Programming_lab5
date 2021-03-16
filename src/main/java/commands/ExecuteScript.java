package commands;

import collectionUtils.CreationPriorityQueue;
import IOutils.InputAndOutput;
import IOutils.UserInput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс для команды execute_script, которая считывает и исполняет скрипт из указанного файла.
 */

public class ExecuteScript extends Commands {

    private final HashSet<String> paths;

    public ExecuteScript() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        paths = new HashSet<>();
    }

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            if (!paths.add(inputAndOutput.getArgument())) {
                inputAndOutput.output("Выявлена рекурсия! Команда execute_script, вызывающая рекурсию, не выполнена");
            } else {
                String path = inputAndOutput.getArgument();
                FileInputStream fileInputStream = new FileInputStream(path);
                BufferedInputStream file = new BufferedInputStream(fileInputStream);
                Scanner scanner = new Scanner(file);
                Scanner primaryScanner = inputAndOutput.getScanner();
                inputAndOutput.setPrintMessages(false);
                inputAndOutput.setScanner(scanner);
                UserInput userInput = new UserInput(inputAndOutput, commandsControl, priorityQueue, false);
                userInput.startInput();
                paths.remove(path);
                inputAndOutput.setScanner(primaryScanner);
                inputAndOutput.setPrintMessages(true);
            }
        } catch (FileNotFoundException e) {
            inputAndOutput.output("Файл не существует или не хватает прав на чтение файла");
        }
    }
}
