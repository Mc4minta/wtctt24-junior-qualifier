package com.coinbase.wallet.consumer.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.h0.c;
import kotlin.jvm.internal.m;

/* compiled from: TraceKey+ConsumerConnect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "Lcom/coinbase/wallet/core/models/TraceKey;", "consumerUserRepositoryTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;)Lcom/coinbase/wallet/core/models/TraceKey;", "consumerAccountsRepositoryTrace", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TraceKey_ConsumerConnectKt {
    public static final TraceKey consumerAccountsRepositoryTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("ConsumerAccountsRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }

    public static final TraceKey consumerUserRepositoryTrace(TraceKey.Companion companion) {
        m.g(companion, "<this>");
        return new TraceKey("ConsumerUserRepository#refresh", c.f17279b.c(), false, false, 12, null);
    }
}