//package com.achizhikov.yandex.contest;
//
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class Versions {
//    class Rule implements Comparable<Rule> {
//        public final int branch;
//        public final int myVersion;
//        public final int theirVersion;
//
//        public Rule(int branch, int myVersion, int theirVersion) {
//            this.branch = branch;
//            this.myVersion = myVersion;
//            this.theirVersion = theirVersion;
//        }
//
//        @Override
//        public int compareTo(Rule o) {
//            return Integer.compare(myVersion, o.myVersion);
//        }
//    }
//
//    private void start() {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//
//        PriorityQueue<Rule> aRules = new PriorityQueue<>();
//        PriorityQueue<Rule> bRules = new PriorityQueue<>();
//        PriorityQueue<Rule> cRules = new PriorityQueue<>();
//
//        int rulesNumber = scanner.nextInt();
//        for (int i = 0; i < rulesNumber; i++) {
//            int b1 = scanner.nextInt();
//            int v1 = scanner.nextInt();
//            int b2 = scanner.nextInt();
//            int v2 = scanner.nextInt();
//            PriorityQueue<Rule> queue;
//            switch (b1) {
//                case 1:
//                    queue = aRules;
//                    break;
//                case 2:
//                    queue = bRules;
//                    break;
//                default:
//                    queue = cRules;
//            }
//            queue.add(new Rule(b2, v1, v2));
//        }
//
//        long currentAmount = (long) a * b * c;
//
//        int previousStopA = 0;
//        int previousStopB = 0;
//        int previousStopC = 0;
//        while (!aRules.isEmpty()) {
//            Rule rule = aRules.poll();
//            int versionsAvailable = 0;
//            if (rule.branch == 1) {
//                if (rule.theirVersion < previousStopB) continue;
//                versionsAvailable = b - previousStopB;
//                previousStopB = rule.theirVersion;
//            } else {
//                versionsAvailable = c - previousStopC;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new Versions().start();
//    }
//}
