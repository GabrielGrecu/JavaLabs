package com.pj.p2;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "resources/cantec_in.txt";
        String outputFileName = "resources/cantec_out.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            Random random = new Random();

            while ((line = reader.readLine()) != null) {
                Vers vers = new Vers(line);

                if (random.nextDouble() < 0.1) {
                    line = line.toUpperCase();
                }

                writer.write(line);

                int numarCuvinte = vers.numarCuvinte();
                int numarVocale = vers.numarVocale();

                writer.write(" (Cuvinte: " + numarCuvinte + ", Vocale: " + numarVocale + ")");

                if (line.endsWith("ape") || line.endsWith("APE")) {
                    writer.write(" *");
                }


                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Cantecul a fost procesat si scris in fisierul " + outputFileName);
        } catch (IOException e) {
            System.err.println("A aparut o eroare: " + e.getMessage());
        }
    }
}