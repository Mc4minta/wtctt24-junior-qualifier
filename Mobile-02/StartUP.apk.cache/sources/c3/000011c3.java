package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.core.models.TraceKey;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: TraceKey+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/core/models/TraceKey;", "<anonymous>", "()Lcom/coinbase/wallet/core/models/TraceKey;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TraceKey_ApplicationKt$registerNewUserKey$2 extends o implements a<TraceKey> {
    public static final TraceKey_ApplicationKt$registerNewUserKey$2 INSTANCE = new TraceKey_ApplicationKt$registerNewUserKey$2();

    TraceKey_ApplicationKt$registerNewUserKey$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final TraceKey invoke() {
        return new TraceKey("registerNewUser", 0, true, false, 10, null);
    }
}