package tutorials.base.collection;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return Objects.equals(this.firstName, person.firstName) &&
                    Objects.equals(this.firstName, person.firstName) &&
                    this.age == person.age;
        }
        return false;
    }
}
