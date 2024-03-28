package com.upt.p;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

class Copiator extends Echipament {
    private int paginiToner;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, Stare stare, int paginiToner, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, stare);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    public int getPaginiToner() {
        return paginiToner;
    }

    public void setPaginiToner(int paginiToner) {
        this.paginiToner = paginiToner;
    }

    public FormatCopiere getFormatCopiere() {
        return formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }


}
