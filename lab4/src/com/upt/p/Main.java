package com.upt.p;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    private static List<Echipament> echipamente = new ArrayList<>();

    public static void main(String[] args) {
        citesteDate("echipamente.txt");

        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Meniu:");
            System.out.println("1. Afișare toate echipamentele");
            System.out.println("2. Afișare imprimante");
            System.out.println("3. Afișare copiatoare");
            System.out.println("4. Afișare sisteme de calcul");
            System.out.println("5. Modificare stare echipament");
            System.out.println("6. Setare mod de scriere pentru imprimantă");
            System.out.println("7. Setare format de copiere pentru copiator");
            System.out.println("8. Instalare sistem de operare pentru sistem de calcul");
            System.out.println("9. Afișare echipamente vândute");
            System.out.println("10. Serializare colecție în fișier");
            System.out.println("11. Deserializare colecție din fișier");
            System.out.println("0. Ieșire");

            System.out.print("Alegeți opțiunea: ");
            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline

            switch (optiune) {

                case 0:
                    continua = false;
                    break;
                case 1:
                default:
                    System.out.println("Opțiune invalidă.");
            }
        }
        scanner.close();
    }

    private static void citesteDate(String numeFisier) {
        try (Scanner scanner = new Scanner(new File(numeFisier))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                String[] date = linie.split(";");
                if (date.length >= 6) {
                    switch (date[5]) {

                        default:
                            System.out.println("Tip de echipament necunoscut: " + date[5]);
                    }
                } else {
                    System.out.println("Linie invalidă: " + linie);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fișierul nu a fost găsit");
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fișier: " + e.getMessage());
        }


    }

    private static void citesteEchipamente() {
        try (Scanner fileScanner = new Scanner(new File("echipamente.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");
                String tipEchipament = parts[5].toLowerCase().trim();

                if (tipEchipament.equals("copiator")) {
                    echipamente.add(new Copiator(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]), Stare.valueOf(parts[3]), Integer.parseInt(parts[6]), FormatCopiere.valueOf(parts[7])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul electronic.txt nu a fost găsit.");
            e.printStackTrace();
        }
    }
}