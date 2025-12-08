package com.bautzen.senfservice.model;

public class Turm {

    private int id;
    private String name;
    private double hoehe;
    private boolean besuchbar;
    
    //Leeres Konstruktor für die Umwandlung von JSON in Java Objekten   
    public Turm(){}
    public Turm(String name, double hoehe, boolean besuchbar) {
        this.name = name;
        this.hoehe = hoehe;
        this.besuchbar = besuchbar;
    }

    public Turm(int id, String name, double hoehe, boolean besuchbar) {
        this.id = id;
        this.name = name;
        this.hoehe = hoehe;
        this.besuchbar = besuchbar;
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
