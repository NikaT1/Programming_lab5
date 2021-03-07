package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

/**
 * Класс для команды average_of_meters_above_sea_level, которая выводит среднее значение поля metersAboveSeaLevel
 * для всех элементов коллекции.
 */

public class AverageOfMetersAboveSeaLevel extends Commands {
    public AverageOfMetersAboveSeaLevel() {
        super("average_of_meters_above_sea_level", "вывести среднее значение поля metersAboveSeaLevel для всех элементов коллекции");
    }

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty())
            inputAndOutput.output("Коллекция пуста; среднее значение поля metersAboveSeaLevel установить невозможно");
        else {
            int sum = 0;
            for (City city : priorityQueue.getPriorityQueue()) {
                sum += city.getMetersAboveSeaLevel();
            }
            double answer = sum * 1.0 / priorityQueue.getPriorityQueue().size();
            String result = String.format("%.3f", answer);
            inputAndOutput.output("Среднее значение поля metersAboveSeaLevel для всех элементов коллекции: " + result + "");
        }
    }
}
