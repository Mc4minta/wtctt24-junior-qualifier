package com.coinbase.wallet.featureflags.apis;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.http.models.HTTPResponse;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RPC.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n"}, d2 = {"", "T", "Lcom/coinbase/wallet/http/models/HTTPResponse;", Payload.RESPONSE, "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPC$postProtected$1<T, R> implements n {
    public static final RPC$postProtected$1<T, R> INSTANCE = new RPC$postProtected$1<>();

    @Override // h.c.m0.n
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((HTTPResponse) ((HTTPResponse) obj));
    }

    public final T apply(HTTPResponse<T> response) {
        m.g(response, "response");
        return response.getBody();
    }
}