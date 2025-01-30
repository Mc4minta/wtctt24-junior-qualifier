package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.signer.models.SignatureRequest;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "request", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/signer/models/SignatureRequest;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewModel$observeWalletLinkRequests$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SignatureRequest, x> {
    final /* synthetic */ SignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignerViewModel$observeWalletLinkRequests$3(SignerViewModel signerViewModel) {
        super(1);
        this.this$0 = signerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SignatureRequest signatureRequest) {
        invoke2(signatureRequest);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SignatureRequest request) {
        kotlin.jvm.internal.m.g(request, "request");
        l.a.a.a(kotlin.jvm.internal.m.o("[signer] app incoming request ", request), new Object[0]);
        this.this$0.appendSignatureRequest(request);
    }
}