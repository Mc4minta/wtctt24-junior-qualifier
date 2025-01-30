package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.content.Intent;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingViewEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerOnboardingFragment$onViewCreated$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerOnboardingViewEvent, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$onViewCreated$6(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerOnboardingViewEvent consumerOnboardingViewEvent) {
        invoke2(consumerOnboardingViewEvent);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerOnboardingViewEvent consumerOnboardingViewEvent) {
        if (kotlin.jvm.internal.m.c(consumerOnboardingViewEvent, ConsumerOnboardingViewEvent.StartConnection.INSTANCE)) {
            this.this$0.startConnecting();
        } else if (consumerOnboardingViewEvent instanceof ConsumerOnboardingViewEvent.StartActivityForResult) {
            Context requireContext = this.this$0.requireContext();
            kotlin.jvm.internal.m.f(requireContext, "requireContext()");
            ConsumerOnboardingViewEvent.StartActivityForResult startActivityForResult = (ConsumerOnboardingViewEvent.StartActivityForResult) consumerOnboardingViewEvent;
            Context_CommonKt.setComponentEnabledSetting(requireContext, true, startActivityForResult.getClazz());
            this.this$0.startActivityForResult(new Intent(this.this$0.requireActivity(), startActivityForResult.getClazz()), startActivityForResult.getRequestCode());
        } else if (!kotlin.jvm.internal.m.c(consumerOnboardingViewEvent, ConsumerOnboardingViewEvent.HideKeyboard.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Fragment_CommonKt.hideKeyboard(this.this$0);
        }
        SafeWhen_CommonKt.getSafe(kotlin.x.a);
    }
}