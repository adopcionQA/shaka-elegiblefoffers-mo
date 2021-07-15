package com.telefonica.eom.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: MobileElegibleOffersRequest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Pojo del objeto MobileElegibleOffersRequest.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileElegibleOffersRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String     type;
    private String     correlationId;
    private String     name;
    private Boolean    isBundle;
    private String     lifeCycleStatus;
    private String     categoryId;
    private String     categoryName;
    private String     subcategoryId;
    private String     subcategoryName;
    private String     channelId;
    private String     channelName;
    private String     productSpecificationId;
    private String     productSpecificationName;
    private String     frameworkAgreeementId;
    private String     customerId;
    private String     accountId;
    private String     productType;
    private String     productId;
    private String     productPublicId;
    private DateTime   startDate;
    private DateTime   endDate;
    private String     limit;
    private String     offset;
    private String     productOfferingPricePriceUnits;
    private DateTime   productOfferingPriceCurrencyChangeDate;
    private DateTime   productOfferingPriceStartPriceDate;
    private DateTime   productOfferingPriceEndPriceDate;
    private String     productOfferingPricePriceConsumerEntityType;
    private String     productOfferingPricePriceConsumerId;
    private String     productOfferingPricePriceLocation;
    private BigDecimal productOfferingPriceStartPriceAmout;
    private BigDecimal productOfferingPriceEndPriceAmout;
    private String     fields;
    private String     creditScore;
    private BigDecimal creditLimit;
    private String     siteId;
    private String     region;
    private String     stateOrProvince;
    private String     customerSegment;
    private String     customerSubsegment;
    private Boolean    isPortability;
    private String     portabilityCurrentPlanType;
    private String     portabilityCustomerSince;
    private String     portabilityCurrentCompany;
    private String     dealerId;
    private Integer    broadbandMinDlDataRate;
    private Integer    broadbandMaxDlDataRate;
    private String     broadbandConnection;
    private Boolean    isRetention;
    private String     productOfferingCatalogId;
    private String     currentOffering;
    private Boolean    isUpgrade;
    private String     action;
    private String     commercialAreaId;
    private String     productOrderId;
    private String     planId;
    private String     product;
    private String     sourceType;
    private String     networkTechnology;
    private String     currentNetworkTechnology;
    private String     serviceabilityMaxSpeed;
    private String     serviceabilityId;
    private String     planGroup;
    private String     planRankInitial;
    private String     planRank;
    private String     planCommitmentDuration;
    private String     invoiceCompany;
    private String     orderSubType;
    private String     subscriberGroupValue;
    private String     excludeOffersId;
    private String     installationAddressDepartment;
    private String     nationalID;
    private String     nationalIDType;
    private String     typeRent;
    private Integer    paginationInfoSize;
    private Integer    paginationInfoPageCount;
    private Integer    paginationInfoPage;
    private Integer    paginationInfoMaxResultCount;
    private String     sortCriteriaName;
    private Boolean    sortCriteriaAscending;
    private String     currentOfferingCatalogId;
    private String     ubigeo;
    private String     currentBillingOfferCatalogId;

}
