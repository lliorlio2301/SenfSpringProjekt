package com.bautzen.senfservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bautzen.senfservice.model.Bewertung;
import com.bautzen.senfservice.model.Turm;


@Repository
public interface BewertungRepository extends JpaRepository<Bewertung, Integer>{
    List<Bewertung> findByTurm(Turm turm);
}
