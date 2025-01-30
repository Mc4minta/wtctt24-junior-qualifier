package com.coinbase.wallet.core.util;

import h.c.a0;
import h.c.u0.a;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RxSchedulers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/core/util/RxSchedulers;", "", "Lh/c/a0;", "newSerialScheduler", "()Lh/c/a0;", "", "size", "newFixedThreadPool", "(I)Lh/c/a0;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RxSchedulers {
    public static final RxSchedulers INSTANCE = new RxSchedulers();

    private RxSchedulers() {
    }

    public static /* synthetic */ a0 newFixedThreadPool$default(RxSchedulers rxSchedulers, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 64;
        }
        return rxSchedulers.newFixedThreadPool(i2);
    }

    public final a0 newFixedThreadPool(int i2) {
        a0 b2 = a.b(Executors.newFixedThreadPool(i2));
        m.f(b2, "from(executorService)");
        return b2;
    }

    public final a0 newSerialScheduler() {
        a0 b2 = a.b(Executors.newSingleThreadExecutor());
        m.f(b2, "from(newSingleThread)");
        return b2;
    }
}