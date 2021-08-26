package com.achizhikov.yandex;

import java.util.Scanner;

public class Parenthesis {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        build(n, n, "");
    }

    private void build (int l, int r, String current) {
        if (l > 0) {
            build(l - 1, r, current + "(");
        }
        if (r > 0 && l < r) {
            build(l, r - 1, current + ")");
        }
        if (r == 0 && l == 0) {
            System.out.println(current);
        }
    }

    public static void main(String[] args) {
        new Parenthesis().run();
    }
}
