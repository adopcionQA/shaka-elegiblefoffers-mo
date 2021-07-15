package com.telefonica.eom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.FinancingCode;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: FinancingCodeRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity FinancingCode. 
* 
*/
@Repository
public interface FinancingCodeRepo extends JpaRepository<FinancingCode, String> {
	

}
