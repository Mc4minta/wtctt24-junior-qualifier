package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVState;
import kotlin.Metadata;

/* compiled from: ConsumerCardCDVFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerCardCDVFragment$onViewCreated$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerCardCDVState, kotlin.x> {
    final /* synthetic */ ConsumerCardCDVFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerCardCDVFragment$onViewCreated$3(ConsumerCardCDVFragment consumerCardCDVFragment) {
        super(1);
        this.this$0 = consumerCardCDVFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerCardCDVState consumerCardCDVState) {
        invoke2(consumerCardCDVState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerCardCDVState consumerCardCDVState) {
        View view = this.this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(R.id.confirmButton))).setProgressBarIsVisible(consumerCardCDVState.getLoading());
        View view2 = this.this$0.getView();
        ((ProgressBarButton) (view2 == null ? null : view2.findViewById(R.id.confirmButton))).setEnabled(consumerCardCDVState.getButtonEnabled());
        View view3 = this.this$0.getView();
        ((TextView) (view3 != null ? view3.findViewById(R.id.errorMessage) : null)).setText(consumerCardCDVState.getErrorMessage());
    }
}