package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import exceptions.TooMuchElementsException;

public class Add extends Commands {
    public Add() {
        super ("add", "добавить новый элемент в коллекцию");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            City city = inputAndOutput.readCity();
            city.setId(priorityQueue.generateId());
            priorityQueue.addToQueue(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        } catch (TooMuchElementsException e) {
            inputAndOutput.output("Ошибка: в коллекции слишком много элементов; объект коллекции не создан");
        }
    }
}
