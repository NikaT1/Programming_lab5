package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Класс для команды print_ascending, которая выводит элементы коллекции в порядке возрастания.
 */

public class PrintAscending extends Commands {
    public PrintAscending() {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
    }

    private final PriorityQueue<City> dop = new PriorityQueue<>(10, Comparator.comparingInt(City::getArea));

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
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
