package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Angajati> angajatiList = Arrays.asList(
                new Angajati("Ion Popescu", "Manager", LocalDate.of(2022, 5, 15), 3500),
                new Angajati("Maria Ionescu", "Programator", LocalDate.of(2023, 3, 20), 2800),
                new Angajati("Ana Munteanu", "Director Vanzari", LocalDate.of(2022, 4, 10), 4000),
                new Angajati("George Stan", "Contabil", LocalDate.of(2023, 3, 5), 3200),
                new Angajati("Mihai Popa", "Sef Departament", LocalDate.of(2023, 4, 30), 3800)
        );

        Angajati.scrieInFisier(angajatiList);

        List<Angajati> angajatiDeserializati = Angajati.citesteDinFisier();
        if (angajatiDeserializati != null) {
            System.out.println("\nDatele citite din fisierul angajati.json:");
            angajatiDeserializati.forEach(System.out::println);
        }


        List<Angajati> angajati = Angajati.citesteDinFisier();
        if (angajati != null) {
            Angajati.afisareListaAngajati(angajati);
            Angajati.afisareSalariuPeste(angajati, 2500);
            Angajati.angajatiConducereAprilieAnulTrecut(angajati);
            Angajati.angajatiFaraConducere(angajati);
            Angajati.numeAngajatiMajuscule(angajati);
            Angajati.afisareSalariiMaiMiciDe(angajatiList, 3000);
            Angajati.afisarePrimulAngajat(angajatiList);
            Angajati.afisareStatisticiSalarii(angajatiList);
            Angajati.afisareMesajIon(angajatiList);
            Angajati.afisareNumarAngajatiVaraAnulPrecedent(angajatiList);
        }
    }
}
