package commands;

import collection.City;
import collectionUtils.CreationPriorityQueue;
import IOutils.InputAndOutput;

import java.util.PriorityQueue;

/**
 * Класс для команды group_counting_by_meters_above_sea_level, которая группирует элементы коллекции по значению
 * поля metersAboveSeaLevel и выводит количество элементов в каждой группе.
 */

public class GroupCountingByMetersAboveSeaLevel extends Commands {
    public GroupCountingByMetersAboveSeaLevel() {
        super("group_counting_by_meters_above_sea_level", "сгруппировать элементы коллекции по значению поля metersAboveSeaLevel, вывести количество элементов в каждой группе");
    }

    private final PriorityQueue<City> dop = new PriorityQueue<>(10, (c1, c2) -> {
        if (c2.getMetersAboveSeaLevel() != null && c1.getMetersAboveSeaLevel() != null) {
            return c1.getMetersAboveSeaLevel().compareTo(c2.getMetersAboveSeaLevel());
        } else if (c2.getMetersAboveSeaLevel() == null && c1.getMetersAboveSeaLevel() != null) {
            return -1;
        } else if (c2.getMetersAboveSeaLevel() != null && c1.getMetersAboveSeaLevel() == null) {
            return 1;
        } else return 0;
    });

    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        if (priorityQueue.getPriorityQueue().isEmpty()) inputAndOutput.output("Коллекция пуста");
        else {
            while (!priorityQueue.getPriorityQueue().isEmpty()) {
                City city = priorityQueue.pollFromQueue();
                dop.add(city);
            }
            City city = dop.poll();
            Long meters = null;
            if (city != null) {
                meters = city.getMetersAboveSeaLevel();
            }
            inputAndOutput.output("Группа " + meters + " (м):");
            if (city != null) {
                inputAndOutput.output(city.toString());
            } else inputAndOutput.output(null);
            priorityQueue.addToQueue(city);
            while (!dop.isEmpty()) {
                city = dop.poll();
                if (meters != null && !meters.equals(city.getMetersAboveSeaLevel()) || meters == null && city.getMetersAboveSeaLevel() != null) {
                    meters = city.getMetersAboveSeaLevel();
                    inputAndOutput.output("Группа " + meters + " (м):");
                }
                inputAndOutput.output(city.toString());
                priorityQueue.addToQueue(city);
            }
        }
    }
}
