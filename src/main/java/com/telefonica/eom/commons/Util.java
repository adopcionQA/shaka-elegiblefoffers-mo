package com.telefonica.eom.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.telefonica.eom.generated.offers.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceTypeProdAltType;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: Util.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Representa las metodos utilitarios necesarios en el flujo MOVIL. 
* 
*/
public class Util {

    private Util() {}

    /**
     * Metodo que retorna true|false de acuerdo a condicion.
     * 
     * @param boolean
     * @return String
     */
    public static String fromBoolToYN(boolean cond) {
        return cond ? Constant.YES : Constant.NO;
    }

    /**
     * Metodo que convierte una cadena string a fecha de acuerdo a filtro.
     * 
     * @param String
     * @return LocalDate
     */
    public static LocalDate parseDate(String dateString) {

        LocalDate localDAte = null;

        if (dateString.contains("T")) {
            localDAte = LocalDate.parse(Arrays.asList(dateString.split("T")).get(0));
        }

        return localDAte;
    }

    /**
     * método que separa una cadena en base a un divisor "," ,":" , etc..
     * 
     * @param data
     *            : cadena a ser dividida
     * @param separator
     *            : divisores
     * @return lista de cadena dividida ;
     */
    public static List<String> getListSplit(String data, String separator) {
        return Arrays.asList(data.split(separator));
    }

    /**
     * Método que devuelve la fecha actual en formato gregoriano.
     * 
     * @return Fecha actual en formato gregoriano.
     */
    public static GregorianCalendar getGCalendar() {

        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(new Date());

        return gCalendar;
    }

    /**
     * Metodo que retorna los meses entre dos fechas.
     * 
     * @param LocalDate
     * @return Long
     */
    public static Long getMonthsPeriod(LocalDate localDate) {
        return ChronoUnit.MONTHS.between(localDate, LocalDate.now());
    }

    /**
     * Metodo que retorna los dias entre dos fechas.
     * 
     * @param XMLGregorianCalendar
     * @return Long
     */
    public static Long getDaysPeriod(XMLGregorianCalendar xmlGC) {

        LocalDate localDatenow = LocalDate.now();
        LocalDate localDate = LocalDate.of(xmlGC.getYear(), xmlGC.getMonth(), xmlGC.getDay());

        if (localDate.compareTo(localDatenow) >= 0) {
            return (long) 0;
        }

        return ChronoUnit.DAYS.between(localDate, localDatenow);
    }

    /**
     * Metodo que retorna PriceTypeEnum|null de acuerdo a filtros..
     * 
     * @param PriceTypeProdAltType
     * @return PriceTypeEnum
     */
    public static PriceTypeEnum enumEquivalence(PriceTypeProdAltType ptpatEnum) {

        for (PriceTypeEnum b : PriceTypeEnum.values()) {
            if (b.toString().substring(0, 5).equals(ptpatEnum.value().substring(0, 5))) {
                return b;
            }
        }

        return null;
    }

    private static final BigDecimal IGV = BigDecimal.valueOf(1 + Constant.IGV);

    /**
     * Metodo que retorna el monto enviado mas IGV
     * 
     * @param BigDecimal
     * @return BigDecimal
     */
    public static BigDecimal igvCalculator(BigDecimal amount) {
        return amount.multiply(IGV).setScale(2, RoundingMode.HALF_UP);
    }

    public static String getTracking() {
        return Thread.currentThread().getName();
    }

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(Constant.DATE_TIME);

    /**
     * Método de formato de fecha y hora utilizado en la clase LoggingAspect.
     * 
     * @return date
     */
    public static String getDateTimeFormatter() {
        return DATETIME_FORMATTER.format(LocalDateTime.now());
    }
    
    public static String getDateFormat(Date date, String exp) {
	SimpleDateFormat sdf = new SimpleDateFormat(exp);
	return sdf.format(date);
    }
    
    public static String getTempDir() {
	return System.getProperty("java.io.tmpdir");
    }
}
