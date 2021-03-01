package commands;

import collection.City;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CommandSave extends Commands {
    public CommandSave() {
        super("save", "сохранить коллекцию в файл");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        try {
            PrintWriter printWriter = new PrintWriter(priorityQueue.getFilePath());
            printWriter.write("name,x,y,area,population,metersAboveSeaLevel,establishmentDate,agglomeration,climate,age" + "\n");
            while (!priorityQueue.getPriorityQueue().isEmpty()){
                City city = priorityQueue.pollFromQueue();
                printWriter.write(city.getName()+",");
                printWriter.write(city.getCoordinates().getX()+",");
                printWriter.write(city.getCoordinates().getY()+",");
                printWriter.write(city.getArea()+",");
                printWriter.write(city.getPopulation()+",");
                printWriter.write(city.getMetersAboveSeaLevel()+",");
                printWriter.write(city.getEstablishmentDate()+",");
                printWriter.write(city.getAgglomeration()+",");
                printWriter.write(city.getClimate()+",");
                printWriter.write(city.getGovernor().getAge() + "");
                printWriter.write("\n");
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            inputAndOutput.output("Файл не существует или не хватает прав на чтение");
        }
    }
}
