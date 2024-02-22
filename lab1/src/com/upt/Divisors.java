package com.upt;

import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu un numar: ");
        int n = scanner.nextInt();

        System.out.println("Divizorii numarului " + n + " sunt:");
        boolean prim = true;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != 1 && i != n) {
                    prim = false;
                }
            }
        }

        if (prim) {
            System.out.println("\nNumarul " + n + " este prim.");
        } else {
            System.out.println("\nNumarul " + n + " nu este prim.");
        }

        scanner.close();
    }
}
