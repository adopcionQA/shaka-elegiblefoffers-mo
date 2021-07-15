package com.telefonica.eom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telefonica.eom.entity.RelationsMaster;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: RelationsMasterRepo.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio para consultas del entity RelationsMaster.
 * 
 */
public interface RelationsMasterRepo extends JpaRepository<RelationsMaster, Integer> {

	RelationsMaster findByChildIdAndRootCid(String childId, String rootCid);

	List<RelationsMaster> findByRootCid(String rootCid);

	List<RelationsMaster> findByRootCidAndChildIdIn(String rootCid, List<String> listChilId);

	@Query(value = "select rm.*  from relations_master rm " + " where rm.child_id in ?1 and "
			+ " rm.root_cid in (select rrc.cid_child from relation_root_cid rrc where rrc.root_cid = ?2)", nativeQuery = true)
	List<RelationsMaster> relRootCidByChilIdAndRootCid(List<String> listChildId, String rootCid);
}
