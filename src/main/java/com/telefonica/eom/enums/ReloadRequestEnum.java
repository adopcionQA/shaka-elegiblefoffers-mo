package com.telefonica.eom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum ReloadRequestEnum {
    REQUEST("15", "mobile", "R", "CC", "OFFER", 1, 1, 1, "NAME", Boolean.TRUE, Boolean.FALSE, "elegibles", "50000579", "1221181", "Postpaid", "3201", new BigDecimal(250), "05537001", "05537", 5, "PR");

    private String region;
    private String productType;
    private String customerSegment;
    private String channelId;
    private String sourceType;
    private int paginationInfoPageCount;
    private int paginationInfoPage;
    private int paginationInfoMaxResultCount;
    private String sortCriteriaName;
    private boolean sortCriteriaAscending;
    private boolean isPortability;
    private String type;
    private String customerId;
    private String categoryId;
    private String product;
    private String creditScore;
    //private int creditScore;
    private BigDecimal creditLimit;
    private String siteId;
    private String dealerId;
    private int paginationInfoSize;
    private String action;
}
