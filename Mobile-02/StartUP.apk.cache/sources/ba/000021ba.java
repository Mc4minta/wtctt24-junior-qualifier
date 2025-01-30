package com.coinbase.wallet.features.signer.views;

import android.view.View;
import android.widget.Button;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: TxSignerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class TxSignerFragment$setup$9 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SigningSessionEvent, x> {
    final /* synthetic */ TxSignerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerFragment$setup$9(TxSignerFragment txSignerFragment) {
        super(1);
        this.this$0 = txSignerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SigningSessionEvent signingSessionEvent) {
        invoke2(signingSessionEvent);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SigningSessionEvent signingSessionEvent) {
        View view = this.this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.payButton))).setEnabled(true);
        if (signingSessionEvent instanceof SigningSessionEvent.Failure) {
            TxSignerFragment txSignerFragment = this.this$0;
            String localizedMessage = ((SigningSessionEvent.Failure) signingSessionEvent).getError().getLocalizedMessage();
            kotlin.jvm.internal.m.f(localizedMessage, "event.error.localizedMessage");
            TxSignerFragment.handleError$default(txSignerFragment, null, localizedMessage, 1, null);
        }
    }
}