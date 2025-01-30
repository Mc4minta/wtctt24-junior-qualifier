package com.coinbase.resources.trades;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.resources.trades.Trade;
import h.c.b0;
import java.util.Map;
import java.util.Set;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.s;
import retrofit2.z.t;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface TradesApiRx<T extends Trade> {
    @o("accounts/{account_id}/{trade_type}/{trade_id}/commit")
    b0<CoinbaseResponse<Trade>> commitTradeOrderRx(@s("account_id") String str, @s("trade_type") String str2, @s("trade_id") String str3, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/{trade_type}")
    b0<PagedResponse<Trade>> listTradesRx(@s("account_id") String str, @s("trade_type") String str2, @u Map<String, String> map, @t("expand[]") Set<String> set);

    @o("accounts/{account_id}/{trade_type}")
    b0<CoinbaseResponse<Trade>> placeTradeOrderRx(@s("account_id") String str, @s("trade_type") String str2, @a PlaceTradeOrderBody placeTradeOrderBody, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/{trade_type}/{trade_id}")
    b0<CoinbaseResponse<Trade>> showTradeRx(@s("account_id") String str, @s("trade_type") String str2, @s("trade_id") String str3, @t("expand[]") Set<String> set);
}