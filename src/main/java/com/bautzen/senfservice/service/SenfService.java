package com.bautzen.senfservice.service;

import com.bautzen.senfservice.model.Gericht;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SenfService {

    List<Gericht> gerichte;

    public SenfService() {
        this.gerichte = new ArrayList<>();
    }

    @PostConstruct
    public void erstelleListe() {
        this.gerichte.addAll(List.of(
            new Gericht("Bautzener Senfeier", 8.50, true),
            new Gericht("Sorbisches Hochzeitsessen", 14.90, false),
            new Gericht("Teichelmauke", 11.20, false),
            new Gericht("Quark mit Leinöl", 7.50, true)
        ));
    }

    public List<Gericht> getGerichte() {
        return gerichte;
    }

    public void setGerichte(List<Gericht> gerichte) {
        this.gerichte = gerichte;
    }

    public List<Gericht> getVegetarischeGerichte() {
        
        List<Gericht> vegetarisch = gerichte.stream().filter(Gericht::istVegetarisch)
        .collect(Collectors.toList());

        return vegetarisch;
    }

    public List<Gericht> getTeuereGerichte() {

        List<Gericht> teuereGerichte = gerichte.stream().filter(v -> v.getPreis() > 10)
        .collect(Collectors.toList());
        
        return teuereGerichte;
    }

    public Optional<Gericht> getGerichtNachNummer(int nummer) {
        
        if (gerichte.size()>nummer && nummer >=0) {
            return Optional.of(gerichte.get(nummer));
        }
        return Optional.empty();
    }

    public List<Gericht> gerichtHinzufuegen(Gericht neuesGericht) {
        gerichte.add(neuesGericht);
        return gerichte;
    }

    public List<Gericht> gerichtLoeschen(int nummer) {

        if (nummer >= 0 && nummer < gerichte.size()) {
            gerichte.remove(nummer);
        }
        return gerichte;
    }

    public List<Gericht> gerichtAktualisieren(int nummer, Gericht update) {
        if (nummer >= 0 && nummer < gerichte.size()) {
            gerichte.set(nummer, update);
        }
        return gerichte;
    } 
}

