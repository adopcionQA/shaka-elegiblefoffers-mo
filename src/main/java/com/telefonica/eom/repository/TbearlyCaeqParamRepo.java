package com.telefonica.eom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.TbearlyCaeqParam;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: TbearlyCaeqParamRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity TbearlyCaeqParam. 
* 
*/
@Repository
public interface TbearlyCaeqParamRepo extends JpaRepository<TbearlyCaeqParam, String> {

}
