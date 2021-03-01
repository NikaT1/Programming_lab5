package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintAscending extends Commands {
    public PrintAscending() {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
    }
    private PriorityQueue<City> dop = new PriorityQueue<City>(10, new Comparator<City>(){
        public int compare(City c1, City c2) {
            return (c1.getArea() - c2.getArea());
        }
    });
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty()) inputAndOutput.output("Коллекция пуста");
        while (!priorityQueue.getPriorityQueue().isEmpty()) {
            City city = priorityQueue.pollFromQueue();
            dop.add(city);
        }
        while (!dop.isEmpty()) {
            City city = dop.poll();
            inputAndOutput.output(city.toString());
            priorityQueue.addToQueue(city);
        }
    }
}
