package com.coinbase.resources.time;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import h.c.b0;

/* loaded from: classes.dex */
public class TimeResource {
    private final TimeApi timeApi;
    private final TimeApiRx timeApiRx;

    public TimeResource(TimeApi timeApi, TimeApiRx timeApiRx) {
        this.timeApi = timeApi;
        this.timeApiRx = timeApiRx;
    }

    public ApiCall<CoinbaseResponse<Time>> getCurrentTime() {
        return this.timeApi.getCurrentTime();
    }

    public b0<CoinbaseResponse<Time>> getCurrentTimeRx() {
        return this.timeApiRx.getCurrentTime();
    }
}