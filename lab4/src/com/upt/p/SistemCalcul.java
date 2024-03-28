package com.upt.p;

class SistemCalcul extends Echipament {
    private String tipMonitor;
    private double vitezaProcesor;
    private int capacitateHDD;
    private TipSistemOperare sistemOperare;

    public SistemCalcul(String denumire, int nrInv, double pret, Stare stare, String tipMonitor, double vitezaProcesor, int capacitateHDD, TipSistemOperare sistemOperare) {
        super(denumire, nrInv, pret, stare);
        this.tipMonitor = tipMonitor;
        this.vitezaProcesor = vitezaProcesor;
        this.capacitateHDD = capacitateHDD;
        this.sistemOperare = sistemOperare;
    }

    public String getTipMonitor() {
        return tipMonitor;
    }

    public void setTipMonitor(String tipMonitor) {
        this.tipMonitor = tipMonitor;
    }

    public double getVitezaProcesor() {
        return vitezaProcesor;
    }

    public void setVitezaProcesor(double vitezaProcesor) {
        this.vitezaProcesor = vitezaProcesor;
    }

    public int getCapacitateHDD() {
        return capacitateHDD;
    }

    public void setCapacitateHDD(int capacitateHDD) {
        this.capacitateHDD = capacitateHDD;
    }

    public TipSistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(TipSistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }
}
