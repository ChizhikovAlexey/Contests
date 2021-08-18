package com.achizhikov.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringInWord {
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        Matcher matcher = null;
        for (String string : patterns) {
            Pattern pattern = Pattern.compile("\\w*" + string + "\\w*");
            if (matcher == null) {
                matcher = pattern.matcher(word);
            } else {
                matcher.usePattern(pattern);
                matcher.reset();
            }
            if (matcher.find()) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringInWord().numOfStrings(new String[] {"a", "b", "aboba", "cde"}, "aboba"));
    }
}
