package collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class InputAndOutput {
    private Scanner input;
    private String argument;
    private boolean printMessages;
    public InputAndOutput(Scanner input, boolean printMessages) {
        this.input = input;
        this.printMessages = printMessages;
    }
    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {

        this.argument = argument;
    }

    public String readField(String message){
        String s;
        if (printMessages) System.out.println(message);
        s = input.nextLine();
        return s;
    }
    public boolean readAnswer(String message){
        String s;
        System.out.println(message);
        while (true) {
            s = input.nextLine();
            switch (s) {
                case ("да"):
                    return true;
                case ("нет"):
                    return false;
                default:
                    System.out.println("Неверный ввод! Введите да/нет");
                break;
            }
        }
    }
    public City readCity() {
        City city = new City();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        city.setId((int) (date.getTime()%100000000));
        city.setName(readField("Введите название города:"));
        city.setCoordinates(new Coordinates(Float.parseFloat(readField("Введите координату х:")), Integer.parseInt(readField("Введите координату у:"))));
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
    public void output(String s) {
        System.out.println(s);
    }
}
