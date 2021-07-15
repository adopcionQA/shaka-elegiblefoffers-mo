package com.telefonica.eom.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: RelationsAdditionalServices.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Pojo del objeto RelationsAdditionalServices.
 */
@Data
@AllArgsConstructor
public class RelationsAdditionalServices  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String cidBo;
    private String nameBo;
    private String captionBo;
    private String parentId;
    private String minumumQuantity;
    private String maximumQuantity;
    private String defaultQuantity;
    private String propertyValue;
    private String valueAbp;
    private String revenueType;
    private String relationId;
    private String idComponente;
    private String nameParent;
}
