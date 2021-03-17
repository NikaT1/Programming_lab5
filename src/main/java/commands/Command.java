package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Абстрактный класс для всех команд.
 */

public abstract class Command {
    /**
     * Дополнительная информация о команде.
     */
    private final String someInformation;
    /**
     * Название команды.
     */
    private final String name;

    /**
     * Конструктор.
     *
     * @param name название команды.
     * @param name дополнительная информация о команде.
     */
    public Command(String name, String someInformation) {
        this.name = name;
        this.someInformation = someInformation;
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     * @throws Exception в случае ошибки при выполнении команды.
     */
    public abstract void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) throws Exception;

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
