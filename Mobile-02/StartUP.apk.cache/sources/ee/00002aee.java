package com.coinbase.walletengine.services.resolver;

import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: ResolverService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "", "", "asJSONMap", "(Lcom/coinbase/walletengine/services/resolver/ResolutionResult;)Ljava/util/Map;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ResolverServiceKt {
    private static final Map<String, String> asJSONMap(ResolutionResult resolutionResult) {
        Map<String, String> l2;
        l2 = m0.l(u.a("address", resolutionResult.getAddress()), u.a("resolveType", resolutionResult.getResolveType().getRawValue()));
        return l2;
    }
}