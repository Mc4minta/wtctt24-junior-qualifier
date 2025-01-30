package com.coinbase.resources.rates;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import h.c.b0;

/* loaded from: classes.dex */
public class ExchangeRatesResource {
    private final ExchangeRatesApi exchangeRatesApi;
    private final ExchangeRatesApiRx exchangeRatesApiRx;

    public ExchangeRatesResource(ExchangeRatesApi exchangeRatesApi, ExchangeRatesApiRx exchangeRatesApiRx) {
        this.exchangeRatesApi = exchangeRatesApi;
        this.exchangeRatesApiRx = exchangeRatesApiRx;
    }

    public ApiCall<CoinbaseResponse<ExchangeRates>> getExchangeRates(String str) {
        return this.exchangeRatesApi.getExchangeRates(str);
    }

    public b0<CoinbaseResponse<ExchangeRates>> getExchangeRatesRx(String str) {
        return this.exchangeRatesApiRx.getExchangeRates(str);
    }
}