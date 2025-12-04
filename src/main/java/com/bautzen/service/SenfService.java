package com.bautzen.service;

import com.bautzen.senfservice.model.Gericht;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SenfService {

    List<Gericht> gerichte;

    public SenfService(List<Gericht> gerichte) {
        this.gerichte = gerichte;
    }

    public SenfService(){}

    public void erstelleListe() {
        gerichte = new ArrayList<>(List.of(
            new Gericht("Bautzener Senfeier", 8.50, true),
            new Gericht("Sorbisches Hochzeitsessen", 14.90, false),
            new Gericht("Teichelmauke", 11.20, false),
            new Gericht("Quark mit Leinöl", 7.50, true)
        ));
    }
    
}

