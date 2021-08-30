package com.achizhikov.yandex.contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Cocktail {
    class GlassLayer {
        public char leftBorder;
        public char rightBorder;
        public char content;
        public int leftBorderIndex;
        public int rightBorderIndex;

        public GlassLayer(String string) {
            leftBorderIndex = 0;
            while (string.charAt(leftBorderIndex) == '.') {
                leftBorderIndex++;
            }
            leftBorder = string.charAt(leftBorderIndex);

            rightBorderIndex = leftBorderIndex + 1;
            while (string.charAt(rightBorderIndex) == ' ' || string.charAt(rightBorderIndex) == '_') {
                rightBorderIndex++;
            }
            rightBorder = string.charAt(rightBorderIndex);
            content = string.charAt(leftBorderIndex + 1);
        }

        public String toString(int width) {
            StringBuilder result = new StringBuilder();
//            result.append(".".repeat(leftBorderIndex));
            for (int i = 0; i < leftBorderIndex; i++) {
                result.append('.');
            }
            result.append(leftBorder);
            for (int i = leftBorderIndex + 1; i < rightBorderIndex; i++) {
                result.append(content);
            }
            result.append(rightBorder);
//            result.append(".".repeat(Math.max(0, width - (rightBorderIndex + 1))));
            for (int i = rightBorderIndex + 1; i < width; i++) {
                result.append('.');
            }
            return result.toString();
        }
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        Deque<GlassLayer> emptyLayers = new ArrayDeque<>();
        Deque<GlassLayer> fullLayers = new ArrayDeque<>();

        scanner.nextLine();
        for (int i = 0; i < height; i++) {
            emptyLayers.addFirst(new GlassLayer(scanner.nextLine()));
        }

        fullLayers.addLast(emptyLayers.pollFirst());
        int drinkLayers = scanner.nextInt();
        for (int i = 0; i < drinkLayers; i++) {
            scanner.next();
            int drinkHeight = scanner.nextInt();
            char drinkSymbol = scanner.next().charAt(0);
            for (int j = 0; j < drinkHeight; j++) {
                GlassLayer layer = emptyLayers.pollFirst();
                layer.content = drinkSymbol;
                fullLayers.addLast(layer);
            }
        }

        while (!emptyLayers.isEmpty()) {
            System.out.println(emptyLayers.pollLast().toString(width));
        }
        while (!fullLayers.isEmpty()) {
            System.out.println(fullLayers.pollLast().toString(width));
        }
    }

    public static void main(String[] args) {
        new Cocktail().start();
    }
}
