package com.achizhikov.yandex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jewelry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String J = scanner.nextLine();
        String S = scanner.nextLine();

        Set<Character> symbols = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            symbols.add(J.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (symbols.contains(S.charAt(i))) result++;
        }

        System.out.println(result);
    }
}
