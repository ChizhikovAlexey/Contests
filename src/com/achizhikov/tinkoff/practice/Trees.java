package com.achizhikov.tinkoff.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Trees {
    class Node {
        public final ArrayList<Node> children;
        public int maxDepth;

        Node() {
            children = new ArrayList<>();
        }
    }
    private void run() {
        HashMap<Integer, Node> nodesL = new HashMap<>();
        HashMap<Integer, Node> nodesD = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fun(nodesL, scanner, n);

        n = scanner.nextInt();
        fun(nodesD, scanner, n);

        int maxL = findMaxLength(nodesL.get(1), 0);
        int L = maxL / 2 - 1 + maxL % 2;
        int D = findMaxLength(nodesD.get(1), 0);
        if (L > D) {
            System.out.println("L");
        } else {
            System.out.println("D");
        }
    }

    private void fun(HashMap<Integer, Node> nodesD, Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            nodesD.put(i, new Node());
        }
        for (int i = 0; i < n - 1; i++) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            nodesD.get(p).children.add(nodesD.get(c));
        }
    }

    private int findMaxDepth (Node current) {
        if (current == null) return 0;
        current.maxDepth = 0;
        for (Node child : current.children) {
            current.maxDepth = Math.max(current.maxDepth, findMaxDepth(child) + 1);
        }
        return current.maxDepth;
    }

    private int findMaxLength(Node current, int max) {
        int max1 = 0;
        int max2 = 0;
        int maxL = 0;
        for (Node child : current.children) {
            if (child == null) continue;
            if (child.maxDepth >= max1) {
                max2 = max1;
                max1 = child.maxDepth;
            } else if (child.maxDepth > max2) {
                max2 = child.maxDepth;
            }
            int l = findMaxLength(child, max + 1);
            maxL = Math.max(maxL, l);
        }
        int newMax =  Math.max(3 + max1 + max2, max + maxL);
        return Math.max(max, newMax);
    }

    public static void main(String[] args) {
        new Trees().run();
    }
}
