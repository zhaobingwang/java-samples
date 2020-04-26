package Basic;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        double pi = 3.1415926;
        System.out.println(pi);
        System.out.printf("%.2f\n", pi);    // 3.14
        System.out.printf("%.4f\n", pi);    // 3.1416

//        System.out.println("Input value:");
//        Scanner scanner = new Scanner(System.in);
//        var input = scanner.nextLine();
//        int option = Integer.parseInt(input);
//        switch (option) {
//            case 1:
//                System.out.println(1);
//                break;
//            case 2:
//                System.out.println(2);
//                break;
//            default:
//                System.out.println(0);
//                break;
//        }

        LoopSnippets.Loop();
    }
}

class LoopSnippets {
    public static void Loop() {
        System.out.println("loop begin...");
        int[] ns = {1, 2, 3, 4, 5};
        for (int i = 0; i < ns.length; i++) {
            System.out.println(ns[i]);
        }
        System.out.println("first loop end...");
        for (var item : ns) {
            System.out.println(item);
        }
        System.out.println("loop end...");
    }
}