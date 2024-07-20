package com.console_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс Coordinates.
 */

@AllArgsConstructor
@Getter
@Setter
public class Coordinates {
    /**
     * Координата х. Значение поля должно быть больше -742, Поле не может быть null.
     */
    private final Float x;
    /**
     * Координата y. Значение поля должно быть больше -989, Поле не может быть null.
     */
    private final Integer y;

    public String toString() {
        return "координаты х: " + x + ", y: " + y;
    }
}