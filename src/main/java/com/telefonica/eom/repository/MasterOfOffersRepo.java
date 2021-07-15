package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.MasterOfOffers;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: MasterOfOffersRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity MasterOfOffers. 
* 
*/
@Repository
public interface MasterOfOffersRepo extends JpaRepository<MasterOfOffers, String> {
    
    List<MasterOfOffers> findByOfferCid(String offerCid);

}
