package com.coinbase.wallet.wallets.repositories;

import com.coinbase.wallet.blockchains.models.Wallet;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062§\u0001\u0010\u0005\u001a¢\u0001\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001 \u0003*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004 \u0003*P\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001 \u0003*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletRepository$observeWalletUpdates$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends kotlin.o<? extends List<? extends Wallet>, ? extends List<? extends Wallet>>, ? extends Boolean>, kotlin.x> {
    final /* synthetic */ WalletRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletRepository$observeWalletUpdates$2(WalletRepository walletRepository) {
        super(1);
        this.this$0 = walletRepository;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends kotlin.o<? extends List<? extends Wallet>, ? extends List<? extends Wallet>>, ? extends Boolean> oVar) {
        invoke2((kotlin.o<? extends kotlin.o<? extends List<Wallet>, ? extends List<Wallet>>, Boolean>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends kotlin.o<? extends List<Wallet>, ? extends List<Wallet>>, Boolean> oVar) {
        h.c.v0.c cVar;
        h.c.v0.c cVar2;
        kotlin.o<? extends List<Wallet>, ? extends List<Wallet>> a = oVar.a();
        cVar = this.this$0.usableWalletsSubject;
        cVar.onNext(a.b());
        cVar2 = this.this$0.allWalletsSubject;
        cVar2.onNext(a.a());
    }
}