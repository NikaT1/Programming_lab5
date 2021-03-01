package commands;
import IOutils.InputAndOutput;
import collection.*;

public class Info extends Commands {
    public Info () {
        super ("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        inputAndOutput.output("тип: PriorityQueue");
        inputAndOutput.output("дата инициализации: " + priorityQueue.getCreationDate());
        inputAndOutput.output("количество элементов: " + priorityQueue.getPriorityQueue().size());
    }
}
