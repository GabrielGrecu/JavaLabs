package com.upt.p;

import lombok.Data;

@Data
class Echipament {
    protected String denumire;
    protected int nrInv;
    protected double pret;
    protected Stare stare;

    public Echipament(String denumire, int nrInv, double pret, Stare stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.stare = stare;
    }

}
