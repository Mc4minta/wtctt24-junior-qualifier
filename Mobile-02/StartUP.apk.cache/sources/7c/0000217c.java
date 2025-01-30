package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lh/c/s;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$signConfirmationObservable$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<SendConfirmationResult>> {
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$signConfirmationObservable$2(TxSignerViewModel txSignerViewModel) {
        super(0);
        this.this$0 = txSignerViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final h.c.s<SendConfirmationResult> invoke() {
        h.c.v0.b bVar;
        bVar = this.this$0.signConfirmationSubject;
        return bVar.hide().onErrorReturnItem(new SendConfirmationResult(SendConfirmationState.None.INSTANCE, null, null, null, null, null, null, 126, null));
    }
}