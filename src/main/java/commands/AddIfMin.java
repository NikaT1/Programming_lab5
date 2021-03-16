package commands;

import collection.City;
import collectionUtils.CreationPriorityQueue;
import IOutils.InputAndOutput;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Класс для команды add_if_min, которая добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего
 * элемента этой коллекции.
 */

public class AddIfMin extends Commands {
    public AddIfMin() {
        super("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    private final PriorityQueue<City> dop = new PriorityQueue<>(10, Comparator.comparingInt(City::getArea));

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        while (!priorityQueue.getPriorityQueue().isEmpty()) {
            City city1 = priorityQueue.pollFromQueue();
            dop.add(city1);
        }
        City city = inputAndOutput.readCity();
        if (dop.peek() != null) {
            if (city.getArea() < dop.peek().getArea()) {
                priorityQueue.addToQueue(city);
                inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
            } else inputAndOutput.output("В коллекцию не добавлен элемент: " + city.toString());
        } else {
            priorityQueue.addToQueue(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        }
        while (!dop.isEmpty()) {
            priorityQueue.addToQueue(dop.poll());
        }
    }
}
