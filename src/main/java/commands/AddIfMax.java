package commands;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды add_if_max, которая добавляет новый элемент в коллекцию, если его значение превышает значение
 * наибольшего элемента этой коллекции.
 */

public class AddIfMax extends Command {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public AddIfMax() {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        City city = inputAndOutput.readCity();
        if (priorityQueue.getCollection().peek() != null) {
            if (city.getArea() > priorityQueue.getCollection().peek().getArea()) {
                priorityQueue.addToCollection(city);
                inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
            } else inputAndOutput.output("В коллекцию не добавлен элемент: " + city.toString());
        } else {
            priorityQueue.addToCollection(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        }
    }
}
