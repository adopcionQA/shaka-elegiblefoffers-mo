package com.telefonica.eom.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.Svaoffering;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: SvaofferingRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity Svaoffering. 
* 
*/
@Repository
public interface SvaofferingRepo extends JpaRepository<Svaoffering, String> {
    
    @Query("select svao from Svaoffering svao where "
	    	+ "svao.flagRetention in (:retentions) and "
	    	+ "svao.lobType = :lobType and "
	    	+ "svao.tipoOperation in (:tipoOperation, '*') and "
	    	+ "svao.fechaInicio <= :systemDate and "
	    	+ "svao.fechaFin >= :systemDate"
		    )
	    List<Svaoffering> findByQueryParamFilters(@Param("lobType") String lobType,
		    @Param("tipoOperation") String tipoOperation,
		    @Param("systemDate") LocalDate systemDate,
		    @Param("retentions") List<String> retentions);

    
}
