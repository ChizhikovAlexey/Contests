package com.achizhikov.yandex;

import java.util.Scanner;

public class Acid {
    private int count() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) return 0;
        int value = scanner.nextInt();
        int firstValue = value;
        int previousValue = value;
        for (int i = 1; i < n; i++) {
            value = scanner.nextInt();
            if (value < previousValue) {
                return -1;
            }
            if (value > previousValue) {
                previousValue = value;
            }
        }
        return value - firstValue;
    }
    public static void main(String[] args) {
        System.out.println(new Acid().count());
    }
}
