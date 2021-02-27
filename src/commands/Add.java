package commands;
import collection.*;
public class Add extends Commands {
    public Add () {
        super ("add", "добавить новый элемент в коллекцию");
    }
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        City city = inputAndOutput.readCity();
        priorityQueue.addToQueue(city);
        inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
    }
}
