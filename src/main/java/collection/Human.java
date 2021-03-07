package collection;

/**
 * Класс Human.
 */

public class Human {
    private Integer age; //Значение поля должно быть больше 0

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