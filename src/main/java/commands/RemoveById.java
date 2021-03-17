package commands;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

import java.util.PriorityQueue;

/**
 * Класс для команды remove_by_id, которая удаляет элемент из коллекции по его id.
 */

public class RemoveById extends Command {
    /**
     * Поле, использующееся для временного хранения коллекции.
     */
    private final PriorityQueue<City> dop = new PriorityQueue<>(10, (c1, c2) -> (c2.getArea() - c1.getArea()));

    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public RemoveById() {
        super("remove_by_id id", "удалить элемент из коллекции по его id");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        try {
            int id = Integer.parseInt(inputAndOutput.getArgument());
            boolean flag = false;
            while (!priorityQueue.getCollection().isEmpty()) {
                City city = priorityQueue.pollFromQueue();
                if (city.getId() == id) {
                    flag = true;
                } else dop.add(city);
            }
            if (flag) inputAndOutput.output("удаление элемента успешно завершено");
            else inputAndOutput.output("Элемент с id " + id + " не существует");
            while (!dop.isEmpty()) {
                City city = dop.poll();
                priorityQueue.addToCollection(city);
            }
        } catch (NumberFormatException e) {
            inputAndOutput.output("неправильный формат id");
        }
    }
}
