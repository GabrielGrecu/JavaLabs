package org.upt.pj.lab7.p2;

import java.util.Objects;

class Chitara extends InstrumentMuzical {
    private TipChitara tipChitara;
    private int nrCorzi;

    public Chitara(String producator, double pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    public Chitara() {
        super("", 0);
    }

    @Override
    public String toString() {
        return "Chitara{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                ", tipChitara=" + tipChitara +
                ", nrCorzi=" + nrCorzi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chitara chitara = (Chitara) o;
        return nrCorzi == chitara.nrCorzi &&
                Double.compare(chitara.pret, pret) == 0 &&
                Objects.equals(producator, chitara.producator) &&
                tipChitara == chitara.tipChitara;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator, pret, tipChitara, nrCorzi);
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }
}
