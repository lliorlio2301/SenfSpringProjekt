package com.bautzen.senfservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Turm {

    @Id // Damit signalisiert man, das id der PS ist
    @GeneratedValue(strategy= GenerationType.AUTO) //so wird es automatisch hochgezählt
    private int id;
    private String name;
    private double hoehe;
    private boolean besuchbar;

    @OneToMany(mappedBy="turm", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
    private List<Bewertung> bewertungen;
    
    //Leeres Konstruktor für die Umwandlung von JSON in Java Objekten
    //ArrayList wird erstellt am Anfang    
    public Turm(){}

    public Turm(String name, double hoehe, boolean besuchbar) {
        this.name = name;
        this.hoehe = hoehe;
        this.besuchbar = besuchbar;
    }

    //Konstruktor für die erste Erstellung von Tabellen - ohne Bewertung, da diese nachher abgegeben werden
    public Turm(int id, String name, double hoehe, boolean besuchbar) {
        this.id = id;
        this.name = name;
        this.hoehe = hoehe;
        this.besuchbar = besuchbar;
        this.bewertungen = new ArrayList<>();
    }

    public void bewertungEintragen(Bewertung bewertung){
        this.bewertungen.add(bewertung);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHoehe() {
        return hoehe;
    }
    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }
    public boolean isBesuchbar() {
        return besuchbar;
    }
    public void setBesuchbar(boolean besuchbar) {
        this.besuchbar = besuchbar;
    }
}
