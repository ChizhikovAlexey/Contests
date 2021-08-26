package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int[] lastDigits = new int[3];

        if (number.length() >= 3) {
            char digit = number.charAt(number.length() - 3);
            lastDigits[0] = digit == '*' ? -1 : Character.getNumericValue(digit);
        } else {
            lastDigits[0] = -1;
        }

        if (number.length() >= 2) {
            char digit = number.charAt(number.length() - 2);
            lastDigits[1] = digit == '*' ? -1 : Character.getNumericValue(digit);
        } else {
            lastDigits[1] = -1;
        }

        if (number.length() >= 1) {
            char digit = number.charAt(number.length() - 1);
            lastDigits[2] = digit == '*' ? -1 : Character.getNumericValue(digit);
        } else {
            lastDigits[2] = -1;
        }

        //1
        System.out.print("1 ");

        //2
        if (lastDigits[2] >= 0 && lastDigits[2] % 2 == 0) {
            System.out.print("2 ");
        }

        //4
        if (lastDigits[2] >= 0 && lastDigits[1] >= 0) {
            int tmp = lastDigits[1] * 10 + lastDigits[2];
            if (tmp % 4 == 0) {
                System.out.print("4 ");
            }
        }

        //5
        if (lastDigits[2] == 0 || lastDigits[2] == 5) {
            System.out.print("5 ");
        }

        //8
        if (lastDigits[0] >= 0 && lastDigits[2] >= 0 && lastDigits[1] >= 0) {
            int tmp = lastDigits[0] * 100 + lastDigits[1] * 10 + lastDigits[2];
            if (tmp % 8 == 0) {
                System.out.print("8 ");
            }
        }

        //10
        if (lastDigits[0] == 0) {
            System.out.print("10 ");
        }
    }
}
