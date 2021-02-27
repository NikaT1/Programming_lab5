package commands;

import collection.City;
import collection.CreationPriorityQueue;
import collection.InputAndOutput;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AddIfMin extends Commands {
    public AddIfMin() {
        super("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }
    private PriorityQueue<City> dop = new PriorityQueue<>(10, new Comparator<>(){
        public int compare(City c1, City c2) {
            return (c1.getArea() - c2.getArea());
        }
    });
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        while (!priorityQueue.getPriorityQueue().isEmpty()) {
            City city1 = priorityQueue.pollFromQueue();
            dop.add(city1);
        }
        City city = inputAndOutput.readCity();
        if (city.getArea()<dop.peek().getArea()) {
            priorityQueue.addToQueue(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        } else inputAndOutput.output("В коллекцию не добавлен элемент: " + city.toString());
        while (!dop.isEmpty()) {
            priorityQueue.addToQueue(dop.poll());
        }
    }
}
