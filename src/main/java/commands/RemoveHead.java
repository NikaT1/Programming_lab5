package commands;

import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

public class RemoveHead extends Commands {
    public RemoveHead() {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty()) inputAndOutput.output("Коллекция пуста");
        else inputAndOutput.output(priorityQueue.pollFromQueue().toString());
    }
}
