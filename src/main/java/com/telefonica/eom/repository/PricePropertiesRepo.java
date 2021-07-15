package com.telefonica.eom.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.eom.entity.PriceProperties;

@Repository
public interface PricePropertiesRepo extends JpaRepository<PriceProperties, Serializable> {

	List<PriceProperties> findDistinctByIdAndNamePropAbp(Integer id, String namePropAbp);

	List<PriceProperties> findByBillingOfferId(String offerCid);

	@Cacheable(value = "priceprop_bynamepropabp", unless = "#result == null or #result.size() == 0")
	List<PriceProperties> findDistinctByNamePropAbp(String namePropAbp);
}
