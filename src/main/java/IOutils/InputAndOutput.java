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
    /**
     * Ввод пользователя.
     */
    private Scanner scanner;
    /**
     * Аргумент текущей команды.
     */
    private String argument;
    /**
     * Флаг, отвечающий за вид взаимодействия с пользователем.
     */
    private boolean printMessages;

    /**
     * Конструктор.
     *
     * @param scanner       ввод пользователя
     * @param printMessages флаг, отвечающий за вид взаимодействия с пользователем.
     */
    public InputAndOutput(Scanner scanner, boolean printMessages) {
        this.scanner = scanner;
        this.printMessages = printMessages;
        argument = null;
    }

    /**
     * Метод, устанавливающий вид взаимодействия с пользователем.
     *
     * @param printMessages флаг, отвечающий за вид взаимодействия с пользователем.
     */
    public void setPrintMessages(boolean printMessages) {
        this.printMessages = printMessages;
    }

    /**
     * Метод, возвращающий аргумент текущей команды.
     *
     * @return аргумент текущей команды.
     */
    public String getArgument() {
        return argument;
    }

    /**
     * Метод, возвращающий сканнер.
     *
     * @return сканнер.
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Метод, устанавливающий сканнер.
     *
     * @param scanner сканнер.
     */
    public void setScanner(Scanner scanner) {

        this.scanner = scanner;
    }

    /**
     * Метод, устанавливающий аргумент текущей команды.
     *
     * @param argument аргумент текущей команды.
     */
    public void setArgument(String argument) {

        this.argument = argument;
    }

    /**
     * Метод, считывающий значение одного поля.
     *
     * @param message сообщение пользователю.
     * @return значение поля.
     */
    public String readField(String message) {
        String s;
        if (printMessages) System.out.println(message);
        s = scanner.nextLine();
        return s;
    }

    /**
     * Метод, считывающий ответ пользвателя.
     *
     * @param message сообщение пользователю.
     * @return ответ пользователя.
     */
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

    /**
     * Метод, считывающий значение поля name.
     *
     * @return значение поля name.
     */
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

    /**
     * Метод, считывающий значение поля area.
     *
     * @return значение поля area.
     */
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

    /**
     * Метод, считывающий значение поля population.
     *
     * @return значение поля population.
     */
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

    /**
     * Метод, считывающий значение поля metersAboveSeaLevel.
     *
     * @return значение поля metersAboveSeaLevel.
     */
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

    /**
     * Метод, считывающий значение поля establishmentDate.
     *
     * @return значение поля establishmentDate.
     */
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

    /**
     * Метод, считывающий значение поля agglomeration.
     *
     * @return значение поля agglomeration.
     */
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

    /**
     * Метод, считывающий значение поля climate.
     *
     * @return значение поля climate.
     */
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

    /**
     * Метод, считывающий значение поля governor.
     *
     * @return значение поля governor.
     */
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

    /**
     * Метод, считывающий и создающий объект класса City.
     *
     * @return новый объект класса City.
     */
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

    /**
     * Метод, считывающий значение поля coordinates.
     *
     * @return значение поля coordinates.
     */
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

    /**
     * Метод, отвечающий за вывод строки на экран.
     *
     * @param s строка для вывода.
     */
    public void output(String s) {
        System.out.println(s);
    }
}
