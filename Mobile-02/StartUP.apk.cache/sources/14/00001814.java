package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel;
import com.coinbase.wallet.consumer.views.adapter.ConsumerAvailablePaymentMethodsAdapter;
import kotlin.Metadata;

/* compiled from: ConsumerAvailablePaymentMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerAvailablePaymentMethodsFragment$adapter$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ConsumerAvailablePaymentMethodsAdapter> {
    final /* synthetic */ ConsumerAvailablePaymentMethodsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConsumerAvailablePaymentMethodsFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.consumer.views.ConsumerAvailablePaymentMethodsFragment$adapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAvailablePaymentMethod, kotlin.x> {
        final /* synthetic */ ConsumerAvailablePaymentMethodsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
            super(1);
            this.this$0 = consumerAvailablePaymentMethodsFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
            invoke2(consumerAvailablePaymentMethod);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ConsumerAvailablePaymentMethod it) {
            ConsumerAvailablePaymentMethodsViewModel consumerAvailablePaymentMethodsViewModel;
            kotlin.jvm.internal.m.g(it, "it");
            consumerAvailablePaymentMethodsViewModel = this.this$0.viewModel;
            if (consumerAvailablePaymentMethodsViewModel != null) {
                consumerAvailablePaymentMethodsViewModel.onPaymentMethodClick(it);
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAvailablePaymentMethodsFragment$adapter$2(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
        super(0);
        this.this$0 = consumerAvailablePaymentMethodsFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ConsumerAvailablePaymentMethodsAdapter invoke() {
        return new ConsumerAvailablePaymentMethodsAdapter(new AnonymousClass1(this.this$0));
    }
}