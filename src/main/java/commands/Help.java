package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды help, которая выводит справку по доступным коммандам.
 */

public class Help extends Commands {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        inputAndOutput.output("Доступные команды:");
        for (Commands command : commandsControl.getCommands().values()) {
            inputAndOutput.output(command.toString());
        }
    }
}
