package com.coinbase.wallet.core.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: Assertion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/os/Handler;", "<anonymous>", "()Landroid/os/Handler;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AssertionKt$assertionHandler$2 extends o implements a<Handler> {
    public static final AssertionKt$assertionHandler$2 INSTANCE = new AssertionKt$assertionHandler$2();

    AssertionKt$assertionHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}