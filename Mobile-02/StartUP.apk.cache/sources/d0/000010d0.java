package com.coinbase.resources.prices;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import java.util.List;
import retrofit2.z.f;
import retrofit2.z.s;
import retrofit2.z.t;

/* loaded from: classes.dex */
public interface PricesApi {
    @f("prices/{base_currency}-{fiat_currency}/buy")
    ApiCall<CoinbaseResponse<Price>> getBuyPrice(@s("base_currency") String str, @s("fiat_currency") String str2);

    @f("prices/{base_currency}-{fiat_currency}/sell")
    ApiCall<CoinbaseResponse<Price>> getSellPrice(@s("base_currency") String str, @s("fiat_currency") String str2);

    @f("prices/{base_currency}-{fiat_currency}/spot")
    ApiCall<CoinbaseResponse<Price>> getSpotPrice(@s("base_currency") String str, @s("fiat_currency") String str2, @t("date") String str3);

    @f("prices/{fiat_currency}/spot")
    ApiCall<CoinbaseResponse<List<Price>>> getSpotPrices(@s("fiat_currency") String str, @t("date") String str2);
}