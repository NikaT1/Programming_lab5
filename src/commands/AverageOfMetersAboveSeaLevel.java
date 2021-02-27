package commands;

import collection.City;
import collection.CreationPriorityQueue;
import collection.InputAndOutput;

public class AverageOfMetersAboveSeaLevel extends Commands {
    public AverageOfMetersAboveSeaLevel() {
        super("average_of_meters_above_sea_level", "вывести среднее значение поля metersAboveSeaLevel для всех элементов коллекции");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        int sum = 0;
        for (City city : priorityQueue.getPriorityQueue()) {
            sum+=city.getMetersAboveSeaLevel();
        }
        double answer = sum*1.0/priorityQueue.getPriorityQueue().size();
        String result = String.format("%.3f",answer);
        inputAndOutput.output("Среднее значение поля metersAboveSeaLevel для всех элементов коллекции: " + result + "");
    }
}
