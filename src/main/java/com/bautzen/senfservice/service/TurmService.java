package com.bautzen.senfservice.service;

import java.lang.classfile.ClassFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.stereotype.Service;

import com.bautzen.repository.TurmRepository;
import com.bautzen.senfservice.model.Turm;

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
        if(turmRepository.count()==0){
            turmRepository.save(new Turm("Reichenturm", 70.8, false));
            turmRepository.save(new Turm("Lauenturm", 50.6, true));
            turmRepository.save(new Turm("Alte Wasserkunst", 43.5, true));
            turmRepository.save(new Turm("Nicolaiturm", 33.5, false));
            turmRepository.save(new Turm("Schülerturm", 56.3, true));
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
