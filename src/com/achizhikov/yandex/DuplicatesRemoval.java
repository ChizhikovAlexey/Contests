package com.achizhikov.yandex;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class DuplicatesRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in, 8));
        int n = scanner.nextInt();
        if (n == 0) return;

        int previousValue = scanner.nextInt();
        System.out.println(previousValue);
        for (int i = 1; i < n; i++) {
            int currentValue = scanner.nextInt();
            if (previousValue != currentValue) {
                System.out.println(currentValue);
                previousValue = currentValue;
            }
        }
    }
}
