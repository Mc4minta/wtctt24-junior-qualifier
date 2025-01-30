package com.coinbase.resources.sells;

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
public class SellsResource extends TradesResource<Sell> {
    public SellsResource(TradesApi tradesApi, TradesApiRx tradesApiRx) {
        super(tradesApi, tradesApiRx, ApiConstants.SELLS);
    }

    public ApiCall<CoinbaseResponse<Sell>> commitSellOrder(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrder(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Sell>> commitSellOrderRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrderRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Sell>> listSells(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, paginationParams, expandFieldArr);
    }

    public b0<PagedResponse<Sell>> listSellsRx(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, paginationParams, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Sell>> placeSellOrder(String str, TransferOrderBody transferOrderBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrder(str, transferOrderBody, expandFieldArr);
    }

    public b0<CoinbaseResponse<Sell>> placeSellOrderRx(String str, TransferOrderBody transferOrderBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrderRx(str, transferOrderBody, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Sell>> showSell(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTrade(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Sell>> showSellRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTradeRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Sell>> listSells(String str, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, expandFieldArr);
    }

    public b0<PagedResponse<Sell>> listSellsRx(String str, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, expandFieldArr);
    }
}