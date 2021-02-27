package commands;
import collection.*;

import java.time.LocalDate;

public class Info extends Commands {
    public Info () {
        super ("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        System.out.println("тип: PriorityQueue");
        System.out.println("дата инициализации: " + priorityQueue.getCreationDate());
        System.out.println("количество элементов: " + priorityQueue.getPriorityQueue().size());
    }
}
