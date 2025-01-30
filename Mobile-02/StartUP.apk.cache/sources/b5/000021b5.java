package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: TxSignerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TxSignerFragment$setup$10 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendConfirmationResult, x> {
    final /* synthetic */ TxSignerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerFragment$setup$10(TxSignerFragment txSignerFragment) {
        super(1);
        this.this$0 = txSignerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SendConfirmationResult sendConfirmationResult) {
        invoke2(sendConfirmationResult);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendConfirmationResult it) {
        TxSignerFragment txSignerFragment = this.this$0;
        kotlin.jvm.internal.m.f(it, "it");
        txSignerFragment.handleConfirmationResult(it);
    }
}