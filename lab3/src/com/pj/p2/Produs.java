package com.pj.p2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirare;
}
