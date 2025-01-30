package com.coinbase.resources.trades;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.ExpandUtils;
import com.coinbase.resources.trades.Trade;
import h.c.b0;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class TradesResource<T extends Trade> {
    private final String tradeType;
    private final TradesApi tradesApi;
    private final TradesApiRx tradesApiRx;

    public TradesResource(TradesApi tradesApi, TradesApiRx tradesApiRx, String str) {
        this.tradesApi = tradesApi;
        this.tradesApiRx = tradesApiRx;
        this.tradeType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiCall<CoinbaseResponse<T>> commitTradeOrder(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return (ApiCall<CoinbaseResponse<T>>) this.tradesApi.commitTradeOrder(str, this.tradeType, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0<CoinbaseResponse<T>> commitTradeOrderRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return (b0<CoinbaseResponse<T>>) this.tradesApiRx.commitTradeOrderRx(str, this.tradeType, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiCall<PagedResponse<T>> listTrades(String str, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, null, expandFieldArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0<PagedResponse<T>> listTradesRx(String str, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, null, expandFieldArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiCall<CoinbaseResponse<T>> placeTradeOrder(String str, PlaceTradeOrderBody placeTradeOrderBody, Trade.ExpandField... expandFieldArr) {
        return (ApiCall<CoinbaseResponse<T>>) this.tradesApi.placeTradeOrder(str, this.tradeType, placeTradeOrderBody, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0<CoinbaseResponse<T>> placeTradeOrderRx(String str, PlaceTradeOrderBody placeTradeOrderBody, Trade.ExpandField... expandFieldArr) {
        return (b0<CoinbaseResponse<T>>) this.tradesApiRx.placeTradeOrderRx(str, this.tradeType, placeTradeOrderBody, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiCall<CoinbaseResponse<T>> showTrade(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return (ApiCall<CoinbaseResponse<T>>) this.tradesApi.showTrade(str, this.tradeType, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0<CoinbaseResponse<T>> showTradeRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return (b0<CoinbaseResponse<T>>) this.tradesApiRx.showTradeRx(str, this.tradeType, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiCall<PagedResponse<T>> listTrades(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return (ApiCall<PagedResponse<T>>) this.tradesApi.listTrades(str, this.tradeType, paginationParams != null ? paginationParams.toQueryMap() : Collections.emptyMap(), ExpandUtils.toValueSet(expandFieldArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0<PagedResponse<T>> listTradesRx(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return (b0<PagedResponse<T>>) this.tradesApiRx.listTradesRx(str, this.tradeType, paginationParams != null ? paginationParams.toQueryMap() : Collections.emptyMap(), ExpandUtils.toValueSet(expandFieldArr));
    }
}