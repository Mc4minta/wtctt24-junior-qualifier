package com.coinbase.wallet.consumer.views;

import android.view.View;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerTransferConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationFragment$setupOnClicks$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ ConsumerTransferConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferConfirmationFragment$setupOnClicks$4(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
        super(1);
        this.this$0 = consumerTransferConfirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        ConsumerTransferConfirmationViewModel viewModel;
        kotlin.jvm.internal.m.g(it, "it");
        viewModel = this.this$0.getViewModel();
        viewModel.presentMinerFee();
    }
}