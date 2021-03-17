package commands;

import collection.City;
import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды average_of_meters_above_sea_level, которая выводит среднее значение поля metersAboveSeaLevel
 * для всех элементов коллекции.
 */

public class AverageOfMetersAboveSeaLevel extends Command {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public AverageOfMetersAboveSeaLevel() {
        super("average_of_meters_above_sea_level", "вывести среднее значение поля metersAboveSeaLevel для всех элементов коллекции");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        if (priorityQueue.getCollection().isEmpty())
            inputAndOutput.output("Коллекция пуста; среднее значение поля metersAboveSeaLevel установить невозможно");
        else {
            int sum = 0;
            for (City city : priorityQueue.getCollection()) {
                sum += city.getMetersAboveSeaLevel();
            }
            double answer = sum * 1.0 / priorityQueue.getCollection().size();
            String result = String.format("%.3f", answer);
            inputAndOutput.output("Среднее значение поля metersAboveSeaLevel для всех элементов коллекции: " + result + "");
        }
    }
}
