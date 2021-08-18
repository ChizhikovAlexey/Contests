package com.achizhikov.tinkoff.practice;

import java.util.Scanner;

public class InternetTraffic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tariffPrice = scanner.nextInt();
        int tariffTraffic = scanner.nextInt();
        int overflowPrice = scanner.nextInt();
        int traffic = scanner.nextInt();

        int overflow = traffic > tariffTraffic ? traffic - tariffTraffic : 0;
        int price = tariffPrice + overflow * overflowPrice;

        System.out.println(price);
    }
}
