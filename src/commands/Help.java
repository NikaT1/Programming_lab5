package commands;

import collection.CreationPriorityQueue;
import collection.InputAndOutput;
import collection.UserInput;

public class Help extends Commands {
    public Help () {
        super ("help", "вывести справку по доступным командам");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        for (Commands command : commandsControl.getCommands().values()) {
            System.out.println(command.toString());
        }
    }
}
