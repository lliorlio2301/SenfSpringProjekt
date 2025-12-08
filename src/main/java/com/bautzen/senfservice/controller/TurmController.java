package com.bautzen.senfservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bautzen.senfservice.model.Turm;
import com.bautzen.senfservice.service.TurmService;

@RestController
public class TurmController {
    
    private TurmService turmService;

    public TurmController(TurmService turmService) {
        this.turmService = turmService;
    }

    @GetMapping("/tuerme")
    public List<Turm> getTuerme() {
        return turmService.getTuerme();
    }

    @GetMapping("/tuerme/{id}")
    public ResponseEntity<Turm> getTurm(@PathVariable int id) {
        //R.Entity sendet automatisch den Status-Code
        //200 OK / 404 not Found 
        return ResponseEntity.of(turmService.getTurmnachId(id));
    }

    @PostMapping("/tuerme") 
    public void setNeuenTurm(@RequestBody Turm turm ) {
        turmService.setNeuenTurm(turm);
    }

    @DeleteMapping("/tuerme/{id}")
    public void deleteTurm(@PathVariable int id){
        turmService.loeschenTurmNachId(id);
    }

    @GetMapping("/tuerme/besuchbar")
    public List<Turm> getBesuchbareTuerme() {
        //R.Entity sendet automatisch den Status-Code
        //200 OK / 404 not Found 
        return turmService.getBesucbareTuerme();
    }



}
