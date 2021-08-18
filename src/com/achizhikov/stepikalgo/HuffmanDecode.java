package com.achizhikov.stepikalgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuffmanDecode {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int lettersNumber = scanner.nextInt();
        int codeLength = scanner.nextInt();
        scanner.nextLine();
        Map<String, Character> codes = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<letter>[a-z]): (?<code>\\d+)");
        Matcher matcher = pattern.matcher("");

        for (int i = 0; i < lettersNumber; i++) {
            String s = scanner.nextLine();
            matcher.reset(s);
            if (matcher.find()) {
                codes.put(matcher.group("code"), matcher.group("letter").charAt(0));
            } else {
                throw new IllegalArgumentException("Wrong text format!");
            }
        }

        String string = scanner.next();
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < codeLength; i++) {
            String substring = string.substring(start, i + 1);
            if (codes.containsKey(substring)) {
                result.append(codes.get(substring));
                start = i + 1;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        new HuffmanDecode().run();
    }
}
