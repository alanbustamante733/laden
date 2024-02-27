package com.laden.laden.Repository;

import com.laden.laden.Model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKundeRepository  extends JpaRepository <Kunde, Long>{
    
}
