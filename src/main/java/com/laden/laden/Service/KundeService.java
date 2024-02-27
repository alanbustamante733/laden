
package com.laden.laden.Service;

import com.laden.laden.Model.Kunde;
import com.laden.laden.Repository.IKundeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeService implements IKundeService{
    
    @Autowired
    private IKundeRepository kundeRepo;
    
    @Override
    public List<Kunde> getKunden() {
        List <Kunde> kundenListe = kundeRepo.findAll();
        return kundenListe;
    }

    @Override
    public void saveKunde(Kunde kun) {
        kundeRepo.save(kun);
    }

    @Override
    public void deleteKunde(Long id) {
        kundeRepo.deleteById(id);
    }

    @Override
    public Kunde findKunde(Long id) {
        Kunde kun = kundeRepo.findById(id).orElse(null);
        return kun;
    }

    @Override
    public void editKunde(Long idOriginal,
                                                Long idNeuer,
                                                String neuerName,
                                                String neuerNachname,
                                                String neueAusweisnummer) {
        
        //ich hole den urschprüglichen Id
        Kunde kun = this.findKunde(idOriginal);
        
        //Modifitzierung des Objektes
        kun.setIdKunde(idNeuer);
        kun.setNachname(neuerName);
        kun.setAusweisnummer(neueAusweisnummer);
        
        //Speicherung des Objektes
        this.saveKunde(kun);
        
    }

    @Override
    public void editKunde(Kunde kun) {
        this.saveKunde(kun);
    }
    
}
