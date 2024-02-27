package com.laden.laden.Controller;

import com.laden.laden.Model.Kunde;
import com.laden.laden.Service.IKundeService;
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
public class KundeController {
    
    @Autowired
    private IKundeService kundeServ;
    
    @PostMapping ("/kunden/erstellen")
    public String saveKunde (@RequestBody Kunde kun) {
        kundeServ.saveKunde(kun);
        
        return "Der Kunde ist erfolgreich erstellt.";
    }
    
    @GetMapping ("/kunden/holen")
    public List<Kunde> getKunden() {

        return kundeServ.getKunden();
    }
    
    @DeleteMapping ("/kunden/loeschen/{id}")
    public String deleteKunde(@PathVariable Long id) {
        kundeServ.deleteKunde(id);
        return "Der Kunde ist erfolgreich gelöscht";
    }
    
    @PutMapping ("/kunden/bearbeiten")
        public Kunde editKunde(@RequestBody Kunde kun) {
        kundeServ.editKunde(kun);
        
        return kundeServ.findKunde(kun.getIdKunde());
    }
    
        //extra übungen
        
}
