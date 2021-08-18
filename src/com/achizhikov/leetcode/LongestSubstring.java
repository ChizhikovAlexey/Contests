package com.achizhikov.leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> letters = new HashSet<>();
        int currentLen = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            if (!letters.contains(letter)) {
                letters.add(letter);
                currentLen++;
            } else {
                maxLen = Math.max(currentLen, maxLen);
                letters.clear();
                letters.add(letter);
                currentLen = 1;
                char currentChar = s.charAt(i - 1);
                while (!letter.equals(currentChar)) {
                    letters.add(currentChar);
                    currentLen++;
                    currentChar = s.charAt(i - currentLen);
                }
            }
        }
        maxLen = Math.max(currentLen, maxLen);
        int [] arr = new int[5];
        return  maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcaadadabc"));
    }
}
