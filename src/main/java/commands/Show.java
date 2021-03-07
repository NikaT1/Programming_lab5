package commands;

import java.util.Comparator;
import java.util.PriorityQueue;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

/**
 * Класс для команды show, которая выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class Show extends Commands {
    public Show() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    private PriorityQueue<City> dop = new PriorityQueue<City>(10, new Comparator<City>() {
        public int compare(City c1, City c2) {
            return (c2.getArea() - c1.getArea());
        }
    });

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty()) inputAndOutput.output("Коллекция пуста");
        while (!priorityQueue.getPriorityQueue().isEmpty()) {
            City city = priorityQueue.pollFromQueue();
            inputAndOutput.output(city.toString());
            dop.add(city);
        }
        while (!dop.isEmpty()) {
            priorityQueue.addToQueue(dop.poll());
        }
    }
}
