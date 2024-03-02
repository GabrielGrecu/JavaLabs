package com.pj.p3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String sir = scanner.nextLine();

        System.out.println("Enter the string for insertion:");
        String sirInserat = scanner.nextLine();
        System.out.println("Enter position:");
        int pozitieInserare = scanner.nextInt();

        StringBuilder stringBuilder = new StringBuilder(sir);
        stringBuilder.insert(pozitieInserare, sirInserat);
        System.out.println("The sequence after insertion: " + stringBuilder.toString());

        System.out.println("Enter position to remove:");
        int pozitieStergere = scanner.nextInt();
        System.out.println("Enter the number of charcters to remove:");
        int lungimeStergere = scanner.nextInt();

        stringBuilder.delete(pozitieStergere, pozitieStergere + lungimeStergere);
        System.out.println("The sequence: " + stringBuilder.toString());

        scanner.close();
    }
}
