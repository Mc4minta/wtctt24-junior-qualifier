package com.coinbase.wallet.consumer.views;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.lifecycle.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.View_ConsumerKt;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.TransferMoneyRequest;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSendTwoFactorViewModel;
import com.coinbase.wallet.consumer.views.SimpleAmountInputView;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ConsumerSendTwoFactorFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0007J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>R(\u0010@\u001a\b\u0012\u0004\u0012\u0002030?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001e\u0010L\u001a\n K*\u0004\u0018\u00010J0J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerSendTwoFactorFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "initViewModel", "()V", "initClickListeners", "", "it", "attemptTransfer", "(Ljava/lang/CharSequence;)V", "doErrorAnimation", "", TextBundle.TEXT_ENTRY, "setSubmitEnabled", "(Ljava/lang/String;)V", "switchToLoadingButton", "reset2faText", "switchToContinueButtonAfterError", "setLetterSpacing", "", "throwable", "showSendError", "(Ljava/lang/Throwable;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackspaceClick", "onDecimalClick", "", "number", "onNumberClick", "(I)V", "", "onBackPressed", "()Z", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSendTwoFactorViewModel;", "viewModel", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerSendTwoFactorViewModel;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "selectedTransfer", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "", "originalLetterSpacing", "F", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "sendRequest", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "<init>", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendTwoFactorFragment extends LockedFragment implements SimpleAmountInputView.Listeners, StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final float ENTERING_AMOUNT_LETTER_SPACING = 0.5f;
    private static final int MAX_2FA_LENGTH = 7;
    private static final int MIN_2FA_LENGTH = 6;
    private static final String SELECTED_TRANSFER = "consumer_selected_transfer";
    private static final String SEND_REQUEST = "consumer_send_request";
    private final a0 mainScheduler = h.c.j0.c.a.b();
    private float originalLetterSpacing;
    private AvailableTransfer selectedTransfer;
    private TransferMoneyRequest sendRequest;
    private ConsumerSendTwoFactorViewModel viewModel;
    public GenericViewModelFactory<ConsumerSendTwoFactorViewModel> viewModelFactory;

    /* compiled from: ConsumerSendTwoFactorFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerSendTwoFactorFragment$Companion;", "", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "sendRequest", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "selectedTranfer", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;Lcom/coinbase/wallet/consumer/models/AvailableTransfer;)Landroid/os/Bundle;", "", "ENTERING_AMOUNT_LETTER_SPACING", "F", "", "MAX_2FA_LENGTH", "I", "MIN_2FA_LENGTH", "", "SELECTED_TRANSFER", "Ljava/lang/String;", "SEND_REQUEST", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(TransferMoneyRequest sendRequest, AvailableTransfer selectedTranfer) {
            kotlin.jvm.internal.m.g(sendRequest, "sendRequest");
            kotlin.jvm.internal.m.g(selectedTranfer, "selectedTranfer");
            return androidx.core.os.b.a(kotlin.u.a(ConsumerSendTwoFactorFragment.SEND_REQUEST, sendRequest), kotlin.u.a(ConsumerSendTwoFactorFragment.SELECTED_TRANSFER, selectedTranfer));
        }
    }

    public final void attemptTransfer(CharSequence charSequence) {
        switchToLoadingButton();
        ConsumerSendTwoFactorViewModel consumerSendTwoFactorViewModel = this.viewModel;
        if (consumerSendTwoFactorViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        TransferMoneyRequest transferMoneyRequest = this.sendRequest;
        if (transferMoneyRequest == null) {
            kotlin.jvm.internal.m.w("sendRequest");
            throw null;
        }
        AvailableTransfer availableTransfer = this.selectedTransfer;
        if (availableTransfer != null) {
            b0 onErrorResumeNext = consumerSendTwoFactorViewModel.transfer(transferMoneyRequest, availableTransfer, charSequence.toString()).observeOn(this.mainScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.views.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerSendTwoFactorFragment.e(ConsumerSendTwoFactorFragment.this, (kotlin.x) obj);
                }
            }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.views.m
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerSendTwoFactorFragment.f(ConsumerSendTwoFactorFragment.this, (Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorResumeNext, "viewModel.transfer(sendRequest, selectedTransfer, it.toString())\n            .observeOn(mainScheduler)\n            .map { navigate(R.id.action_consumerSendTwoFactorFragment_to_consumerTransactionInitiatedFragment) }\n            .onErrorResumeNext {\n                switchToContinueButtonAfterError()\n                if (it is ConsumerException.SendNeedsTwoFactor) {\n                    doErrorAnimation()\n                    Single.just(Unit)\n                } else {\n                    reset2faText()\n                    Single.error(it)\n                }\n            }");
            Object as = Single_AnalyticsKt.logError$default(onErrorResumeNext, "Couldn't check amount locally", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.transfer(sendRequest, selectedTransfer, it.toString())\n            .observeOn(mainScheduler)\n            .map { navigate(R.id.action_consumerSendTwoFactorFragment_to_consumerTransactionInitiatedFragment) }\n            .onErrorResumeNext {\n                switchToContinueButtonAfterError()\n                if (it is ConsumerException.SendNeedsTwoFactor) {\n                    doErrorAnimation()\n                    Single.just(Unit)\n                } else {\n                    reset2faText()\n                    Single.error(it)\n                }\n            }\n            .logError(\"Couldn't check amount locally\")\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, new ConsumerSendTwoFactorFragment$attemptTransfer$3(this), null, 2, null);
            return;
        }
        kotlin.jvm.internal.m.w("selectedTransfer");
        throw null;
    }

    /* renamed from: attemptTransfer$lambda-0 */
    public static final kotlin.x m1040attemptTransfer$lambda0(ConsumerSendTwoFactorFragment this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Fragment_CommonKt.navigate$default(this$0, R.id.action_consumerSendTwoFactorFragment_to_consumerTransactionInitiatedFragment, null, null, null, 14, null);
        return kotlin.x.a;
    }

    /* renamed from: attemptTransfer$lambda-1 */
    public static final h0 m1041attemptTransfer$lambda1(ConsumerSendTwoFactorFragment this$0, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.switchToContinueButtonAfterError();
        if (it instanceof ConsumerException.SendNeedsTwoFactor) {
            this$0.doErrorAnimation();
            return b0.just(kotlin.x.a);
        }
        this$0.reset2faText();
        return b0.error(it);
    }

    public static /* synthetic */ void d(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment, ValueAnimator valueAnimator, int i2, ValueAnimator valueAnimator2) {
        m1042doErrorAnimation$lambda3$lambda2(consumerSendTwoFactorFragment, valueAnimator, i2, valueAnimator2);
    }

    @SuppressLint({"AutoDispose"})
    private final void doErrorAnimation() {
        int d2 = androidx.core.content.a.d(requireContext(), R.color.primary_red);
        final int d3 = androidx.core.content.a.d(requireContext(), R.color.primary_blue);
        View view = getView();
        EditText editText = (EditText) (view == null ? null : view.findViewById(R.id.twoFaDisplay));
        if (editText != null) {
            editText.setTextColor(d2);
        }
        View view2 = getView();
        LinearLayout linearLayout = (LinearLayout) (view2 == null ? null : view2.findViewById(R.id.twoFaDisplayContainer));
        if (linearLayout != null) {
            View_ConsumerKt.showInvalidKeyStroke(linearLayout);
        }
        Fragment_CommonKt.toast$default(this, R.string.invalid_verification_code, 0, 2, (Object) null);
        final ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(d2), Integer.valueOf(d3));
        ofObject.setDuration(250L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.consumer.views.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConsumerSendTwoFactorFragment.d(ConsumerSendTwoFactorFragment.this, ofObject, d3, valueAnimator);
            }
        });
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a0 mainScheduler = this.mainScheduler;
        kotlin.jvm.internal.m.f(mainScheduler, "mainScheduler");
        Fragment_CommonKt.withDelay(this, 2L, timeUnit, mainScheduler, new ConsumerSendTwoFactorFragment$doErrorAnimation$1(this, ofObject));
    }

    /* renamed from: doErrorAnimation$lambda-3$lambda-2 */
    public static final void m1042doErrorAnimation$lambda3$lambda2(ConsumerSendTwoFactorFragment this$0, ValueAnimator valueAnimator, int i2, ValueAnimator valueAnimator2) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View findViewById = view == null ? null : view.findViewById(R.id.twoFaDisplay);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ((EditText) findViewById).setTextColor(((Integer) animatedValue).intValue());
        if (kotlin.jvm.internal.m.c(valueAnimator.getAnimatedValue(), Integer.valueOf(i2))) {
            this$0.reset2faText();
        }
    }

    public static /* synthetic */ kotlin.x e(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment, kotlin.x xVar) {
        return m1040attemptTransfer$lambda0(consumerSendTwoFactorFragment, xVar);
    }

    public static /* synthetic */ h0 f(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment, Throwable th) {
        return m1041attemptTransfer$lambda1(consumerSendTwoFactorFragment, th);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void initClickListeners() {
        View view = getView();
        View submit2Fa = view == null ? null : view.findViewById(R.id.submit2Fa);
        kotlin.jvm.internal.m.f(submit2Fa, "submit2Fa");
        View_CommonKt.setOnSingleClickListener$default(submit2Fa, 0L, new ConsumerSendTwoFactorFragment$initClickListeners$1(this), 1, null);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerSendTwoFactorFragment$initClickListeners$2(this), 1, null);
        View view3 = getView();
        ((EditText) (view3 != null ? view3.findViewById(R.id.twoFaDisplay) : null)).addTextChangedListener(new TextWatcher() { // from class: com.coinbase.wallet.consumer.views.ConsumerSendTwoFactorFragment$initClickListeners$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                View view4 = ConsumerSendTwoFactorFragment.this.getView();
                ((EditText) (view4 == null ? null : view4.findViewById(R.id.twoFaDisplay))).setAnimation(AnimationUtils.loadAnimation(ConsumerSendTwoFactorFragment.this.requireContext(), R.anim.fade_in_short));
                View view5 = ConsumerSendTwoFactorFragment.this.getView();
                ((EditText) (view5 != null ? view5.findViewById(R.id.twoFaDisplay) : null)).animate().setDuration(200L).start();
            }
        });
    }

    private final void initViewModel() {
        this.sendRequest = (TransferMoneyRequest) Bundle_CommonKt.requireParcelable(getArguments(), SEND_REQUEST);
        this.selectedTransfer = (AvailableTransfer) Bundle_CommonKt.requireParcelable(getArguments(), SELECTED_TRANSFER);
        androidx.lifecycle.b0 a = new d0(this, getViewModelFactory()).a(ConsumerSendTwoFactorViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (ConsumerSendTwoFactorViewModel) a;
    }

    private final void reset2faText() {
        View view = getView();
        ((EditText) (view == null ? null : view.findViewById(R.id.twoFaDisplay))).setText(Strings_CoreKt.getEmpty(Strings.INSTANCE));
        setLetterSpacing();
    }

    private final void setLetterSpacing() {
        View view = getView();
        Editable text = ((EditText) (view == null ? null : view.findViewById(R.id.twoFaDisplay))).getText();
        kotlin.jvm.internal.m.f(text, "twoFaDisplay.text");
        if (text.length() == 0) {
            View view2 = getView();
            ((EditText) (view2 != null ? view2.findViewById(R.id.twoFaDisplay) : null)).setLetterSpacing(this.originalLetterSpacing);
            return;
        }
        View view3 = getView();
        ((EditText) (view3 != null ? view3.findViewById(R.id.twoFaDisplay) : null)).setLetterSpacing(ENTERING_AMOUNT_LETTER_SPACING);
    }

    private final void setSubmitEnabled(String str) {
        int length = str.length();
        boolean z = false;
        if (6 <= length && length <= 7) {
            z = true;
        }
        View view = getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(R.id.submit2Fa))).setEnabled(z);
    }

    public final void showSendError(Throwable th) {
        if (!(th instanceof ConsumerException.KnownConsumerException)) {
            Fragment_CommonKt.toast(this, R.string.label__consumer_send_error, 1);
            return;
        }
        String localizedMessage = ((ConsumerException.KnownConsumerException) th).getLocalizedMessage();
        kotlin.jvm.internal.m.f(localizedMessage, "throwable.localizedMessage");
        Fragment_CommonKt.toast(this, localizedMessage, 1);
    }

    private final void switchToContinueButtonAfterError() {
        View view = getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(R.id.submit2Fa))).setProgressBarIsVisible(false);
        View view2 = getView();
        ((ProgressBarButton) (view2 == null ? null : view2.findViewById(R.id.submit2Fa))).setBackgroundResource(R.drawable.button_primary);
        View view3 = getView();
        ((ProgressBarButton) (view3 != null ? view3.findViewById(R.id.submit2Fa) : null)).setEnabled(false);
    }

    private final void switchToLoadingButton() {
        View view = getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(R.id.submit2Fa))).setProgressBarIsVisible(true);
        View view2 = getView();
        ((ProgressBarButton) (view2 != null ? view2.findViewById(R.id.submit2Fa) : null)).setEnabled(false);
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final GenericViewModelFactory<ConsumerSendTwoFactorViewModel> getViewModelFactory() {
        GenericViewModelFactory<ConsumerSendTwoFactorViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // com.coinbase.wallet.consumer.views.SimpleAmountInputView.Listeners
    public void onBackspaceClick() {
        String k1;
        View view = getView();
        Editable text = ((EditText) (view == null ? null : view.findViewById(R.id.twoFaDisplay))).getText();
        kotlin.jvm.internal.m.f(text, "twoFaDisplay.text");
        if (text.length() == 0) {
            View view2 = getView();
            LinearLayout linearLayout = (LinearLayout) (view2 == null ? null : view2.findViewById(R.id.twoFaDisplayContainer));
            if (linearLayout != null) {
                View_ConsumerKt.showInvalidKeyStroke(linearLayout);
            }
        }
        View view3 = getView();
        k1 = kotlin.l0.a0.k1(((EditText) (view3 == null ? null : view3.findViewById(R.id.twoFaDisplay))).getText().toString(), 1);
        View view4 = getView();
        ((EditText) (view4 != null ? view4.findViewById(R.id.twoFaDisplay) : null)).setText(k1);
        setSubmitEnabled(k1);
        setLetterSpacing();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_send_two_factor, viewGroup, false);
    }

    @Override // com.coinbase.wallet.consumer.views.SimpleAmountInputView.Listeners
    public void onDecimalClick() {
    }

    @Override // com.coinbase.wallet.consumer.views.SimpleAmountInputView.Listeners
    public void onNumberClick(int i2) {
        View view = getView();
        if (((EditText) (view == null ? null : view.findViewById(R.id.twoFaDisplay))).getText().length() + 1 > 7) {
            View view2 = getView();
            LinearLayout linearLayout = (LinearLayout) (view2 == null ? null : view2.findViewById(R.id.twoFaDisplayContainer));
            if (linearLayout != null) {
                View_ConsumerKt.showInvalidKeyStroke(linearLayout);
            }
        }
        View view3 = getView();
        ((EditText) (view3 == null ? null : view3.findViewById(R.id.twoFaDisplay))).append(String.valueOf(i2));
        View view4 = getView();
        setSubmitEnabled(((EditText) (view4 != null ? view4.findViewById(R.id.twoFaDisplay) : null)).getText().toString());
        setLetterSpacing();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerTransferTwoFaViewed(AnalyticsEvent.Companion));
        initClickListeners();
        initViewModel();
        View view2 = getView();
        ((SimpleAmountInputView) (view2 == null ? null : view2.findViewById(R.id.twoFaInput))).setListeners(this);
        View view3 = getView();
        this.originalLetterSpacing = ((EditText) (view3 == null ? null : view3.findViewById(R.id.twoFaDisplay))).getLetterSpacing();
        View view4 = getView();
        ((ProgressBarButton) (view4 != null ? view4.findViewById(R.id.submit2Fa) : null)).setEnabled(false);
    }

    public final void setViewModelFactory(GenericViewModelFactory<ConsumerSendTwoFactorViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}