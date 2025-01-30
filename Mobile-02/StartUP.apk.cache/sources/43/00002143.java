package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.authentication.AuthenticationResult;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult;", "result", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/authentication/AuthenticationResult;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MessageSignerViewModel$approve$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationResult, x> {
    final /* synthetic */ MessageSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSignerViewModel$approve$1(MessageSignerViewModel messageSignerViewModel) {
        super(1);
        this.this$0 = messageSignerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(AuthenticationResult authenticationResult) {
        invoke2(authenticationResult);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AuthenticationResult result) {
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof AuthenticationResult.RecoveryPhrase) {
            this.this$0.sign(((AuthenticationResult.RecoveryPhrase) result).getRecoveryPhrase());
        }
    }
}