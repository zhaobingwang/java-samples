package snippets.base.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Student {
    private String name;
    private int totalScore;
    private boolean isLocal;
    private GradeType gradeType;

    public enum GradeType {ONE, TWO, THREE}

    public Student(String name, int totalScore, boolean isLocal, GradeType gradeType) {
        this.name = name;
        this.totalScore = totalScore;
        this.isLocal = isLocal;
        this.gradeType = gradeType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", totalScore=" + totalScore +
                ", isLocal=" + isLocal +
                ", gradeType=" + gradeType +
                '}';
    }
}
