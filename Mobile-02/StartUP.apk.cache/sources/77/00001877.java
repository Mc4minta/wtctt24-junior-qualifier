package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerTransferConfirmationViewState;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.uber.autodispose.a0;
import h.c.b0;
import kotlin.Metadata;

/* compiled from: ConsumerTransferConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferConfirmationViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferConfirmationFragment$onViewCreated$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerTransferConfirmationViewState, kotlin.x> {
    final /* synthetic */ ConsumerTransferConfirmationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferConfirmationFragment$onViewCreated$3(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
        super(1);
        this.this$0 = consumerTransferConfirmationFragment;
    }

    public static /* synthetic */ void a(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment, ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState, kotlin.x xVar) {
        m1045invoke$lambda0(consumerTransferConfirmationFragment, consumerTransferConfirmationViewState, xVar);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1045invoke$lambda0(ConsumerTransferConfirmationFragment this$0, ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.isFirstDetailsUpdate = false;
        View view = this$0.getView();
        ((Button) (view == null ? null : view.findViewById(R.id.detailsButton))).setEnabled(true);
        if (consumerTransferConfirmationViewState.getErrorText() != null) {
            View view2 = this$0.getView();
            ((ScrollView) (view2 != null ? view2.findViewById(R.id.containerView) : null)).fullScroll(130);
        }
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState) {
        invoke2(consumerTransferConfirmationViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(final ConsumerTransferConfirmationViewState consumerTransferConfirmationViewState) {
        View view;
        int i2;
        View view2;
        View view3;
        int i3;
        View view4;
        TextView textView;
        boolean z;
        b0 updateDetailsView;
        FragmentLifecycleScopeProvider scopeProvider;
        boolean z2;
        View view5 = this.this$0.getView();
        ((ProgressBarButton) (view5 == null ? null : view5.findViewById(R.id.proceedButton))).setProgressBarIsVisible(kotlin.jvm.internal.m.c(consumerTransferConfirmationViewState.getLoading(), Boolean.TRUE));
        View view6 = this.this$0.getView();
        ((ProgressBarButton) (view6 == null ? null : view6.findViewById(R.id.proceedButton))).setProgressBarText(consumerTransferConfirmationViewState.getProgressButtonText());
        View view7 = this.this$0.getView();
        ((TextView) (view7 == null ? null : view7.findViewById(R.id.modeLabel))).setText(consumerTransferConfirmationViewState.getModeText());
        View view8 = this.this$0.getView();
        ((TextView) (view8 == null ? null : view8.findViewById(R.id.fromLabel))).setText(consumerTransferConfirmationViewState.getFromLabel());
        View view9 = this.this$0.getView();
        ((TextView) (view9 == null ? null : view9.findViewById(R.id.fiatAmountLabel))).setText(consumerTransferConfirmationViewState.getPrimaryAmount());
        View view10 = this.this$0.getView();
        ((TextView) (view10 == null ? null : view10.findViewById(R.id.cryptoAmountLabel))).setText(consumerTransferConfirmationViewState.getSecondaryAmount());
        View view11 = this.this$0.getView();
        View sendOnlyContainer = view11 == null ? null : view11.findViewById(R.id.sendOnlyContainer);
        kotlin.jvm.internal.m.f(sendOnlyContainer, "sendOnlyContainer");
        sendOnlyContainer.setVisibility(consumerTransferConfirmationViewState.getOnrampEnabled() ^ true ? 0 : 8);
        View view12 = this.this$0.getView();
        View transferMethodContainer = view12 == null ? null : view12.findViewById(R.id.transferMethodContainer);
        kotlin.jvm.internal.m.f(transferMethodContainer, "transferMethodContainer");
        transferMethodContainer.setVisibility(consumerTransferConfirmationViewState.getOnrampEnabled() ? 0 : 8);
        if (consumerTransferConfirmationViewState.getOnrampEnabled()) {
            view = this.this$0.getView();
            if (view != null) {
                i2 = R.id.transferIcon;
                view2 = view.findViewById(i2);
            }
            view2 = null;
        } else {
            view = this.this$0.getView();
            if (view != null) {
                i2 = R.id.contactIcon;
                view2 = view.findViewById(i2);
            }
            view2 = null;
        }
        ImageView imageView = (ImageView) view2;
        if (consumerTransferConfirmationViewState.getOnrampEnabled()) {
            view3 = this.this$0.getView();
            if (view3 != null) {
                i3 = R.id.transferMethodTitle;
                view4 = view3.findViewById(i3);
            }
            view4 = null;
        } else {
            view3 = this.this$0.getView();
            if (view3 != null) {
                i3 = R.id.fromCoinbaseTitle;
                view4 = view3.findViewById(i3);
            }
            view4 = null;
        }
        TextView textView2 = (TextView) view4;
        if (consumerTransferConfirmationViewState.getOnrampEnabled()) {
            textView = null;
        } else {
            View view13 = this.this$0.getView();
            textView = (TextView) (view13 == null ? null : view13.findViewById(R.id.coinbaseEmail));
        }
        textView2.setText(consumerTransferConfirmationViewState.getFromPrimaryText());
        if (textView != null) {
            textView.setVisibility(consumerTransferConfirmationViewState.getFromSecondaryText() != null ? 0 : 8);
        }
        if (textView != null) {
            String fromSecondaryText = consumerTransferConfirmationViewState.getFromSecondaryText();
            if (fromSecondaryText == null) {
                fromSecondaryText = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            }
            textView.setText(fromSecondaryText);
        }
        if (consumerTransferConfirmationViewState.getFromImage() != null) {
            imageView.setImageDrawable(Fragment_CommonKt.requireDrawableById(this.this$0, consumerTransferConfirmationViewState.getFromImage().intValue()));
        } else if (consumerTransferConfirmationViewState.getFromImageUrl() != null) {
            Glide.with(this.this$0).load(consumerTransferConfirmationViewState.getFromImageUrl()).into(imageView);
        }
        if (!consumerTransferConfirmationViewState.getDetailsChanged()) {
            z2 = this.this$0.isFirstDetailsUpdate;
            if (!z2) {
                return;
            }
        }
        View view14 = this.this$0.getView();
        View totalFeeContainer = view14 == null ? null : view14.findViewById(R.id.totalFeeContainer);
        kotlin.jvm.internal.m.f(totalFeeContainer, "totalFeeContainer");
        totalFeeContainer.setVisibility(consumerTransferConfirmationViewState.getTotalPrimaryAmount() != null ? 0 : 8);
        View view15 = this.this$0.getView();
        ((TextView) (view15 == null ? null : view15.findViewById(R.id.primaryTotalAmountLabel))).setText(consumerTransferConfirmationViewState.getTotalPrimaryAmount());
        View view16 = this.this$0.getView();
        View secondaryTotalAmountLabel = view16 == null ? null : view16.findViewById(R.id.secondaryTotalAmountLabel);
        kotlin.jvm.internal.m.f(secondaryTotalAmountLabel, "secondaryTotalAmountLabel");
        secondaryTotalAmountLabel.setVisibility(consumerTransferConfirmationViewState.getOnrampEnabled() ^ true ? 0 : 8);
        View view17 = this.this$0.getView();
        ((TextView) (view17 == null ? null : view17.findViewById(R.id.secondaryTotalAmountLabel))).setText(consumerTransferConfirmationViewState.getTotalSecondaryAmount());
        View view18 = this.this$0.getView();
        ((TextView) (view18 == null ? null : view18.findViewById(R.id.primaryFeeAmountLabel))).setText(consumerTransferConfirmationViewState.getMinerFeePrimaryAmount());
        View view19 = this.this$0.getView();
        ((TextView) (view19 == null ? null : view19.findViewById(R.id.secondaryFeeAmountLabel))).setText(consumerTransferConfirmationViewState.getMinerFeeSecondaryAmount());
        View view20 = this.this$0.getView();
        ((TextView) (view20 == null ? null : view20.findViewById(R.id.coinbaseFeeLabel))).setText(consumerTransferConfirmationViewState.getCoinbaseFeeAmount());
        View view21 = this.this$0.getView();
        View coinbaseFeeContainer = view21 == null ? null : view21.findViewById(R.id.coinbaseFeeContainer);
        kotlin.jvm.internal.m.f(coinbaseFeeContainer, "coinbaseFeeContainer");
        coinbaseFeeContainer.setVisibility(consumerTransferConfirmationViewState.getCoinbaseFeeAmount() != null ? 0 : 8);
        View view22 = this.this$0.getView();
        View worldpayText = view22 == null ? null : view22.findViewById(R.id.worldpayText);
        kotlin.jvm.internal.m.f(worldpayText, "worldpayText");
        worldpayText.setVisibility(consumerTransferConfirmationViewState.getShowWorldpay() ? 0 : 8);
        View view23 = this.this$0.getView();
        ((TextView) (view23 == null ? null : view23.findViewById(R.id.transferExplanation))).setText(consumerTransferConfirmationViewState.getTransferExplanation());
        View view24 = this.this$0.getView();
        ((Button) (view24 == null ? null : view24.findViewById(R.id.detailsButton))).setEnabled(false);
        View view25 = this.this$0.getView();
        TextView textView3 = (TextView) (view25 == null ? null : view25.findViewById(R.id.errorLabel));
        String errorText = consumerTransferConfirmationViewState.getErrorText();
        if (errorText == null) {
            errorText = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        textView3.setText(errorText);
        View view26 = this.this$0.getView();
        View errorLabel = view26 != null ? view26.findViewById(R.id.errorLabel) : null;
        kotlin.jvm.internal.m.f(errorLabel, "errorLabel");
        errorLabel.setVisibility(consumerTransferConfirmationViewState.getErrorText() != null ? 0 : 8);
        ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment = this.this$0;
        boolean isDetailsShowing = consumerTransferConfirmationViewState.isDetailsShowing();
        z = this.this$0.isFirstDetailsUpdate;
        updateDetailsView = consumerTransferConfirmationFragment.updateDetailsView(isDetailsShowing, !z);
        final ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment2 = this.this$0;
        b0 doOnSuccess = updateDetailsView.doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.o
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConsumerTransferConfirmationFragment$onViewCreated$3.a(ConsumerTransferConfirmationFragment.this, consumerTransferConfirmationViewState, (kotlin.x) obj);
            }
        });
        scopeProvider = this.this$0.getScopeProvider();
        ((a0) doOnSuccess.as(com.uber.autodispose.d.a(scopeProvider))).subscribe();
    }
}