package org.upt.pj.lab7.p2;

class SetTobe extends InstrumentMuzical {
    private TipTobe tipTobe;
    private int nrTobe;
    private int nrCinele;

    public SetTobe(String producator, double pret, TipTobe tipTobe, int nrTobe, int nrCinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    public SetTobe() {
        super("", 0);
    }


    @Override
    public String toString() {
        return "SetTobe{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                ", tipTobe=" + tipTobe +
                ", nrTobe=" + nrTobe +
                ", nrCinele=" + nrCinele +
                '}';
    }

    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(TipTobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    public void setNrCinele(int nrCinele) {
        this.nrCinele = nrCinele;
    }
}
