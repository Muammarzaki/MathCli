package com.logika.helpers.print;

public class Print {
    public static void topBottom(int length) {
        System.out.print("+");
        for (int i = 0; i <= length + 1; i++)
            System.out.print("-");
        System.out.println("+");
    }

}
