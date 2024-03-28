package com.upt.p;

class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int paginiCarutus;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nrInv, double pret, Stare stare, int ppm, String rezolutie, int paginiCarutus, ModTiparire modTiparire) {
        super(denumire, nrInv, pret, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.paginiCarutus = paginiCarutus;
        this.modTiparire = modTiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getPaginiCarutus() {
        return paginiCarutus;
    }

    public void setPaginiCarutus(int paginiCarutus) {
        this.paginiCarutus = paginiCarutus;
    }

    public ModTiparire getModTiparire() {
        return modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }
}
