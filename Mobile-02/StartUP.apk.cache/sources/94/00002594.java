package com.coinbase.wallet.ripple.interfaces;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.k;

/* compiled from: XRPBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001d\u0010\u0005\u001a\u00020\u00008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Ljava/util/concurrent/locks/ReentrantLock;", "ledgerVersionLock$delegate", "Lkotlin/h;", "getLedgerVersionLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "ledgerVersionLock", "ripple_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPBalanceManagingKt {
    private static final kotlin.h ledgerVersionLock$delegate;

    static {
        kotlin.h b2;
        b2 = k.b(XRPBalanceManagingKt$ledgerVersionLock$2.INSTANCE);
        ledgerVersionLock$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReentrantLock getLedgerVersionLock() {
        return (ReentrantLock) ledgerVersionLock$delegate.getValue();
    }
}