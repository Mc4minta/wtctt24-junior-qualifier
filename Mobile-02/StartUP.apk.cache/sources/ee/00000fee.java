package com.coinbase.ciphercore.extensions;

import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SafeTrace+CipherCore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/core/interfaces/Tracing$Companion;", "", "uuid", "", "method", "Lcom/coinbase/wallet/core/models/TraceKey;", "cipherCoreBridgeCallTrace", "(Lcom/coinbase/wallet/core/interfaces/Tracing$Companion;ILjava/lang/String;)Lcom/coinbase/wallet/core/models/TraceKey;", "cipher-core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SafeTrace_CipherCoreKt {
    public static final TraceKey cipherCoreBridgeCallTrace(Tracing.Companion companion, int i2, String str) {
        m.g(companion, "<this>");
        TraceKey traceKey = new TraceKey("CipherCoreBridge#call", i2, false, true, 4, null);
        traceKey.setDescriptor(str);
        return traceKey;
    }

    public static /* synthetic */ TraceKey cipherCoreBridgeCallTrace$default(Tracing.Companion companion, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return cipherCoreBridgeCallTrace(companion, i2, str);
    }
}