package com.coinbase.resources.buys;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.trades.Trade;
import com.coinbase.resources.trades.TradesApi;
import com.coinbase.resources.trades.TradesApiRx;
import com.coinbase.resources.trades.TradesResource;
import com.coinbase.resources.trades.TransferOrderBody;
import h.c.b0;

/* loaded from: classes.dex */
public class BuysResource extends TradesResource<Buy> {
    public BuysResource(TradesApi tradesApi, TradesApiRx tradesApiRx) {
        super(tradesApi, tradesApiRx, ApiConstants.BUYS);
    }

    public ApiCall<CoinbaseResponse<Buy>> commitBuyOrder(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrder(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Buy>> commitBuyOrderRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrderRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Buy>> listBuys(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, paginationParams, expandFieldArr);
    }

    public b0<PagedResponse<Buy>> listBuysRx(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, paginationParams, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Buy>> placeBuyOrder(String str, TransferOrderBody transferOrderBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrder(str, transferOrderBody, expandFieldArr);
    }

    public b0<CoinbaseResponse<Buy>> placeBuyOrderRx(String str, TransferOrderBody transferOrderBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrderRx(str, transferOrderBody, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Buy>> showBuy(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTrade(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Buy>> showBuyRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTradeRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Buy>> listBuys(String str, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, expandFieldArr);
    }

    public b0<PagedResponse<Buy>> listBuysRx(String str, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, expandFieldArr);
    }
}