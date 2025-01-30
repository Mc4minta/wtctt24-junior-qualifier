package com.coinbase.resources.currencies;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import h.c.b0;
import java.util.List;

/* loaded from: classes.dex */
public class CurrenciesResource {
    private final CurrenciesApi currenciesApi;
    private final CurrenciesApiRx currenciesApiRx;

    public CurrenciesResource(CurrenciesApi currenciesApi, CurrenciesApiRx currenciesApiRx) {
        this.currenciesApi = currenciesApi;
        this.currenciesApiRx = currenciesApiRx;
    }

    public ApiCall<CoinbaseResponse<List<Currency>>> getSupportedCurrencies() {
        return this.currenciesApi.getSupportedCurrencies();
    }

    public b0<CoinbaseResponse<List<Currency>>> getSupportedCurrenciesRx() {
        return this.currenciesApiRx.getSupportedCurrencies();
    }
}