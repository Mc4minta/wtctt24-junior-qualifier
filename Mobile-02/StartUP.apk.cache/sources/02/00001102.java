package com.coinbase.resources.withdrawals;

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
public class WithdrawalsResource extends TradesResource<Withdrawal> {
    public WithdrawalsResource(TradesApi tradesApi, TradesApiRx tradesApiRx) {
        super(tradesApi, tradesApiRx, ApiConstants.WITHDRAWALS);
    }

    public ApiCall<CoinbaseResponse<Withdrawal>> commitWithdrawal(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrder(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Withdrawal>> commitWithdrawalRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return commitTradeOrderRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Withdrawal>> listWithdrawals(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, paginationParams, expandFieldArr);
    }

    public b0<PagedResponse<Withdrawal>> listWithdrawalsRx(String str, PaginationParams paginationParams, Trade.ExpandField... expandFieldArr) {
        return listTradesRx(str, paginationParams, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Withdrawal>> placeWithdrawal(String str, PlaceWithdrawalBody placeWithdrawalBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrder(str, placeWithdrawalBody, expandFieldArr);
    }

    public b0<CoinbaseResponse<Withdrawal>> placeWithdrawalRx(String str, PlaceWithdrawalBody placeWithdrawalBody, Trade.ExpandField... expandFieldArr) {
        return placeTradeOrderRx(str, placeWithdrawalBody, expandFieldArr);
    }

    public ApiCall<CoinbaseResponse<Withdrawal>> showWithdrawal(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTrade(str, str2, expandFieldArr);
    }

    public b0<CoinbaseResponse<Withdrawal>> showWithdrawalRx(String str, String str2, Trade.ExpandField... expandFieldArr) {
        return showTradeRx(str, str2, expandFieldArr);
    }

    public ApiCall<PagedResponse<Withdrawal>> listWithdrawals(String str, Trade.ExpandField... expandFieldArr) {
        return listTrades(str, null, expandFieldArr);
    }

    public b0<PagedResponse<Withdrawal>> listWithdrawalsRx(String str, Trade.ExpandField... expandFieldArr) {
        return listWithdrawalsRx(str, null, expandFieldArr);
    }
}