package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.content.Intent;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerAccountViewEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ConsumerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerFragment$onViewCreated$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAccountViewEvent, kotlin.x> {
    final /* synthetic */ ConsumerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerFragment$onViewCreated$2(ConsumerFragment consumerFragment) {
        super(1);
        this.this$0 = consumerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAccountViewEvent consumerAccountViewEvent) {
        invoke2(consumerAccountViewEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAccountViewEvent consumerAccountViewEvent) {
        if (consumerAccountViewEvent instanceof ConsumerAccountViewEvent.StartActivityForResult) {
            Context requireContext = this.this$0.requireContext();
            kotlin.jvm.internal.m.f(requireContext, "requireContext()");
            ConsumerAccountViewEvent.StartActivityForResult startActivityForResult = (ConsumerAccountViewEvent.StartActivityForResult) consumerAccountViewEvent;
            Context_CommonKt.setComponentEnabledSetting(requireContext, true, startActivityForResult.getClazz());
            this.this$0.startActivityForResult(new Intent(this.this$0.requireActivity(), startActivityForResult.getClazz()), startActivityForResult.getRequestCode());
        } else if (!kotlin.jvm.internal.m.c(consumerAccountViewEvent, ConsumerAccountViewEvent.HideKeyboard.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Fragment_CommonKt.hideKeyboard(this.this$0);
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }
}