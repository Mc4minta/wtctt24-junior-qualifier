package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h0.c;
import kotlin.jvm.internal.m;

/* compiled from: TraceKey+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "Lcom/coinbase/wallet/core/models/TraceKey;", "traceHistoryRefreshTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TraceKey_TxHistoryKt {
    public static final TraceKey traceHistoryRefreshTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("TxHistoryRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }
}