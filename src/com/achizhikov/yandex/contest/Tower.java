package com.achizhikov.yandex.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Tower {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String tmpString = bi.readLine() + " " + bi.readLine() + " " + bi.readLine();
        StringTokenizer st = new StringTokenizer(tmpString, " ");

        int platesNumber = Integer.parseInt(st.nextToken());
        int menNumber = Integer.parseInt(st.nextToken());
        long[] plates = new long[platesNumber];
        PriorityQueue<Long> shoulders = new PriorityQueue<>();
        PriorityQueue<Long> platesQueue = new PriorityQueue<>();

        for (int i = 0; i < platesNumber; i++) {
            plates[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < menNumber; i++) {
            shoulders.add(Long.parseLong(st.nextToken()));
        }

        long currentLongestPlate = 0;
        for (int i = platesNumber - 1; i >= 0; i--) {
            final long currentPlate = plates[i];
            if (currentPlate > currentLongestPlate) {
                platesQueue.add(currentPlate - currentLongestPlate);
                currentLongestPlate = currentPlate;
            }

        }

        while (!shoulders.isEmpty() && !platesQueue.isEmpty()) {
            if (shoulders.peek() <= platesQueue.poll()) {
                shoulders.poll();
            }
        }

        System.out.println(menNumber - shoulders.size());
    }
}
