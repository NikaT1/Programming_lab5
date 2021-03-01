import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import IOutils.InputAndOutput;
import IOutils.UserInput;
import collection.CreationPriorityQueue;
import com.opencsv.exceptions.CsvValidationException;
import commands.CommandsControl;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputAndOutput inputAndOutput = new InputAndOutput(scanner, true);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch(FileNotFoundException e){
            inputAndOutput.output("Файл не существует или не хватает прав на чтение");
            System.exit(1);
        }
        CreationPriorityQueue priorityQueue = new CreationPriorityQueue(fileInputStream, args[0]);
        try {
            priorityQueue.makeQueue();
        } catch(NumberFormatException e) {
            inputAndOutput.output("Значения полей объектов введены неверно");
        }catch(NullPointerException e) {
            inputAndOutput.output("Файл сожержит не все поля, необходимые для создания элементов коллекции");
        } catch(CsvValidationException e){
            inputAndOutput.output("Что-то пошло не так при парсинге");
        } catch(ParseException e) {
            inputAndOutput.output("Дата в файле введена в неправильном формате");
        } catch(IOException e){
            inputAndOutput.output("Ошибка при чтении из файла");
        }
        CommandsControl commandsControl = new CommandsControl();
        UserInput userInput = new UserInput(inputAndOutput, commandsControl, priorityQueue);
        userInput.startInput();
    }
}
