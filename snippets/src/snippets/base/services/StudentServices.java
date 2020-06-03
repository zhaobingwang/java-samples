package snippets.base.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import snippets.base.FakeData;
import snippets.base.model.Student;

import javax.swing.text.html.Option;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StudentServices {
    private static List<Student> students;

    // https://blog.csdn.net/sl1992/article/details/98900343
    public static void run() {
        students = FakeData.getStudents();
        avgScore();
        countStudent();
        groupByGrade();
        joinName();
        mappingName();
        maxScore();
        minScore();
        partitionByLocation();
        summaryInfo();
        toCollcetion();
    }

    private static void avgScore() {
        DecimalFormat df = new DecimalFormat("#.00");
//        double avgScore = students.stream().collect(Collectors.averagingInt(Student::getTotalScore));
        double avgScore = students.stream().collect(Collectors.averagingInt(x -> x.getTotalScore()));
        String avgScore2 = students.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.averagingInt(Student::getTotalScore), x -> "平均分是：" + x)
        );

        System.out.println("平均分：" + df.format(avgScore));
        System.out.println(avgScore2);
    }

    private static void countStudent() {
        long count = students.stream().collect(Collectors.counting());
        System.out.println("学生总数：" + count);
    }

    private static void groupByGrade() {
        Map<Student.GradeType, List<Student>> collect = students.stream().collect(
                Collectors.groupingBy(x -> x.getGradeType())
        );
        Map<Student.GradeType, Long> collect2 = students.stream().collect(
                Collectors.groupingBy(x -> x.getGradeType(), Collectors.counting())
        );
        Map<Student.GradeType, Double> collect3 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGradeType,
                        TreeMap::new,
                        Collectors.averagingInt(Student::getTotalScore))
        );
        System.out.println("统计各个年级学生信息：");
        System.out.println(collect);
        System.out.println(collect2);
        System.out.println(collect3);
    }

    private static void joinName() {
        String joinedName = students.stream().map(x -> x.getName())
                .collect(Collectors.joining(",", "Names[", "]"));
        System.out.println("姓名连接：" + joinedName);
    }

    private static void mappingName() {
        String joinedName = students.stream().collect(
                Collectors.mapping(Student::getName, Collectors.joining(","))
        );
        System.out.println("姓名连接：" + joinedName);
    }

    private static void maxScore() {
        Optional<Student> maxScore = students.stream().collect(
                Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore))
        );
        if (maxScore.isPresent()) {
            System.out.println("最高分：");
            System.out.println(maxScore.get());
        }
    }

    private static void minScore() {
        Optional<Student> minScore = students.stream().collect(
                Collectors.minBy(Comparator.comparingInt(Student::getTotalScore))
        );
        if (minScore.isPresent()) {
            System.out.println("最低分：");
            System.out.println(minScore);
        }
    }

    private static void partitionByLocation() {
        Map<Boolean, List<Student>> collect = students.stream().collect(
                Collectors.partitioningBy(Student::isLocal)
        );

        Map<Boolean, Double> collect2 = students.stream().collect(
                Collectors.partitioningBy(
                        Student::isLocal,
                        Collectors.averagingInt(Student::getTotalScore)
                )
        );

        System.out.println("本地和非本地学生：");
        Optional.of(collect).ifPresent(System.out::println);
        System.out.println("本地和非本地学生平均总成绩");
        Optional.of(collect2).ifPresent(System.out::println);
    }

    private static void summaryInfo() {
        IntSummaryStatistics result = students.stream().collect(
                Collectors.summarizingInt(Student::getTotalScore)
        );
        DoubleSummaryStatistics result2 = students.stream().collect(
                Collectors.summarizingDouble(Student::getTotalScore)
        );
        LongSummaryStatistics result3 = students.stream().collect(
                Collectors.summarizingLong(Student::getTotalScore)
        );
        Optional.of(result).ifPresent(System.out::println);
        Optional.of(result2).ifPresent(System.out::println);
        Optional.of(result3).ifPresent(System.out::println);
    }

    private static void toCollcetion() {
        LinkedList<Student> linkedList = students.stream().filter(x -> x.getTotalScore() > 600)
                .collect(Collectors.toCollection(LinkedList::new));
        Optional.of(linkedList).ifPresent(x -> {
            System.out.println(x.getClass());
            System.out.println(x);
        });
    }
}
