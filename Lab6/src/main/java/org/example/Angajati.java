package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Angajati {
    private String nume;
    private String post;
    private LocalDate dataAngajarii;
    private float salariu;
    private static Logger logger = LoggerFactory.getLogger(Angajati.class);

    @Override
    public String toString() {
        return "Angajati{" + "nume='" + nume + '\'' + ", post='" + post + '\'' + ", dataAngajarii=" + dataAngajarii + ", salariu=" + salariu + '}';
    }

    public static void scrieInFisier(List<Angajati> angajatiList) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            objectMapper.writeValue(new File("src/main/resources/angajati.json"), angajatiList);
            System.out.println("Datele angajatilor au fost scrise in fisierul angajati.json.");
        } catch (IOException e) {
            logger.error("Eroare la citirea din fisierul JSON: {}", e.getMessage());
            System.err.println("Eroare la scrierea in fisierul JSON: " + e.getMessage());
        }
    }

    public static List<Angajati> citesteDinFisier() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(new File("src/main/resources/angajati.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Angajati.class));
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisierul JSON: " + e.getMessage());
            return Collections.emptyList(); // Returnează o listă goală în caz de eroare
        }
    }


    public static void afisareListaAngajati(List<Angajati> angajatiList) {
        System.out.println("\n\n\n************************************************ Lista de angajati: *********************************************");
        angajatiList.forEach(System.out::println);
    }

    public static void afisareSalariuPeste(List<Angajati> angajatiList, float limitaSalariu) {
        System.out.println("\n\n\n********************************************* Angajatii cu salariul peste " + limitaSalariu + " RON: *********************************************");
        angajatiList
                .stream()
                .filter(angajat -> angajat.getSalariu() > limitaSalariu)
                .forEach(System.out::println);
    }

    public static void angajatiConducereAprilieAnulTrecut(List<Angajati> angajatiList) {
        int anCurent = LocalDate.now().getYear();
        List<Angajati> angajatiConducereAprilieAnulTrecut = angajatiList.stream().filter(angajat -> angajat.getDataAngajarii().getYear() == anCurent - 1 && angajat.getDataAngajarii().getMonthValue() == 4 && (angajat.getPost().toLowerCase().contains("sef") || angajat.getPost().toLowerCase().contains("director"))).toList();

        System.out.println("\n\n\n********************************************* Angajatii din luna aprilie, a anului trecut, cu functie de conducere: *********************************************");
        angajatiConducereAprilieAnulTrecut.forEach(System.out::println);
    }


    public static void angajatiFaraConducere(List<Angajati> angajatiList) {
        System.out.println("\n\n\n********************************************* Angajatii fara functie de conducere, in ordine descrescatoare a salariilor: *********************************************");
        angajatiList.stream().filter(angajat -> !angajat.getPost().toLowerCase().contains("director") && !angajat.getPost().toLowerCase().contains("sef")).sorted(Comparator.comparingDouble(Angajati::getSalariu).reversed()).forEach(System.out::println);
    }

    public static void numeAngajatiMajuscule(List<Angajati> angajatiList) {
        List<String> numeAngajatiMajuscule = angajatiList.stream().map(angajat -> angajat.getNume().toUpperCase()).collect(Collectors.toList());

        System.out.println("\n\n\n********************************************* Numele angajatilor cu majuscule: *********************************************");
        System.out.println(numeAngajatiMajuscule);
    }

    public static void afisareSalariiMaiMiciDe(List<Angajati> angajatiList, float limitaSalariu) {
        System.out.println("\n\n\n********************************************* Salariile mai mici de " + limitaSalariu + " RON: *********************************************");
        angajatiList.stream().map(Angajati::getSalariu).filter(salariu -> salariu < limitaSalariu).forEach(System.out::println);
    }

    public static void afisarePrimulAngajat(List<Angajati> angajatiList) {
        System.out.println("\n\n\n********************************************* Datele primului angajat al firmei: *********************************************");
        angajatiList.stream().min((a1, a2) -> 0).ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista angajati în firma."));
    }

    public static void afisareStatisticiSalarii(List<Angajati> angajatiList) {
        System.out.println("\n\n\n********************************************* Statistici referitoare la salariul angajaților: *********************************************");
        var statisticiSalarii = angajatiList.stream().collect(Collectors.summarizingDouble(Angajati::getSalariu));
        System.out.println("Salariul minim: " + statisticiSalarii.getMin() + " RON");
        System.out.println("Salariul mediu: " + statisticiSalarii.getAverage() + " RON");
        System.out.println("Salariul maxim: " + statisticiSalarii.getMax() + " RON");
    }

    public static void afisareMesajIon(List<Angajati> angajatiList) {
        System.out.println("\n\n\n********************************************* Mesaj despre angajatii cu numele Ion: *********************************************");
        boolean existaIon = angajatiList.stream().anyMatch(angajat -> angajat.getNume().toLowerCase().contains("ion"));
        if (existaIon) {
            System.out.println("Firma are cel putin un angajat cu numele Ion.");
        } else {
            System.out.println("Firma nu are angajat cu numele Ion.");
        }
    }

    public static void afisareNumarAngajatiVaraAnulPrecedent(List<Angajati> angajatiList) {
        int anCurent = LocalDate.now().getYear();
        long numarAngajatiVaraAnulPrecedent = angajatiList.stream().filter(angajat -> angajat.getDataAngajarii().getYear() == anCurent - 1 && (angajat.getDataAngajarii().getMonthValue() >= 6 && angajat.getDataAngajarii().getMonthValue() <= 8)).count();
        log.info("\n\n\n********************************************* Numarul de angajati care s-au angajat in vara anului precedent: *********************************************" + numarAngajatiVaraAnulPrecedent);
    }
}