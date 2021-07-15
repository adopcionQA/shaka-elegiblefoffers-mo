package com.telefonica.eom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.ReplaceOfferBenefits;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ReplaceOfferBenefitsRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity ReplaceOfferBenefits. 
* 
*/
@Repository
public interface ReplaceOfferBenefitsRepo extends JpaRepository<ReplaceOfferBenefits, String> {
    
    @Query("select rob from ReplaceOfferBenefits rob where "
		+ "rob.customerType in (?1, '*') and "
		+ "(rob.customerSubType like %?2% or rob.customerSubType = '*') and "
		+ "rob.suscriberGroupValue in (?3, '*') and "
		+ "rob.sourceProductOfferCode in (?4, '*') and "
		+ "rob.sourcePlanBOCode in (?5, '*') and "
		+ "rob.saleChannel in (?6, '*') and "
		+ "rob.department in (?7, '*') and "
		+ "rob.userStoreBrand in (?8, '*') and "
		+ "rob.userStoreId in (?9, '*') and "
		+ "rob.salabilityStartDate <= ?10 and "
		+ "rob.salabilityEndDate >= ?10 ")
    public List<ReplaceOfferBenefits> findByQueryParamFilters(String customerType, String customerSubType, String suscriberGroupValue,
	    String sourceProductOfferCode, String sourcePlanBOCode, String saleChannel, String department, String userStoreBrand,
	    String userStoreId, LocalDate date);
}
