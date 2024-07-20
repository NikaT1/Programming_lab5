package com.console_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс Human.
 */

@AllArgsConstructor
@Getter
@Setter
public class Human {
    /**
     * Возраст человека. Значение поля должно быть больше 0.
     */
    private final Integer age;

    public String toString() {
        return "возраст человека: " + age;
    }
}