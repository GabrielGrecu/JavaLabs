package com.upt;

import java.util.Random;

public class CMMDC {
    public static void main(String[] args) {
        Random random = new Random();

        int numar1 = random.nextInt(30) + 1;
        int numar2 = random.nextInt(30) + 1;

        System.out.println("Numerele generate sunt: " + numar1 + " si " + numar2);

        int cmmdc = calculeazaCMMDC(numar1, numar2);

        System.out.println("CMMDC-ul celor doua numere este: " + cmmdc);
    }

    private static int calculeazaCMMDC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
