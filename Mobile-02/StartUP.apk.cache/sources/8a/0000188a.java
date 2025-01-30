package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.ConsumerTransferMethodItem;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import kotlin.Metadata;

/* compiled from: ConsumerTransferMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "item", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferMethodsFragment$onViewCreated$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerTransferMethodItem, kotlin.x> {
    final /* synthetic */ ConsumerTransferMethodsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferMethodsFragment$onViewCreated$1(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
        super(1);
        this.this$0 = consumerTransferMethodsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerTransferMethodItem consumerTransferMethodItem) {
        invoke2(consumerTransferMethodItem);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerTransferMethodItem item) {
        ConsumerTransferMethodsViewModel viewModel;
        kotlin.jvm.internal.m.g(item, "item");
        viewModel = this.this$0.getViewModel();
        viewModel.selectTransfer(item);
    }
}