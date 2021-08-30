package com.achizhikov.yandex.contest;

import java.io.IOException;
import java.util.Scanner;

public class CellDefiner {
    class Cell {
        public final int x;
        public final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isOutsideCorner(int[][] corners, int i) {
        int a = i == 0 ? corners.length - 1 : i - 1;
        int c = i == corners.length - 1 ? 0 : i + 1;
        return (corners[a][0] > corners[i][0] && corners[i][1] > corners[c][1] ||       //X--Y--
                corners[a][0] < corners[i][0] && corners[i][1] < corners[c][1] ||       //X++Y++
                corners[a][1] > corners[i][1] && corners[i][0] < corners[c][0] ||       //Y--X++
                corners[a][1] < corners[i][1] && corners[i][0] > corners[c][0]);        //Y++X--
    }

    private void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int border = 0;
        int outsideCorner = 0;
        int inside = 0;
        int insideCorner = 0;

        int[][] corners = new int[k][2];

        for (int i = 0; i < k; i++) {
            corners[i][0] = scanner.nextInt();
            corners[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            if (isOutsideCorner(corners, i)) {
                outsideCorner++;
            } else {
                insideCorner++;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            border += Math.abs(corners[i][0] - corners[i + 1][0]) + Math.abs(corners[i][1] - corners[i + 1][1]) - 1;
        }
        border += Math.abs(corners[k - 1][0] - corners[0][0]) + Math.abs(corners[k - 1][1] - corners[0][1]) - 1;

        int square = 0;
        for (int i = 0; i < k - 1; i++) {
            square += corners[i][0] * corners[i + 1][1] - corners[i][1] * corners[i + 1][0];
        }
        square += corners[k - 1][0] * corners[0][1] - corners[k - 1][1] * corners[0][0];
        square = Math.abs(square) / 2;
        int additionalSquare = 8 * (outsideCorner * 3 + insideCorner + border * 2) / 32;
//        System.out.println("Additional square = " + additionalSquare);
        square += additionalSquare;

//        System.out.println("Square = " + square);
        inside = square - border - insideCorner - outsideCorner;
        System.out.println(inside);
        System.out.println(border);
        System.out.println(outsideCorner);
        System.out.println(insideCorner);
    }

    public static void main(String[] args) throws IOException {
        new CellDefiner().start();
    }
}
