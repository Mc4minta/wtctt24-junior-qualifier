package com.coinbase.resources.currencies;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import java.util.List;
import retrofit2.z.f;

/* loaded from: classes.dex */
public interface CurrenciesApi {
    @f(ApiConstants.CURRENCIES)
    ApiCall<CoinbaseResponse<List<Currency>>> getSupportedCurrencies();
}