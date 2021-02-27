package commands;

import collection.CreationPriorityQueue;
import collection.InputAndOutput;
import collection.UserInput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ExecuteScript extends Commands {
    private HashSet<String> paths;
    public ExecuteScript() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        paths = new HashSet<>();
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (!paths.add(inputAndOutput.getArgument())) {
            inputAndOutput.output("Выявлена рекурсия! Выполнение команды остановлено");
        } else {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(inputAndOutput.getArgument());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedInputStream file = new BufferedInputStream(fileInputStream);
            UserInput userInput = new UserInput(new InputStreamReader(file), commandsControl, priorityQueue, false);
            userInput.startInput();
        }
    }
}
