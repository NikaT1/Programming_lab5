package commands;

import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

/**
 * Абстрактный класс для всех комманд.
 */

public abstract class Commands {
    private String someInformation;
    private String name;
    public Commands (String name, String someInformation) {
        this.name = name;
        this.someInformation = someInformation;
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) throws Exception {}
    public String getName() {
        return name;
    }
    public String getSomeInformation() {
        return someInformation;
    }
    public String toString() {
        return getName() + " : " + getSomeInformation();
    }
}
