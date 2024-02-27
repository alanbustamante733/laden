package com.laden.laden.Service;

import com.laden.laden.Model.Kunde;
import java.util.List;

public interface IKundeService {
    
    
    public List<Kunde> getKunden();
    
    
    public void saveKunde(Kunde kun);
    
    
    public void deleteKunde (Long id);
    
    
    public Kunde findKunde(Long id);
    
    //edit nach Parameter und id veränderbar falls nötig ist
    public void editKunde (Long idOriginal, Long idNeuer, 
                                                        String neuerName, 
                                                        String neuerNachname, 
                                                        String neueAusweisnummer);

    public void editKunde(Kunde kun);
    
}


