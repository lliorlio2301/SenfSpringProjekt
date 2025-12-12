package com.bautzen.senfservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Bewertung {

    private String text;
    private int sterne; //1-6

    @ManyToOne
    @JoinColumn(name="turm_id")
    @JsonIgnore // WICHTIG: Verhindert eine Endlos-Schleife beim Laden (Turm -> Bewertung -> Turm -> ...)
    private Turm turm;

    public Bewertung(){}

    public Bewertung(String text, int bewertung, Turm turm) {
        this.text = text;
        this.turm = turm;
        this.sterne = bewertung;
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int bewertung) {
        this.sterne = bewertung;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Turm getTurm() {
        return turm;
    }

    public void setTurm(Turm turm) {
        this.turm = turm;
    }

    

}
