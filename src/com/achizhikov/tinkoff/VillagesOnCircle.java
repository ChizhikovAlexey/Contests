package com.achizhikov.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillagesOnCircle {
    private int findShortestPath () {
        Scanner scanner = new Scanner(System.in);
        int perimeter = scanner.nextInt();
        int n  = scanner.nextInt();
        int first = scanner.nextInt();
        int prev = first;
        int current = scanner.nextInt();
        int longestDistance = current - prev;
        for (int i = 2; i < n; i++) {
            prev = current;
            current = scanner.nextInt();
            longestDistance = Math.max(longestDistance, current - prev);
        }
        longestDistance = Math.max(longestDistance, perimeter - current + first);
        return perimeter - longestDistance;
    }
    public static void main(String[] args) {
        System.out.println(new VillagesOnCircle().findShortestPath());
    }
}
