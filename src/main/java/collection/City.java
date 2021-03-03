package collection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Класс City.
 */

public class City {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int area; //Значение поля должно быть больше 0
    private long population; //Значение поля должно быть больше 0
    private Long metersAboveSeaLevel;
    private Date establishmentDate;
    private Integer agglomeration;
    private Climate climate; //Поле не может быть null
    private Human governor; //Поле не может быть null
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setMetersAboveSeaLevel(Long metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public void setAgglomeration(Integer agglomeration) {
        this.agglomeration = agglomeration;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public Long getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public String getEstablishmentDate() {
        if (establishmentDate != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(establishmentDate.getTime());
        }
        else return null;
    }

    public Integer getAgglomeration() {
        return agglomeration;
    }

    public Climate getClimate() {
        return climate;
    }

    public Human getGovernor() {
        return governor;
    }
    public String toString() {
        return getId() + ", название: " + getName() + ", " +
                coordinates.toString() + ", дата создания: " +
                getCreationDate() + ", площадь территории: " +
                getArea() + ", численность населения: " + getPopulation() +
                ", кол-во метров над уровнем моря: " + getMetersAboveSeaLevel() +
                ", дата основания: " + getEstablishmentDate() +
                ", площадь агломерации: " + getAgglomeration() +
                ", климат: " + getClimate() + ", возраст губернатора: " +
                getGovernor().getAge() + ".";
    }
}