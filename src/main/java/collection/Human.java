package collection;

/**
 * Класс Human.
 */

public class Human {
    /**
     * Возраст человека. Значение поля должно быть больше 0.
     */
    private Integer age;

    /**
     * Конструктор.
     *
     * @param age возраст человека.
     */
    public Human(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "возраст человека: " + age;
    }
}