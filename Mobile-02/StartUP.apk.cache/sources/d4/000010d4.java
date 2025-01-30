package com.coinbase.resources.rates;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import retrofit2.z.f;
import retrofit2.z.t;

/* loaded from: classes.dex */
public interface ExchangeRatesApi {
    @f(ApiConstants.EXCHANGE_RATES)
    ApiCall<CoinbaseResponse<ExchangeRates>> getExchangeRates(@t("currency") String str);
}