package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParentRequestEthereumAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsViewModel$reject$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<x, x> {
    final /* synthetic */ ParentRequestEthereumAccountsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentRequestEthereumAccountsViewModel$reject$3(ParentRequestEthereumAccountsViewModel parentRequestEthereumAccountsViewModel) {
        super(1);
        this.this$0 = parentRequestEthereumAccountsViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        h.c.v0.b signatureRequestEventSubject;
        signatureRequestEventSubject = this.this$0.getSignatureRequestEventSubject();
        signatureRequestEventSubject.onNext(new SigningSessionEvent.Cancelled(this.this$0.getViewState().getUuid()));
    }
}