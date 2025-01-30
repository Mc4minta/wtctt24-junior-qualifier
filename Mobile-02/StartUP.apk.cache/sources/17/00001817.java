package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethodsState;
import com.coinbase.wallet.consumer.views.adapter.ConsumerAvailablePaymentMethodsAdapter;
import kotlin.Metadata;

/* compiled from: ConsumerAvailablePaymentMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethodsState;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethodsState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAvailablePaymentMethodsFragment$onViewCreated$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAvailablePaymentMethodsState, kotlin.x> {
    final /* synthetic */ ConsumerAvailablePaymentMethodsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAvailablePaymentMethodsFragment$onViewCreated$2(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
        super(1);
        this.this$0 = consumerAvailablePaymentMethodsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAvailablePaymentMethodsState consumerAvailablePaymentMethodsState) {
        invoke2(consumerAvailablePaymentMethodsState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAvailablePaymentMethodsState consumerAvailablePaymentMethodsState) {
        ConsumerAvailablePaymentMethodsAdapter adapter;
        adapter = this.this$0.getAdapter();
        adapter.setList(consumerAvailablePaymentMethodsState.getAvailablePaymentMethods());
    }
}