package com.telefonica.eom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.ServiceActvtnBenefits;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ServiceActvtnBenefitsRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity ServiceActvtnBenefits. 
* 
*/
@Repository
public interface ServiceActvtnBenefitsRepo extends JpaRepository<ServiceActvtnBenefits, String> {
     
    @Query("select sab from ServiceActvtnBenefits sab where "
	    +"sab.customerType in (:customerType, '*') and "
	    +"sab.customerSubType = :customerSubType and "
	    +"sab.suscriberGroupValue in (:suscriberGroupValue, '*') and "
	    +"sab.boServiceActivated in (:boServiceActivated) and "
	    +"sab.planGroup in (:planGroup, '*') and "
	    +"sab.productOfferCode in (:productOfferCode, '*') and "
	    +"sab.planBoCode in (:planBoCode, '*') and "
	    +"sab.department in (:department, '*') and "
	    +"sab.saleChannel in (:saleChannel, '*') and "
	    +"sab.userStoreBrand in (:userStoreBrand, '*') and "
	    +"sab.userStoreId in (:userStoreId, '*') and "
	    +"sab.salabilityStartDate <= :salabilityDate and "
	    +"sab.salabilityEndDate >= :salabilityDate")
    List<ServiceActvtnBenefits> findByQueryParamFilters(
	    @Param("customerType") String customerType,
	    @Param("customerSubType") String customerSubType, 
	    @Param("suscriberGroupValue") String suscriberGroupValue, 
	    @Param("boServiceActivated") List<String> boServiceActivated,
	    @Param("planGroup") String planGroup, 
	    @Param("productOfferCode") String productOfferCode,
	    @Param("planBoCode") String planBoCode, 
	    @Param("department") String department, 
	    @Param("saleChannel") String saleChannel,
	    @Param("userStoreBrand") String userStoreBrand, 
	    @Param("userStoreId") String userStoreId,
	    @Param("salabilityDate") LocalDate salabilityDate);

}
