//package com.achizhikov.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class PermutationInString {
//    public boolean checkInclusion(String s1, String s2) {
//        Map<Character, Integer> letters = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            char c = s1.charAt(i);
//            letters.put(c, letters.getOrDefault(c, 0) + 1);
//        }
//        int substringLength = 0;
//        for (int i = 0; i < s2.length(); i++) {
//            if (substringLength == s1.length()) return true;
//
//            char c = s2.charAt(i);
//            if (letters.containsKey(c)) {
//                int cLeft = letters.get(c);
//                if (cLeft > 0) {
//                    letters.put(c,cLeft - 1);
//                    substringLength++;
//                } else {
//                    for (int j = i - substringLength; s2.charAt(j) != c; j++) {
//
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new PermutationInString().checkInclusion("ab", "ediaobaoo"));
//    }
//}
