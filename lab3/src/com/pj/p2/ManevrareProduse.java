package com.pj.p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManevrareProduse {
    private static List<Produs> produse = new ArrayList<>();
    public static void citesteProduse(String numeFisier) {
        try {
            Scanner scanner = new Scanner(new File(numeFisier));
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                String[] elemente = linie.split(",");
                String denumire = elemente[0].trim();
                double pret = Double.parseDouble(elemente[1].trim());
                int cantitate = Integer.parseInt(elemente[2].trim());
                LocalDate dataExpirare = LocalDate.parse(elemente[3].trim());
                Produs produs = new Produs(denumire, pret, cantitate, dataExpirare);
                produse.add(produs);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void meniu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Afiseaza toate produsele");
            System.out.println("2. Afiseaza produsele expirate");
            System.out.println("3. Vand un produs");
            System.out.println("4. Afiseaza produsele cu pretul minim");
            System.out.println("5. Salveaza produsele cu cantitate mai mica decat o valoare");
            System.out.println("0. Iesire");

            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    afiseazaProduse();
                    break;
                case 2:
                    afiseazaProduseExpirate();
                    break;
                case 3:
                    vindeProdus();
                    break;
                case 4:
                    afiseazaProduseCuPretMinim();
                    break;
                case 5:
                    salveazaProduseCantitateMica();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Optiune invalida");
            }
        }
    }

    public static void afiseazaProduse() {
        System.out.println("Lista de produse:");
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }

    public static void afiseazaProduseExpirate() {
        LocalDate azi = LocalDate.now();
        System.out.println("Produsele expirate:");
        for (Produs produs : produse) {
            if (produs.getDataExpirare().isBefore(azi)) {
                System.out.println(produs);
            }
        }
    }

    public static void vindeProdus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti denumirea produsului pe care doriti sa-l vindeti:");
        String denumire = scanner.nextLine();
        System.out.println("Introduceti cantitatea pe care doriti sa o vindeti:");
        int cantitate = scanner.nextInt();

        for (Produs produs : produse) {
            if (produs.getDenumire().equalsIgnoreCase(denumire)) {
                if (produs.getCantitate() >= cantitate) {
                    produs.setCantitate(produs.getCantitate() - cantitate);
                    double incasari = cantitate * produs.getPret();
                    System.out.println("Produsul a fost vandut cu succes. Incasari: " + incasari);
                    if (produs.getCantitate() == 0) {
                        produse.remove(produs);
                    }
                    return;
                } else {
                    System.out.println("Nu exista suficienta cantitate pe stoc pentru a vinde produsul.");
                    return;
                }
            }
        }
        System.out.println("Produsul nu a fost gasit in lista.");
    }

    public static void afiseazaProduseCuPretMinim() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse in lista.");
            return;
        }

        double pretMinim = Double.MAX_VALUE;
        for (Produs produs : produse) {
            if (produs.getPret() < pretMinim) {
                pretMinim = produs.getPret();
            }
        }

        System.out.println("Produsele cu pretul minim:");
        for (Produs produs : produse) {
            if (produs.getPret() == pretMinim) {
                System.out.println(produs);
            }
        }
    }

    public static void salveazaProduseCantitateMica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti cantitatea minima dorita:");
        int cantitateMinima = scanner.nextInt();
        try {
            PrintWriter writer = new PrintWriter("produse_cantitate_mica.txt");
            for (Produs produs : produse) {
                if (produs.getCantitate() < cantitateMinima) {
                    writer.println(produs);
                }
            }
            writer.close();
            System.out.println("Produsele cu cantitate mai mica decat " + cantitateMinima + " au fost salvate in fisierul produse_cantitate_mica.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
