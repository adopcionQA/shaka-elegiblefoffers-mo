package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.BillingOfferMaster;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: BillingOfferMasterRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity BillingOfferMaster. 
* 
*/
@Repository
public interface BillingOfferMasterRepo extends JpaRepository<BillingOfferMaster, String> {
    
    List<BillingOfferMaster> findByCidBO(String cidBO);
    
    List<BillingOfferMaster> findByCaptionBO(String captionBO);
    
    List<BillingOfferMaster> findByCaptionBOIn(List<String> captionBOList);
    
   
    
}
