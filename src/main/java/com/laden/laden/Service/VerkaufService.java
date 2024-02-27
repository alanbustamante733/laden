package com.laden.laden.Service;

import com.laden.laden.Model.Verkauf;
import com.laden.laden.Repository.IVerkaufRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerkaufService implements IVerkaufService{

    @Autowired
    private IVerkaufRepository verkaufRepo;
    
    @Override
    public List<Verkauf> getVerkaeufe() {
        List <Verkauf> verkaufListe = verkaufRepo.findAll();
        return verkaufListe;
    }

    @Override
    public void saveVerkauf(Verkauf verk) {
        verkaufRepo.save(verk);
    }

    @Override
    public void deleteVerkauf(Long id) {
        verkaufRepo.deleteById(id);
    }

    @Override
    public Verkauf findVerkauf(Long id) {
        Verkauf verk = verkaufRepo.findById(id).orElse(null);
        return verk;
    }

    @Override
    public void editProdukt(Long idOriginal,
                                                      Long idNeuer,
                                                      LocalDate neusVerkaufsDatum) {
        
        //ich hole den urschprüglichen Id
        Verkauf verk = this.findVerkauf(idOriginal);
        
        //Modifitzierung des Objektes
        verk.setIdVerkauf(idNeuer);
        verk.setVerkaufsDatum(neusVerkaufsDatum);
        
        //Speicherung des Objektes
        this.saveVerkauf(verk);
        
    }

    @Override
    public void editVerkauf(Verkauf verk) {
        this.saveVerkauf(verk);
    }
    
}
