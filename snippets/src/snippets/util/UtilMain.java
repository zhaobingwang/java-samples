package snippets.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilMain {
    public static void main(String[] args) throws ParseException {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse("2000-06-17"));
        int age = DateUtil.calculateAge(birth, today);
        System.out.println(age);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth2 = simpleDateFormat.parse("2000-06-17");
        int age2 = DateUtil.getAge(birth2);
        System.out.println(age2);
    }
}
