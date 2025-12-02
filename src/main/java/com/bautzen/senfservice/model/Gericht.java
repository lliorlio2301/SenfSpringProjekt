package com.bautzen.senfservice.model;

public class Gericht {
    private String name;
    private double preis;
    private boolean istVegetarisch;

    public Gericht(String name, double preis, boolean istVegetarisch) {
        this.name = name;
        this.preis = preis;
        this.istVegetarisch = istVegetarisch;
    }

    // WICHTIG: Für JSON braucht Spring Boot zwingend Getter!
    public String getName() { return name; }
    public double getPreis() { return preis; }
    public boolean istVegetarisch() { return istVegetarisch; }
}
