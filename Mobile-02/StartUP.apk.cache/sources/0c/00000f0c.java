package com.coinbase.android.apiv3.generated.unauthed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.o;

/* compiled from: AuthenticationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/AuthenticationService;", "", "Lcom/coinbase/android/apiv3/generated/unauthed/CanonicalAuthTokenRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/unauthed/CanonicalAuthTokenResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "getCanonicalAuthToken", "(Lcom/coinbase/android/apiv3/generated/unauthed/CanonicalAuthTokenRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface AuthenticationService {
    @o("coinbase.public_api.unauthed.AuthenticationService/GetCanonicalAuthToken")
    b0<NetworkResponse<CanonicalAuthTokenResponse, V3Error>> getCanonicalAuthToken(@a CanonicalAuthTokenRequest canonicalAuthTokenRequest);
}