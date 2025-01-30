package com.coinbase.resources.time;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import retrofit2.z.f;

/* loaded from: classes.dex */
public interface TimeApi {
    @f(ApiConstants.TIME)
    ApiCall<CoinbaseResponse<Time>> getCurrentTime();
}