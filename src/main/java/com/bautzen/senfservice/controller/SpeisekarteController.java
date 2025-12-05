package com.bautzen.senfservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bautzen.senfservice.model.Gericht;
import com.bautzen.senfservice.service.SenfService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

@RestController // Sagt: "Ich bin bereit für Web-Anfragen!"
public class SpeisekarteController {

    private SenfService senfService;

    public SpeisekarteController(SenfService senfService) {
        this.senfService = senfService;
    }

    // Wenn jemand im Browser "localhost:8082/menue" aufruft, passiert das hier:
    @GetMapping("/menue")
    public List<Gericht> holeSpeisekarte() {
        
        return senfService.getGerichte();
        // Spring Boot verwandelt diese Liste automatisch in JSON!
    }
    
    @GetMapping("/info")
    public String hallo() {
        return "Willkommen im besten Wirtshaus der Oberlausitz!";
    }

    @GetMapping("/menue/vegetarisch")
    public List<Gericht> getVegetarischeGerichte() {
        return senfService.getVegetarischeGerichte();
    }

    @GetMapping("/menue/teuer")
    public List<Gericht> getTeuereGerichte() {        
        return senfService.getTeuereGerichte();
    }

    // URL: /menue/0  oder /menue/2
    @GetMapping("/menue/{nummer}")
    public ResponseEntity<Gericht> getGerichtNachNummer(@PathVariable int nummer) {
        // Wir holen das Element an der Stelle "nummer" aus der Liste
        // Achtung: Wenn nummer zu groß ist, stürzt es ab (IndexOutOfBounds)
        // Aber zum Testen reicht es erstmal!
        Gericht gericht = senfService.getGerichtNachNummer(nummer);
        if (gericht==null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gericht);
    }
    
    // Wir nutzen hier POST statt GET
    @PostMapping("/menue") 
    public List<Gericht> gerichtHinzufuegen(@RequestBody Gericht neuesGericht) {
        // Das "neuesGericht" wird automatisch aus dem JSON gebaut, das wir senden!        
        // Wir geben zur Bestätigung die neue, volle Liste zurück
        return senfService.gerichtHinzufuegen(neuesGericht);
    }

    @DeleteMapping("/menue/{nummer}")
    public List<Gericht> gerichtLoeschen(@PathVariable int nummer) {
        // .remove(int index) löscht das Element an dieser Stelle
        // Vorsicht: Alle nachfolgenden Elemente rutschen auf!
        // Index 1 wird dann zu Index 0.
        return senfService.gerichtLoeschen(nummer);
    }

    @PutMapping("/menue/{nummer}")
    public List<Gericht> gerichtAktualisieren(@PathVariable int nummer, @RequestBody Gericht update) {
        // .set(index, element) tauscht das Element aus
        return senfService.gerichtAktualisieren(nummer, update);
    }
}
