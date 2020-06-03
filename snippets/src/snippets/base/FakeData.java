package snippets.base;

import snippets.base.model.Student;

import java.util.Arrays;
import java.util.List;

public class FakeData {
    public static List<Student> getStudents() {
        List<Student> students = Arrays.asList(
                new Student("刘一", 721, true, Student.GradeType.THREE),
                new Student("陈二", 637, true, Student.GradeType.THREE),
                new Student("张三", 666, true, Student.GradeType.THREE),
                new Student("李四", 531, true, Student.GradeType.TWO),
                new Student("王五", 483, false, Student.GradeType.THREE),
                new Student("赵六", 367, true, Student.GradeType.THREE),
                new Student("孙七", 499, false, Student.GradeType.ONE));

        return students;
    }
}
