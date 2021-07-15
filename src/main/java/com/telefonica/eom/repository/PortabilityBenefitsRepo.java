package com.telefonica.eom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.PortabilityBenefits;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: PortabilityBenefitsRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity PortabilityBenefits. 
* 
*/
@Repository
public interface PortabilityBenefitsRepo extends JpaRepository<PortabilityBenefits, String> {
    
    
    @Query("select pb from PortabilityBenefits pb where "
		+ "pb.customerType in (?1, '*') and "
		+ "(pb.customerSubType like %?2% or pb.customerSubType = '*') and "
		+ "pb.prodTypeDonor in (?3, '*') and "
		+ "pb.donorOperator in (?4, '*') and "
		+ "pb.salesChannel in (?5, '*') and "
		+ "pb.storeId in (?6, '*') and "
		+ "pb.storeBrand in (?7, '*') and "
		+ "pb.department in (?8, '*') and "
		+ "pb.salabilityStartDate <= CURRENT_DATE  and "
		+ "pb.salabilityEndDate >= CURRENT_DATE ")
    public List<PortabilityBenefits> findByQueryParamFilters(String customerType, String customerSubType, String prodTypeDonor,
	    String donorOperator, String salesChannel, String storeId, String storeBrand, String department);

}
