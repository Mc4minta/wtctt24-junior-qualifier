package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingArgs;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerOnboardingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingViewModel$forwardingCurrencyCode$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<CurrencyCode> {
    final /* synthetic */ ConsumerOnboardingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingViewModel$forwardingCurrencyCode$2(ConsumerOnboardingViewModel consumerOnboardingViewModel) {
        super(0);
        this.this$0 = consumerOnboardingViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final CurrencyCode invoke() {
        androidx.lifecycle.z zVar;
        zVar = this.this$0.savedStateHandle;
        return (CurrencyCode) zVar.b(ConsumerOnboardingArgs.forwadingCurrencyCodeKey);
    }
}