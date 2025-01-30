package com.coinbase.wallet.features.signer.views;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestSigningDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "R", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "I", "", "<anonymous>", "()Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RequestSigningDialog$isFullScreen$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Boolean> {
    final /* synthetic */ RequestSigningDialog<R, I> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestSigningDialog$isFullScreen$2(RequestSigningDialog<R, I> requestSigningDialog) {
        super(0);
        this.this$0 = requestSigningDialog;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.this$0.getArguments();
        return arguments != null && arguments.getBoolean(RequestSigningDialog.IS_FULLSCREEN);
    }
}