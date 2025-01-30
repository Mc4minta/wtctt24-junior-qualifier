package com.coinbase.resources.rates;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import h.c.b0;
import retrofit2.z.f;
import retrofit2.z.t;

/* loaded from: classes.dex */
public interface ExchangeRatesApiRx {
    @f(ApiConstants.EXCHANGE_RATES)
    b0<CoinbaseResponse<ExchangeRates>> getExchangeRates(@t("currency") String str);
}