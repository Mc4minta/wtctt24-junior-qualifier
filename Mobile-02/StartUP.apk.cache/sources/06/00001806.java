package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.CurrencyPickerView;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.commonui.views.ProgressBarButtonCircular;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAmountPickerViewState;
import com.coinbase.wallet.consumer.models.ReceivableWallet;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.a0;

/* compiled from: ConsumerAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerFragment$setupObservers$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerAmountPickerViewState, kotlin.x> {
    final /* synthetic */ a0 $setupOnClickListeners;
    final /* synthetic */ ConsumerAmountPickerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAmountPickerFragment$setupObservers$2(a0 a0Var, ConsumerAmountPickerFragment consumerAmountPickerFragment) {
        super(1);
        this.$setupOnClickListeners = a0Var;
        this.this$0 = consumerAmountPickerFragment;
    }

    public static /* synthetic */ void a(ConsumerAmountPickerFragment consumerAmountPickerFragment, ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        m1031invoke$lambda1(consumerAmountPickerFragment, consumerAmountPickerViewState);
    }

    public static /* synthetic */ void b(ConsumerAmountPickerFragment consumerAmountPickerFragment, ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        m1030invoke$lambda0(consumerAmountPickerFragment, consumerAmountPickerViewState);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1030invoke$lambda0(ConsumerAmountPickerFragment this$0, ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        c.s.b autoTransition;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        if ((view == null ? null : view.findViewById(R.id.currencyPicker)) != null) {
            View view2 = this$0.getView();
            ((CurrencyPickerView) (view2 == null ? null : view2.findViewById(R.id.currencyPicker))).setInsufficientBalance(consumerAmountPickerViewState.isInsufficientBalance());
            View view3 = this$0.getView();
            View findViewById = view3 != null ? view3.findViewById(R.id.ctaContainer) : null;
            autoTransition = this$0.getAutoTransition();
            c.s.a0.b((ViewGroup) findViewById, autoTransition);
        }
    }

    /* renamed from: invoke$lambda-1 */
    public static final void m1031invoke$lambda1(ConsumerAmountPickerFragment this$0, ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        c.s.b autoTransition;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        if ((view == null ? null : view.findViewById(R.id.currencyPicker)) != null) {
            View view2 = this$0.getView();
            ((CurrencyPickerView) (view2 == null ? null : view2.findViewById(R.id.currencyPicker))).setInsufficientBalance(consumerAmountPickerViewState.isInsufficientBalance());
            View view3 = this$0.getView();
            View findViewById = view3 != null ? view3.findViewById(R.id.ctaContainer) : null;
            autoTransition = this$0.getAutoTransition();
            c.s.a0.b((ViewGroup) findViewById, autoTransition);
        }
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        invoke2(consumerAmountPickerViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(final ConsumerAmountPickerViewState consumerAmountPickerViewState) {
        boolean z;
        long shortAnimDuration;
        float nextButtonTranslateAmount;
        ViewPropertyAnimator translationY;
        long shortAnimDuration2;
        long shortAnimDuration3;
        if (!this.$setupOnClickListeners.a && consumerAmountPickerViewState.getWallet() != null) {
            this.this$0.setupOnClickListeners();
            this.$setupOnClickListeners.a = true;
        }
        z = this.this$0.isNextButtonShown;
        if (z != consumerAmountPickerViewState.isNextButtonVisible()) {
            this.this$0.isNextButtonShown = consumerAmountPickerViewState.isNextButtonVisible();
            if (consumerAmountPickerViewState.isNextButtonVisible()) {
                View view = this.this$0.getView();
                View nextButton = view == null ? null : view.findViewById(R.id.nextButton);
                kotlin.jvm.internal.m.f(nextButton, "nextButton");
                shortAnimDuration3 = this.this$0.getShortAnimDuration();
                View_CommonKt.animateOpacity$default(nextButton, 1.0f, shortAnimDuration3, null, 4, null);
                View view2 = this.this$0.getView();
                ViewPropertyAnimator animate = ((LinearLayout) (view2 == null ? null : view2.findViewById(R.id.ctaContainer))).animate();
                final ConsumerAmountPickerFragment consumerAmountPickerFragment = this.this$0;
                translationY = animate.withStartAction(new Runnable() { // from class: com.coinbase.wallet.consumer.views.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConsumerAmountPickerFragment$setupObservers$2.b(ConsumerAmountPickerFragment.this, consumerAmountPickerViewState);
                    }
                }).translationY(0.0f);
            } else {
                View view3 = this.this$0.getView();
                View nextButton2 = view3 == null ? null : view3.findViewById(R.id.nextButton);
                kotlin.jvm.internal.m.f(nextButton2, "nextButton");
                shortAnimDuration = this.this$0.getShortAnimDuration();
                View_CommonKt.animateOpacity$default(nextButton2, 0.0f, shortAnimDuration, null, 4, null);
                View view4 = this.this$0.getView();
                ViewPropertyAnimator animate2 = ((LinearLayout) (view4 == null ? null : view4.findViewById(R.id.ctaContainer))).animate();
                final ConsumerAmountPickerFragment consumerAmountPickerFragment2 = this.this$0;
                ViewPropertyAnimator withEndAction = animate2.withEndAction(new Runnable() { // from class: com.coinbase.wallet.consumer.views.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConsumerAmountPickerFragment$setupObservers$2.a(ConsumerAmountPickerFragment.this, consumerAmountPickerViewState);
                    }
                });
                nextButtonTranslateAmount = this.this$0.getNextButtonTranslateAmount();
                translationY = withEndAction.translationY(nextButtonTranslateAmount);
            }
            shortAnimDuration2 = this.this$0.getShortAnimDuration();
            translationY.setDuration(shortAnimDuration2).start();
        }
        if (consumerAmountPickerViewState.isNextButtonVisible()) {
            View view5 = this.this$0.getView();
            ((ProgressBarButton) (view5 == null ? null : view5.findViewById(R.id.nextButton))).setProgressBarIsVisible(consumerAmountPickerViewState.isNextButtonLoading());
        }
        View view6 = this.this$0.getView();
        View uiMaskView = view6 == null ? null : view6.findViewById(R.id.uiMaskView);
        kotlin.jvm.internal.m.f(uiMaskView, "uiMaskView");
        uiMaskView.setVisibility(!consumerAmountPickerViewState.isMaxButtonLoading() && !consumerAmountPickerViewState.isNextButtonLoading() ? 8 : 0);
        View view7 = this.this$0.getView();
        ((AppCompatTextView) (view7 == null ? null : view7.findViewById(R.id.primaryTextView))).setText(consumerAmountPickerViewState.getPrimaryText());
        View view8 = this.this$0.getView();
        ((AppCompatTextView) (view8 == null ? null : view8.findViewById(R.id.secondaryTextView))).setText(consumerAmountPickerViewState.getSecondaryText());
        this.this$0.setSwapButtonEnabled(consumerAmountPickerViewState.getSwapButtonEnabled());
        View view9 = this.this$0.getView();
        ((NumberKeyboardInputView) (view9 == null ? null : view9.findViewById(R.id.keyboard))).setLocale(consumerAmountPickerViewState.getKeyboardLocale());
        View view10 = this.this$0.getView();
        AppCompatTextView appCompatTextView = (AppCompatTextView) (view10 == null ? null : view10.findViewById(R.id.currencyLabel));
        CurrencyCode currencyCode = consumerAmountPickerViewState.getCurrencyCode();
        String rawValue = currencyCode == null ? null : currencyCode.getRawValue();
        if (rawValue == null) {
            rawValue = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        appCompatTextView.setText(rawValue);
        View view11 = this.this$0.getView();
        ((ProgressBarButtonCircular) (view11 == null ? null : view11.findViewById(R.id.maxButton))).setProgressBarIsVisible(consumerAmountPickerViewState.isMaxButtonLoading());
        View view12 = this.this$0.getView();
        ((ProgressBarButtonCircular) (view12 == null ? null : view12.findViewById(R.id.maxButton))).setEnabled(true ^ consumerAmountPickerViewState.isMaxButtonLoading());
        View view13 = this.this$0.getView();
        ((CurrencyPickerView) (view13 == null ? null : view13.findViewById(R.id.currencyPicker))).setCryptoBalance(consumerAmountPickerViewState.getCryptoBalance());
        View view14 = this.this$0.getView();
        ((CurrencyPickerView) (view14 == null ? null : view14.findViewById(R.id.currencyPicker))).setFiatBalance(consumerAmountPickerViewState.getFiatBalance());
        View view15 = this.this$0.getView();
        ((CurrencyPickerView) (view15 == null ? null : view15.findViewById(R.id.currencyPicker))).setInsufficientBalance(consumerAmountPickerViewState.isInsufficientBalance());
        View view16 = this.this$0.getView();
        View currencyPicker = view16 == null ? null : view16.findViewById(R.id.currencyPicker);
        kotlin.jvm.internal.m.f(currencyPicker, "currencyPicker");
        currencyPicker.setVisibility(consumerAmountPickerViewState.isOnrampEnabled() ? 8 : 0);
        ReceivableWallet wallet = consumerAmountPickerViewState.getWallet();
        if (wallet == null) {
            return;
        }
        View view17 = this.this$0.getView();
        ((CurrencyPickerView) (view17 != null ? view17.findViewById(R.id.currencyPicker) : null)).fillDetails(wallet.getImageURL(), wallet.getCode(), wallet.getName());
    }
}