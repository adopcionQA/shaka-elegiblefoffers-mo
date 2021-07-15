package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.OffersProperties;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: OffersPropertiesRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity OffersProperties. 
* 
*/
@Repository
public interface OffersPropertiesRepo extends JpaRepository<OffersProperties, String> {
    
    List<OffersProperties> findByOfferCidAndNameOfProperty(String offerCid, String nameOfProperty);
    
    List<OffersProperties> findByOfferCidAndNameOfPropertyIn(String offerCid, List<String> namesOfProperty);

}
