package com.coinbase.wallet.analytics;

import com.coinbase.wallet.core.util.RxSchedulers;
import h.c.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lh/c/a0;", "<anonymous>", "()Lh/c/a0;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class Analytics$logSerialQueue$2 extends o implements kotlin.e0.c.a<a0> {
    public static final Analytics$logSerialQueue$2 INSTANCE = new Analytics$logSerialQueue$2();

    Analytics$logSerialQueue$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final a0 invoke() {
        return RxSchedulers.INSTANCE.newSerialScheduler();
    }
}