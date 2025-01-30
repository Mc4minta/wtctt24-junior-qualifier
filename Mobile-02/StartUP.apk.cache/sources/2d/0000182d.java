package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAccountViewState;
import com.coinbase.wallet.consumer.views.adapter.ConsumerAccountsAdapter;
import kotlin.Metadata;

/* compiled from: ConsumerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccountViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerFragment$onViewCreated$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAccountViewState, kotlin.x> {
    final /* synthetic */ ConsumerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerFragment$onViewCreated$1(ConsumerFragment consumerFragment) {
        super(1);
        this.this$0 = consumerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAccountViewState consumerAccountViewState) {
        invoke2(consumerAccountViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerAccountViewState consumerAccountViewState) {
        ConsumerAccountsAdapter consumerAccountsAdapter;
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(R.id.readyToTransfer))).setText(consumerAccountViewState.getSplashScreenState().getReadyToTransferText());
        View view2 = this.this$0.getView();
        ((TextView) (view2 == null ? null : view2.findViewById(R.id.readyToTransferExplanation))).setText(consumerAccountViewState.getSplashScreenState().getReadyToTransferExplanationText());
        View view3 = this.this$0.getView();
        ((Button) (view3 == null ? null : view3.findViewById(R.id.startTransferBtn))).setText(consumerAccountViewState.getSplashScreenState().getStartTransferBtnText());
        View view4 = this.this$0.getView();
        ((TextView) (view4 == null ? null : view4.findViewById(R.id.transferLaterBtn))).setText(consumerAccountViewState.getSplashScreenState().getTransferLaterBtnText());
        View view5 = this.this$0.getView();
        ((TextView) (view5 != null ? view5.findViewById(R.id.subtitle) : null)).setText(consumerAccountViewState.getSplashScreenState().getSubtitleText());
        if (consumerAccountViewState.getShowSplashScreen()) {
            this.this$0.showSplashScreen();
        } else if (consumerAccountViewState.getShowLoading()) {
            this.this$0.switchToLoadingView();
        } else {
            this.this$0.switchToAccountsView();
        }
        consumerAccountsAdapter = this.this$0.accountsAdapter;
        consumerAccountsAdapter.setItemsAndNotifyDataSetChanged(consumerAccountViewState.getAccounts());
    }
}