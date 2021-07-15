package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.PropertyInBillingOffer;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: PropertyInBillingOfferRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity PropertyInBillingOffer. 
* 
*/
@Repository
public interface PropertyInBillingOfferRepo extends JpaRepository<PropertyInBillingOffer, String> {
    
    public List<PropertyInBillingOffer> findByCidBoAndPropertyName(String cidBo, String propertyName);
    	
    public List<PropertyInBillingOffer> findByCidBoInAndPropertyName(List<String> cidBoList, String propertyName);
	
	public List<PropertyInBillingOffer> findByCaptionBoAndPropertyName (String captionBo, String propertyName);
	
	public List<PropertyInBillingOffer> findByCaptionBoIn (List<String> captionBOList);
	
	public List<PropertyInBillingOffer> findByCidBo(String cidBo ) ;

}
