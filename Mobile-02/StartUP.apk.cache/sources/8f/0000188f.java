package com.coinbase.wallet.consumer.views;

import android.content.Context;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsEvent;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsPrompt;
import kotlin.Metadata;

/* compiled from: ConsumerTransferMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferMethodsFragment$onViewCreated$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerTransferMethodsEvent, kotlin.x> {
    final /* synthetic */ ConsumerTransferMethodsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferMethodsFragment$onViewCreated$6(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
        super(1);
        this.this$0 = consumerTransferMethodsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerTransferMethodsEvent consumerTransferMethodsEvent) {
        invoke2(consumerTransferMethodsEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerTransferMethodsEvent consumerTransferMethodsEvent) {
        if (consumerTransferMethodsEvent instanceof ConsumerTransferMethodsPrompt) {
            PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
            Context requireContext = this.this$0.requireContext();
            kotlin.jvm.internal.m.f(requireContext, "requireContext()");
            promptDialogHelper.create(requireContext, ((ConsumerTransferMethodsPrompt) consumerTransferMethodsEvent).getProperties()).show();
        }
    }
}