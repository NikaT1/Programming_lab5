package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import exceptions.WrongValuesException;

public class Add extends Commands {
    public Add() {
        super ("add", "добавить новый элемент в коллекцию");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            City city = inputAndOutput.readCity();
            priorityQueue.checkCity(city);
            priorityQueue.addToQueue(city);
            inputAndOutput.output("В коллекцию добавлен новый элемент: " + city.toString());
        } catch (WrongValuesException | NumberFormatException e) {
            inputAndOutput.output("Ошибка: недопустимые значения полей; объект коллекции не создан");
        }
    }
}
