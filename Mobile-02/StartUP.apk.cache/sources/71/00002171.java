package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult$Success;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$fetchReceiptInformation$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends UnsignedTxResult.Success, ? extends Wallet>, x> {
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$fetchReceiptInformation$4(TxSignerViewModel txSignerViewModel) {
        super(1);
        this.this$0 = txSignerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends UnsignedTxResult.Success, ? extends Wallet> oVar) {
        invoke2((kotlin.o<UnsignedTxResult.Success, Wallet>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<UnsignedTxResult.Success, Wallet> oVar) {
        Wallet feeWallet = oVar.b();
        TxSignerViewModel txSignerViewModel = this.this$0;
        UnsignedTx tx = oVar.a().getTx();
        kotlin.jvm.internal.m.f(feeWallet, "feeWallet");
        txSignerViewModel.handleUnsignedTx(tx, feeWallet);
    }
}