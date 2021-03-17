package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Абстрактный класс для всех комманд.
 */

public abstract class Commands {
    private final String someInformation;
    private final String name;

    public Commands(String name, String someInformation) {
        this.name = name;
        this.someInformation = someInformation;
    }

    public abstract void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue);

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
