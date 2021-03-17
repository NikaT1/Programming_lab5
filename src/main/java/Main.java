import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import IOutils.InputAndOutput;
import IOutils.UserInput;
import collectionUtils.Parser;
import collectionUtils.PriorityQueueStorage;
import commands.CommandsControl;

/**
 * Главный класс программы.
 *
 * @author Troynikova Veronika
 */

public class Main {
    /**
     * Главный метод.
     *
     * @param args путь к файлу с коллекцией.
     */
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
        PriorityQueueStorage priorityQueue = null;
        Parser parser;
        try {
            priorityQueue = new PriorityQueueStorage(args[0]);
            parser = new Parser(priorityQueue);
            BufferedInputStream file = new BufferedInputStream(fileInputStream);
            InputStreamReader lines = new InputStreamReader(file, StandardCharsets.UTF_8);
            parser.parseFile(lines);
            inputAndOutput.output("Коллекция успешно создана!");
        } catch (NumberFormatException e) {
            inputAndOutput.output("Значения полей объектов введены неверно");
            System.exit(1);
        } catch (NullPointerException e) {
            inputAndOutput.output("Файл сожержит не все поля, необходимые для создания элементов коллекции");
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
        do {
            try {
                inputAndOutput.output("Введите команду: ");
                userInput.input();
            } catch (InvalidAlgorithmParameterException e) {
                inputAndOutput.output("Выявлена рекурсия! Выполнение команды остановлено");
            } catch (ArrayIndexOutOfBoundsException e) {
                inputAndOutput.output("Вы ввели не все аргументы команды");
            } catch (NullPointerException e) {
                inputAndOutput.output("Данной команды не существует (узнать о доступных командах можно с помощью команды help)");
            } catch (Exception e) {
                inputAndOutput.output("При выполнении команды возникла ошибка");
                e.printStackTrace();
            }
        } while (true);
    }
}
