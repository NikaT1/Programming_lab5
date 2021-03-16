package commands;

import collectionUtils.CreationPriorityQueue;
import IOutils.InputAndOutput;

/**
 * Класс для команды help, которая выводит справку по доступным коммандам.
 */

public class Help extends Commands {
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        inputAndOutput.output("Доступные команды:");
        for (Commands command : commandsControl.getCommands().values()) {
            inputAndOutput.output(command.toString());
        }
    }
}
