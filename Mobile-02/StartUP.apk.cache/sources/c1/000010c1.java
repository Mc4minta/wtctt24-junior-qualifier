package com.coinbase.resources.currencies;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import h.c.b0;
import java.util.List;
import retrofit2.z.f;

/* loaded from: classes.dex */
public interface CurrenciesApiRx {
    @f(ApiConstants.CURRENCIES)
    b0<CoinbaseResponse<List<Currency>>> getSupportedCurrencies();
}