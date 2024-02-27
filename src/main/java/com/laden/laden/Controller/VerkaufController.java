package com.laden.laden.Controller;

import com.laden.laden.Model.Produkt;
import com.laden.laden.Model.Verkauf;
import com.laden.laden.Service.IVerkaufService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerkaufController {
    
    @Autowired
    private IVerkaufService verkaufServ;
    
    @PostMapping ("/verkauft/erstellen")
    public String saveProdukt (@RequestBody Verkauf verk) {
        verkaufServ.saveVerkauf(verk);
        
        return "Der Verkauf ist erfolgreich erstellt.";
    }
    
    @GetMapping ("/verkauft/holen")
    public List<Verkauf> getVerkaeufe() {

        return verkaufServ.getVerkaeufe();
    }
    
    @DeleteMapping ("/verkauft/loeschen/{id}")
    public String deleteVerkauf(@PathVariable Long id) {
        verkaufServ.deleteVerkauf(id);
        return "Der Verkauf ist erfolgreich gelöscht";
    }
    
    @PutMapping ("/verkauft/bearbeiten")
        public Verkauf editVerkauf(@RequestBody Verkauf verk) {
        verkaufServ.editVerkauf(verk);
        
        return verkaufServ.findVerkauf(verk.getIdVerkauf());
    }
    
        //extra übungen
        //Get nur die Liste von Produkte von einem Verkauf
        
        @GetMapping ("/verkauft/listeprodukte/{id}")
    public List<Produkt> getVerkaeufListeProdukte(@PathVariable Long id) {
        
        Verkauf verk = verkaufServ.findVerkauf(id);
        return verk.getProdukteListe();
    }
    
    //Get Umsatz und anzahl von Verkäufe von einem Tag.
    
    @GetMapping ("/verkauft/umsatzundverkaeufe/{datum}")
    public String getUmsatzundAnzahlVonVerkaeufeVonEinemTag(@PathVariable("datum") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate datum) {
        
        List<Verkauf> alleVerkaeufe = verkaufServ.getVerkaeufe();
        List<Verkauf> listeVerkaeufemitDatum = new ArrayList<>();
        List<Produkt> listeProdukte= new ArrayList<>();
        Double akumullatorPreis = 0.0;
        int akumulatorAnzahlVerkauf = 0;
        
        for(Verkauf verk : alleVerkaeufe) {
            if(verk.getVerkaufsDatum().equals(datum)) {
                listeVerkaeufemitDatum.add(verk);
                akumulatorAnzahlVerkauf = 1 + akumulatorAnzahlVerkauf;
            }
        }
        
        for(Verkauf verk : listeVerkaeufemitDatum) {
            listeProdukte = verk.getProdukteListe();
            for(var prod : listeProdukte) {
                Double preis = prod.getPreis();
                akumullatorPreis = preis + akumullatorPreis;
            }
        }
        
        return "Der Umsatz für den Tag " + datum + " ist " + akumullatorPreis + " euros und die Verkaufsanzahl ist " + 
                akumulatorAnzahlVerkauf + ".";
    }

}
