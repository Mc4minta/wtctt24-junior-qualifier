package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerCardCDVViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "<anonymous>", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCardCDVViewModel$paymentMethod$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ConsumerPaymentMethod> {
    final /* synthetic */ ConsumerCardCDVViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerCardCDVViewModel$paymentMethod$2(ConsumerCardCDVViewModel consumerCardCDVViewModel) {
        super(0);
        this.this$0 = consumerCardCDVViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ConsumerPaymentMethod invoke() {
        androidx.lifecycle.z zVar;
        zVar = this.this$0.savedStateHandle;
        return (ConsumerPaymentMethod) SavedStateHandle_CommonKt.require(zVar, "payment_method");
    }
}