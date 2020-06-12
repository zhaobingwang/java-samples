package com.example.demo.util;

import java.util.Locale;

public class UtilMain {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(now);
        System.out.println("ISO: " + TimeUtil.formatISO(now, Locale.CHINA, "Asia/Shanghai"));
        System.out.println("Beijing: " + TimeUtil.formatBeijing(now));
        System.out.println("Beijing: " + TimeUtil.formatBeijing(now, "yyyy/MM/dd HH:mm:ss"));
    }
}