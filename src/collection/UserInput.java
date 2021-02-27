package collection;

import java.io.InputStreamReader;
import java.util.Scanner;
import commands.*;

public class UserInput {
    private Scanner input;
    private CommandsControl commandsControl;
    private CreationPriorityQueue priorityQueue;
    private InputAndOutput inputAndOutput;
    public UserInput(InputStreamReader input, CommandsControl commandsControl, CreationPriorityQueue priorityQueue, boolean printMessages) {
        this.commandsControl = commandsControl;
        this.input = new Scanner(input);
        this.priorityQueue = priorityQueue;
        inputAndOutput = new InputAndOutput(this.input, printMessages);
    }
    public void startInput() {
        while (input.hasNextLine()) {
            String[] s = input.nextLine().split(" ");
            switch (s[0]) {
                case ("help"):
                    commandsControl.getCommands().get(TypeOfCommands.HELP).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("print_ascending"):
                    commandsControl.getCommands().get(TypeOfCommands.PRINTASCENDING).doCommand(inputAndOutput, commandsControl, priorityQueue);
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
                    commandsControl.getCommands().get(TypeOfCommands.AVERAGEOFMETERSABOVESEALEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("add"):
                    commandsControl.getCommands().get(TypeOfCommands.ADD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("update"):
                    System.out.println(s[1]);
                    inputAndOutput.setArgument(s[1]);
                    commandsControl.getCommands().get(TypeOfCommands.UPDATEID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("add_if_max"):
                    commandsControl.getCommands().get(TypeOfCommands.ADDIFMAX).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("add_if_min"):
                    commandsControl.getCommands().get(TypeOfCommands.ADDIFMIN).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("save"):
                    commandsControl.getCommands().get(TypeOfCommands.SAVE).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("group_counting_by_meters_above_sea_level"):
                    commandsControl.getCommands().get(TypeOfCommands.GROUPCOUNTINGBYMETERSABOVESEALEVEL).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("remove_head"):
                    commandsControl.getCommands().get(TypeOfCommands.REMOVEHEAD).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("remove_by_id"):
                    inputAndOutput.setArgument(s[1]);
                    commandsControl.getCommands().get(TypeOfCommands.REMOVEBYID).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("clear"):
                    commandsControl.getCommands().get(TypeOfCommands.CLEAR).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
                case ("execute_script"):
                    inputAndOutput.setArgument(s[1]);
                    commandsControl.getCommands().get(TypeOfCommands.EXECUTESCRIPT).doCommand(inputAndOutput, commandsControl, priorityQueue);
                    break;
            }
            inputAndOutput.output("Введите следующую команду: ");
        }
    }
}
