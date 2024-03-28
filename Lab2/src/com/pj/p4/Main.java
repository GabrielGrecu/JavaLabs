package com.pj.p4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();
        scanner.nextLine();

        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of person " + (i + 1) + ":");
            String name = scanner.nextLine();

            String cnp;
            boolean cnpValid = false;
            do {
                System.out.println("Enter the CNP of person " + (i + 1) + " (13 digits):");
                cnp = scanner.nextLine();
                cnpValid = isValidCNP(cnp);
                if (!cnpValid) {
                    System.out.println("The entered CNP is invalid. Please re-enter.");
                }
            } while (!cnpValid);

            persons[i] = new Person(name, cnp);
        }

        for (Person person : persons) {
            System.out.println("Name: " + person.getName());
            System.out.println("CNP: " + person.getCnp());
            System.out.println("Age: " + person.getAge());
            System.out.println();
        }

        scanner.close();
    }

    public static boolean isValidCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                return false;
            }
        }

        char firstDigit = cnp.charAt(0);
        if (!Character.isDigit(firstDigit)) {
            return false;
        }

        int[] controlFactors = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnp.charAt(i)) * controlFactors[i];
        }
        int remainder = sum % 11;
        int controlDigit = (remainder == 10) ? 1 : remainder;

        int lastDigit = Character.getNumericValue(cnp.charAt(12));
        if (controlDigit != lastDigit) {
            return false;
        }

        return true;
    }
}