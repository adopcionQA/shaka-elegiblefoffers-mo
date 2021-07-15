package com.telefonica.eom.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.enums.ADataEnum;
import com.telefonica.eom.generated.offers.model.CategoryTreeType;
import com.telefonica.eom.generated.offers.model.KeyValueType;
import com.telefonica.eom.generated.offers.model.MoneyType;
import com.telefonica.eom.generated.offers.model.ProductInstanceRefType;
import com.telefonica.eom.generated.offers.model.ProductInstanceRefType.ProductTypeEnum;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryTreeTypeType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.UNIKeyValueType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.UNIMoneyType;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: ResponseSubFieldsFiller.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service auxiliara para seguir poblando el response.
 */
@Service
public class ResponseSubFieldsFiller {

	/**
	 * Metodo que retorna una lista de ProductInstanceRefType
	 * 
	 * @param List<ProductInventoryResponseDto>
	 * @return List<ProductInstanceRefType>
	 */
	public List<ProductInstanceRefType> getCompatibleProducts(List<ProductInstanceType> pUProduct) {

		return pUProduct.stream().map(product -> {
		
			ProductInstanceRefType pirt = new ProductInstanceRefType();
			pirt.setId(product.getProductOffering().getId());
			pirt.setHref(product.getProductOffering().getId());
			pirt.setName(product.getProductOffering().getName());
			pirt.setPublicId(product.getPublicId());
			pirt.setDescription(product.getProductOffering().getDescription());
			pirt.setProductType(ProductTypeEnum.fromValue(product.getProductType().toString()));
			return pirt;
		}).collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna una lista de KeyValueType
	 * 
	 * @param OfferingTypeOfferType,String
	 * @return List<KeyValueType>
	 */
	public List<KeyValueType> getAdditionalData(OfferingTypeOfferType offerType, String applyFinancing) {

		List<KeyValueType> kvtList = Arrays.asList(this.getADkeyValue(ADataEnum.IMAGE.getValue(), offerType.getImage()),
				this.getADkeyValue(ADataEnum.BANNER.getValue(), offerType.getBanner()),
				this.getADkeyValue(ADataEnum.DISPLAY_NAME.getValue(), offerType.getDisplayName()),
				this.getADkeyValue(ADataEnum.RELATION_ID.getValue(), offerType.getRelationId()),
				this.getADkeyValue(ADataEnum.ID_ASSIGNED_ITEM.getValue(), offerType.getCorrelationId()),
				this.getADkeyValue(ADataEnum.PARENT_CATALOG_ITEM_ID.getValue(), offerType.getParentCatalogItemID()),
				this.getADkeyValue(ADataEnum.PARENT_CATALOG_ITEM_NAME.getValue(), offerType.getParentCatalogItemName()),
				this.getADkeyValue(ADataEnum.PARENT_CURRENT_STATUS.getValue(), offerType.getParentCurrentStatus()),
				this.getADkeyValue(ADataEnum.PARENT_ASSIGNED_ID.getValue(), offerType.getParentAssignedID()),
				this.getADkeyValue(ADataEnum.TOP_RECOMENDED.getValue(), offerType.isTopRecommended().toString()),
				this.getADkeyValue(ADataEnum.PRODUCT_TYPE.getValue(), offerType.getProductType().get(0).value()),
				this.getADkeyValue(ADataEnum.COMPATIBLE_WITH_DEVICE.getValue(), offerType.getCompatibleWithDevice()),
				this.getADkeyValue(ADataEnum.MIN_NUM_OF_SUSCRIBERS.getValue(), offerType.getMinNumOfSubscribers()),
				this.getADkeyValue(ADataEnum.NUM_OF_SUSCRIBERS.getValue(), offerType.getNumOfSubscribers()),
				this.getADkeyValue(ADataEnum.SHARED_PLAN.getValue(), offerType.getSharedPlan()),
				this.getADkeyValue(ADataEnum.APPLY_FINANCING.getValue(), applyFinancing));

		List<KeyValueType> kvtListFinal = new ArrayList<>(kvtList);

		kvtListFinal.addAll(
				offerType.getAdditionalData().stream().map(this::getAditionalDataElement).collect(Collectors.toList()));

		return kvtListFinal;
	}

	/**
	 * Metodo que retorna una lista de KeyValueType
	 * 
	 * @param List<UNIKeyValueType>
	 * @return List<KeyValueType>
	 */
	public List<KeyValueType> getAditionalDataPOP(List<UNIKeyValueType> planInfo) {
		return planInfo.stream().map(this::getAditionalDataElement).collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna un objeto MoneyType
	 * 
	 * @param UNIMoneyType
	 * @return MoneyType
	 */
	public MoneyType getOriginalAmount(UNIMoneyType umt) {

		MoneyType mt = new MoneyType();
		mt.setUnits((umt.getUnits() == null || umt.getUnits().isEmpty()) 
		    ? Constant.PERUVIAN_COIN : umt.getUnits());
		mt.setAmount(umt.getAmount());

		return mt;
	}

	public MoneyType getPrice(UNIMoneyType originalAmount, UNIMoneyType price) {

		MoneyType mt = new MoneyType();
		mt.setUnits((price.getUnits() == null || price.getUnits().isEmpty()) 
		    ? Constant.PERUVIAN_COIN : price.getUnits());
		mt.setAmount(originalAmount.getAmount());

		return mt;
	}

	public MoneyType getPriceWithTax(UNIMoneyType umt) {

		MoneyType mt = new MoneyType();
		mt.setUnits((umt.getUnits() == null || umt.getUnits().isEmpty()) 
		    ? Constant.PERUVIAN_COIN : umt.getUnits());
		mt.setAmount(Util.igvCalculator(umt.getAmount()));

		return mt;
	}

	/**
	 * Metodo que retorna un objeto CategoryTreeType
	 * 
	 * @param CategoryTreeTypeType
	 * @return CategoryTreeType
	 */
	public CategoryTreeType getCategory(CategoryTreeTypeType cttt) {
		CategoryTreeType ctt = new CategoryTreeType();
		ctt.setId(cttt.getId());
		ctt.setHref(cttt.getHref());
		ctt.setName(cttt.getName());
		return ctt;
	}

	/**
	 * Metodo que retorna un objeto KeyValueType
	 * 
	 * @param String,String
	 * @return KeyValueType
	 */
	private KeyValueType getADkeyValue(String key, String value) {
		KeyValueType kvt = new KeyValueType();
		kvt.setKey(key);
		kvt.setValue(value);
		return kvt;
	}

	/**
	 * Metodo que retorna un objeto KeyValueType
	 * 
	 * @param UNIKeyValueType
	 * @return KeyValueType
	 */
	private KeyValueType getAditionalDataElement(UNIKeyValueType uNIkvt) {
		KeyValueType kvt = new KeyValueType();
		kvt.setKey(uNIkvt.getKey());
		kvt.setValue(uNIkvt.getValue() != null ? uNIkvt.getValue() : "");
		return kvt;
	}

}
