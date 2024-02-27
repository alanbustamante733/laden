
package com.laden.laden.Service;

import com.laden.laden.Model.Verkauf;
import java.time.LocalDate;
import java.util.List;

public interface IVerkaufService {
    
     public List<Verkauf> getVerkaeufe();
    
    
    public void saveVerkauf(Verkauf verk);
    
    
    public void deleteVerkauf (Long id);
    
    
    public Verkauf findVerkauf(Long id);
    
    //edit nach Parameter und id veränderbar falls nötig ist
    public void editProdukt (Long idOriginal, Long idNeuer, 
                                                        LocalDate neusVerkaufsDatum);

    public void editVerkauf(Verkauf verk);
    
}

