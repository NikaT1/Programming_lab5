package commands;

import java.util.PriorityQueue;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды show, которая выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class Show extends Commands {
    /**
     * Поле, использующееся для временного хранения коллекции.
     */
    private final PriorityQueue<City> dop = new PriorityQueue<>(10, (c1, c2) -> (c2.getArea() - c1.getArea()));

    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public Show() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        if (priorityQueue.getCollection().isEmpty()) inputAndOutput.output("Коллекция пуста");
        while (!priorityQueue.getCollection().isEmpty()) {
            City city = priorityQueue.pollFromQueue();
            inputAndOutput.output(city.toString());
            dop.add(city);
        }
        while (!dop.isEmpty()) {
            priorityQueue.addToCollection(dop.poll());
        }
    }
}
