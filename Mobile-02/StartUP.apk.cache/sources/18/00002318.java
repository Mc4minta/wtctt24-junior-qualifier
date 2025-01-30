package com.coinbase.wallet.features.walletlink.repositories;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import kotlin.Metadata;

/* compiled from: WalletLinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lh/c/s;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkRepository$activeWalletObservable$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<Wallet>> {
    final /* synthetic */ WalletLinkRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkRepository$activeWalletObservable$2(WalletLinkRepository walletLinkRepository) {
        super(0);
        this.this$0 = walletLinkRepository;
    }

    public static /* synthetic */ h.c.x a(WalletLinkRepository walletLinkRepository, Network network) {
        return m1538invoke$lambda0(walletLinkRepository, network);
    }

    /* renamed from: invoke$lambda-0 */
    public static final h.c.x m1538invoke$lambda0(WalletLinkRepository this$0, Network network) {
        IWalletRepository iWalletRepository;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "network");
        iWalletRepository = this$0.walletRepository;
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(iWalletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(\n                    Blockchain.ETHEREUM,\n                    EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                )");
        h.c.x map = observeWallet.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$activeWalletObservable$2$invoke$lambda-0$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$activeWalletObservable$2$invoke$lambda-0$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map;
    }

    @Override // kotlin.e0.c.a
    public final h.c.s<Wallet> invoke() {
        IWalletRepository iWalletRepository;
        iWalletRepository = this.this$0.walletRepository;
        h.c.s<Network> observeNetwork = iWalletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
        final WalletLinkRepository walletLinkRepository = this.this$0;
        return observeNetwork.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletLinkRepository$activeWalletObservable$2.a(WalletLinkRepository.this, (Network) obj);
            }
        });
    }
}