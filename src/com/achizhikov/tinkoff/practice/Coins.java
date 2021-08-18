package com.achizhikov.tinkoff.practice;

import java.util.*;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long maxSum = scanner.nextLong();
        List<Long> coins = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            coins.add(scanner.nextLong());
        }
        Set<Long> sums = new HashSet<>();
        sums.add(1L);

        count(coins, sums, 1, maxSum);

        System.out.println(sums);
        System.out.println(sums.size());
    }

    private static void count(List<Long> coins, Set<Long> sums, long sum, long maxSum) {
        for (int i = 0; i < coins.size(); i++) {
            long tmpSum = sum + coins.get(i);
            if (tmpSum <= maxSum) {
                sums.add(tmpSum);
                count(coins, sums, tmpSum, maxSum);
            }
        }
    }
}
