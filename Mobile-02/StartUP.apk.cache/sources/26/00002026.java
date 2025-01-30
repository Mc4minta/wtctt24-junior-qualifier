package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import kotlin.Metadata;

/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendConfirmationViewModel$recipientAddress$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$recipientAddress$2(SendConfirmationViewModel sendConfirmationViewModel) {
        super(0);
        this.this$0 = sendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        return e.j.f.e.d(this.this$0.getArgs(), SendConfirmationArgs.recipientAddressKey);
    }
}