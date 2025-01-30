package com.coinbase.resources.deposits;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.trades.Trade;
import com.coinbase.resources.trades.TradesApi;
import com.coinbase.resources.trades.TradesApiRx;
import com.coinbase.resources.trades.TradesResource;
import h.c.b0;

/* loaded from: classes.dex */
public class DepositsResource extends TradesResource<Deposit> {
    public DepositsResource(TradesApi tradesApi, TradesApiRx tradesApiRx) {
        super(tradesApi, tradesApiRx, ApiConstants.DEPOSITS);
    }

    public ApiCall<CoinbaseResponse<Deposit>> commitDeposit(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrder(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Deposit>> commitDepositRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrderRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Deposit>> listDeposits(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, paginationParams, expandFieldArr);
    }

    public b0<PagedResponse<Deposit>> listDepositsRx(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, paginationParams, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Deposit>> placeDeposit(String str, PlaceDepositBody placeDepositBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrder(str, placeDepositBody, expandFieldArr);
    }

    public b0<CoinbaseResponse<Deposit>> placeDepositRx(String str, PlaceDepositBody placeDepositBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrderRx(str, placeDepositBody, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Deposit>> showDeposit(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTrade(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Deposit>> showDepositRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTradeRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Deposit>> listDeposits(String str, Trade.ExpandField... expandFieldArr) {
        return listDeposits(str, null, expandFieldArr);
    }

    public b0<PagedResponse<Deposit>> listDepositsRx(String str, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, null, expandFieldArr);
    }
}