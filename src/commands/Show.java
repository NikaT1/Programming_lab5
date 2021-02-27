package commands;
import java.util.Comparator;
import java.util.PriorityQueue;
import collection.*;
public class Show extends Commands {
    public Show () {
        super ("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    private PriorityQueue<City> dop = new PriorityQueue<City>(10, new Comparator<City>(){
        public int compare(City c1, City c2) {
            return (c2.getArea() - c1.getArea());
        }
    });
    public void doCommand (InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        while (!priorityQueue.getPriorityQueue().isEmpty()) {
            City city = priorityQueue.pollFromQueue();
            System.out.println(city);
            dop.add(city);
        }
        while (!dop.isEmpty()) {
            priorityQueue.addToQueue(dop.poll());
        }
    }
}
