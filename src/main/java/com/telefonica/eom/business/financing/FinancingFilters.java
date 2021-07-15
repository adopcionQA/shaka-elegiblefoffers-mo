package com.telefonica.eom.business.financing;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.entity.FinancingCode;
import com.telefonica.eom.entity.FinancingElegibility;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: FinancingFilters.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Clase Service que contiene los metodos necesarios para filtar el financiamiento.
*/
@Service
public class FinancingFilters {

    /**
     * Metodo que retorna true|false de acuerdo a parametros enviado.
     * 
     * @param FinancingCode,String
     * @return boolean
     */
    public boolean subType (FinancingCode fc, String customerSubsegment) {

        if (customerSubsegment == null) {
    	    return true;
    	}

        return customerSubsegment.equalsIgnoreCase(fc.getSubType()) 
    	    || Constant.ASTERISK.equals(fc.getSubType());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingCode
     * @return boolean
     */
    public boolean financingElegibilityInd(FinancingCode fc) {
    	return Constant.YES.equals(fc.getFiancingElegibilityInd());
    }
    
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingCode
     * @return boolean
     */
    public boolean isNotCorporate(FinancingCode fc) {
    	return Constant.NO.equals(fc.getIsCorporate());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingCode
     * @return boolean
     */
    public boolean isCorporate(FinancingCode fc) {
    	return Constant.YES.equals(fc.getIsCorporate());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingCode
     * @return boolean
     */
    public boolean hasFWA(FinancingCode fc) {
    	return Constant.NO.equals(fc.getHasFwa());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingElegibility,List<String>
     * @return boolean
     */
    public boolean financingPlan(FinancingElegibility fe, List<String> fpcList) {
    	return fpcList.contains(fe.getFinancingPlan());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingElegibility,String
     * @return boolean
     */  
    public boolean riskLevel(FinancingElegibility fe, String creditScore) {
    	return  creditScore.equals(fe.getRiskLevel());
    }

    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingElegibility,String
     * @return boolean
     */  
    public boolean customerType(FinancingElegibility fe, String customeSegment) {
    	return fe.getCustomerType().equals(customeSegment) 
    	    || Constant.ASTERISK.equals(fe.getCustomerType());
    }
    
    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingElegibility,String
     * @return boolean
     */    
    public boolean customerSubType(FinancingElegibility fe, String customeSubsegment) {
    	return fe.getCustomeSubtype().equals(customeSubsegment) 
    	    || Constant.ASTERISK.equals(fe.getCustomeSubtype());
    }

    /**
     * Metodo que retorna true|false de acuerdo a parametro enviado.
     * 
     * @param FinancingElegibility,String
     * @return boolean
     */  
    public boolean flowName(FinancingElegibility fe, String action) {
    	return action.equals(fe.getFlowName()) || Constant.ASTERISK.equals(fe.getFlowName());
    }

}
