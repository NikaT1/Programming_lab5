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
        boolean flag = false;
        String name = null;
        while (!flag) {
            flag = true;
            name = readField("Введите название города:");
            if (name.equals("")) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        city.setName(name);
        city.setCoordinates(readCoordinates());
        city.setCreationDate(LocalDate.now());
        flag = false;
        int area = 1;
        while (!flag) {
            flag = true;
            try {
                area = Integer.parseInt(readField("Введите размер территории (в квадратных метрах):"));
                if (area <= 0) {
                    output("Значение меньше допустимого, повторите ввод:");
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        city.setArea(area);
        flag = false;
        long population = 1;
        while (!flag) {
            flag = true;
            try {
                population = Long.parseLong(readField("Введите численность населения:"));
                if (population <= 0) {
                    output("Значение меньше допустимого, повторите ввод:");
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        city.setPopulation(population);
        flag = false;
        while (!flag) {
            flag = true;
            String s = readField("Введите количество метров над уровнем моря:");
            if (s.equals("")) {
                city.setEstablishmentDate(null);
                break;
            }
            try {
                city.setMetersAboveSeaLevel(Long.parseLong(s));
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        flag = false;
        while (!flag) {
            flag = true;
            String s = readField("Введите дату создания (dd/MM/yyyy):");
            if (s.equals("")) {
                city.setEstablishmentDate(null);
                break;
            }
            try {
                city.setEstablishmentDate(formatter.parse(s));
            } catch (ParseException e) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        flag = false;
        while (!flag) {
            flag = true;
            String s = readField("Введите размер агломерации (в квадратных метрах):");
            if (s.equals("")) {
                city.setEstablishmentDate(null);
                break;
            }
            try {
                city.setAgglomeration(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        flag = false;
        while (!flag) {
            flag = true;
            try {
                city.setClimate(Climate.valueOf(readField("Введите тип климата (RAIN_FOREST, MONSOON, HUMIDSUBTROPICAL):")));
            } catch (IllegalArgumentException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        flag = false;
        Integer age = null;
        while (!flag) {
            flag = true;
            String s = readField("Введите возраст губернатора:");
            if (s.equals("")) {
                age = null;
                break;
            }
            try {
                age = Integer.parseInt(s);
                if (age <= 0) {
                    output("Неверный формат данных, повторите ввод:");
                    flag = false;
                }
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        city.setGovernor(new Human(age));
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
