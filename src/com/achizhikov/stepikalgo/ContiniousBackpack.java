package com.achizhikov.stepikalgo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ContiniousBackpack {
    private class Thing implements Comparable<Thing> {
        private int cost;
        private int volume;

        public Thing(int cost, int volume) {
            this.cost = cost;
            this.volume = volume;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "cost=" + cost +
                    ", volume=" + volume +
                    '}';
        }

        @Override
        public int compareTo(Thing o) {
            if ((double) this.getCost() / this.getVolume() - (double) o.getCost() / o.getVolume() >= 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int thingsNumber = scanner.nextInt();
        int volume = scanner.nextInt();
        double finalCost = 0.0;
        ArrayList<Thing> things = new ArrayList<>();

        for (int i = 0; i < thingsNumber; i++) {
            things.add(new Thing(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(things);

        for (int i = 0; i < thingsNumber && volume > 0; i++) {
            Thing currentThing = things.get(i);
            int usingVolume = Math.min(volume, currentThing.getVolume());
            volume -= usingVolume;
            finalCost += (double) currentThing.getCost() / currentThing.getVolume() * usingVolume;
        }

        System.out.println(BigDecimal.valueOf(finalCost)
                .setScale(3, RoundingMode.HALF_UP));
    }

    public static void main(String[] args) {
        new ContiniousBackpack().run();
    }
}
