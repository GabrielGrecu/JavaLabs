package org.upt.pj.lab7.p2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Adnotația pentru tipul polimorfic
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
abstract class InstrumentMuzical {
    protected String producator;
    protected double pret;

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }
}
