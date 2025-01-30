package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.SendDestinationPickerState;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lh/c/v0/a;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "kotlin.jvm.PlatformType", "<anonymous>", "()Lh/c/v0/a;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel$stateSubject$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.v0.a<SendDestinationPickerState>> {
    final /* synthetic */ SendDestinationPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerViewModel$stateSubject$2(SendDestinationPickerViewModel sendDestinationPickerViewModel) {
        super(0);
        this.this$0 = sendDestinationPickerViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final h.c.v0.a<SendDestinationPickerState> invoke() {
        SendDestinationPickerState sendDestinationPickerState;
        sendDestinationPickerState = this.this$0.state;
        return h.c.v0.a.e(sendDestinationPickerState);
    }
}