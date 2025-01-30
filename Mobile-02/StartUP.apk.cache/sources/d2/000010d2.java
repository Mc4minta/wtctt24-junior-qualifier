package com.coinbase.resources.prices;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import h.c.b0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class PricesResource {
    private final SimpleDateFormat dayDateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private final PricesApi pricesApi;
    private final PricesApiRx pricesApiRx;

    public PricesResource(PricesApi pricesApi, PricesApiRx pricesApiRx) {
        this.pricesApi = pricesApi;
        this.pricesApiRx = pricesApiRx;
    }

    public ApiCall<CoinbaseResponse<Price>> getBuyPrice(String str, String str2) {
        return this.pricesApi.getBuyPrice(str, str2);
    }

    public b0<CoinbaseResponse<Price>> getBuyPriceRx(String str, String str2) {
        return this.pricesApiRx.getBuyPrice(str, str2);
    }

    public ApiCall<CoinbaseResponse<Price>> getSellPrice(String str, String str2) {
        return this.pricesApi.getSellPrice(str, str2);
    }

    public b0<CoinbaseResponse<Price>> getSellPriceRx(String str, String str2) {
        return this.pricesApiRx.getSellPrice(str, str2);
    }

    public ApiCall<CoinbaseResponse<Price>> getSpotPrice(String str, String str2, Date date) {
        return this.pricesApi.getSpotPrice(str, str2, date != null ? this.dayDateFormatter.format(date) : null);
    }

    public b0<CoinbaseResponse<Price>> getSpotPriceRx(String str, String str2, Date date) {
        return this.pricesApiRx.getSpotPrice(str, str2, date != null ? this.dayDateFormatter.format(date) : null);
    }

    public ApiCall<CoinbaseResponse<List<Price>>> getSpotPrices(String str, Date date) {
        return this.pricesApi.getSpotPrices(str, date != null ? this.dayDateFormatter.format(date) : null);
    }

    public b0<CoinbaseResponse<List<Price>>> getSpotPricesRx(String str, Date date) {
        return this.pricesApiRx.getSpotPrices(str, date != null ? this.dayDateFormatter.format(date) : null);
    }

    public ApiCall<CoinbaseResponse<Price>> getSpotPrice(String str, String str2) {
        return this.pricesApi.getSpotPrice(str, str2, null);
    }

    public b0<CoinbaseResponse<Price>> getSpotPriceRx(String str, String str2) {
        return this.pricesApiRx.getSpotPrice(str, str2, null);
    }

    public ApiCall<CoinbaseResponse<List<Price>>> getSpotPrices(String str) {
        return this.pricesApi.getSpotPrices(str, null);
    }

    public b0<CoinbaseResponse<List<Price>>> getSpotPricesRx(String str) {
        return this.pricesApiRx.getSpotPrices(str, null);
    }
}