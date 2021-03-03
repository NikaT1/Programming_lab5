package collection;

/**
 * Класс Coordinates.
 */

public class Coordinates {
    private Float x; //Значение поля должно быть больше -742, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -989, Поле не может быть null
    public Coordinates(Float x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String toString() {
        return "координаты х: " + x + ", y: " + y;
    }
}