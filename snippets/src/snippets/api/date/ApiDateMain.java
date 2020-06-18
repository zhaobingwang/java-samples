package snippets.api.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ApiDateMain {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar now2 = Calendar.getInstance();
        System.out.println(now2.get(Calendar.YEAR));

        // 新版API
        System.out.println("新版API");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 转为ISO 8601格式
        LocalDateTime dt2 = LocalDateTime.parse("2019-11-30 15:16:17", dtf);
        System.out.println(dt2);

        // 创建时间
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2020, 6, 17, 12, 12, 12);
        System.out.println(ldt);
        System.out.println(ldt2);
        LocalDateTime lastDayOfMongth = ldt2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMongth);

        // Duration和Period
        // Duration表示两个时刻之间的时间间隔。Period表示两个日期之间的天数：
        // 输出格式：以P...T...的形式表示，P...T之间表示日期间隔，T后面表示时间间隔
        // 如果是PT...的格式表示仅有时间间隔
        // 如：PT4H34M1.412S，H,M,S分别表示小时，分钟，秒，此处含义是时间时间间隔为4小时34分钟1.412秒
        Duration duration = Duration.between(ldt2, ldt);
        System.out.println(duration);
        Period period = Period.between(LocalDate.now().minusDays(1), LocalDate.now());
        System.out.println(period);

        // 带时区的时间
        ZonedDateTime beijingTime = ZonedDateTime.now(); // 默认时区
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        ZonedDateTime beijingTime2 = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime newYorkTime2 = ldt.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime newYorkTime3 = beijingTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(beijingTime);
        System.out.println(newYorkTime);
        System.out.println(beijingTime2);
        System.out.println(newYorkTime2);
        System.out.println(newYorkTime3);

        // Instant
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());   // 秒
        System.out.println(instant.toEpochMilli()); // 毫秒
        Instant ins = Instant.ofEpochSecond(1592385860);
        System.out.println(ins);    // UTC 时间
        ZonedDateTime zonedDateTime = ins.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = ins.atZone(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime2);

        long unixTimestamp = 1592386268000L;
        String bj = timestampToString(unixTimestamp, Locale.CHINA, "Asia/Shanghai");
        String ny = timestampToString(unixTimestamp, Locale.US, "America/New_York");
        System.out.println(bj);
        System.out.println(ny);
    }

    static String timestampToString(long epochMilli, Locale locale, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.withLocale(locale).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
