package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

import java.util.PriorityQueue;

/**
 * Класс для команды update, которая обновляет значение элемента коллекции по его id.
 */

public class UpdateId extends Commands {
    public UpdateId() {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
    }

    private final PriorityQueue<City> dop = new PriorityQueue<>(10, (c1, c2) -> (c2.getArea() - c1.getArea()));

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            int id = Integer.parseInt(inputAndOutput.getArgument());
            boolean flag = false;
            while (!priorityQueue.getPriorityQueue().isEmpty()) {
                City city = priorityQueue.pollFromQueue();
                if (city.getId() == id) {
                    city = inputAndOutput.readCity();
                    flag = true;
                }
                dop.add(city);
            }
            if (flag) inputAndOutput.output("обновление элемента успешно завершено");
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
