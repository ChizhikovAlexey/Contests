package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class Tablecloth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tableWidth = scanner.nextInt();
        int tableHeight = scanner.nextInt();
        boolean foundFirst = false;
        int minPrice = 0;
        for (int i = 0; i < n; i++) {
            int clothWidth = scanner.nextInt();
            int clothHeight = scanner.nextInt();
            int clothPrice = scanner.nextInt();
            if (clothWidth >= tableWidth && clothHeight >= tableHeight ||
            clothHeight >= tableWidth && clothWidth >= tableHeight) {
                if (clothPrice < minPrice || !foundFirst) {
                    minPrice = clothPrice;
                    foundFirst = true;
                }
            }
        }
        System.out.println(foundFirst ? minPrice : 0);
    }
}
