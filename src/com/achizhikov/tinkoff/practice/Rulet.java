package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class Rulet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long partsNumber = scanner.nextLong();

        int separations = 0;
        while (partsNumber > 1) {
            partsNumber >>= 1;
            separations++;
        }

        System.out.println(separations);
    }
}
