package com.coinbase.walletengine.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TraceKey+WalletEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey$Companion;", "", "uuid", "", "descriptor", "Lcom/coinbase/wallet/core/models/TraceKey;", "callTrace", "(Lcom/coinbase/wallet/core/models/TraceKey$Companion;ILjava/lang/String;)Lcom/coinbase/wallet/core/models/TraceKey;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TraceKey_WalletEngineKt {
    public static final TraceKey callTrace(TraceKey.Companion companion, int i2, String str) {
        m.g(companion, "<this>");
        TraceKey traceKey = new TraceKey("WalletEngine#call", i2, false, true, 4, null);
        traceKey.setDescriptor(str);
        return traceKey;
    }

    public static /* synthetic */ TraceKey callTrace$default(TraceKey.Companion companion, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return callTrace(companion, i2, str);
    }
}