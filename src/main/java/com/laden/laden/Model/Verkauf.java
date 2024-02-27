package com.laden.laden.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Verkauf {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idVerkauf;
    private LocalDate verkaufsDatum;
    @OneToMany
    private List<Produkt> produkteListe;
    @OneToOne
    private Kunde einKunde;

    public Verkauf() {
    }

    public Verkauf(Long idVerkauf, LocalDate verkaufsDatum, List<Produkt> produkteListe, Kunde einKunde) {
        this.idVerkauf = idVerkauf;
        this.verkaufsDatum = verkaufsDatum;
        this.produkteListe = produkteListe;
        this.einKunde = einKunde;
    }


    
    
}
