package com.bautzen.senfservice.service;

import java.lang.classfile.ClassFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.stereotype.Service;

import com.bautzen.senfservice.model.Turm;

import jakarta.annotation.PostConstruct;

@Service
public class TurmService {

    List<Turm> tuerme;

    public TurmService(){
        this.tuerme = new ArrayList<>();
    }

    @PostConstruct
    public void erstelleListe(){
        this.tuerme.addAll(List.of(
            new Turm(0,"Reichenturm", 70.8, false),
            new Turm(1, "Lauenturm", 50.6, true),
            new Turm(2, "Alte Wasserkunst", 43.5, true),
            new Turm(3, "Nicolaiturm", 33.5, false),
            new Turm(4, "Schülerturm", 56.3, true)
        ));
    }

    public List<Turm> getTuerme() {
        return this.tuerme;
    }

    public Optional<Turm> getTurmnachId(int id) {
        if (id<tuerme.size() && id>=0) {
            return Optional.of(tuerme.get(id));
        }
        return Optional.empty();
    }

    public void setNeuenTurm(Turm turm) {
        int id = getMaxId()+1;
        turm.setId(id);
        tuerme.add(turm);
    }

    public int getMaxId() {
        OptionalInt id = tuerme.stream().mapToInt(Turm::getId).max();
        return id.orElse(0);
    }

    public void loeschenTurmNachId(int id) {
        tuerme.removeIf(t->t.getId()==id);
    }

    public List<Turm> getBesucbareTuerme() {
        return tuerme.stream().filter(t-> t.isBesuchbar()).toList();
    }
       
}
