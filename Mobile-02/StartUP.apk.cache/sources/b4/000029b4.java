package com.coinbase.wallet.wallets.repositories;

import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.wallets.models.WalletRefreshState;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* compiled from: WalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/wallets/models/WalletRefreshState;", "<anonymous>", "()Ljava/util/concurrent/ConcurrentHashMap;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class WalletRepository$refreshStates$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ConcurrentHashMap<Blockchain, WalletRefreshState>> {
    final /* synthetic */ List<WalletManaging> $repositories;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WalletRepository$refreshStates$2(List<? extends WalletManaging> list) {
        super(0);
        this.$repositories = list;
    }

    @Override // kotlin.e0.c.a
    public final ConcurrentHashMap<Blockchain, WalletRefreshState> invoke() {
        ConcurrentHashMap<Blockchain, WalletRefreshState> concurrentHashMap = new ConcurrentHashMap<>();
        for (WalletManaging walletManaging : this.$repositories) {
            concurrentHashMap.put(walletManaging.getConfiguration().getBlockchain(), new WalletRefreshState(walletManaging.getConfiguration().getRefreshInterval()));
        }
        return concurrentHashMap;
    }
}