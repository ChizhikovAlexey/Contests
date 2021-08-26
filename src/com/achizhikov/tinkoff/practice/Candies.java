package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class Candies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(Math.min(a + b, n));
    }
}
