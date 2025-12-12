package com.bautzen.senfservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bautzen.senfservice.model.Bewertung;
import com.bautzen.senfservice.model.Turm;
import com.bautzen.senfservice.repository.TurmRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TurmService {

    List<Turm> tuerme;
    private final TurmRepository turmRepository; 

    public TurmService(TurmRepository turmRepository){
        this.turmRepository = turmRepository;
    }

    @PostConstruct
    public void erstelleListe(){
        if (turmRepository.count() == 0) {
            // Erst den Turm erstellen
            Turm reichenturm = new Turm("Reichenturm", 56.0, true);
            
            // Dann Bewertungen erstellen (und den Turm mitgeben!)
            Bewertung b1 = new Bewertung("Super Ausblick über Bautzen!", 5, reichenturm);
            Bewertung b2 = new Bewertung("Viele Treppen, aber lohnt sich.", 4, reichenturm);

            // Die Bewertungen in die Liste des Turms packen
            reichenturm.getBewertungen().add(b1);
            reichenturm.getBewertungen().add(b2);

            // Speichern (Dank CascadeType.ALL werden die Bewertungen automatisch mitgespeichert!)
            turmRepository.save(reichenturm);
        }
    }

    public List<Turm> getTuerme() {
        return this.turmRepository.findAll();
    }

    public Optional<Turm> getTurmnachId(int id) {
        return turmRepository.findById(id);
    }

    public void setNeuenTurm(Turm turm) {
        turmRepository.save(turm);    
    }

    public boolean  loeschenTurmNachId(int id) {
        if(turmRepository.existsById(id)) {
            turmRepository.deleteById(id);
        } 
        return false;
    }

    public List<Turm> getBesuchbareTuerme() {
        return turmRepository.findByBesuchbar(true);
    }

    public List<Turm> filterTuermeNachHoehe(double minHoehe) {
        return turmRepository.findByHoeheGreaterThan(minHoehe);
    }
       
}
