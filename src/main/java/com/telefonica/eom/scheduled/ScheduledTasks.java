package com.telefonica.eom.scheduled;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.telefonica.eom.enums.ReloadRequestEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.service.MobileElegibleOffersService;

/**
 * @Author: Jose Linares.
 * @Datecreation: 19 feb. 2020 15:00:00
 * @FileName: ScheduledTasks.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Componente de tarea programada para borrar caché.
 */

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private CacheManager manager;

    @Autowired
    MobileElegibleOffersService mobileElegibleOffersService;

    @Scheduled(cron = "0 0 7 * * *")
    public void reportCurrentTime() {
        for (String cacheName : manager.getCacheNames()) {
            clearCacheFromCacheName(cacheName);
        }
        log.info("Se borró la caché, fecha: " + dateFormat.format(new Date()));
        reloadCache();
    }

    private Boolean clearCacheFromCacheName(final String cacheName) {
        final Cache cache = manager.getCache(cacheName);
        if (cache != null) {
            cache.clear();
            return true;
        }
        return false;
    }

    private void reloadCache() {
        MobileElegibleOffersRequest request = MobileElegibleOffersRequest.builder()
                .region(ReloadRequestEnum.REQUEST.getRegion())
                .productType(ReloadRequestEnum.REQUEST.getProductType())
                .customerSegment(ReloadRequestEnum.REQUEST.getCustomerSegment())
                .channelId(ReloadRequestEnum.REQUEST.getChannelId())
                .sourceType(ReloadRequestEnum.REQUEST.getSourceType())
                .paginationInfoPageCount(ReloadRequestEnum.REQUEST.getPaginationInfoPageCount())
                .paginationInfoPage(ReloadRequestEnum.REQUEST.getPaginationInfoPage())
                .paginationInfoMaxResultCount(ReloadRequestEnum.REQUEST.getPaginationInfoMaxResultCount())
                .sortCriteriaName(ReloadRequestEnum.REQUEST.getSortCriteriaName())
                .sortCriteriaAscending(ReloadRequestEnum.REQUEST.isSortCriteriaAscending())
                .isPortability(ReloadRequestEnum.REQUEST.isPortability())
                .type(ReloadRequestEnum.REQUEST.getType())
                .customerId(ReloadRequestEnum.REQUEST.getCustomerId())
                .categoryId(ReloadRequestEnum.REQUEST.getCategoryId())
                .product(ReloadRequestEnum.REQUEST.getProduct())
                .creditScore(ReloadRequestEnum.REQUEST.getCreditScore())
                .creditLimit(ReloadRequestEnum.REQUEST.getCreditLimit())
                .siteId(ReloadRequestEnum.REQUEST.getSiteId())
                .dealerId(ReloadRequestEnum.REQUEST.getDealerId())
                .paginationInfoSize(ReloadRequestEnum.REQUEST.getPaginationInfoSize())
                .action(ReloadRequestEnum.REQUEST.getAction())
                .build();

        try {
            mobileElegibleOffersService.getOffers(request);
        } catch (Exception e) {
            log.error(this.getClass().getSimpleName(), e);
        }

    }
}
