package com.achizhikov.stepikalgo;

import java.util.ArrayList;
import java.util.Scanner;

public class DifferentNumbers {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int bigNumber = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; bigNumber - i >= i + 1; i++) {
            numbers.add(i);
            bigNumber -= i;
        }
        if (bigNumber > 0) numbers.add(bigNumber);

        System.out.println(numbers.size());
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new DifferentNumbers().run();
    }
}
