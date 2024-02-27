package com.laden.laden.Repository;

import com.laden.laden.Model.Verkauf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVerkaufRepository  extends JpaRepository <Verkauf, Long>{
    
}
