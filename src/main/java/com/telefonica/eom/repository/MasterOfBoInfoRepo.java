package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.MasterOfBoInfo;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: MasterOfBoInfoRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity MasterOfBoInfo. 
* 
*/
@Repository
public interface MasterOfBoInfoRepo extends JpaRepository<MasterOfBoInfo, String>{
    
    List<MasterOfBoInfo> findByCidBoIn(List<String> cidsBo);

}
