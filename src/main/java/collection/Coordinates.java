package collection;

/**
 * Класс Coordinates.
 */

public class Coordinates {
    /**
     * Координата х. Значение поля должно быть больше -742, Поле не может быть null.
     */
    private final Float x;
    /**
     * Координата y. Значение поля должно быть больше -989, Поле не может быть null.
     */
    private final Integer y;

    /**
     * Конструктор.
     *
     * @param x координата х.
     * @param y координата y.
     */
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