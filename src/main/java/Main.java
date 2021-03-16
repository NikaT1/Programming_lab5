import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import IOutils.InputAndOutput;
import IOutils.UserInput;
import collection.CreationPriorityQueue;
import commands.CommandsControl;
import exceptions.WrongValuesException;

/**
 * Главный класс программы.
 *
 * @author Troynikova Veronika
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputAndOutput inputAndOutput = new InputAndOutput(scanner, true);
        FileInputStream fileInputStream = null;
        try {
            Pattern pattern = Pattern.compile("/dev/*");
            Matcher matcher = pattern.matcher(args[0]);
            if (matcher.find()) {
                inputAndOutput.output("Вы задали недопустимое имя файла");
                System.exit(1);
            }
            fileInputStream = new FileInputStream(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            inputAndOutput.output("Вы не задали имя файла");
            System.exit(1);
        } catch (FileNotFoundException e) {
            inputAndOutput.output("Файл не существует или не хватает прав на чтение");
            System.exit(1);
        }
        CreationPriorityQueue priorityQueue = null;
        try {
            priorityQueue = new CreationPriorityQueue(fileInputStream, args[0]);
        } catch (UnsupportedEncodingException e) {
            inputAndOutput.output("Данные в файла невозможно представить в нужной кодироваке");
        }
        try {
            System.out.println(priorityQueue.makeQueue());
        } catch (NumberFormatException | WrongValuesException e) {
            inputAndOutput.output("Значения полей объектов введены неверно");
            System.exit(1);
        } catch (NullPointerException e) {
            inputAndOutput.output("Файл сожержит не все поля, необходимые для создания элементов коллекции");
            e.printStackTrace();
            System.exit(1);
        } catch (ParseException e) {
            inputAndOutput.output("Дата в файле введена в неправильном формате");
            System.exit(1);
        } catch (Exception e) {
            inputAndOutput.output("Ошибка при чтении из файла");
            e.printStackTrace();
            System.exit(1);
        }
        CommandsControl commandsControl = new CommandsControl();
        UserInput userInput = new UserInput(inputAndOutput, commandsControl, priorityQueue, true);
        userInput.startInput();
    }
}
