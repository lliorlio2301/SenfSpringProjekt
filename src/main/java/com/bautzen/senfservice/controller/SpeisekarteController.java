package com.bautzen.senfservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bautzen.senfservice.model.Gericht;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController // Sagt: "Ich bin bereit für Web-Anfragen!"
public class SpeisekarteController {

    private List<Gericht> gerichte;

    @PostConstruct
    private void erstelleListe() {
        gerichte = List.of(
            new Gericht("Bautzener Senfeier", 8.50, true),
            new Gericht("Sorbisches Hochzeitsessen", 14.90, false),
            new Gericht("Teichelmauke", 11.20, false),
            new Gericht("Quark mit Leinöl", 7.50, true)
        );
    }

    // Wenn jemand im Browser "localhost:8082/menue" aufruft, passiert das hier:
    @GetMapping("/menue")
    public List<Gericht> holeSpeisekarte() {
        
        return gerichte;
        // Spring Boot verwandelt diese Liste automatisch in JSON!
    }
    
    @GetMapping("/info")
    public String hallo() {
        return "Willkommen im besten Wirtshaus der Oberlausitz!";
    }

    @GetMapping("/menue/vegetarisch")
    public List<Gericht> getVegetarischeGerichte() {
        
        List<Gericht> vegetarisch = gerichte.stream().filter(Gericht::istVegetarisch)
        .collect(Collectors.toList());

        return vegetarisch;
    }

    @GetMapping("/menue/teuer")
    public List<Gericht> getTeuereGerichte() {

        List<Gericht> teuereGerichte = gerichte.stream().filter(v -> v.getPreis() > 10)
        .collect(Collectors.toList());
        
        return teuereGerichte;
    }

    // URL: /menue/0  oder /menue/2
    @GetMapping("/menue/{nummer}")
    public Gericht getGerichtNachNummer(@PathVariable int nummer) {
        // Wir holen das Element an der Stelle "nummer" aus der Liste
        // Achtung: Wenn nummer zu groß ist, stürzt es ab (IndexOutOfBounds)
        // Aber zum Testen reicht es erstmal!
        return gerichte.get(nummer);
    }    

}
