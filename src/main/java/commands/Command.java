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
     * @param someInformation дополнительная информация о команде.
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
    /**
     * Метод, возвращающий название команды.
     *
     * @return название команды.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод, возвращающий информацию о команде.
     *
     * @return информация о команде.
     */
    public String getSomeInformation() {
        return someInformation;
    }
    /**
     * Метод, возвращающий объект в строковом представлении.
     *
     * @return объект в строковом представлении.
     */
    public String toString() {
        return getName() + " : " + getSomeInformation();
    }
}
