package com.coinbase.wallet.wallets.repositories;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.models.WalletRefreshState;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletRepository$refreshRepository$1$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ Blockchain $blockchain;
    final /* synthetic */ RefreshContext $context;
    final /* synthetic */ boolean $isSyncingRequired;
    final /* synthetic */ WalletRefreshState $refreshState;
    final /* synthetic */ String $requestId;
    final /* synthetic */ WalletRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletRepository$refreshRepository$1$2(WalletRefreshState walletRefreshState, String str, Blockchain blockchain, RefreshContext refreshContext, WalletRepository walletRepository, boolean z) {
        super(1);
        this.$refreshState = walletRefreshState;
        this.$requestId = str;
        this.$blockchain = blockchain;
        this.$context = refreshContext;
        this.this$0 = walletRepository;
        this.$isSyncingRequired = z;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        StoreInterface storeInterface;
        StoreInterface storeInterface2;
        h.c.v0.a aVar;
        this.$refreshState.completed(this.$requestId);
        SharedPrefsStoreKey<Boolean> isWalletSynced = StoreKeys_WalletsKt.isWalletSynced(StoreKeys.INSTANCE, this.$blockchain, this.$context.getNetwork());
        storeInterface = this.this$0.store;
        Object obj = storeInterface.get(isWalletSynced);
        Boolean bool = Boolean.TRUE;
        if (kotlin.jvm.internal.m.c(obj, bool)) {
            return;
        }
        if (!(this.$isSyncingRequired && kotlin.jvm.internal.m.c(this.$context.getMode(), RefreshContext.Mode.Full.INSTANCE)) && this.$isSyncingRequired) {
            return;
        }
        storeInterface2 = this.this$0.store;
        storeInterface2.set(isWalletSynced, bool);
        aVar = this.this$0.reloadWalletsSubject;
        aVar.onNext(kotlin.x.a);
    }
}