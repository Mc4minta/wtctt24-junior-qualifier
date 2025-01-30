package com.coinbase.wallet.ethereum.repositories;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* compiled from: EthereumBasedBalanceRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/locks/ReentrantLock;", "<anonymous>", "()Ljava/util/concurrent/locks/ReentrantLock;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class EthereumBasedBalanceRepositoryKt$blockHeightLock$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ReentrantLock> {
    public static final EthereumBasedBalanceRepositoryKt$blockHeightLock$2 INSTANCE = new EthereumBasedBalanceRepositoryKt$blockHeightLock$2();

    EthereumBasedBalanceRepositoryKt$blockHeightLock$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final ReentrantLock invoke() {
        return new ReentrantLock();
    }
}