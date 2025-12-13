package com.bautzen.senfservice.repository;

import com.bautzen.senfservice.model.Turm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmRepository extends JpaRepository<Turm, Integer> {
    
    // Spring zaubert hier automatisch SQL-Queries draus!
    // Wir müssen nur den Methodennamen richtig wählen.
    
    // SELECT * FROM Turm WHERE besuchbar = ?
    List<Turm> findByBesuchbar(boolean besuchbar);

    // SELECT * FROM Turm WHERE hoehe > ?
    List<Turm> findByHoeheGreaterThan(double minHoehe);
}