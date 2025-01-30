package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.features.send.models.Recipient;
import kotlin.Metadata;

/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/send/models/Recipient;", "<anonymous>", "()Lcom/coinbase/wallet/features/send/models/Recipient;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendConfirmationViewModel$recipient$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Recipient> {
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$recipient$2(SendConfirmationViewModel sendConfirmationViewModel) {
        super(0);
        this.this$0 = sendConfirmationViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final Recipient invoke() {
        return (Recipient) Bundle_CommonKt.requireParcelable(this.this$0.getArgs(), "recipient");
    }
}