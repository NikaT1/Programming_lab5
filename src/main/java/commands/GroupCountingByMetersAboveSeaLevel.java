package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GroupCountingByMetersAboveSeaLevel extends Commands {
    public GroupCountingByMetersAboveSeaLevel() {
        super("group_counting_by_meters_above_sea_level", "сгруппировать элементы коллекции по значению поля metersAboveSeaLevel, вывести количество элементов в каждой группе");
    }
    private PriorityQueue<City> dop = new PriorityQueue<City>(10, new Comparator<City>(){
        public int compare(City c1, City c2) {
            return (int) (c2.getMetersAboveSeaLevel() - c1.getMetersAboveSeaLevel());
        }
    });
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty()) inputAndOutput.output("Коллекция пуста");
        else {
            while (!priorityQueue.getPriorityQueue().isEmpty()) {
                City city = priorityQueue.pollFromQueue();
                dop.add(city);
            }
            City city = dop.poll();
            Long meters = city.getMetersAboveSeaLevel();
            inputAndOutput.output("Группа " + meters + " (м):");
            inputAndOutput.output(city.toString());
            priorityQueue.addToQueue(city);
            while (!dop.isEmpty()) {
                city = dop.poll();
                if (meters != city.getMetersAboveSeaLevel()) {
                    meters = city.getMetersAboveSeaLevel();
                    inputAndOutput.output("Группа " + meters + " (м):");
                }
                inputAndOutput.output(city.toString());
                priorityQueue.addToQueue(city);
            }
        }
    }
}
