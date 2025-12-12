package com.bautzen.senfservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Bewertung {

    private int bewertung;

    public Bewertung(){}

    public Bewertung(int bewertung) {
        this.bewertung = bewertung;
    }



    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

}
