package Basic;

import java.lang.annotation.*;

public class AnnotationSnippets {
    public static void main(String[] args) {
        Class cls = AnnotationSnippets.class;
        if (cls.isAnnotationPresent(Report.class)) {
            Report report = (Report) cls.getAnnotation(Report.class);
        }
    }


    private static void foo() {

    }
}

@Report(type = 1, level = "warning")
class AnnotationSnippetsUser {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "";
}