package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.features.signer.exceptions.SignerViewException;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult;", "kotlin.jvm.PlatformType", "result", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/authentication/AuthenticationResult;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$approve$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationResult, x> {
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$approve$2(TxSignerViewModel txSignerViewModel) {
        super(1);
        this.this$0 = txSignerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(AuthenticationResult authenticationResult) {
        invoke2(authenticationResult);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AuthenticationResult authenticationResult) {
        UnsignedTx unsignedTx;
        h.c.v0.b signatureRequestEventSubject;
        AuthenticationResult.RecoveryPhrase recoveryPhrase = authenticationResult instanceof AuthenticationResult.RecoveryPhrase ? (AuthenticationResult.RecoveryPhrase) authenticationResult : null;
        String recoveryPhrase2 = recoveryPhrase != null ? recoveryPhrase.getRecoveryPhrase() : null;
        if (recoveryPhrase2 == null) {
            return;
        }
        unsignedTx = this.this$0.tx;
        if (unsignedTx == null) {
            signatureRequestEventSubject = this.this$0.getSignatureRequestEventSubject();
            signatureRequestEventSubject.onNext(new SigningSessionEvent.Failure(this.this$0.getViewState().getUuid(), SignerViewException.UnableToGenerateUnsignedTx.INSTANCE));
            return;
        }
        this.this$0.confirm(unsignedTx, recoveryPhrase2);
    }
}