package com.laden.laden.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Kunde {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idKunde;
    private String name;
    private String nachname;
    private String ausweisnummer;

    public Kunde() {
    }

    public Kunde(Long idKunde, String name, String nachname, String ausweisnummer) {
        this.idKunde = idKunde;
        this.name = name;
        this.nachname = nachname;
        this.ausweisnummer = ausweisnummer;
    }
    
    
}
