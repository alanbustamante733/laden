
package com.laden.laden.Service;

import com.laden.laden.Model.Produkt;
import java.util.List;

public interface IProduktService {
    
    public List<Produkt> getProdukte();
    
    
    public void saveProdukt(Produkt prod);
    
    
    public void deleteProdukt (Long id);
    
    
    public Produkt findProdukt(Long id);
    
    //edit nach Parameter und id veränderbar falls nötig ist
    public void editProdukt (Long idOriginal, Long idNeuer, 
                                                        String neueBezeichnung, 
                                                        String neueMarke, 
                                                        Double neuerPreis,
                                                        Double neueVerfuegbareMenge);

    public void editProdukt(Produkt prod);
    
}

