package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$sign$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<EthereumSignedTx, x> {
    final /* synthetic */ String $mnemonic;
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$sign$3(TxSignerViewModel txSignerViewModel, String str) {
        super(1);
        this.this$0 = txSignerViewModel;
        this.$mnemonic = str;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(EthereumSignedTx ethereumSignedTx) {
        invoke2(ethereumSignedTx);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EthereumSignedTx it) {
        h.c.v0.b signatureRequestEventSubject;
        signatureRequestEventSubject = this.this$0.getSignatureRequestEventSubject();
        String uuid = this.this$0.getViewState().getUuid();
        kotlin.jvm.internal.m.f(it, "it");
        signatureRequestEventSubject.onNext(new SigningSessionEvent.SignedTx(uuid, it, this.$mnemonic));
    }
}