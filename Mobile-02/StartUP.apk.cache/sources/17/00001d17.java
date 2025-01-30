package com.coinbase.wallet.featureflags.apis;

import com.squareup.moshi.JsonAdapter;
import h.c.m0.n;
import kotlin.Metadata;

/* compiled from: HTTP.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0005*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T", "Lokhttp3/Response;", "it", "Lcom/coinbase/wallet/http/models/HTTPResponse;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lokhttp3/Response;)Lcom/coinbase/wallet/http/models/HTTPResponse;", "com/coinbase/wallet/http/HTTP$post$1"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPC$postProtected$$inlined$post$default$1<T, R> implements n {
    final /* synthetic */ JsonAdapter $parameterizedAdapter;

    public RPC$postProtected$$inlined$post$default$1(JsonAdapter jsonAdapter) {
        this.$parameterizedAdapter = jsonAdapter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append("Since ");
        kotlin.jvm.internal.m.l(4, "T");
        r5.append((java.lang.Object) kotlin.jvm.internal.e0.b(java.lang.Object.class).getSimpleName());
        r5.append(" is parameterized please pass an adapter to `parameterizedAdapter`");
        l.a.a.e(new com.coinbase.wallet.core.util.AssertionException(r5.toString()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.c.m0.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.RPC$postProtected$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
    }
}