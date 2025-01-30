package com.coinbase.wallet.http.connectivity;

import com.coinbase.wallet.http.connectivity.Internet;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Internet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Internet$isServerReachable$2 extends o implements l<Throwable, Boolean> {
    public static final Internet$isServerReachable$2 INSTANCE = new Internet$isServerReachable$2();

    Internet$isServerReachable$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable it) {
        m.g(it, "it");
        return !m.c(it, new Internet.NetworkNotReachableException());
    }
}