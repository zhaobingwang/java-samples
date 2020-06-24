package snippets.base.regex;

public class regexMain {
    // https://www.liaoxuefeng.com/wiki/1252599548343744/1304066080636961
    public static void main(String[] args) {
        dot();
        matchDigit();
        matchWord();
        matchRepeat();
    }

    static void dot() {
        System.out.println("*****dot*****");

        // 使用.模糊匹配，.可以匹配一个任意字符
        // 匹配a.c
        String regex = "a.c";

        String str1 = "a和c";
        String str2 = "abc";
        String str3 = "a&c";
        String str4 = "acc";
        String str5 = "abbc";
        System.out.println(str1.matches(regex));    // true
        System.out.println(str2.matches(regex));    // true
        System.out.println(str3.matches(regex));    // true
        System.out.println(str4.matches(regex));    // true
        System.out.println(str5.matches(regex));    // false
    }

    static void matchDigit() {
        System.out.println("*****matchDigit*****");
        // 使用\d匹配数字0~9单个数字字符
        String regex = "00\\d";
        System.out.println("001".matches(regex));   // true
        System.out.println("0010".matches(regex));  // false
        System.out.println("00A".matches(regex));  // false
    }

    static void matchWord() {
        System.out.println("*****matchWord*****");
        // 用\w可以匹配一个字母、数字或下划线，w的意思是word
        // 因为\w不能匹配#、空格等字符
        String regex = "java\\w";
        System.out.println("javac".matches(regex)); // true
        System.out.println("java8".matches(regex)); // true
        System.out.println("java_".matches(regex)); // true
        System.out.println("java#".matches(regex)); // false
        System.out.println("java ".matches(regex)); // false
    }

    static void matchSpace() {
        // 用\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\t表示
        String regex = "\\s";
    }


    static void matchNondigit() {
        System.out.println("*****matchNondigit*****");
        // 用\d可以匹配一个数字，而\D则匹配一个非数字
        // "00A"，因为\D可以匹配非数字字符A
        // "00#"，因为\D可以匹配非数字字符#
        // 类似的，\W可以匹配\w不能匹配的字符，\S可以匹配\s不能匹配的字符
    }

    static void matchRepeat() {
        System.out.println("*****matchRepeat*****");
        // 修饰符*可以匹配任意个字符，包括0个字符。
        // 修饰符+可以匹配至少一个字符。
        // 修饰符?可以匹配0个或一个字符。

        // 另外，{n}可以匹配n个字符，{n,m}可以匹配n~m个字符
        System.out.println("A123".matches("A\\d{3}"));  // true
        System.out.println("A123".matches("A\\d{3,5}"));  // true
        System.out.println("A1234".matches("A\\d{3,5}"));  // true
        System.out.println("A12345".matches("A\\d{3,5}"));  // true
    }


    static boolean is21stCentury(String year) {
        String regex = "20\\d\\d";
        return year.matches(regex);
    }
}
