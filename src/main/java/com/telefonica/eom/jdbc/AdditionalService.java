package com.telefonica.eom.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.pojo.RelationsAdditionalServices;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: AdditionalService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que contiene los metodos necesarios para obtener
 *               la conexion JDBC y lista de RelationsAdditionalServices.
 */
@Service
public class AdditionalService {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	String password;

	/**
	 * Metodo que retorna una coleccion de instancias de la clase
	 * 'RelationsAdditionalServices'.
	 * 
	 * @param meor
	 *            instancia de la clase.
	 * @param lstComponentId
	 *            coleccion con los componentes a consultar.
	 * 
	 * @return coleccion de instancias
	 */
	public List<RelationsAdditionalServices> getRelations(MobileElegibleOffersRequest meor,
			List<String> lstComponentId) {

		List<RelationsAdditionalServices> lstRas = new ArrayList<>();

		try (Connection cn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = cn.prepareStatement(getSql(lstComponentId.size()));) {

			int i = 1;

			ps.setString(i++, meor.getProductOfferingCatalogId());
			ps.setString(i++, meor.getRegion());
			ps.setString(i++, meor.getDealerId());
			ps.setString(i++, meor.getSiteId());

			for (String componentId : lstComponentId)
				ps.setString(i++, componentId);

			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					lstRas.add(new RelationsAdditionalServices(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lstRas;
	}

	/**
	 * Metodo para generar la consulta sql.
	 * 
	 * @param componentsQty
	 *            cantidad de componentes a consultar.
	 * 
	 * @return cadena con la consulta sql.
	 */
	private String getSql(int componentsQty) {

		StringBuilder bindsString = new StringBuilder();

		for (int i = 0; i < componentsQty; i++) {
			if (i > 0)
				bindsString.append(Constant.COMMA);

			bindsString.append(Constant.INTERROGACION);
		}

		StringBuilder sql = new StringBuilder()
		.append("SELECT BOM.CID_BO, BOM.NAME_BO, BOM.CAPTION_BO, RM.PARENT_ID, RM.MINIMUM_QUANTITY, ")
		.append("RM.MAXIMUM_QUANTITY, RM.DEFAULT_QUANTITY, PIBO.PROPERTY_VALUE, PP.VALUE_ABP, ")
		.append("PP.REVENUE_TYPE, RM.RELATION_ID, SVA.IDCOMPONENTE, RM.NAME_PARENT, RM.ROOT_CID ")
		.append("FROM RE_DATA.RELATIONS_MASTER RM ")
		.append("INNER JOIN RE_DATA.BILLING_OFFER_MASTER BOM ON RM.CHILD_ID = BOM.CID_BO ")
		.append("INNER JOIN RE_DATA.PROPERTY_IN_BILLING_OFFER PIBO ON RM.CHILD_ID = PIBO.CID_BO ")
		.append("INNER JOIN RE_DATA.OFFER_FILTER_BO OFBO ON BOM.CAPTION_BO = OFBO.BILLING_OFFER_CODE ")
		.append("INNER JOIN RE_DATA.PRICE_PROPERTIES PP ON BOM.CID_BO = PP.BILLING_OFFER_CID ")
		.append("INNER JOIN RE_DATA.SVAOFFERING SVA ON RM.PARENT_ID = SVA.IDCOMPONENTE ")
		.append("WHERE RM.ROOT_CID = ? ").append("AND RM.CHILD_IS = 'PP' ")
		.append("AND RM.DEFAULT_QUANTITY = 0 ").append("AND RM.MINIMUM_QUANTITY = 0 ")
		.append("AND RM.MAXIMUM_QUANTITY > 0 ")
		.append("AND PIBO.PROPERTY_NAME = 'Salesenddate' ")
		.append("AND OFBO.DEPARTMENT IN (?, '*') ")
		.append("AND OFBO.DEALER_CODE IN (?, '*') ")
		.append("AND OFBO.STORE_ID IN (?, '*') ").append("AND RM.PARENT_ID IN (")
		.append(bindsString).append(") ")
		.append("AND OFBO.VALIDITY_START_DATE <= CURRENT_DATE ")
		.append("AND OFBO.VALIDITY_END_DATE >= CURRENT_DATE ")
		.append("AND PP.NAME_PROP_ABP = 'Rate' ").append("ORDER BY SVA.IDCOMPONENTE ASC");

		return sql.toString();
	}

}
