package com.achizhikov.yandex;

import java.util.*;

public class Roads {
    private int run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextInt();
            cities[i][1] = scanner.nextInt();
        }
        int maxDistance = scanner.nextInt();
        int start = scanner.nextInt() - 1;
        int end = scanner.nextInt() - 1;
        if (start == end) {
            return 0;
        }
        Map<Integer, Set<Integer>> roads = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            roads.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(cities[i][0] - cities[j][0]) + Math.abs(cities[i][1] - cities[j][1]);
                if (distance <= maxDistance) {
                    roads.get(i).add(j);
                    roads.get(j).add(i);
                }
            }
        }
//        System.out.println(roads);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> justVisited = new HashSet<>();

        justVisited.add(start);
        for (int depth = 1; depth <= n; depth++) {
            Set<Integer> newCities = new HashSet<>();
            visited.addAll(justVisited);
            for (int city : justVisited) {
                for (int newCity : roads.get(city)) {
                    if (!visited.contains(newCity)) {
                        newCities.add(newCity);
                    }
                }
            }
            if (newCities.isEmpty()) {
                return -1;
            } else if (newCities.contains(end)) {
                return depth;
            }
            justVisited = newCities;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Roads().run());
    }
}
