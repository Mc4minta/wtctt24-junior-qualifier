package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerInterstitialViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "<anonymous>", "()Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerInterstitialViewModel$connectionStatus$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ConsumerConnectionStatus> {
    final /* synthetic */ ConsumerInterstitialViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerInterstitialViewModel$connectionStatus$2(ConsumerInterstitialViewModel consumerInterstitialViewModel) {
        super(0);
        this.this$0 = consumerInterstitialViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ConsumerConnectionStatus invoke() {
        androidx.lifecycle.z zVar;
        zVar = this.this$0.savedStateHandle;
        return (ConsumerConnectionStatus) SavedStateHandle_CommonKt.require(zVar, ConsumerInterstitialArgs.connectionStatusKey);
    }
}