package com.achizhikov.yandex;

import java.util.Scanner;

public class BinaryVector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int max = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        max = Math.max(max, current);

        System.out.println(max);
    }
}
