package com.coinbase.resources.transactions;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.PaginationParams;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.ExpandUtils;
import com.coinbase.resources.transactions.Transaction;
import h.c.b0;

/* loaded from: classes.dex */
public class TransactionsResource {
    private final TransactionsApi transactionsApi;
    private final TransactionsApiRx transactionsApiRx;

    public TransactionsResource(TransactionsApi transactionsApi, TransactionsApiRx transactionsApiRx) {
        this.transactionsApi = transactionsApi;
        this.transactionsApiRx = transactionsApiRx;
    }

    public ApiCall<CoinbaseResponse<Void>> cancelMoneyRequest(String str, String str2) {
        return this.transactionsApi.cancelMoneyRequest(str, str2);
    }

    public b0<CoinbaseResponse<Void>> cancelMoneyRequestRx(String str, String str2) {
        return this.transactionsApiRx.cancelMoneyRequest(str, str2);
    }

    public ApiCall<CoinbaseResponse<Transaction>> completeMoneyRequest(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.completeMoneyRequest(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<Transaction>> completeMoneyRequestRx(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.completeMoneyRequest(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<PagedResponse<Transaction>> listTransactions(String str, PaginationParams paginationParams, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.listTransactions(str, ExpandUtils.toValueSet(expandFieldArr), paginationParams.toQueryMap());
    }

    public b0<PagedResponse<Transaction>> listTransactionsRx(String str, PaginationParams paginationParams, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.listTransactions(str, ExpandUtils.toValueSet(expandFieldArr), paginationParams.toQueryMap());
    }

    public ApiCall<CoinbaseResponse<Transaction>> requestMoney(String str, MoneyRequest moneyRequest, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.requestMoney(str, moneyRequest, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<Transaction>> requestMoneyRx(String str, MoneyRequest moneyRequest, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.requestMoney(str, moneyRequest, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<CoinbaseResponse<Transaction>> resendMoneyRequest(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.resendMoneyRequest(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<Transaction>> resendMoneyRequestRx(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.resendMoneyRequest(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<CoinbaseResponse<Transaction>> sendMoney(String str, String str2, SendMoneyRequest sendMoneyRequest, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.sendMoney(str, str2, sendMoneyRequest, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<Transaction>> sendMoneyRx(String str, String str2, SendMoneyRequest sendMoneyRequest, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.sendMoney(str, str2, sendMoneyRequest, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<CoinbaseResponse<Transaction>> showTransaction(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.showTransaction(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<CoinbaseResponse<Transaction>> showTransactionRx(String str, String str2, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.showTransaction(str, str2, ExpandUtils.toValueSet(expandFieldArr));
    }

    public ApiCall<PagedResponse<Transaction>> listTransactions(String str, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApi.listTransactions(str, ExpandUtils.toValueSet(expandFieldArr));
    }

    public b0<PagedResponse<Transaction>> listTransactionsRx(String str, Transaction.ExpandField... expandFieldArr) {
        return this.transactionsApiRx.listTransactions(str, ExpandUtils.toValueSet(expandFieldArr));
    }
}