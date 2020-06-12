package com.example.demo.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class TimeUtil {
    /**
     * 默认格式化 [yyyy-MM-dd HH:mm:ss]
     *
     * @param epochMilli the number of milliseconds from 1970-01-01T00:00:00Z
     * @param locale
     * @param zoonId
     * @return
     */
    public static String format(long epochMilli, Locale locale, String zoonId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.withLocale(locale).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoonId)));
    }


    public static String format(long epochMilli, Locale locale, String zoonId, String formatPattern) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return formatter.withLocale(locale).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoonId)));
    }

    /**
     * 格式化为北京时间 [yyyy-MM-dd HH:mm:ss]
     *
     * @param epochMilli the number of milliseconds from 1970-01-01T00:00:00Z
     * @return
     */
    public static String formatBeijing(long epochMilli) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.withLocale(Locale.CHINA).format(ZonedDateTime.ofInstant(ins, ZoneId.of("Asia/Shanghai")));
    }

    /**
     * 格式化为北京时间
     *
     * @param epochMilli
     * @param formatPattern
     * @return
     */
    public static String formatBeijing(long epochMilli, String formatPattern) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return formatter.withLocale(Locale.CHINA).format(ZonedDateTime.ofInstant(ins, ZoneId.of("Asia/Shanghai")));
    }


    public static String formatISO(long epochMilli, Locale locale, String zoonId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return formatter.withLocale(locale).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoonId)));
    }
}
