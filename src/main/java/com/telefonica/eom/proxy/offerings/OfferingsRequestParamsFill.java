package com.telefonica.eom.proxy.offerings;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryTreeTypeType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.FilterInfoType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PagingInfoType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.SortCriteriaType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.UNIKeyValueType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September. 2020
 * @FileName: OfferingsRequestParamsFill.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los metodos necesarios para poblar el response de
 *               Offerings.
 * 
 */
@Service
public class OfferingsRequestParamsFill {

    /**
     * Metodo que retorna objeto CategoryTreeTypeType.
     * 
     * @param MobileElegibleOffersRequest
     * @return CategoryTreeTypeType
     */
    public CategoryTreeTypeType getCategory(MobileElegibleOffersRequest meor) {

	CategoryTreeTypeType category = new CategoryTreeTypeType();
	CategoryTreeTypeType subcategory = new CategoryTreeTypeType();

	category.setId(meor.getCategoryId());
	category.setName(meor.getCategoryName());

	if (meor.getSubcategoryId() != null && !meor.getSubcategoryId().isEmpty()) {
	    subcategory.setId(meor.getSubcategoryId());
	    subcategory.setName(meor.getSubcategoryName());
	    category.setSubcategories(subcategory);

	}

	return category;
    }

    /**
     * Metodo que retorna objeto FilterInfoType.
     * 
     * @param MobileElegibleOffersRequest
     * @return FilterInfoType
     */
    public FilterInfoType getFilterInfo(MobileElegibleOffersRequest meor) {

	FilterInfoType fit = new FilterInfoType();

	fit.setSourceType(meor.getSourceType());
	fit.setActionType(meor.getAction());
	if (meor.getCreditScore() != null) {
		if(String.valueOf(meor.getCreditScore()).length() > 2) {
			fit.setCreditScore(String.valueOf(meor.getCreditScore()).substring(0,3));
		}else {
			fit.setCreditScore(String.valueOf(meor.getCreditScore()));
		}	
	}
	fit.setDepartament(meor.getRegion());
	fit.setStoreId(meor.getSiteId());
	fit.setDealerCode(meor.getDealerId());
	fit.setPaginationInfo(this.getPaginationInfo(meor.getPaginationInfoSize(), meor.getPaginationInfoPageCount(),
		meor.getPaginationInfoPage(), meor.getPaginationInfoMaxResultCount()));
	fit.getSortCriteria().add((this.getSortCriteria(meor.getSortCriteriaName(), meor.getSortCriteriaAscending())));
	fit.setProduct(meor.getProduct());
	if (meor.getFields() != null) {
	    fit.getFilterFacets().add(this.getFilterFacet(meor.getFields()));
	}
	fit.setCustomerType(meor.getCustomerSegment());

	if (meor.getBroadbandMinDlDataRate() != null) {
	    fit.setOfferMinInternetSpeed(String.valueOf(meor.getBroadbandMinDlDataRate()));
	}
	if (meor.getBroadbandMaxDlDataRate() != null) {
	    fit.setOfferMaxInternetSpeed(String.valueOf(meor.getBroadbandMaxDlDataRate()));
	}
	
	fit.setServiceTechnology(meor.getBroadbandConnection());

	if (meor.getIsRetention() != null) {
	    fit.setRetentionFlag(String.valueOf(meor.getIsRetention()));
	}

	if (meor.getIsPortability() != null) {
	    fit.setPortInFlag(String.valueOf(meor.getIsPortability()));
	}
	fit.setCommercialZoneId(meor.getCommercialAreaId());
	fit.setSourceProductOfferingId(meor.getCurrentOffering());
	fit.setNetworkTechnology(meor.getNetworkTechnology());

	fit.setMaxSpeed(meor.getServiceabilityMaxSpeed());
	fit.setServiceabilityID(meor.getServiceabilityId());

	fit.setPlanGroup(meor.getPlanGroup());
	fit.setPlanRank(meor.getPlanRank());
	fit.setPlanCommitmentDuration(meor.getPlanCommitmentDuration());

	fit.setInvoiceCompany(meor.getInvoiceCompany());

	return fit;
    }

    /**
     * Metodo auxiliar.
     * 
     * @param String
     * @return UNIKeyValueType
     */
    private UNIKeyValueType getFilterFacet(String element) {

	UNIKeyValueType ukvt = new UNIKeyValueType();

	List<String> subcategories = Util.getListSplit(element, Constant.DOBLEPOINT);

	ukvt.setKey(subcategories.get(0));
	ukvt.setValue(subcategories.get(1));

	return ukvt;
    }

    /**
     * Metodo que retorna objeto FilterInfoType.
     * 
     * @param Integer,Integer,Integer,Integer
     * @return PagingInfoType
     */
    private PagingInfoType getPaginationInfo(Integer paginationInfoSize, Integer paginationInfoPageCount, Integer paginationInfoPage,
	    Integer paginationInfoMaxResultCount) {

	PagingInfoType pit = new PagingInfoType();

	pit.setPageSize(new BigDecimal(paginationInfoSize));
	pit.setPageCount(new BigDecimal(paginationInfoPageCount));
	pit.setPageNumber(new BigDecimal(paginationInfoPage));
	pit.setMaxResultCount(new BigDecimal(paginationInfoMaxResultCount));

	return pit;
    }

    /**
     * Metodo que retorna objeto FilterInfoType.
     * 
     * @param String,Boolean
     * @return SortCriteriaType
     */
    private SortCriteriaType getSortCriteria(String sortCriteriaName, Boolean sortCriteriaAscending) {

	SortCriteriaType sct = new SortCriteriaType();

	sct.setPropertyName(sortCriteriaName);
	sct.setIsAscending(sortCriteriaAscending);

	return sct;
    }

}
