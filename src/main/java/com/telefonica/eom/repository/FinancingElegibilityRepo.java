package com.telefonica.eom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telefonica.eom.entity.FinancingElegibility;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: FinancingElegibilityRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity FinancingElegibility. 
* 
*/
public interface FinancingElegibilityRepo extends JpaRepository<FinancingElegibility, String>{
	
}
