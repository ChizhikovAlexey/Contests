package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class PolinomialRoot {
    static int MAX_ITER = 1000000;

    class Polynomial {
        private final double[] a;

        public Polynomial(double[] a) {
            this.a = a;
        }

        public double f (double val) {
            int x = 1;
            int result = 0;
            for (double j : a) {
                result += j * x;
                x *= val;
            }
            return result;
        }

        public double df (double val) {
            int x = 1;
            int result = 0;
            for (int i = 1; i < a.length; i++) {
                result += a[i] * x;
                x *= val;
            }
            return result;
        }
    }

    private void run() {
        final double EPS = 1e-16;
        double x = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] a = new double[n + 1];
        for (int i = 0; i < n + 1; i++) {
            a[i] = scanner.nextDouble();
        }
        Polynomial polynomial = new Polynomial(a);

        for (int i = 1; Math.abs(polynomial.f(x)) > EPS && i < MAX_ITER; i++) {
            if (polynomial.df(x) < EPS && polynomial.df(x) > -EPS) {
                break;
            }
            x -= polynomial.f(x) / polynomial.df(x);

        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        new PolinomialRoot().run();
    }
}
