package com.achizhikov.leetcode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {
    public String complexNumberMultiply(String num1, String num2) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        Pattern pattern = Pattern.compile("(?<real>-?\\d+)\\+(?<imaginary>-?\\d+)i");
        Matcher matcher = pattern.matcher(num1);
        if (matcher.find()) {
            a = Integer.parseInt(matcher.group("real"));
            b = Integer.parseInt(matcher.group("imaginary"));
        }

        matcher.reset(num2);
        if (matcher.find()) {
            c = Integer.parseInt(matcher.group("real"));
            d = Integer.parseInt(matcher.group("imaginary"));
        }

        return (a * c - b * d) + "+" + (b * c + a * d) + "i";
    }

    public static void main(String[] args) {
        System.out.println(new ComplexNumber().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
