package com.upt;

import java.util.Scanner;

public class Dreptunghi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu lungimea dreptunghiului: ");
        double lungime = scanner.nextDouble();

        System.out.print("Introdu latimea dreptunghiului: ");
        double latime = scanner.nextDouble();

        double aria = lungime * latime;
        double perimetru = 2 * (lungime + latime);

        System.out.println("Aria dreptunghiului este: " + aria);
        System.out.println("Perimetrul dreptunghiului este: " + perimetru);

        scanner.close();
    }
}
