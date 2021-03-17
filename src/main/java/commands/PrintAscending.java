package commands;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Класс для команды print_ascending, которая выводит элементы коллекции в порядке возрастания.
 */

public class PrintAscending extends Command {
    /**
     * Поле, использующееся для временного хранения коллекции.
     */
    private final PriorityQueue<City> dop = new PriorityQueue<>(10, Comparator.comparingInt(City::getArea));

    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public PrintAscending() {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
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
            dop.add(city);
        }
        while (!dop.isEmpty()) {
            City city = dop.poll();
            inputAndOutput.output(city.toString());
            priorityQueue.addToCollection(city);
        }
    }
}
