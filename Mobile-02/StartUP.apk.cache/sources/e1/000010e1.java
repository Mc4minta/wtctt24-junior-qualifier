package com.coinbase.resources.trades;

import com.coinbase.CoinbaseResponse;
import com.coinbase.PagedResponse;
import com.coinbase.network.ApiCall;
import com.coinbase.resources.trades.Trade;
import java.util.Map;
import java.util.Set;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.s;
import retrofit2.z.t;
import retrofit2.z.u;

/* loaded from: classes.dex */
public interface TradesApi<T extends Trade> {
    @o("accounts/{account_id}/{trade_type}/{trade_id}/commit")
    ApiCall<CoinbaseResponse<Trade>> commitTradeOrder(@s("account_id") String str, @s("trade_type") String str2, @s("trade_id") String str3, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/{trade_type}")
    ApiCall<PagedResponse<Trade>> listTrades(@s("account_id") String str, @s("trade_type") String str2, @u Map<String, String> map, @t("expand[]") Set<String> set);

    @o("accounts/{account_id}/{trade_type}")
    ApiCall<CoinbaseResponse<Trade>> placeTradeOrder(@s("account_id") String str, @s("trade_type") String str2, @a PlaceTradeOrderBody placeTradeOrderBody, @t("expand[]") Set<String> set);

    @f("accounts/{account_id}/{trade_type}/{trade_id}")
    ApiCall<CoinbaseResponse<Trade>> showTrade(@s("account_id") String str, @s("trade_type") String str2, @s("trade_id") String str3, @t("expand[]") Set<String> set);
}