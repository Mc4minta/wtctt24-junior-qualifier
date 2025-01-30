package com.coinbase.wallet.wallets.repositories;

import com.coinbase.wallet.core.util.RxSchedulers;
import kotlin.Metadata;

/* compiled from: WalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lh/c/a0;", "<anonymous>", "()Lh/c/a0;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class WalletRepository$refreshScheduler$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.a0> {
    public static final WalletRepository$refreshScheduler$2 INSTANCE = new WalletRepository$refreshScheduler$2();

    WalletRepository$refreshScheduler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final h.c.a0 invoke() {
        return RxSchedulers.INSTANCE.newSerialScheduler();
    }
}