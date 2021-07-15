package com.telefonica.eom.business.svas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.BenefitsQueries;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.entity.OffersProperties;
import com.telefonica.eom.entity.ServiceActvtnBenefits;
import com.telefonica.eom.entity.Svaoffering;
import com.telefonica.eom.enums.PropertyValueEnum;
import com.telefonica.eom.jdbc.AdditionalService;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.pojo.RelationsAdditionalServices;
import com.telefonica.eom.repository.OffersPropertiesRepo;
import com.telefonica.eom.repository.ServiceActvtnBenefitsRepo;
import com.telefonica.eom.repository.SvaofferingRepo;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: AdditionalServices.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que contiene los metodos necesarios para obtener
 *               los Servicios adicionales.
 */
@Service
public class AdditionalServices {

	@Autowired
	OffersPropertiesRepo offersPropertiesRepo;

	@Autowired
	SvaofferingRepo svaofferingRepo;

	@Autowired
	AdditionalService additionalService;

	@Autowired
	ServiceActvtnBenefitsRepo serviceActvtnBenefitsRepo;

	@Autowired
	BenefitsQueries businessQueries;

	/**
	 * Metodo que retorna una lista de RelationsAdditionalServices.
	 * 
	 * @param MobileElegibleOffersRequest,List<OffersProperties>
	 * @return List<RelationsAdditionalServices>
	 */
	
	@Cacheable(value = "additional_services", unless = "#result == null or #result.size() == 0")
	public List<RelationsAdditionalServices> getSVAS(MobileElegibleOffersRequest meor, List<OffersProperties> offersValues) {

		//	this.offersValues = offersValues;

		return additionalService
				.getRelations(meor,
						this.getAdditionalComponents(Util.fromBoolToYN(meor.getIsRetention()), meor.getAction(), offersValues))
				.stream().filter(this::pvCondition).collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna una lista Id de componentes.
	 * 
	 * @param String,String
	 * @return List<String>
	 */
	private List<String> getAdditionalComponents(String isRetention, String action, List<OffersProperties> offersValues) {

		String soloRetention = this.getPropertyValue(PropertyValueEnum.RETENTION, offersValues);
		String lobType = this.getPropertyValue(PropertyValueEnum.LOB_TYPE, offersValues);
		List<String> retentions;
		LocalDate systemDate = LocalDate.now();

		if (lobType == null) {
			lobType = Constant.WIRELESS;
		}

		if (Constant.YES.equals(soloRetention) && Constant.YES.equals(isRetention)) {
			retentions = Arrays.asList(isRetention);
		} else {
			retentions = Arrays.asList(isRetention, Constant.ASTERISK);
		}

		return svaofferingRepo.findByQueryParamFilters(lobType, action, systemDate, retentions).stream()
				.map(Svaoffering::getIdComponente).collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna una lista de OffersProperties.
	 * 
	 * @param String
	 * @return List<OffersProperties>
	 */
	public List<OffersProperties> getPropertyValues(String productOfferingCatalogId) {

		return offersPropertiesRepo.findByOfferCidAndNameOfPropertyIn(productOfferingCatalogId,
				Arrays.asList(PropertyValueEnum.RETENTION.getValue(), PropertyValueEnum.LOB_TYPE.getValue(),
						PropertyValueEnum.PLAN_GROUP.getValue()));
	}

	/**
	 * Metodo que retorna el PropertyValue de OffersProperties.
	 * 
	 * @param PropertyValueEnum
	 * @return String
	 */
	private String getPropertyValue(PropertyValueEnum pvenmun, List<OffersProperties> offersValues) {
		String pv = null;

		Optional<OffersProperties> ovOptional = offersValues.stream()
				.filter(ov -> pvenmun.getValue().equals(ov.getNameOfProperty())).findAny();

		if (ovOptional.isPresent()) {
			pv = ovOptional.get().getPropertyValue();
		}

		return pv;
	}

	/**
	 * Metodo que retorna true|false de acuerdo a parametros enviados
	 * 
	 * @param RelationsAdditionalServices
	 * @return boolean
	 */
	private boolean pvCondition(RelationsAdditionalServices ras) {
		if (ras.getPropertyValue() == null) {
			return true;
		} else {
			return LocalDate.now().isBefore(Util.parseDate(ras.getPropertyValue()));
		}
	}

	/**
	 * Metodo que retorna una lista de ServiceActvtnBenefits.
	 * 
	 * @param List<String>,MobileElegibleOffersRequest,List<OffersProperties>
	 * @return List<ServiceActvtnBenefits>
	 */
	public List<ServiceActvtnBenefits> getBenefits(List<String> captionsBo, MobileElegibleOffersRequest meor,
			List<OffersProperties> offersValues) {

		//	this.offersValues = offersValues;
		String planGroup = businessQueries.getPropertyValue(meor.getPlanId(), meor.getProductOfferingCatalogId());
		String productOfferCode = this.getPropertyValue(PropertyValueEnum.PLAN_GROUP, offersValues);
		String planBoCode = businessQueries.getCaptionBO(meor.getPlanId());

		return serviceActvtnBenefitsRepo.findByQueryParamFilters(meor.getCustomerSegment(),
				meor.getCustomerSubsegment(), meor.getSubscriberGroupValue(), captionsBo, planGroup, productOfferCode,
				planBoCode, meor.getRegion(), meor.getChannelId(), meor.getDealerId(), meor.getSiteId(),
				LocalDate.now());
	}

}
