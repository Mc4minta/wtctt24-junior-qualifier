package com.coinbase.wallet.ethereum.repositories;

import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a0.s0;

/* compiled from: EthereumBasedBalanceRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001d\u0010\u0005\u001a\u00020\u00008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/util/concurrent/locks/ReentrantLock;", "blockHeightLock$delegate", "Lkotlin/h;", "getBlockHeightLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "blockHeightLock", "", "", "erc20FilteredCurrencyCode", "Ljava/util/Set;", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumBasedBalanceRepositoryKt {
    private static final kotlin.h blockHeightLock$delegate;
    private static final Set<String> erc20FilteredCurrencyCode;

    static {
        Set<String> e2;
        kotlin.h b2;
        e2 = s0.e("ETH", "ETC", "BTC", "BCH", "LTC", "XRP", "XLM", "DOGE");
        erc20FilteredCurrencyCode = e2;
        b2 = kotlin.k.b(EthereumBasedBalanceRepositoryKt$blockHeightLock$2.INSTANCE);
        blockHeightLock$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReentrantLock getBlockHeightLock() {
        return (ReentrantLock) blockHeightLock$delegate.getValue();
    }
}