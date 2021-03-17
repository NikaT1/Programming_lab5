package IOutils;

import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

import collectionUtils.PriorityQueueStorage;
import commands.CommandsControl;
import commands.TypeOfCommands;

/**
 * Класс для распознавания введенных комманд.
 */

public class UserInput {
    /**
     * Ввод пользователя.
     */
    private final Scanner input;
    /**
     * Поле для доступа к объектам команд.
     */
    private final CommandsControl commandsControl;
    /**
     * Поле для доступа к элементам коллекции.
     */
    private final PriorityQueueStorage priorityQueue;
    /**
     * Поле, хранящее объект, отвечающий за ввод/вывод.
     */
    private final InputAndOutput inputAndOutput;

    /**
     * Конструктор.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public UserInput(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        this.commandsControl = commandsControl;
        this.input = inputAndOutput.getScanner();
        this.priorityQueue = priorityQueue;
        this.inputAndOutput = inputAndOutput;
    }

    /**
     * Метод, отвечающий за распознавание команд и их выполнение.
     *
     * @throws InvalidAlgorithmParameterException в случае, когда команда вызывает рекурсию.
     */
    public void input() throws Exception {
        String[] s = input.nextLine().split(" ");
        switch (s[0]) {
            case ("help"):
                commandsControl.getCommands().get(TypeOfCommands.HELP).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("print_ascending"):
                commandsControl.getCommands().get(TypeOfCommands.PRINT_ASCENDING).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("exit"):
                commandsControl.getCommands().get(TypeOfCommands.EXIT).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("info"):
                commandsControl.getCommands().get(TypeOfCommands.INFO).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("show"):
                commandsControl.getCommands().get(TypeOfCommands.SHOW).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("average_of_meters_above_sea_level"):
                commandsControl.getCommands().get(TypeOfCommands.AVERAGE_OF_METERS_ABOVE_SEA_LEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("add"):
                commandsControl.getCommands().get(TypeOfCommands.ADD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("update"):
                inputAndOutput.setArgument(s[1]);
                commandsControl.getCommands().get(TypeOfCommands.UPDATE_ID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("add_if_max"):
                commandsControl.getCommands().get(TypeOfCommands.ADD_IF_MAX).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("add_if_min"):
                commandsControl.getCommands().get(TypeOfCommands.ADD_IF_MIN).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("save"):
                commandsControl.getCommands().get(TypeOfCommands.SAVE).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("group_counting_by_meters_above_sea_level"):
                commandsControl.getCommands().get(TypeOfCommands.GROUP_COUNTING_BY_METERS_ABOVE_SEA_LEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("remove_head"):
                commandsControl.getCommands().get(TypeOfCommands.REMOVE_HEAD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("remove_by_id"):
                inputAndOutput.setArgument(s[1]);
                commandsControl.getCommands().get(TypeOfCommands.REMOVE_BY_ID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("clear"):
                commandsControl.getCommands().get(TypeOfCommands.CLEAR).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            case ("execute_script"):
                inputAndOutput.setArgument(s[1]);
                commandsControl.getCommands().get(TypeOfCommands.EXECUTE_SCRIPT).doCommand(inputAndOutput, commandsControl, priorityQueue);
                break;
            default:
                throw new NullPointerException();
        }
    }
}
