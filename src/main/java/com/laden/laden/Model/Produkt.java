package com.laden.laden.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Produkt {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idProdukt;
    private String bezeichnung;
    private String  marke;
    private Double preis;
    private Double verfuegbareMenge;

    public Produkt() {
    }

    public Produkt(Long idProdukt, String bezeichnung, String marke, Double preis, Double verfuegbareMenge) {
        this.idProdukt = idProdukt;
        this.bezeichnung = bezeichnung;
        this.marke = marke;
        this.preis = preis;
        this.verfuegbareMenge = verfuegbareMenge;
    }
    
    
}
