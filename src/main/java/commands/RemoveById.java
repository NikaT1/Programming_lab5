package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Класс для команды remove_by_id, которая удаляет элемент из коллекции по его id.
 */

public class RemoveById extends Commands {
    public RemoveById() {
        super("remove_by_id id", "удалить элемент из коллекции по его id");
    }

    private PriorityQueue<City> dop = new PriorityQueue<City>(10, new Comparator<City>() {
        public int compare(City c1, City c2) {
            return (c2.getArea() - c1.getArea());
        }
    });

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            int id = Integer.parseInt(inputAndOutput.getArgument());
            boolean flag = false;
            while (!priorityQueue.getPriorityQueue().isEmpty()) {
                City city = priorityQueue.pollFromQueue();
                if (city.getId().intValue() == id) {
                    flag = true;
                } else dop.add(city);
            }
            if (flag) inputAndOutput.output("удаление элемента успешно завершено");
            else inputAndOutput.output("Элемент с id " + id + " не существует");
            while (!dop.isEmpty()) {
                City city = dop.poll();
                priorityQueue.addToQueue(city);
            }
        } catch (NumberFormatException e) {
            inputAndOutput.output("неправильный формат id");
        }
    }
}
