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
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, осуществляющий ввод/вывод.
 */

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

    public String readField(String message) {
        String s;
        if (printMessages) System.out.println(message);
        s = scanner.nextLine();
        return s;
    }

    public boolean readAnswer(String message) {
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
                    System.out.println("Неверный ввод! Введите yes/no");
                    break;
            }
        }
    }

    private String readName() {
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
        return name;
    }

    private int readArea() {
        boolean flag = false;
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
        return area;
    }

    private long readPopulation() {
        boolean flag = false;
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
        return population;
    }

    private Long readMetersAboveSeaLevel() {
        boolean flag = false;
        Long metersAboveSeaLevel = null;
        while (!flag) {
            flag = true;
            String s = readField("Введите количество метров над уровнем моря:");
            if (s.equals("")) {
                return null;
            }
            try {
                metersAboveSeaLevel = Long.parseLong(s);
            } catch (NumberFormatException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        return metersAboveSeaLevel;
    }

    private Date readEstablishmentDate() {
        boolean flag = false;
        Date establishmentDate = null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        while (!flag) {
            flag = true;
            String s = readField("Введите дату создания (yyyy-MM-dd):");
            if (s.equals("")) {
                return null;
            }
            try {
                establishmentDate = formatter.parse(s);
            } catch (ParseException e) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        return establishmentDate;
    }

    private Integer readAgglomeration() {
        boolean flag = false;
        Integer agglomeration = null;
        while (!flag) {
            flag = true;
            String s = readField("Введите размер агломерации (в квадратных метрах):");
            if (s.equals("")) {
                return null;
            }
            try {
                agglomeration = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        return agglomeration;
    }

    private Climate readClimate() {
        boolean flag = false;
        Climate climate = null;
        while (!flag) {
            flag = true;
            try {
                climate = Climate.valueOf(readField("Введите тип климата (RAIN_FOREST, MONSOON, HUMIDSUBTROPICAL):"));
            } catch (IllegalArgumentException ex) {
                output("Неверный формат данных, повторите ввод:");
                flag = false;
            }
        }
        return climate;
    }

    private Human readGovernor() {
        boolean flag = false;
        Integer age = null;
        while (!flag) {
            flag = true;
            String s = readField("Введите возраст губернатора:");
            if (s.equals("")) {
                return new Human(null);
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
        return new Human(age);
    }

    public City readCity() throws NumberFormatException, NoSuchElementException {
        City city = new City();
        city.setName(readName());
        city.setCoordinates(readCoordinates());
        city.setCreationDate(LocalDate.now());
        city.setArea(readArea());
        city.setPopulation(readPopulation());
        city.setMetersAboveSeaLevel(readMetersAboveSeaLevel());
        city.setEstablishmentDate(readEstablishmentDate());
        city.setAgglomeration(readAgglomeration());
        city.setClimate(readClimate());
        city.setGovernor(readGovernor());
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
