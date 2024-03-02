package com.pj.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] counties = readCounties("resources/judete_in.txt");
        if (counties != null) {
            Arrays.sort(counties);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your countie: ");
            String searchCountie = scanner.nextLine();

            int position = Arrays.binarySearch(counties, searchCountie);
            if (position >= 0) {
                System.out.println("The countie " + searchCountie + " was found on position " + (position + 1) + " in the txt file");
            } else {
                System.out.println("The countie wasn;t found.");
            }
        }
    }

    public static String[] readCounties(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int numberCounties = 0;

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numberCounties++;
            }
            scanner.close();

            String[] counties = new String[numberCounties];
            scanner = new Scanner(file);
            for (int i = 0; i < numberCounties; i++) {
                counties[i] = scanner.nextLine();
            }
            scanner.close();

            return counties;

        } catch (FileNotFoundException e) {
            System.out.println("the file " + fileName + " is not found.");
            return null;
        }
    }
}
