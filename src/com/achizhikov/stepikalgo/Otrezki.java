package com.achizhikov.stepikalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Otrezki {
    class LineSegment implements Comparable<LineSegment> {
        private int start;
        private int end;

        public LineSegment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public boolean dotIsInside(int dot) {
            return dot >= start && dot <= end;
        }

        @Override
        public int compareTo(LineSegment o) {
            return this.getEnd() - o.getEnd();
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int numberOfSegments = scanner.nextInt();
        ArrayList<LineSegment> segments = new ArrayList<>();
        for (int i = 0; i < numberOfSegments; i++) {
            segments.add(new LineSegment(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(segments);

        ArrayList<Integer> dots = new ArrayList<>();
        dots.add(segments.get(0).getEnd());
        while (!segments.isEmpty()) {
            if (!segments.get(0).dotIsInside(dots.get(dots.size() - 1))) {
                dots.add(segments.get(0).getEnd());
            }
            segments.remove(0);
        }

        System.out.println(dots.size());
        for (int dot : dots) {
            System.out.print(dot + " ");
        }
    }

    public static void main(String[] args) {
        new Otrezki().run();
    }
}
