package com.example.demo.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String value) {
        return (value == null || value.length() == 0);
    }

    public static boolean isNullOrWhiteSpace(String value) {
        if (value == null)
            return true;
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i)))
                return false;
        }
        return true;
    }
}
