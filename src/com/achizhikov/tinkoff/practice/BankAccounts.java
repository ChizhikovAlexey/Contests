package com.achizhikov.tinkoff.practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BankAccounts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = scanner.nextInt();
        double comission = 0.0;

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        while (queue.size() > 1) {
            int newAccount = queue.poll() + queue.poll();
            comission += newAccount * 0.05;
            queue.add(newAccount);
        }
        System.out.println(comission);
    }
}
