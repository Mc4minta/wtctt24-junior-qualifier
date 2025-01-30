package com.coinbase.resources.prices;

import com.coinbase.CoinbaseResponse;
import h.c.b0;
import java.util.List;
import retrofit2.z.f;
import retrofit2.z.s;
import retrofit2.z.t;

/* loaded from: classes.dex */
public interface PricesApiRx {
    @f("prices/{base_currency}-{fiat_currency}/buy")
    b0<CoinbaseResponse<Price>> getBuyPrice(@s("base_currency") String str, @s("fiat_currency") String str2);

    @f("prices/{base_currency}-{fiat_currency}/sell")
    b0<CoinbaseResponse<Price>> getSellPrice(@s("base_currency") String str, @s("fiat_currency") String str2);

    @f("prices/{base_currency}-{fiat_currency}/spot")
    b0<CoinbaseResponse<Price>> getSpotPrice(@s("base_currency") String str, @s("fiat_currency") String str2, @t("date") String str3);

    @f("prices/{fiat_currency}/spot")
    b0<CoinbaseResponse<List<Price>>> getSpotPrices(@s("fiat_currency") String str, @t("date") String str2);
}