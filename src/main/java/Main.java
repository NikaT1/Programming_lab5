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
import exceptions.WrongValuesException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputAndOutput inputAndOutput = new InputAndOutput(scanner, true);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch(ArrayIndexOutOfBoundsException e){
            inputAndOutput.output("Вы не задали имя файла");
            System.exit(1);
        }catch(FileNotFoundException e){
            inputAndOutput.output("Файл не существует или не хватает прав на чтение");
            System.exit(1);
        }
        CreationPriorityQueue priorityQueue = new CreationPriorityQueue(fileInputStream, args[0]);
        try {
            System.out.println(priorityQueue.makeQueue());
        } catch(NumberFormatException | WrongValuesException e) {
            inputAndOutput.output("Значения полей объектов введены неверно");
            System.exit(1);
        } catch(NullPointerException e) {
            inputAndOutput.output("Файл сожержит не все поля, необходимые для создания элементов коллекции");
            System.exit(1);
        } catch(ParseException e) {
            inputAndOutput.output("Дата в файле введена в неправильном формате");
            System.exit(1);
        } catch(CsvValidationException e){
            inputAndOutput.output("Ошибка при парсинге файла");
            System.exit(1);
        } catch(IOException e){
            inputAndOutput.output("Ошибка при чтении из файла");
            e.printStackTrace();
            System.exit(1);
        }
        CommandsControl commandsControl = new CommandsControl();
        UserInput userInput = new UserInput(inputAndOutput, commandsControl, priorityQueue, true);
        userInput.startInput();
    }
}
