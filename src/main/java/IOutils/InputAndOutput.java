package IOutils;

import collection.City;
import collection.Climate;
import collection.Coordinates;
import collection.Human;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class InputAndOutput {
    private Scanner scanner;
    private String argument;
    private boolean printMessages;
    public InputAndOutput(Scanner scanner, boolean printMessages) {
        this.scanner = scanner;
        this.printMessages = printMessages;
        argument = null;
    }

    public void setPrintMessages(boolean printMessages) {
        this.printMessages = printMessages;
    }

    public void deleteArgument(){
        argument = null;
    }

    public String getArgument() {
        return argument;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;
    }

    public void setArgument(String argument) {

        this.argument = argument;
    }

    public String readField(String message){
        String s;
        if (printMessages) System.out.println(message);
        s = scanner.nextLine();
        return s;
    }
    public boolean readAnswer(String message){
        String s;
        System.out.println(message);
        while (true) {
            s = scanner.nextLine();
            switch (s) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Неверный ввод! Введите да/нет");
                    break;
            }
        }
    }
    public City readCity() throws NumberFormatException{
        City city = new City();
        city.setName(readField("Введите название города:"));
        city.setCoordinates(readCoordinates());
        city.setCreationDate(LocalDate.now());
        city.setArea(Integer.parseInt(readField("Введите размер территории (в квадратных метрах):")));
        city.setPopulation(Long.parseLong(readField("Введите численность населения:")));
        city.setMetersAboveSeaLevel(Long.parseLong(readField("Введите количество метров над уровнем моря:")));
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            city.setEstablishmentDate(formatter.parse(readField("Введите дату создания:")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        city.setAgglomeration(Integer.parseInt(readField("Введите размер агломерации (в квадратных метрах):")));
        city.setClimate(Climate.valueOf(readField("Введите тип климата (RAIN_FOREST, MONSOON, HUMIDSUBTROPICAL):")));
        city.setGovernor(new Human(Integer.parseInt(readField("Введите возраст губернатора:"))));
        return city;
    }
    public Coordinates readCoordinates() {
        boolean flag = false;
        Float x = null;
        Integer y = null;
        while (!flag) {
            flag = true;
            try {
                x = Float.parseFloat(readField("Введите координату х:"));
                if (x <= -724) {
                    output("Значение меньше допустимого, повторите ввод:");
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        flag = false;
        while (!flag) {
            flag = true;
            try {
                y = Integer.parseInt(readField("Введите координату у:"));
                if (y <= -989) {
                    output("Значение меньше допустимого, повторите ввод:");
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        return new Coordinates(x, y);
    }
    public void output(String s) {
        System.out.println(s);
    }
}
