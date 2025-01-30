package com.coinbase;

import android.net.Uri;
import com.coinbase.PagedResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PaginationParams {
    static final String ENDING_BEFORE_KEY = "ending_before";
    static final String LIMIT_KEY = "limit";
    static final String ORDER_KEY = "order";
    static final String STARTING_AFTER_KEY = "starting_after";
    private String endingBefore;
    private int limit;
    private PageOrder order;
    private String startingAfter;

    private static PaginationParams copyLimitAndOrder(PaginationParams paginationParams, PagedResponse.Pagination pagination) {
        paginationParams.limit = pagination.getLimit().intValue();
        paginationParams.order = pagination.getOrder();
        return paginationParams;
    }

    public static PaginationParams fromEndingBefore(String str) {
        PaginationParams paginationParams = new PaginationParams();
        paginationParams.endingBefore = str;
        return paginationParams;
    }

    public static PaginationParams fromStartingAfter(String str) {
        PaginationParams paginationParams = new PaginationParams();
        paginationParams.startingAfter = str;
        return paginationParams;
    }

    private static String getQueryParameter(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (queryParameter == null || queryParameter.isEmpty()) {
            throw new IllegalArgumentException("No value provided for a " + str2 + " key");
        }
        return queryParameter;
    }

    public static PaginationParams nextPage(PagedResponse.Pagination pagination) throws IllegalArgumentException {
        if (pagination.getNextUri() == null) {
            return null;
        }
        try {
            return copyLimitAndOrder(fromStartingAfter(getQueryParameter(pagination.getNextUri(), "starting_after")), pagination);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Malformed url", e2);
        }
    }

    public static PaginationParams previousPage(PagedResponse.Pagination pagination) throws IllegalArgumentException {
        if (pagination.getPreviousUri() == null) {
            return null;
        }
        try {
            return copyLimitAndOrder(fromEndingBefore(getQueryParameter(pagination.getPreviousUri(), ENDING_BEFORE_KEY)), pagination);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Malformed url", e2);
        }
    }

    public String getEndingBefore() {
        return this.endingBefore;
    }

    public int getLimit() {
        return this.limit;
    }

    public PageOrder getOrder() {
        return this.order;
    }

    public String getStartingAfter() {
        return this.startingAfter;
    }

    public void setEndingBefore(String str) {
        this.endingBefore = str;
    }

    public void setLimit(int i2) {
        this.limit = i2;
    }

    public void setOrder(PageOrder pageOrder) {
        this.order = pageOrder;
    }

    public void setStartingAfter(String str) {
        this.startingAfter = str;
    }

    public Map<String, String> toQueryMap() {
        HashMap hashMap = new HashMap();
        int i2 = this.limit;
        if (i2 != 0) {
            hashMap.put(LIMIT_KEY, String.valueOf(i2));
        }
        PageOrder pageOrder = this.order;
        if (pageOrder != null) {
            hashMap.put(ORDER_KEY, pageOrder.getValue());
        }
        String str = this.startingAfter;
        if (str != null) {
            hashMap.put("starting_after", str);
        }
        String str2 = this.endingBefore;
        if (str2 != null) {
            hashMap.put(ENDING_BEFORE_KEY, str2);
        }
        return hashMap;
    }
}