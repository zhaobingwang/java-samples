package Basic;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class DateTimeSnippets {
    public static void main(String[] args) {
//        tmp();
//        localDateTimeSnippets();
//        timeOp();
//        timeOp2();
//        timeOp3();
//        timeOp4();
//        timeOp5();
//        zonedDateTimeSnippets();
//        zoneConvert();
//        instant();
        bestPractice();
    }

    private static void localDateTimeSnippets() {
        LocalDate d = LocalDate.now();  // 当前日期
        LocalTime t = LocalTime.now();   // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期时间
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);
    }

    private static void timeOp() {
        LocalDateTime dt = LocalDateTime.of(2020, 5, 29, 14, 59, 59);
        System.out.println(dt);
        // 加5天减10小时:
        LocalDateTime dt2 = dt.plusDays(5).minusHours(10);
        System.out.println(dt2);
        // 减1月:
        LocalDateTime dt3 = dt2.minusMonths(1);
        System.out.println(dt3);
    }

    private static void timeOp2() {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 日期变为31日:
        LocalDateTime dt2 = dt.withDayOfMonth(31);
        System.out.println(dt2); // 2019-10-31T20:30:59
        // 月份变为9:
        LocalDateTime dt3 = dt2.withMonth(9);
        System.out.println(dt3); // 2019-09-30T20:30:59
    }

    private static void timeOp3() {
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
    }

    private static void timeOp4() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
    }

    private static void timeOp5() {
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D
    }

    private static void zonedDateTimeSnippets() {
        ZonedDateTime zbj = ZonedDateTime.now();    // 默认时区
        // zone id see: https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html#SHORT_IDS
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));  // 指定时区获取当前时间
        System.out.println(zbj);
        System.out.println(zny);
    }

    private static void zoneConvert() {
        // 以中国时区获取当前时间:
        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }

    private static void instant() {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());

        // 以指定时间戳创建Instant:
        Instant ins = Instant.ofEpochSecond(1568568760);
//        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        ZonedDateTime zdt = ins.atZone(ZoneId.of("Asia/Shanghai"));

        System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]
    }

    private static void bestPractice() {
        long ts = 1574208900000L;
        System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts, Locale.US, "America/New_York"));
        System.out.println(timestampToString2(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString2(ts, Locale.US, "America/New_York"));
    }

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }

    static String timestampToString2(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
//        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.LONG);
        DateTimeFormatter f = DateTimeFormatter.ISO_DATE_TIME;//.ofPattern("yyyy-MM-dd HH:mm:ss");
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }

    private static void tmp() {
        Date date = new Date();
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getYear() + 1900);
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
    }
}
