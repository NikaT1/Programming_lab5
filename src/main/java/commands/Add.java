package commands;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;
import exceptions.TooMuchElementsException;

import java.util.NoSuchElementException;

/**
 * Класс для команды add, которая добавляет новый элемент в коллекцию.
 */

public class Add extends Commands {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public Add() {
        super("add", "добавить новый элемент в коллекцию");
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
            City city = inputAndOutput.readCity();
            city.setId(priorityQueue.generateId());
            priorityQueue.addToCollection(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        } catch (TooMuchElementsException e) {
            inputAndOutput.output("Ошибка: в коллекции слишком много элементов; объект коллекции не создан");
        } catch (NoSuchElementException e) {
            inputAndOutput.output("В скрипте не указаны значения для создания элемента коллекции. Команда add не выполнена");
        }
    }
}
