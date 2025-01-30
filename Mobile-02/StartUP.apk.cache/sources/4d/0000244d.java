package com.coinbase.wallet.lending.extensions;

import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h0.c;
import kotlin.jvm.internal.m;

/* compiled from: TraceLogger+Lend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/core/interfaces/Tracing$Companion;", "Lcom/coinbase/wallet/core/models/TraceKey;", "repositoryRefreshTrace", "(Lcom/coinbase/wallet/core/interfaces/Tracing$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "lending_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TraceLogger_LendKt {
    public static final TraceKey repositoryRefreshTrace(Tracing.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("LendRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }
}