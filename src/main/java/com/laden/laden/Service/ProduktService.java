package com.laden.laden.Service;

import com.laden.laden.Model.Produkt;
import com.laden.laden.Repository.IProduktRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduktService implements IProduktService{

    @Autowired
    private IProduktRepository produktRepo;
    
    @Override
    public List<Produkt> getProdukte() {
        List <Produkt> produkteListe = produktRepo.findAll();
        return produkteListe;
    }

    @Override
    public void saveProdukt(Produkt prod) {
        produktRepo.save(prod);
    }

    @Override
    public void deleteProdukt(Long id) {
        produktRepo.deleteById(id);
    }

    @Override
    public Produkt findProdukt(Long id) {
        Produkt prod = produktRepo.findById(id).orElse(null);
        return prod;
    }

    @Override
    public void editProdukt(Long idOriginal,
                                                  Long idNeuer,
                                                  String neueBezeichnung,
                                                  String neueMarke,
                                                  Double neuerPreis,
                                                  Double neueVerfuegbareMenge) {
        
        //ich hole den urschprüglichen Id
        Produkt prod = this.findProdukt(idOriginal);
        
        //Modifitzierung des Objektes
        prod.setIdProdukt(idNeuer);
        prod.setBezeichnung(neueBezeichnung);
        prod.setMarke(neueMarke);
        prod.setPreis(neuerPreis);
        prod.setVerfuegbareMenge(neueVerfuegbareMenge);
        
        //Speicherung des Objektes
        this.saveProdukt(prod);
        
    }

    @Override
    public void editProdukt(Produkt prod) {
        this.saveProdukt(prod);
    }
    
}
