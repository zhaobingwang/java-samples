package Basic;


import java.util.Vector;

public class Tmp {
    public static void main(String[] args) {
        String[] names = {"aa", "bb"};
        Student student = new Student("张三", (short) 20);
        student.SetNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}

interface IPerson {
    int MAIL = 1;
    int FEMALE = 2;

    void setName(String name);

    String getName();
}

abstract class Person {
    protected String name;
    protected short age;

    public Person(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void Run();
}

class Student extends Person {

    private String[] names;

    public Student(String name, short age) {
        super(name, age);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void Run() {

    }

    public void SetNames(String... names) {
        this.names = names;
    }
}

class Teacher implements IPerson {
    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }
}