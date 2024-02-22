package com.upt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            double suma = 0;
            double minim = Double.MAX_VALUE;
            double maxim = Double.MIN_VALUE;
            int numarElemente = 0;

            while (scanner.hasNextDouble()) {
                double numar = scanner.nextDouble();
                suma += numar;
                minim = Math.min(minim, numar);
                maxim = Math.max(maxim, numar);
                numarElemente++;
            }

            double media = suma / numarElemente;

            scanner.close();

            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);
            System.out.println("Valoarea minima: " + minim);
            System.out.println("Valoarea maxima: " + maxim);

            FileWriter writer = new FileWriter("out.txt");
            writer.write("Suma: " + suma + "\n");
            writer.write("Media: " + media + "\n");
            writer.write("Valoarea minima: " + minim + "\n");
            writer.write("Valoarea maxima: " + maxim + "\n");
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul de intrare nu a fost gasit.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Eroare la scriere.");
            e.printStackTrace();
        }
    }
}
