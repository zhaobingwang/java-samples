package snippets.book.javacore1;

import snippets.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Ch03 {
    public static void main(String[] args) throws ParseException {
        codePointAndUnit();
        double d = 114.144;
        d = (double) Math.round(d * 10) / 10;
        System.out.println(d);
    }

    /**
     * 码点与代码单元
     */
    static void codePointAndUnit() throws ParseException {
        String greeting = "\uD835\uDD46";
        System.out.println(greeting.length());  // 2
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);    // 1
        System.out.println(greeting);   // 𝕆
    }
}
