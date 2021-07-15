package com.telefonica.eom.business.penalty;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.entity.TbearlyCaeqParam;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

import pe.telefonica.customerordermanagement.orderservices.v1.types.DevicePenaltyInfo;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: VerifyPenalty.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que contiene los metodos necesarios para
 *               verificar la penalidad.
 */
@Service
public class VerifyPenalty {

	/**
	 * Metodo que retorna si aplica Penalidad.
	 * 
	 * @param MobileElegibleOffersRequest,String,DevicePenaltyInfo,BusinessReference,String
	 * @return String
	 */
	public String validate(MobileElegibleOffersRequest meor, String billingMethod, DevicePenaltyInfo devicePenaltyInfo,
			BusinessReference businessRef, String productOfferingPriceId) {

		if (!Constant.PROVIDE.equals(meor.getAction()) && !Constant.PREPAID.equals(billingMethod)) {

			String planRank = null;

			if (devicePenaltyInfo.getPenaltyAmountWithTax() != null
					&& Double.valueOf(devicePenaltyInfo.getPenaltyAmountWithTax()) >= 0) {

				Optional<PropertyInBillingOffer> piboOptional = businessRef.getPenaltyPropertyInBillingOfferList()
						.stream().filter(pibo -> productOfferingPriceId.equals(pibo.getCidBo())).findAny();

				if (piboOptional.isPresent()) {
					planRank = piboOptional.get().getPropertyValue();
				}
				// if plan rank null agregar validación de no encontrado en la base de datos

				int umbralplanRank = Integer.valueOf(meor.getPlanRankInitial()) - Integer.valueOf(planRank);
				long diasRestantes = Util.getDaysPeriod(devicePenaltyInfo.getCommitmentEndDate());

				Optional<TbearlyCaeqParam> tcpOptional = businessRef.getTbearlyCaeqParamList().stream()
						.filter(tcp -> meor.getSubscriberGroupValue().equals(tcp.getGvs()))
						.filter(tcp -> tcp.getDaysPriorExp() > diasRestantes)
						.filter(tcp -> tcp.getDowngradeTol() > umbralplanRank).findAny();

				if (tcpOptional.isPresent()) {
					return Constant.NO;
				} else {
					return Constant.YES;
				}

			} else {
				return Constant.NO;
			}
		} else {
			return Constant.NO;
		}
	}

}
