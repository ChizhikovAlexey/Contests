package com.achizhikov.leetcode;

public class DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        int current = 0;
        int previous = 1;
        int preprevious = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                current = previous;
                if (i < length - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    current += preprevious;
            }
            preprevious = previous;
            previous = current;
            current = 0;
        }

        return previous;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(new DecodeWays().numDecodings("12"));
        long end = System.currentTimeMillis();
        System.out.println((end - begin) + "ms");
    }
}
