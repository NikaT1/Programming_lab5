package collection;

import java.io.*;
import java.io.IOException;
import java.text.ParseException;
import com.opencsv.exceptions.CsvValidationException;
import commands.*;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch(FileNotFoundException e){
            System.out.println("Файл не существует или не хватает прав на чтение");
            System.exit(1);
        }
        CreationPriorityQueue priorityQueue = new CreationPriorityQueue(fileInputStream, args[0]);
        try {
            priorityQueue.makeQueue();
        } catch(NumberFormatException e) {
            System.out.println("Значения полей объектов введены неверно");
        }catch(NullPointerException e) {
            System.out.println("Файл сожержит не все поля, необходимые для создания элементов коллекции");
        } catch(CsvValidationException e){
            System.out.println("Что-то пошло не так при парсинге");
        } catch(ParseException e) {
            System.out.println("Дата в файле введена в неправильном формате");
        } catch(IOException e){
            System.out.println("Что-то пошло не так при парсинге3");
        }
        CommandsControl commandsControl = new CommandsControl();
        UserInput userInput = new UserInput(new InputStreamReader(System.in), commandsControl, priorityQueue, true);
        userInput.startInput();
    }
}
