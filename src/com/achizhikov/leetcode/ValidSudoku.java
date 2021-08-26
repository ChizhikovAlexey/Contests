package com.achizhikov.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>(9);
        for (int row = 0; row < 9; row++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                char c = board[row][i];
                if (c != '.' && set.contains(c)) return false;
                set.add(c);
            }
        }
        for (int col = 0; col < 9; col++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                char c = board[i][col];
                if (c != '.' && set.contains(c)) return false;
                set.add(c);
            }
        }
        for (int block = 0; block < 9; block++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                char c = board[(block / 3) * 3 + i / 3][(block % 3) * 3 + i % 3];
                if (c != '.' && set.contains(c)) return false;
                set.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]
                {
                        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
                }
        ));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
