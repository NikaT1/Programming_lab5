package IOutils;

import java.util.Scanner;
import collection.CreationPriorityQueue;
import commands.CommandsControl;
import commands.TypeOfCommands;

public class UserInput {
    private Scanner input;
    private boolean printMessages;
    private CommandsControl commandsControl;
    private CreationPriorityQueue priorityQueue;
    private InputAndOutput inputAndOutput;
    public UserInput(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue, boolean printMessages) {
        this.commandsControl = commandsControl;
        this.input = inputAndOutput.getScanner();
        this.priorityQueue = priorityQueue;
        this.inputAndOutput = inputAndOutput;
        this.printMessages = printMessages;
    }
    public void startInput() {
        while (input.hasNextLine()) {
            String[] s = input.nextLine().split(" ");
            switch (s[0]) {
                case ("help"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.HELP).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("print_ascending"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.PRINT_ASCENDING).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("exit"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.EXIT).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("info"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.INFO).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("show"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.SHOW).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("average_of_meters_above_sea_level"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.AVERAGE_OF_METERS_ABOVE_SEA_LEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("add"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.ADD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("update"):
                    inputAndOutput.setArgument(s[1]);
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.UPDATE_ID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    inputAndOutput.deleteArgument();
                    break;
                case ("add_if_max"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.ADD_IF_MAX).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("add_if_min"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.ADD_IF_MIN).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("save"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.SAVE).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("group_counting_by_meters_above_sea_level"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.GROUP_COUNTING_BY_METERS_ABOVE_SEA_LEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("remove_head"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.REMOVE_HEAD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("remove_by_id"):
                    inputAndOutput.setArgument(s[1]);
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.REMOVE_BY_ID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("clear"):
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.CLEAR).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
                case ("execute_script"):
                    inputAndOutput.setArgument(s[1]);
                    try {
                        commandsControl.getCommands().get(TypeOfCommands.EXECUTE_SCRIPT).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    } catch (Exception e) {
                        inputAndOutput.output("При выполнении команды возникла ошибка");
                    }
                    break;
            }
            if (printMessages) inputAndOutput.output("Введите следующую команду: ");
        }
    }
}
