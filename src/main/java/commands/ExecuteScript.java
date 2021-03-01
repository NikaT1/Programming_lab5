package commands;

import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import IOutils.UserInput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class ExecuteScript extends Commands {
    private HashSet<String> paths;
    public ExecuteScript() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        paths = new HashSet<>();
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (inputAndOutput.getArgument() == null) inputAndOutput.output("Аргумент команды не найден");
        else {
            try {
                if (!paths.add(inputAndOutput.getArgument())) {
                    inputAndOutput.output("Выявлена рекурсия! Выполнение команды остановлено");
                } else {
                    FileInputStream fileInputStream = new FileInputStream(inputAndOutput.getArgument());
                    BufferedInputStream file = new BufferedInputStream(fileInputStream);
                    inputAndOutput.setPrintMessages(false);
                    UserInput userInput = new UserInput(inputAndOutput, commandsControl, priorityQueue);
                }
            } catch (FileNotFoundException e) {
                inputAndOutput.output("Файл не существует или не хватает прав на чтение файла");
            }
        }
    }
}