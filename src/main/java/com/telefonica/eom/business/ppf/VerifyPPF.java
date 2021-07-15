package com.telefonica.eom.business.ppf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.enums.NumberEnum;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.repository.PropertyInBillingOfferRepo;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: VerifyPPF.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que contiene los metodos necesarios para
 *               verificar si aplica Post Pago Facil.
 */
@Service
public class VerifyPPF {

	@Autowired
	PropertyInBillingOfferRepo propertyInBillingOfferRepo;

	/**
	 * Metodo que retorna si aplica PPF.
	 *
	 * @param MobileElegibleOffersRequest,String,String
	 * @return String
	 */
	public String validate(MobileElegibleOffersRequest meor, String poPriceId, String billingMethod) {

		if (Constant.PREPAID.equalsIgnoreCase(billingMethod)) {
			return Constant.NO;
		} else {
			Optional<PropertyInBillingOffer> piboOptional = propertyInBillingOfferRepo
					.findByCidBoAndPropertyName(poPriceId, "Plan Rank").stream().findAny();

			if (!piboOptional.isPresent()) {
				return Constant.NO;
			}

		    int risk;
		   // if(meor.getCreditScore() == 0) {
		    //	risk = 0;
		    //}else {
		    //	risk = Character.getNumericValue(Integer.toString(meor.getCreditScore()).charAt(3));
		   // }
		    risk = Integer.parseInt(meor.getCreditScore().substring(3,4)) ;

			int planRank = Integer.parseInt(piboOptional.get().getPropertyValue());

			if ((NumberEnum.THREE.getValue() == risk && planRank >= 99)
					|| (NumberEnum.FOUR.getValue() == risk && planRank >= 79)
					|| (NumberEnum.EIGHT.getValue() == risk && planRank >= 59) || NumberEnum.FIVE.getValue() == risk) {
				return Constant.YES;
			} else {
				return Constant.NO;
			}
		}
	}

}
