package commands;

import collection.CreationPriorityQueue;
import collection.InputAndOutput;
import collection.UserInput;

public class RemoveHead extends Commands {
    public RemoveHead() {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        inputAndOutput.output(priorityQueue.pollFromQueue().toString());
    }
}
