package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.extensions.Activity_ApplicationKt;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.consumer.models.ConsumerConfirmationEvent;
import com.coinbase.wallet.consumer.models.ConsumerConfirmationFeeInfoEvent;
import com.coinbase.wallet.consumer.models.ConsumerConfirmationPromptEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ConsumerTransferConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerConfirmationEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerConfirmationEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferConfirmationFragment$onViewCreated$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerConfirmationEvent, kotlin.x> {
    final /* synthetic */ ConsumerTransferConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferConfirmationFragment$onViewCreated$2(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
        super(1);
        this.this$0 = consumerTransferConfirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerConfirmationEvent consumerConfirmationEvent) {
        invoke2(consumerConfirmationEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerConfirmationEvent consumerConfirmationEvent) {
        if (consumerConfirmationEvent instanceof ConsumerConfirmationFeeInfoEvent) {
            androidx.fragment.app.d requireActivity = this.this$0.requireActivity();
            kotlin.jvm.internal.m.f(requireActivity, "requireActivity()");
            Activity_ApplicationKt.launchCustomTab$default(requireActivity, ((ConsumerConfirmationFeeInfoEvent) consumerConfirmationEvent).getUrl(), null, null, null, 14, null);
        } else if (!(consumerConfirmationEvent instanceof ConsumerConfirmationPromptEvent)) {
            throw new NoWhenBranchMatchedException();
        } else {
            PromptDialogHelper.INSTANCE.show(this.this$0, ((ConsumerConfirmationPromptEvent) consumerConfirmationEvent).getProperties());
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }
}