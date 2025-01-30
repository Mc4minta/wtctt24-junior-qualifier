package com.coinbase.resources.time;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import h.c.b0;
import retrofit2.z.f;

/* loaded from: classes.dex */
public interface TimeApiRx {
    @f(ApiConstants.TIME)
    b0<CoinbaseResponse<Time>> getCurrentTime();
}