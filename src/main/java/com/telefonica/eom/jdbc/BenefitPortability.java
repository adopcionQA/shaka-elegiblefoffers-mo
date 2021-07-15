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

import com.telefonica.eom.entity.RelationsMaster;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

@Service
public class BenefitPortability {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    String password;

    /**
     * Metodo que retorna una coleccion de instancias de la clase 'RelationsMaster'.
     * 
     * @param meor
     *            instancia de la clase.
     * @param lstComponentId
     *            coleccion con los componentes a consultar.
     * 
     * @return coleccion de instancias
     */
    public List<RelationsMaster> getRelations(MobileElegibleOffersRequest meor, String catalogItemID) {

	List<RelationsMaster> lstRas = new ArrayList<>();

	try (Connection cn = DriverManager.getConnection(url, user, password); PreparedStatement ps = cn.prepareStatement(getSql())) {

	    int i = 1;

	    ps.setString(i++, meor.getChannelId());
	    ps.setString(i++, meor.getDealerId());
	    ps.setString(i++, meor.getSiteId());
	    ps.setString(i++, meor.getNationalIDType());
	    ps.setString(i++, meor.getNationalID());
	    ps.setString(i++, catalogItemID);

	    try (ResultSet rs = ps.executeQuery();) {
		while (rs.next()) {

		    lstRas.add(new RelationsMaster(rs.getInt("ID_TAB_RELATIONS_MASTER"), rs.getString("RELATION_ID"),
			    rs.getString("PARENT_ID"), rs.getString("IS_MANDATORY"), rs.getString("NAME_PARENT"), rs.getString("CHILD_ID"),
			    rs.getString("CHILD_ID")));
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return lstRas;
    }

    private String getSql() {

	StringBuilder sql = new StringBuilder()
		.append("SELECT ID_TAB_RELATIONS_MASTER,RELATION_ID,LAST_VERSION_RELATION,PARENT_ID,NAME_PARENT,PARENTE_IS ")
		.append(",LAST_VERSION_PARENT ,CHILD_ID,NAME_CHILD,CHILD_IS,LAST_VERSION_CHILD,IS_MANDATORY,MINIMUM_QUANTITY,DEFAULT_QUANTITY ")
		.append(",MAXIMUM_QUANTITY, IS_DELETED,ROOT_CID,CREATION_USER,CREATION_DATE,CREATION_IP,MODIFICATION_USER,MODIFICATION_DATE,MODIFICATION_IP ")
		.append("FROM  relations_master WHERE child_id  IN  ")
		.append("(select ID_BILLING_OFF from (SELECT ID_BILLING_OFF FROM VW_PROM_PORTA_OL WHERE CAN_AMDOC IN ('*',?) AND COD_ENT_VENT IN ('*' ,?)  ")
		.append("AND COD_POINT_VEN IN ('*',?) AND TIP_DOC = ?  AND  NUM_DOC = ? AND TO_TIMESTAMP(FEC_FIN_CAM ,'DD-MM-YY')>=  TRUNC(SYSDATE)   order by fec_fin_cam desc) where   ROWNUM ='1'  )  ")
		.append("AND parent_id ='6821'    AND root_cid =?  ") ;
	return sql.toString();
    }

    public String getRelationId(String catalogItemID) {

	String relationId = null;
	try (Connection cn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = cn.prepareStatement(getRelationIdSql())) {

	    ps.setString(1, catalogItemID);

	    try (ResultSet rs = ps.executeQuery();) {
		while (rs.next()) {
		    relationId = rs.getString("RELATION_ID");

		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return relationId;

    }

    private String getRelationIdSql() {

	StringBuilder sql = new StringBuilder().append("SELECT * FROM RELATIONS_MASTER ").append("WHERE CHILD_ID ='6821' ")
		.append("AND ROOT_CID  IN ( ").append("SELECT CID_CHILD FROM RELATION_ROOT_CID ").append("WHERE ROOT_CID =?) ");

	return sql.toString();
    }

}
