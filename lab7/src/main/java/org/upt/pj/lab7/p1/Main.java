package org.upt.pj.lab7.p1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> colectie = citesteCarti("carti.json");

        afiseazaColecția(colectie);

        colectie.remove(3);

        Carte carteNoua = new Carte("Amintiri din copilarie", "Ion Creanga", 2022);
        colectie.putIfAbsent(7, carteNoua);

        salveazaCarti(colectie, "carti_modificate.json");

        Set<Carte> cartiYuval = colectie.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.autorul()))
                .collect(Collectors.toSet());

        System.out.println("Cartile lui Yuval Noah Harari:");
        cartiYuval.forEach(System.out::println);

        System.out.println();
        cartiYuval.stream()
                .sorted(Comparator.comparing(Carte::titlul))
                .forEach(System.out::println);

        System.out.println();
        Optional<Carte> ceaMaiVecheCarte = cartiYuval.stream()
                .min(Comparator.comparingInt(Carte::anul));
        ceaMaiVecheCarte.ifPresent(carte -> System.out.println("Cea mai veche carte: " + carte));
    }

    private static Map<Integer, Carte> citesteCarti(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MapType mapType = TypeFactory.defaultInstance().constructMapType(HashMap.class, Integer.class, Carte.class);
        return objectMapper.readValue(new File(fileName), mapType);
    }

    private static void afiseazaColecția(Map<Integer, Carte> colectie) {
        System.out.println("Colectia de carti:");
        colectie.forEach((id, carte) -> System.out.println("ID: " + id + ", Carte: " + carte));
    }

    private static void salveazaCarti(Map<Integer, Carte> colectie, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(fileName), colectie);
    }
}

