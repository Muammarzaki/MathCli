package com.logika.helpers.print;

import java.util.Collection;

public class Print {

    /**
     * 
     */
    private Print() {
    }

    public static void topBottom(int length) {
        System.out.print("+");
        for (int i = 0; i <= length - 3; i++)
            System.out.print("-");
        System.out.println("+");
    }

    /**
     * print hasil ke kosol
     * 
     * @param prefix
     * @param result
     */
    public static void printResult(String prefix, Collection<Boolean> result) {
        String printed = String.format("| %-15s | %s |", prefix, result.toString().replace("[", "").replace("]", ""));
        int lenght = printed.length();
        Print.topBottom(lenght);
        System.out.println(printed);
        Print.topBottom(lenght);

    }
}
