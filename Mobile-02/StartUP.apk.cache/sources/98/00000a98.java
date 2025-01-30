package com.coinbase;

import java.util.List;

/* loaded from: classes.dex */
public class PagedResponse<T> extends CoinbaseResponse<List<T>> {
    private Pagination pagination;

    /* loaded from: classes.dex */
    public static class Pagination {
        private String endingBefore;
        private Integer limit;
        private String nextUri;
        private PageOrder order;
        private String previousUri;
        private String startingAfter;

        public String getEndingBefore() {
            return this.endingBefore;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getNextUri() {
            return this.nextUri;
        }

        public PageOrder getOrder() {
            return this.order;
        }

        public String getPreviousUri() {
            return this.previousUri;
        }

        public String getStartingAfter() {
            return this.startingAfter;
        }

        public PaginationParams nextPage() {
            return PaginationParams.nextPage(this);
        }

        public PaginationParams previousPage() {
            return PaginationParams.previousPage(this);
        }

        public void setLimit(Integer num) {
            this.limit = num;
        }

        public void setNextUri(String str) {
            this.nextUri = str;
        }

        public void setOrder(PageOrder pageOrder) {
            this.order = pageOrder;
        }

        public void setPreviousUri(String str) {
            this.previousUri = str;
        }
    }

    public Pagination getPagination() {
        return this.pagination;
    }
}