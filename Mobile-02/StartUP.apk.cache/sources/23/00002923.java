package com.coinbase.wallet.wallets.di;

import com.coinbase.Coinbase;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import retrofit2.t;

/* compiled from: WalletsContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsComponent;", "<anonymous>", "()Lcom/coinbase/wallet/wallets/di/WalletsComponent;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class WalletsContainer$component$2 extends o implements a<WalletsComponent> {
    final /* synthetic */ Coinbase $coinbase;
    final /* synthetic */ CryptoContainer $cryptoContainer;
    final /* synthetic */ t $retrofit;
    final /* synthetic */ StoreInterface $store;
    final /* synthetic */ Tracing $tracer;
    final /* synthetic */ String $walletApiUrl;
    final /* synthetic */ String $walletBlockchainUrl;
    final /* synthetic */ String $walletXRPNodeUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsContainer$component$2(t tVar, StoreInterface storeInterface, Coinbase coinbase, CryptoContainer cryptoContainer, Tracing tracing, String str, String str2, String str3) {
        super(0);
        this.$retrofit = tVar;
        this.$store = storeInterface;
        this.$coinbase = coinbase;
        this.$cryptoContainer = cryptoContainer;
        this.$tracer = tracing;
        this.$walletApiUrl = str;
        this.$walletBlockchainUrl = str2;
        this.$walletXRPNodeUrl = str3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final WalletsComponent invoke() {
        return DaggerWalletsComponent.factory().create(this.$retrofit, this.$store, this.$coinbase, this.$cryptoContainer.cipherCore(), this.$cryptoContainer.application(), this.$cryptoContainer.context(), this.$tracer, this.$walletApiUrl, this.$walletBlockchainUrl, this.$walletXRPNodeUrl);
    }
}