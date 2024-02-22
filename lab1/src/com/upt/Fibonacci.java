package com.upt;

import java.util.Random;

public class Fibonacci {
    public static void main(String[] args) {
        Random random = new Random();

        int numar = random.nextInt(21);

        System.out.println("Numarul random: " + numar);

        boolean bool = verificaFibonacci(numar);

        if (bool) {
            System.out.println("Numarul " + numar + " apartine sirului lui Fibonacci.");
        } else {
            System.out.println("Numarul " + numar + " nu apartine.");
        }
    }

    private static boolean verificaFibonacci(int numar) {
        int fib1 = 0;
        int fib2 = 1;

        while (fib2 < numar) {
            int suma = fib1 + fib2;
            fib1 = fib2;
            fib2 = suma;
        }

        return fib2 == numar;
    }
}
