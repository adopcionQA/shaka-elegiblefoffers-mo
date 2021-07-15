package com.telefonica.eom.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.ProvideBenefits;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ProvideBenefitsRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity ProvideBenefits. 
* 
*/
@Repository
public interface ProvideBenefitsRepo extends JpaRepository<ProvideBenefits, String> {
    
    //@Cacheable(value = "PRList", key = "#meor")
    @Cacheable(value = "provide_benefits", unless = "#result == null or #result.size() == 0")
    @Query("select pb from ProvideBenefits pb where "
	    + "pb.customerType in (?1, '*') and "
	    + "pb.customerSubType = ?2 and "
	    + "pb.saleChannel in (?3, '*') and "
	    + "pb.department in (?4, '*') and "
	    + "pb.userStoreBrand in (?5, '*') and "
	    + "pb.userStoreId in (?6, '*') and "
	    + "pb.salabilityStartDate <= ?7 and "
	    + "pb.salabilityEndDate >= ?7 ")
    public List<ProvideBenefits> findByQueryParamFilters(String customerType, String customerSubType, String saleChannel, String department,
	    String userStoreBrand, String userStoreId, LocalDateTime date);

}
