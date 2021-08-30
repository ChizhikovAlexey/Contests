package com.achizhikov.yandex.contest;

import java.util.Scanner;

public class ArrayMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] numbers = new int[7][3];
        for (int i = 0; i < 3; i++) {
            int num = scanner.nextInt();
            for (int j = 0; j < 7; j++) {
                numbers[j][i] = num;
            }
        }

        int cnt = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    numbers[cnt][i] -= numbers[cnt][j];
                    cnt++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            boolean found = false;
            for (int j = 0; j < 7 && !found; j++) {
                found = numbers[j][i] <= numbers[j][(i + 1) % 3] && numbers[j][i] >= numbers[j][(i + 2) % 3] ||
                        numbers[j][i] <= numbers[j][(i + 2) % 3] && numbers[j][i] >= numbers[j][(i + 1) % 3];
            }
            System.out.println(found ? "YES" : "NO");
        }
    }
}
