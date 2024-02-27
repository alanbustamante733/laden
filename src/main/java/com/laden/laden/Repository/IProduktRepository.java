package com.laden.laden.Repository;

import com.laden.laden.Model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduktRepository  extends JpaRepository <Produkt, Long>{
    
}
