package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.widget.Button;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerOnboardingViewState;
import kotlin.Metadata;

/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerOnboardingFragment$onViewCreated$5 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerOnboardingViewState, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$onViewCreated$5(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerOnboardingViewState consumerOnboardingViewState) {
        invoke2(consumerOnboardingViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerOnboardingViewState consumerOnboardingViewState) {
        if (consumerOnboardingViewState.getShowLoading()) {
            this.this$0.switchToLoadingView();
        } else {
            this.this$0.switchToPrivacyNoticeView(consumerOnboardingViewState.getPrivacyTitle(), consumerOnboardingViewState.getPrivacyBody());
        }
        View view = this.this$0.getView();
        ((Button) (view == null ? null : view.findViewById(R.id.loginButton))).setText(consumerOnboardingViewState.getLoginButtonText());
        View view2 = this.this$0.getView();
        ((ProgressBarButton) (view2 == null ? null : view2.findViewById(R.id.secondaryButton))).setProgressBarText(consumerOnboardingViewState.getSecondaryButtonText());
        View view3 = this.this$0.getView();
        ((ProgressBarButton) (view3 != null ? view3.findViewById(R.id.secondaryButton) : null)).setProgressBarIsVisible(consumerOnboardingViewState.getSecondaryButtonProgressVisible());
    }
}