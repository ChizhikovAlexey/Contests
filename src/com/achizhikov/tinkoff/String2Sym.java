package com.achizhikov.tinkoff;

import java.util.Scanner;

public class String2Sym {
    private static boolean checkString(String string) {
        if (string.length() != 4) return false;
        Character first = null;
        int firstNum = 0;
        Character second = null;
        int secondNum = 0;
        for (int i = 0; i < 4; i++) {
            char symbol = string.charAt(i);
            if (first == null) {
                first = symbol;
                firstNum++;
            } else if (first.equals(symbol)) {
                firstNum++;
            } else if (second == null) {
                second = symbol;
                secondNum++;
            } else if (second.equals(symbol)) {
                secondNum++;
            } else {
                return false;
            }
        }
        return firstNum == 2 && secondNum == 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            System.out.println(checkString(string) ? "Yes" : "No");
        }
    }
}
