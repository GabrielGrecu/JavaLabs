package org.upt.pj.lab7.p2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Set<InstrumentMuzical> colectie = new HashSet<>();
        colectie.add(new Chitara("Fender", 2500, TipChitara.ELECTRICA, 7));
        colectie.add(new Chitara("Yamaha", 1500, TipChitara.ACUSTICA, 6));
        colectie.add(new Chitara("Crafter", 2000, TipChitara.CLASICA, 6));
        colectie.add(new SetTobe("Roland", 3500, TipTobe.ELECTRONICE, 5, 3));
        colectie.add(new SetTobe("Pearl", 2800, TipTobe.ACUSTICE, 4, 2));
        colectie.add(new SetTobe("Mapex", 3200, TipTobe.ACUSTICE, 6, 4));

        mapper.writerFor(new TypeReference<Set<InstrumentMuzical>>() {})
                .withDefaultPrettyPrinter()
                .writeValue(new File("instrumente.json"), colectie);

        Set<InstrumentMuzical> colectieCitita = mapper.readerFor(new TypeReference<Set<InstrumentMuzical>>() {})
                .readValue(new File("instrumente.json"));

        System.out.println("Implementarea utilizata pentru interfata Set: " + colectieCitita.getClass());

        InstrumentMuzical chitaraDuplicat = new Chitara("Fender", 2500, TipChitara.ELECTRICA, 7);
        if (!colectie.contains(chitaraDuplicat)) {
            boolean added = colectie.add(chitaraDuplicat);
            if (added) {
                System.out.println("Instrumentul a fost adaugat cu succes in colectie: " + chitaraDuplicat);
            } else {
                System.out.println("Instrumentul " + chitaraDuplicat + " este deja in colectie.");
            }
        } else {
            System.out.println("Instrumentul " + chitaraDuplicat + " este deja in colectie.");
        }
        System.out.println();

        colectieCitita.removeIf(instrument -> instrument.pret > 3000);
        System.out.println("Instrumentele cu pretul mai mic de 3000 RON: " + colectieCitita);

        System.out.println();
        colectieCitita.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .forEach(System.out::println);

        System.out.println();
        colectieCitita.stream()
                .filter(instrument -> instrument.getClass().equals(SetTobe.class))
                .forEach(System.out::println);

        colectieCitita.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .map(instrument -> (Chitara) instrument)
                .max((chitara1, chitara2) -> chitara1.getNrCorzi() - chitara2.getNrCorzi())
                .ifPresent(System.out::println);

        colectieCitita.stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .map(instrument -> (SetTobe) instrument)
                .filter(instrument -> instrument.getTipTobe().equals(TipTobe.ACUSTICE))
                .sorted((t1, t2) -> t1.getNrTobe() - t2.getNrTobe())
                .forEach(System.out::println);
    }
}
