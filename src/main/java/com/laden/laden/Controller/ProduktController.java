package com.laden.laden.Controller;

import com.laden.laden.Model.Kunde;
import com.laden.laden.Model.Produkt;
import com.laden.laden.Service.IProduktService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduktController {
    
    @Autowired
    private IProduktService produktServ;
    
    @PostMapping ("/produkten/erstellen")
    public String saveProdukt (@RequestBody Produkt prod) {
        produktServ.saveProdukt(prod);
        
        return "Das Produkt ist erfolgreich erstellt.";
    }
    
    @GetMapping ("/produkten/holen")
    public List<Produkt> getProdukte() {

        return produktServ.getProdukte();
    }
    
    @DeleteMapping ("/produkten/loeschen/{id}")
    public String deleteProdukt(@PathVariable Long id) {
        produktServ.deleteProdukt(id);
        return "Das Produkt ist erfolgreich gelöscht";
    }
    
    @PutMapping ("/produkten/bearbeiten")
        public Produkt editProdukt(@RequestBody Produkt prod) {
        produktServ.editProdukt(prod);
        
        return produktServ.findProdukt(prod.getIdProdukt());
    }
    
        //extra übungen
        
        @GetMapping ("/produkten/produktemengekleinerals5")
    public List<Produkt> getProdukteMengeKleienerAls5() {
    
        List<Produkt> alleProdukte = produktServ.getProdukte();
        List<Produkt> listeProdukteMengekleinerAls5 = new ArrayList<>();
        for(Produkt prod : alleProdukte) {
            if(prod.getVerfuegbareMenge() < 5) {
                listeProdukteMengekleinerAls5.add(prod);
            }
        }
        
        
        return listeProdukteMengekleinerAls5;
    }
}
