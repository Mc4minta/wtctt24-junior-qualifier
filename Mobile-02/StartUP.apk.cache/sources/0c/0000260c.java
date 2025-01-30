package com.coinbase.wallet.stellar.api;

import com.coinbase.wallet.stellar.dtos.GetTimeResultDTO;
import h.c.b0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.apache.http.HttpHost;

/* compiled from: TimeAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/stellar/api/TimeAPI;", "", "Lh/c/b0;", "", "getEpoch", "()Lh/c/b0;", "Lcom/coinbase/wallet/stellar/api/TimeHTTP;", HttpHost.DEFAULT_SCHEME_NAME, "Lcom/coinbase/wallet/stellar/api/TimeHTTP;", "<init>", "(Lcom/coinbase/wallet/stellar/api/TimeHTTP;)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TimeAPI {
    private final TimeHTTP http;

    public TimeAPI(TimeHTTP http) {
        m.g(http, "http");
        this.http = http;
    }

    public static /* synthetic */ Long a(GetTimeResultDTO getTimeResultDTO) {
        return m1693getEpoch$lambda0(getTimeResultDTO);
    }

    /* renamed from: getEpoch$lambda-0 */
    public static final Long m1693getEpoch$lambda0(GetTimeResultDTO it) {
        m.g(it, "it");
        return Long.valueOf(it.getResult().getEpoch());
    }

    public final b0<Long> getEpoch() {
        b0 map = this.http.getCurrentTime().map(new n() { // from class: com.coinbase.wallet.stellar.api.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TimeAPI.a((GetTimeResultDTO) obj);
            }
        });
        m.f(map, "http.getCurrentTime().map { it.result.epoch }");
        return map;
    }
}