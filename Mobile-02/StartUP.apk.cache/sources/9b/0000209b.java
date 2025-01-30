package com.coinbase.wallet.features.send.views;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.i;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.ConfirmationSettings;
import com.coinbase.wallet.features.send.models.SendAmounts;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import com.coinbase.wallet.features.send.viewmodels.ConfirmationViewModel;
import com.toshi.view.custom.ProgressBarButton;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001e\u001a\u00020\u0003*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001e\u001a\u00020\u0003*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010!J\u0019\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J-\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0004\b.\u0010/R$\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010A\u001a\n @*\u0004\u0018\u00010?0?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u0016\u0010D\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00107R\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010M\u001a\u00020H8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR$\u0010R\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bR\u00102\"\u0004\bS\u00104R\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020N8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010P¨\u0006Z"}, d2 = {"Lcom/coinbase/wallet/features/send/views/ConfirmationFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setStyles", "()V", "setElasticity", "sendButtonClicked", "detailsButtonClicked", "minerFeeButtonClicked", "retryButtonClicked", "", "willExpand", "Lh/c/b0;", "updateDetailsView", "(Z)Lh/c/b0;", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "result", "handleConfirmationResult", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;)V", "", ApiConstants.MESSAGE, "handleError", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;Ljava/lang/String;)V", "handleSufficientBalance", "setupViews", "setupOnClicks", "Landroid/widget/ImageView;", "", "tint", "tintColor", "(Landroid/widget/ImageView;I)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "(Landroidx/constraintlayout/widget/ConstraintLayout;I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "newValue", "isSendButtonHidden", "Z", "setSendButtonHidden", "(Z)V", "Landroid/graphics/PointF;", "initialMoveLocation", "Landroid/graphics/PointF;", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "isDetailsShowing", "initialCardLocation", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAnimatingDetails", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "Lkotlin/h;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "isSending", "setSending", "Lcom/coinbase/wallet/features/send/viewmodels/ConfirmationViewModel;", "viewModel", "Lcom/coinbase/wallet/features/send/viewmodels/ConfirmationViewModel;", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConfirmationFragment extends BaseFragment implements StyledFragment {
    private final kotlin.h attributes$delegate;
    private boolean isDetailsShowing;
    private boolean isSendButtonHidden;
    private boolean isSending;
    private ConfirmationViewModel viewModel;
    public ViewModelFactoryWithMap viewModelFactory;
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private final AtomicBoolean isAnimatingDetails = new AtomicBoolean(false);
    private PointF initialCardLocation = new PointF();
    private PointF initialMoveLocation = new PointF();

    public ConfirmationFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new ConfirmationFragment$attributes$2(this));
        this.attributes$delegate = b2;
    }

    public static /* synthetic */ void d(ConfirmationFragment confirmationFragment, ValueAnimator valueAnimator) {
        m1411updateDetailsView$lambda11$lambda10(confirmationFragment, valueAnimator);
    }

    public final void detailsButtonClicked() {
        AnalyticsEvent sendConfirmDetailsHide;
        boolean z = !this.isDetailsShowing;
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            if (!confirmationViewModel.getSettings().isLend()) {
                if (z) {
                    sendConfirmDetailsHide = AnalyticsEvent_ApplicationKt.sendConfirmDetailsShow(AnalyticsEvent.Companion);
                } else {
                    sendConfirmDetailsHide = AnalyticsEvent_ApplicationKt.sendConfirmDetailsHide(AnalyticsEvent.Companion);
                }
                Analytics.INSTANCE.log(sendConfirmDetailsHide);
            }
            View view = getView();
            ((Button) (view != null ? view.findViewById(e.j.a.F1) : null)).setEnabled(false);
            ((com.uber.autodispose.a0) updateDetailsView(z).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.a0
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConfirmationFragment.g(ConfirmationFragment.this, (kotlin.x) obj);
                }
            }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: detailsButtonClicked$lambda-8 */
    public static final void m1406detailsButtonClicked$lambda8(ConfirmationFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.F1))).setEnabled(true);
    }

    public static /* synthetic */ void e(ConfirmationFragment confirmationFragment, kotlin.x xVar) {
        m1409retryButtonClicked$lambda9(confirmationFragment, xVar);
    }

    public static /* synthetic */ void f(ConfirmationFragment confirmationFragment, String str) {
        m1407onViewCreated$lambda5(confirmationFragment, str);
    }

    public static /* synthetic */ void g(ConfirmationFragment confirmationFragment, kotlin.x xVar) {
        m1406detailsButtonClicked$lambda8(confirmationFragment, xVar);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public static /* synthetic */ void h(ConfirmationFragment confirmationFragment, kotlin.x xVar) {
        m1412updateDetailsView$lambda13(confirmationFragment, xVar);
    }

    public final void handleConfirmationResult(SendConfirmationResult sendConfirmationResult) {
        View retryButton;
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            boolean isAdjustableMinerFeeEnabled = confirmationViewModel.isAdjustableMinerFeeEnabled();
            View view = getView();
            View adjustableMinerFeeButton = view == null ? null : view.findViewById(e.j.a.adjustableMinerFeeButton);
            kotlin.jvm.internal.m.f(adjustableMinerFeeButton, "adjustableMinerFeeButton");
            adjustableMinerFeeButton.setVisibility(isAdjustableMinerFeeEnabled ? 0 : 8);
            SendConfirmationState state = sendConfirmationResult.getState();
            if (state instanceof SendConfirmationState.SufficientBalance) {
                View view2 = getView();
                retryButton = view2 != null ? view2.findViewById(e.j.a.Y3) : null;
                kotlin.jvm.internal.m.f(retryButton, "minerFeeContainer");
                retryButton.setVisibility(0);
                handleSufficientBalance(sendConfirmationResult);
                return;
            } else if (state instanceof SendConfirmationState.FeeCalculationFailed) {
                View view3 = getView();
                View minerFeeContainer = view3 == null ? null : view3.findViewById(e.j.a.Y3);
                kotlin.jvm.internal.m.f(minerFeeContainer, "minerFeeContainer");
                minerFeeContainer.setVisibility(isAdjustableMinerFeeEnabled ? 0 : 8);
                View view4 = getView();
                ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.fiatFeeLabel))).setText(sendConfirmationResult.getFiatFee());
                View view5 = getView();
                ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.cryptoFeeLabel))).setText(sendConfirmationResult.getCryptoFee());
                View view6 = getView();
                retryButton = view6 != null ? view6.findViewById(e.j.a.retryButton) : null;
                kotlin.jvm.internal.m.f(retryButton, "retryButton");
                retryButton.setVisibility(0);
                handleError(sendConfirmationResult, sendConfirmationResult.getState().getMessage());
                return;
            } else if (state instanceof SendConfirmationState.InsufficientFee) {
                View view7 = getView();
                View minerFeeContainer2 = view7 == null ? null : view7.findViewById(e.j.a.Y3);
                kotlin.jvm.internal.m.f(minerFeeContainer2, "minerFeeContainer");
                minerFeeContainer2.setVisibility(0);
                View view8 = getView();
                ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.fiatFeeLabel))).setText(sendConfirmationResult.getFiatFee());
                View view9 = getView();
                ((TextView) (view9 == null ? null : view9.findViewById(e.j.a.cryptoFeeLabel))).setText(sendConfirmationResult.getCryptoFee());
                View view10 = getView();
                retryButton = view10 != null ? view10.findViewById(e.j.a.retryButton) : null;
                kotlin.jvm.internal.m.f(retryButton, "retryButton");
                retryButton.setVisibility(8);
                handleError(sendConfirmationResult, sendConfirmationResult.getState().getMessage());
                return;
            } else {
                if (state instanceof SendConfirmationState.InsufficientBalance ? true : state instanceof SendConfirmationState.Error) {
                    View view11 = getView();
                    View minerFeeContainer3 = view11 == null ? null : view11.findViewById(e.j.a.Y3);
                    kotlin.jvm.internal.m.f(minerFeeContainer3, "minerFeeContainer");
                    minerFeeContainer3.setVisibility(isAdjustableMinerFeeEnabled ? 0 : 8);
                    View view12 = getView();
                    ((TextView) (view12 == null ? null : view12.findViewById(e.j.a.fiatFeeLabel))).setText(sendConfirmationResult.getFiatFee());
                    View view13 = getView();
                    ((TextView) (view13 == null ? null : view13.findViewById(e.j.a.cryptoFeeLabel))).setText(sendConfirmationResult.getCryptoFee());
                    View view14 = getView();
                    retryButton = view14 != null ? view14.findViewById(e.j.a.retryButton) : null;
                    kotlin.jvm.internal.m.f(retryButton, "retryButton");
                    retryButton.setVisibility(8);
                    handleError(sendConfirmationResult, sendConfirmationResult.getState().getMessage());
                    return;
                }
                kotlin.jvm.internal.m.c(state, SendConfirmationState.None.INSTANCE);
                return;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void handleError(SendConfirmationResult sendConfirmationResult, String str) {
        View view = getView();
        CharSequence text = ((TextView) (view == null ? null : view.findViewById(e.j.a.t2))).getText();
        kotlin.jvm.internal.m.f(text, "fiatAmountLabel.text");
        if (text.length() == 0) {
            View view2 = getView();
            ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.t2))).setText(sendConfirmationResult.getFiatAmount());
        }
        View view3 = getView();
        CharSequence text2 = ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.a1))).getText();
        kotlin.jvm.internal.m.f(text2, "cryptoAmountLabel.text");
        if (text2.length() == 0) {
            View view4 = getView();
            ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.a1))).setText(sendConfirmationResult.getCryptoAmount());
        }
        View view5 = getView();
        CharSequence text3 = ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.fiatFeeLabel))).getText();
        kotlin.jvm.internal.m.f(text3, "fiatFeeLabel.text");
        if (text3.length() == 0) {
            View view6 = getView();
            ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.fiatFeeLabel))).setText(sendConfirmationResult.getFiatFee());
        }
        View view7 = getView();
        CharSequence text4 = ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.cryptoFeeLabel))).getText();
        kotlin.jvm.internal.m.f(text4, "cryptoFeeLabel.text");
        if (text4.length() == 0) {
            View view8 = getView();
            ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.cryptoFeeLabel))).setText(sendConfirmationResult.getCryptoFee());
        }
        View view9 = getView();
        View activityIndicator = view9 == null ? null : view9.findViewById(e.j.a.f13509h);
        kotlin.jvm.internal.m.f(activityIndicator, "activityIndicator");
        activityIndicator.setVisibility(8);
        View view10 = getView();
        View chevronImageView = view10 == null ? null : view10.findViewById(e.j.a.p0);
        kotlin.jvm.internal.m.f(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(0);
        View view11 = getView();
        View errorLabel = view11 == null ? null : view11.findViewById(e.j.a.h2);
        kotlin.jvm.internal.m.f(errorLabel, "errorLabel");
        errorLabel.setVisibility(0);
        View view12 = getView();
        ((TextView) (view12 == null ? null : view12.findViewById(e.j.a.h2))).setText(str);
        View view13 = getView();
        ((Button) (view13 == null ? null : view13.findViewById(e.j.a.F1))).setEnabled(true);
        View view14 = getView();
        View minerFeeExplainerButton = view14 == null ? null : view14.findViewById(e.j.a.a4);
        kotlin.jvm.internal.m.f(minerFeeExplainerButton, "minerFeeExplainerButton");
        tintColor((ImageView) minerFeeExplainerButton, R.color.primary_red);
        View view15 = getView();
        ((TextView) (view15 == null ? null : view15.findViewById(e.j.a.h4))).setTextColor(e.j.f.m.m(this, R.color.primary_red));
        View view16 = getView();
        ((TextView) (view16 == null ? null : view16.findViewById(e.j.a.fiatFeeLabel))).setTextColor(e.j.f.m.m(this, R.color.primary_red));
        setSendButtonHidden(true);
        ((com.uber.autodispose.a0) updateDetailsView(true).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view17 = getView();
        ((TextView) (view17 != null ? view17.findViewById(e.j.a.K1) : null)).setText(R.string.send_confirm_details);
    }

    private final void handleSufficientBalance(SendConfirmationResult sendConfirmationResult) {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.t2))).setText(sendConfirmationResult.getFiatAmount());
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.a1))).setText(sendConfirmationResult.getCryptoAmount());
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.fiatFeeLabel))).setText(sendConfirmationResult.getFiatFee());
        View view4 = getView();
        ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.cryptoFeeLabel))).setText(sendConfirmationResult.getCryptoFee());
        View view5 = getView();
        View activityIndicator = view5 == null ? null : view5.findViewById(e.j.a.f13509h);
        kotlin.jvm.internal.m.f(activityIndicator, "activityIndicator");
        activityIndicator.setVisibility(8);
        View view6 = getView();
        View chevronImageView = view6 == null ? null : view6.findViewById(e.j.a.p0);
        kotlin.jvm.internal.m.f(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(0);
        View view7 = getView();
        View minerFeeContainer = view7 == null ? null : view7.findViewById(e.j.a.Y3);
        kotlin.jvm.internal.m.f(minerFeeContainer, "minerFeeContainer");
        minerFeeContainer.setVisibility(0);
        View view8 = getView();
        View errorLabel = view8 == null ? null : view8.findViewById(e.j.a.h2);
        kotlin.jvm.internal.m.f(errorLabel, "errorLabel");
        errorLabel.setVisibility(8);
        View view9 = getView();
        View retryButton = view9 == null ? null : view9.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        retryButton.setVisibility(8);
        View view10 = getView();
        ((Button) (view10 == null ? null : view10.findViewById(e.j.a.F1))).setEnabled(true);
        View view11 = getView();
        View minerFeeExplainerButton = view11 == null ? null : view11.findViewById(e.j.a.a4);
        kotlin.jvm.internal.m.f(minerFeeExplainerButton, "minerFeeExplainerButton");
        tintColor((ImageView) minerFeeExplainerButton, R.color.primary_blue);
        View view12 = getView();
        ((TextView) (view12 == null ? null : view12.findViewById(e.j.a.h4))).setTextColor(e.j.f.m.m(this, R.color.grey_30));
        View view13 = getView();
        ((TextView) (view13 == null ? null : view13.findViewById(e.j.a.fiatFeeLabel))).setTextColor(e.j.f.m.m(this, R.color.primary_black));
        setSendButtonHidden(false);
        View view14 = getView();
        ((TextView) (view14 != null ? view14.findViewById(e.j.a.K1) : null)).setText(R.string.send_confirm_details);
    }

    public static /* synthetic */ void i(ConfirmationFragment confirmationFragment, String str) {
        m1408onViewCreated$lambda6(confirmationFragment, str);
    }

    public static /* synthetic */ boolean j(float f2, ConfirmationFragment confirmationFragment, float f3, View view, MotionEvent motionEvent) {
        return m1410setElasticity$lambda7(f2, confirmationFragment, f3, view, motionEvent);
    }

    public final void minerFeeButtonClicked() {
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            confirmationViewModel.presentMinerFee();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* renamed from: onViewCreated$lambda-5 */
    public static final void m1407onViewCreated$lambda5(ConfirmationFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.annualInterestAmount))).setText(str);
    }

    /* renamed from: onViewCreated$lambda-6 */
    public static final void m1408onViewCreated$lambda6(ConfirmationFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.minerFeeExplainerText))).setText(str);
    }

    public final void retryButtonClicked() {
        View view = getView();
        View activityIndicator = view == null ? null : view.findViewById(e.j.a.f13509h);
        kotlin.jvm.internal.m.f(activityIndicator, "activityIndicator");
        activityIndicator.setVisibility(0);
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.F1))).setEnabled(false);
        View view3 = getView();
        View chevronImageView = view3 == null ? null : view3.findViewById(e.j.a.p0);
        kotlin.jvm.internal.m.f(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(8);
        View view4 = getView();
        View minerFeeExplainerButton = view4 == null ? null : view4.findViewById(e.j.a.a4);
        kotlin.jvm.internal.m.f(minerFeeExplainerButton, "minerFeeExplainerButton");
        tintColor((ImageView) minerFeeExplainerButton, R.color.grey_30);
        ((com.uber.autodispose.a0) updateDetailsView(false).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.y
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ConfirmationFragment.e(ConfirmationFragment.this, (kotlin.x) obj);
            }
        }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            ConfirmationViewModel.fetchReceiptInformation$default(confirmationViewModel, null, 1, null);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* renamed from: retryButtonClicked$lambda-9 */
    public static final void m1409retryButtonClicked$lambda9(ConfirmationFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.F1))).setEnabled(true);
    }

    public final void sendButtonClicked() {
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            if (!confirmationViewModel.getSettings().isLend()) {
                Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendConfirmSendSelected(AnalyticsEvent.Companion));
            }
            setSending(true);
            ConfirmationViewModel confirmationViewModel2 = this.viewModel;
            if (confirmationViewModel2 != null) {
                Object as = confirmationViewModel2.unlock().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.unlock()\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new ConfirmationFragment$sendButtonClicked$1(this), new ConfirmationFragment$sendButtonClicked$2(this));
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void setElasticity() {
        View view = getView();
        ((ConstraintLayout) (view == null ? null : view.findViewById(e.j.a.K0))).setHapticFeedbackEnabled(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float f2 = displayMetrics.heightPixels;
        final float f3 = displayMetrics.widthPixels;
        View view2 = getView();
        ((ConstraintLayout) (view2 != null ? view2.findViewById(e.j.a.K0) : null)).setOnTouchListener(new View.OnTouchListener() { // from class: com.coinbase.wallet.features.send.views.d0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return ConfirmationFragment.j(f3, this, f2, view3, motionEvent);
            }
        });
    }

    /* renamed from: setElasticity$lambda-7 */
    public static final boolean m1410setElasticity$lambda7(float f2, ConfirmationFragment this$0, float f3, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.initialMoveLocation.set(motionEvent.getRawX(), motionEvent.getRawY());
            this$0.initialCardLocation.set(view.getX(), view.getY());
        } else if (action == 1) {
            view.animate().translationY(0.0f).translationX(0.0f).setDuration(100L).start();
        } else if (action != 2) {
            return false;
        } else {
            if (motionEvent.getRawX() <= 0.0f) {
                f2 = 0.0f;
            } else if (motionEvent.getRawX() < f2) {
                f2 = motionEvent.getRawX();
            }
            float f4 = f2 - this$0.initialMoveLocation.x;
            if (motionEvent.getRawY() <= 0.0f) {
                f3 = 0.0f;
            } else if (motionEvent.getRawY() < f3) {
                f3 = motionEvent.getRawY();
            }
            view.setX((f4 / 4.0f) + this$0.initialCardLocation.x);
            view.setY(((f3 - this$0.initialMoveLocation.y) / 4.0f) + this$0.initialCardLocation.y);
        }
        return true;
    }

    private final void setSendButtonHidden(boolean z) {
        setSending(false);
        View view = getView();
        View proceedButton = view == null ? null : view.findViewById(e.j.a.a5);
        kotlin.jvm.internal.m.f(proceedButton, "proceedButton");
        proceedButton.setVisibility(z ? 4 : 0);
        this.isSendButtonHidden = z;
    }

    public final void setSending(boolean z) {
        View view = getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.a5))).setEnabled(!z);
        View view2 = getView();
        ((ProgressBarButton) (view2 == null ? null : view2.findViewById(e.j.a.a5))).setProgressBarIsVisible(z);
        View view3 = getView();
        ((ImageButton) (view3 != null ? view3.findViewById(e.j.a.t0) : null)).setEnabled(!z);
        this.isSending = z;
    }

    private final void setStyles() {
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            ConfirmationSettings settings = confirmationViewModel.getSettings();
            View view = getView();
            View backgroundImage = view == null ? null : view.findViewById(e.j.a.backgroundImage);
            kotlin.jvm.internal.m.f(backgroundImage, "backgroundImage");
            backgroundImage.setVisibility(settings.isLend() ? 4 : 0);
            View view2 = getView();
            View confirmationCard = view2 == null ? null : view2.findViewById(e.j.a.K0);
            kotlin.jvm.internal.m.f(confirmationCard, "confirmationCard");
            tintColor((ConstraintLayout) confirmationCard, settings.getContainerViewColor());
            View view3 = getView();
            View detailsBar = view3 == null ? null : view3.findViewById(e.j.a.E1);
            kotlin.jvm.internal.m.f(detailsBar, "detailsBar");
            tintColor((ConstraintLayout) detailsBar, settings.getContainerViewColor());
            View view4 = getView();
            ((ProgressBarButton) (view4 == null ? null : view4.findViewById(e.j.a.a5))).setBackground(e.j.f.m.n(this, settings.getProceedButtonBackground()));
            Integer a = e.j.f.m.a(this, settings.getFiatAmountTextColor());
            if (a != null) {
                int intValue = a.intValue();
                View view5 = getView();
                ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.t2))).setTextColor(intValue);
            }
            Integer a2 = e.j.f.m.a(this, settings.getCryptoAmountTextColor());
            if (a2 != null) {
                int intValue2 = a2.intValue();
                View view6 = getView();
                ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.a1))).setTextColor(intValue2);
            }
            Integer a3 = e.j.f.m.a(this, settings.getRecipientTextColor());
            if (a3 != null) {
                int intValue3 = a3.intValue();
                View view7 = getView();
                ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.recipientTitle))).setTextColor(intValue3);
                View view8 = getView();
                ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.recipientSubtitle))).setTextColor(intValue3);
                View view9 = getView();
                ((TextView) (view9 == null ? null : view9.findViewById(e.j.a.K1))).setTextColor(intValue3);
                View view10 = getView();
                ((ProgressBar) (view10 == null ? null : view10.findViewById(e.j.a.f13509h))).getIndeterminateDrawable().setColorFilter(intValue3, PorterDuff.Mode.SRC_IN);
            }
            View view11 = getView();
            View recipientSubtitle = view11 == null ? null : view11.findViewById(e.j.a.recipientSubtitle);
            kotlin.jvm.internal.m.f(recipientSubtitle, "recipientSubtitle");
            recipientSubtitle.setVisibility(settings.isLend() ^ true ? 0 : 8);
            View view12 = getView();
            View detailsDivider = view12 == null ? null : view12.findViewById(e.j.a.H1);
            kotlin.jvm.internal.m.f(detailsDivider, "detailsDivider");
            detailsDivider.setVisibility(settings.isLend() ? 0 : 8);
            View view13 = getView();
            View providerIcon = view13 == null ? null : view13.findViewById(e.j.a.providerIcon);
            kotlin.jvm.internal.m.f(providerIcon, "providerIcon");
            providerIcon.setVisibility(settings.isLend() ? 0 : 8);
            View view14 = getView();
            View annualInterestContainer = view14 == null ? null : view14.findViewById(e.j.a.annualInterestContainer);
            kotlin.jvm.internal.m.f(annualInterestContainer, "annualInterestContainer");
            annualInterestContainer.setVisibility(settings.getHideAnnualInterest() ^ true ? 0 : 8);
            View view15 = getView();
            ((ProgressBarButton) (view15 == null ? null : view15.findViewById(e.j.a.a5))).setProgressBarText(settings.getProceedButtonText());
            View view16 = getView();
            ((TextView) (view16 == null ? null : view16.findViewById(e.j.a.k4))).setText(settings.getModeText());
            View view17 = getView();
            ((TextView) (view17 == null ? null : view17.findViewById(e.j.a.toLabel))).setText(settings.getToLabelText());
            ConfirmationViewModel confirmationViewModel2 = this.viewModel;
            if (confirmationViewModel2 == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.o<URL, Integer> iconImage = confirmationViewModel2.getSettings().getIconImage();
            URL a4 = iconImage.a();
            Integer b2 = iconImage.b();
            if (b2 != null) {
                View view18 = getView();
                ((ImageView) (view18 != null ? view18.findViewById(e.j.a.R0) : null)).setImageDrawable(e.j.f.m.n(this, b2.intValue()));
                return;
            } else if (a4 != null) {
                RequestBuilder<Drawable> load = Glide.with(this).load(a4);
                View view19 = getView();
                load.into((ImageView) (view19 != null ? view19.findViewById(e.j.a.providerIcon) : null));
                return;
            } else {
                return;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void setupOnClicks() {
        View view = getView();
        View detailsButton = view == null ? null : view.findViewById(e.j.a.F1);
        kotlin.jvm.internal.m.f(detailsButton, "detailsButton");
        View_CommonKt.setOnSingleClickListener$default(detailsButton, 0L, new ConfirmationFragment$setupOnClicks$1(this), 1, null);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConfirmationFragment$setupOnClicks$2(this), 1, null);
        View view3 = getView();
        View proceedButton = view3 == null ? null : view3.findViewById(e.j.a.a5);
        kotlin.jvm.internal.m.f(proceedButton, "proceedButton");
        View_CommonKt.setOnSingleClickListener$default(proceedButton, 0L, new ConfirmationFragment$setupOnClicks$3(this), 1, null);
        View view4 = getView();
        View minerFeeExplainerContainer = view4 == null ? null : view4.findViewById(e.j.a.minerFeeExplainerContainer);
        kotlin.jvm.internal.m.f(minerFeeExplainerContainer, "minerFeeExplainerContainer");
        View_CommonKt.setOnSingleClickListener$default(minerFeeExplainerContainer, 0L, new ConfirmationFragment$setupOnClicks$4(this), 1, null);
        View view5 = getView();
        View retryButton = view5 == null ? null : view5.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        View_CommonKt.setOnSingleClickListener$default(retryButton, 0L, new ConfirmationFragment$setupOnClicks$5(this), 1, null);
        View view6 = getView();
        View adjustableMinerFeeButton = view6 != null ? view6.findViewById(e.j.a.adjustableMinerFeeButton) : null;
        kotlin.jvm.internal.m.f(adjustableMinerFeeButton, "adjustableMinerFeeButton");
        View_CommonKt.setOnSingleClickListener$default(adjustableMinerFeeButton, 0L, new ConfirmationFragment$setupOnClicks$6(this), 1, null);
    }

    private final void setupViews() {
        List j2;
        List c2;
        setStyles();
        j2 = kotlin.a0.r.j(Integer.valueOf((int) R.drawable.bg_send_card_pattern_1), Integer.valueOf((int) R.drawable.bg_send_card_pattern_2), Integer.valueOf((int) R.drawable.bg_send_card_pattern_3));
        c2 = kotlin.a0.q.c(j2);
        int intValue = ((Number) kotlin.a0.p.Y(c2)).intValue();
        View view = getView();
        ((ImageView) (view == null ? null : view.findViewById(e.j.a.backgroundImage))).setImageResource(intValue);
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            h.c.b0<SendAmounts> observeOn = confirmationViewModel.getSendAmounts().observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.sendAmounts\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.sendAmounts\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new ConfirmationFragment$setupViews$2(this), 1, null);
            ConfirmationViewModel confirmationViewModel2 = this.viewModel;
            if (confirmationViewModel2 != null) {
                Object as2 = Observable_AnalyticsKt.logError$default(confirmationViewModel2.getNavigationObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.navigationObservable\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConfirmationFragment$setupViews$3(this), 3, null);
                View view2 = getView();
                ((ImageView) (view2 == null ? null : view2.findViewById(e.j.a.backgroundImage))).setClipToOutline(true);
                View view3 = getView();
                TextView textView = (TextView) (view3 == null ? null : view3.findViewById(e.j.a.recipientTitle));
                ConfirmationViewModel confirmationViewModel3 = this.viewModel;
                if (confirmationViewModel3 != null) {
                    textView.setText(confirmationViewModel3.getRecipientTitle());
                    View view4 = getView();
                    TextView textView2 = (TextView) (view4 == null ? null : view4.findViewById(e.j.a.recipientSubtitle));
                    ConfirmationViewModel confirmationViewModel4 = this.viewModel;
                    if (confirmationViewModel4 != null) {
                        textView2.setText(confirmationViewModel4.getRecipientSubtitle());
                        View view5 = getView();
                        ((Button) (view5 != null ? view5.findViewById(e.j.a.F1) : null)).setEnabled(false);
                        return;
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void tintColor(ImageView imageView, int i2) {
        imageView.setImageTintList(androidx.core.content.a.e(requireContext(), i2));
    }

    @SuppressLint({"AutoDispose"})
    public final h.c.b0<kotlin.x> updateDetailsView(boolean z) {
        int intValue;
        h.c.b0 collapse$default;
        this.isDetailsShowing = z;
        if (this.isAnimatingDetails.getAndSet(true)) {
            h.c.b0<kotlin.x> observeOn = h.c.b0.just(kotlin.x.a).subscribeOn(this.mainScheduler).observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "just(Unit)\n                .subscribeOn(mainScheduler)\n                .observeOn(mainScheduler)");
            return observeOn;
        }
        View view = getView();
        ColorStateList backgroundTintList = ((ConstraintLayout) (view == null ? null : view.findViewById(e.j.a.E1))).getBackgroundTintList();
        Integer valueOf = backgroundTintList == null ? null : Integer.valueOf(backgroundTintList.getDefaultColor());
        if (valueOf == null) {
            ConfirmationViewModel confirmationViewModel = this.viewModel;
            if (confirmationViewModel == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            intValue = confirmationViewModel.detailsContainerColor(z);
        } else {
            intValue = valueOf.intValue();
        }
        Context requireContext = requireContext();
        ConfirmationViewModel confirmationViewModel2 = this.viewModel;
        if (confirmationViewModel2 != null) {
            int d2 = androidx.core.content.a.d(requireContext, confirmationViewModel2.detailsContainerColor(!z));
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(150L);
            valueAnimator.setIntValues(intValue, d2);
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.features.send.views.x
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ConfirmationFragment.d(ConfirmationFragment.this, valueAnimator2);
                }
            });
            valueAnimator.start();
            if (z) {
                View view2 = getView();
                int height = ((LinearLayout) (view2 == null ? null : view2.findViewById(e.j.a.J1))).getHeight();
                View view3 = getView();
                View detailsTab = view3 == null ? null : view3.findViewById(e.j.a.J1);
                kotlin.jvm.internal.m.f(detailsTab, "detailsTab");
                collapse$default = View_CommonKt.expand$default(detailsTab, true, null, height, 0L, 10, null);
            } else {
                View view4 = getView();
                View detailsTab2 = view4 == null ? null : view4.findViewById(e.j.a.J1);
                kotlin.jvm.internal.m.f(detailsTab2, "detailsTab");
                collapse$default = View_CommonKt.collapse$default(detailsTab2, true, 0L, 2, null);
            }
            View view5 = getView();
            TextView textView = (TextView) (view5 == null ? null : view5.findViewById(e.j.a.K1));
            Context requireContext2 = requireContext();
            ConfirmationViewModel confirmationViewModel3 = this.viewModel;
            if (confirmationViewModel3 != null) {
                textView.setTextColor(androidx.core.content.a.d(requireContext2, confirmationViewModel3.detailsTextColor(z)));
                View view6 = getView();
                ImageView imageView = (ImageView) (view6 == null ? null : view6.findViewById(e.j.a.p0));
                kotlin.jvm.internal.m.f(imageView, "");
                ConfirmationViewModel confirmationViewModel4 = this.viewModel;
                if (confirmationViewModel4 != null) {
                    tintColor(imageView, confirmationViewModel4.detailsTextColor(z));
                    imageView.animate().rotation(z ? 180.0f : 0.0f).setDuration(100L).start();
                    h.c.b0<kotlin.x> observeOn2 = collapse$default.doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.b0
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            ConfirmationFragment.h(ConfirmationFragment.this, (kotlin.x) obj);
                        }
                    }).subscribeOn(this.mainScheduler).observeOn(this.mainScheduler);
                    kotlin.jvm.internal.m.f(observeOn2, "single\n            .doOnSuccess { isAnimatingDetails.set(false) }\n            .subscribeOn(mainScheduler)\n            .observeOn(mainScheduler)");
                    return observeOn2;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: updateDetailsView$lambda-11$lambda-10 */
    public static final void m1411updateDetailsView$lambda11$lambda10(ConfirmationFragment this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        if ((view == null ? null : view.findViewById(e.j.a.E1)) != null) {
            View view2 = this$0.getView();
            View findViewById = view2 != null ? view2.findViewById(e.j.a.E1) : null;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            ((ConstraintLayout) findViewById).setBackgroundTintList(ColorStateList.valueOf(((Integer) animatedValue).intValue()));
        }
    }

    /* renamed from: updateDetailsView$lambda-13 */
    public static final void m1412updateDetailsView$lambda13(ConfirmationFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.isAnimatingDetails.set(false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final ViewModelFactoryWithMap getViewModelFactory$app_productionRelease() {
        ViewModelFactoryWithMap viewModelFactoryWithMap = this.viewModelFactory;
        if (viewModelFactoryWithMap != null) {
            return viewModelFactoryWithMap;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String name = ConfirmationViewModel.class.getName();
        kotlin.jvm.internal.m.f(name, "ConfirmationViewModel::class.java.name");
        Serializable c2 = e.j.f.e.c(arguments, name);
        if (c2 != null) {
            if (c2 instanceof Class) {
                Class cls = (Class) c2;
                if (ConfirmationViewModel.class.isAssignableFrom(cls)) {
                    androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(cls);
                    kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory)\n            .get(clazz)");
                    ConfirmationViewModel confirmationViewModel = (ConfirmationViewModel) a;
                    Bundle requireArguments = requireArguments();
                    kotlin.jvm.internal.m.f(requireArguments, "requireArguments()");
                    confirmationViewModel.setArgs(requireArguments);
                    kotlin.x xVar = kotlin.x.a;
                    this.viewModel = confirmationViewModel;
                    return;
                }
            }
            throw new IllegalStateException("Class " + c2 + " is not assignable from " + ConfirmationViewModel.class);
        }
        throw new IllegalStateException("Class this is null");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_confirmation, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"AutoDispose"})
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        h.c.s<AdjustableMinerFeeSelection> minerFeeResultObservable = Fragment_CommonKt.getNavigationResult(this, AdjustableMinerFeeArgs.INSTANCE.getResultKey()).toObservable();
        ConfirmationViewModel confirmationViewModel = this.viewModel;
        if (confirmationViewModel != null) {
            kotlin.jvm.internal.m.f(minerFeeResultObservable, "minerFeeResultObservable");
            confirmationViewModel.setup(minerFeeResultObservable);
            setupViews();
            setupOnClicks();
            setElasticity();
            ConfirmationViewModel confirmationViewModel2 = this.viewModel;
            if (confirmationViewModel2 != null) {
                Object as = confirmationViewModel2.getSendConfirmationObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.sendConfirmationObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConfirmationFragment$onViewCreated$1(this), 3, null);
                ConfirmationViewModel confirmationViewModel3 = this.viewModel;
                if (confirmationViewModel3 != null) {
                    Object as2 = confirmationViewModel3.getNavigateToSendCompleteViewObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as2, "viewModel.navigateToSendCompleteViewObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConfirmationFragment$onViewCreated$2(this), 3, null);
                    ConfirmationViewModel confirmationViewModel4 = this.viewModel;
                    if (confirmationViewModel4 != null) {
                        Object as3 = confirmationViewModel4.getPromptObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as3, "viewModel.promptObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConfirmationFragment$onViewCreated$3(this), 3, null);
                        ConfirmationViewModel confirmationViewModel5 = this.viewModel;
                        if (confirmationViewModel5 != null) {
                            Object as4 = confirmationViewModel5.getExpandCardObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                            kotlin.jvm.internal.m.f(as4, "viewModel.expandCardObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new ConfirmationFragment$onViewCreated$4(this), 3, null);
                            ConfirmationViewModel confirmationViewModel6 = this.viewModel;
                            if (confirmationViewModel6 != null) {
                                ConfirmationViewModel.fetchReceiptInformation$default(confirmationViewModel6, null, 1, null);
                                ConfirmationViewModel confirmationViewModel7 = this.viewModel;
                                if (confirmationViewModel7 != null) {
                                    h.c.s<String> observeOn = confirmationViewModel7.getAnnualInterestObservable().observeOn(this.mainScheduler);
                                    kotlin.jvm.internal.m.f(observeOn, "viewModel.annualInterestObservable\n            .observeOn(mainScheduler)");
                                    ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.z
                                        @Override // h.c.m0.f
                                        public final void accept(Object obj) {
                                            ConfirmationFragment.f(ConfirmationFragment.this, (String) obj);
                                        }
                                    });
                                    ConfirmationViewModel confirmationViewModel8 = this.viewModel;
                                    if (confirmationViewModel8 != null) {
                                        h.c.s<String> observeOn2 = confirmationViewModel8.getMinerFeeExplainerObservable().observeOn(this.mainScheduler);
                                        kotlin.jvm.internal.m.f(observeOn2, "viewModel.minerFeeExplainerObservable\n            .observeOn(mainScheduler)");
                                        ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.c0
                                            @Override // h.c.m0.f
                                            public final void accept(Object obj) {
                                                ConfirmationFragment.i(ConfirmationFragment.this, (String) obj);
                                            }
                                        });
                                        return;
                                    }
                                    kotlin.jvm.internal.m.w("viewModel");
                                    throw null;
                                }
                                kotlin.jvm.internal.m.w("viewModel");
                                throw null;
                            }
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void setViewModelFactory$app_productionRelease(ViewModelFactoryWithMap viewModelFactoryWithMap) {
        kotlin.jvm.internal.m.g(viewModelFactoryWithMap, "<set-?>");
        this.viewModelFactory = viewModelFactoryWithMap;
    }

    private final void tintColor(ConstraintLayout constraintLayout, int i2) {
        constraintLayout.setBackgroundTintList(androidx.core.content.a.e(requireContext(), i2));
    }
}