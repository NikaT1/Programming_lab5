package commands;

import collection.CreationPriorityQueue;
import collection.InputAndOutput;

public class CommandExit extends Commands {
    public CommandExit() {
        super("exit", "завершить программу (без сохранения в файл)");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (inputAndOutput.readAnswer("Вы уверены, что хотите выйти без сохранения коллекции? (да/нет)")) System.exit(0);
        else inputAndOutput.output("Выход не выполнен");
    }
}
