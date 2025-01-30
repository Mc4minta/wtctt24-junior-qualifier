package com.coinbase.wallet.features.swap.views;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.z;
import c.h.k.d0;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.swap.models.SwapConfirmationError;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewState;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import com.uber.autodispose.a0;
import com.uber.autodispose.d;
import com.uber.autodispose.y;
import h.c.b0;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.h;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010'¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapConfirmationFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupViews", "()V", "setupObservables", "Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", ApiConstants.STATE, "", "handleErrorState", "(Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;)Ljava/lang/Object;", "setElasticity", "", "willExpand", "updateDetailsView", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/uber/autodispose/y;", "getScopeProvider", "()Lcom/uber/autodispose/y;", "scopeProvider", "Landroid/graphics/PointF;", "initialMoveLocation", "Landroid/graphics/PointF;", "initialCardLocation", "", "defaultFeeLabelColor", "I", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel;", "viewModel$delegate", "Lkotlin/h;", "getViewModel", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel;", "viewModel", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$Factory;", "getViewModelFactory", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$Factory;", "setViewModelFactory", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$Factory;)V", "", "shortAnimDuration$delegate", "getShortAnimDuration", "()J", "shortAnimDuration", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "defaultFeeIconColor", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationFragment extends BaseFragment implements StyledFragment {
    private int defaultFeeIconColor;
    private int defaultFeeLabelColor;
    private PointF initialCardLocation;
    private PointF initialMoveLocation;
    private final h shortAnimDuration$delegate;
    private final h viewModel$delegate = z.a(this, e0.b(SwapConfirmationViewModel.class), new SwapConfirmationFragment$special$$inlined$viewModel$3(new SwapConfirmationFragment$special$$inlined$viewModel$2(this)), new SwapConfirmationFragment$special$$inlined$viewModel$1(this, this));
    public SwapConfirmationViewModel.Factory viewModelFactory;

    public SwapConfirmationFragment() {
        h b2;
        b2 = k.b(new SwapConfirmationFragment$shortAnimDuration$2(this));
        this.shortAnimDuration$delegate = b2;
        this.initialCardLocation = new PointF();
        this.initialMoveLocation = new PointF();
    }

    public static /* synthetic */ boolean d(float f2, SwapConfirmationFragment swapConfirmationFragment, float f3, View view, MotionEvent motionEvent) {
        return m1510setElasticity$lambda2(f2, swapConfirmationFragment, f3, view, motionEvent);
    }

    private final y getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final long getShortAnimDuration() {
        return ((Number) this.shortAnimDuration$delegate.getValue()).longValue();
    }

    public final SwapConfirmationViewModel getViewModel() {
        return (SwapConfirmationViewModel) this.viewModel$delegate.getValue();
    }

    public final Object handleErrorState(SwapConfirmationViewState swapConfirmationViewState) {
        View errorLabel;
        SwapConfirmationError error = swapConfirmationViewState.getError();
        if (error instanceof SwapConfirmationError.InsufficientFee) {
            View view = getView();
            View minerFeeContainer = view == null ? null : view.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer, "minerFeeContainer");
            minerFeeContainer.setVisibility(0);
            View view2 = getView();
            View coinbaseFeeContainer = view2 == null ? null : view2.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer, "coinbaseFeeContainer");
            coinbaseFeeContainer.setVisibility(0);
            ColorStateList valueOf = ColorStateList.valueOf(requireContext().getColor(R.color.primary_red));
            m.f(valueOf, "valueOf(requireContext().getColor(R.color.primary_red))");
            View view3 = getView();
            ((ImageView) (view3 == null ? null : view3.findViewById(e.j.a.minerFeeInfoButton))).setImageTintList(valueOf);
            View view4 = getView();
            ((ImageView) (view4 == null ? null : view4.findViewById(e.j.a.coinbaseFeeInfoButton))).setImageTintList(valueOf);
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.minerFeeTitle))).setTextColor(valueOf);
            View view6 = getView();
            ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.coinbaseFeeTitle))).setTextColor(valueOf);
            View view7 = getView();
            View retryButton = view7 == null ? null : view7.findViewById(e.j.a.retryButton);
            m.f(retryButton, "retryButton");
            retryButton.setVisibility(8);
            View view8 = getView();
            View errorTitle = view8 == null ? null : view8.findViewById(e.j.a.errorTitle);
            m.f(errorTitle, "errorTitle");
            errorTitle.setVisibility(8);
            View view9 = getView();
            View errorLabel2 = view9 == null ? null : view9.findViewById(e.j.a.h2);
            m.f(errorLabel2, "errorLabel");
            errorLabel2.setVisibility(0);
            View view10 = getView();
            ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.h2))).setText(swapConfirmationViewState.getError().getMessage());
            View view11 = getView();
            errorLabel = view11 != null ? view11.findViewById(e.j.a.priceImpactInfoButton) : null;
            m.f(errorLabel, "priceImpactInfoButton");
            errorLabel.setVisibility(8);
            return x.a;
        } else if (error instanceof SwapConfirmationError.FeeCalculationFailed) {
            View view12 = getView();
            View minerFeeContainer2 = view12 == null ? null : view12.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer2, "minerFeeContainer");
            minerFeeContainer2.setVisibility(8);
            View view13 = getView();
            View coinbaseFeeContainer2 = view13 == null ? null : view13.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer2, "coinbaseFeeContainer");
            coinbaseFeeContainer2.setVisibility(8);
            View view14 = getView();
            View retryButton2 = view14 == null ? null : view14.findViewById(e.j.a.retryButton);
            m.f(retryButton2, "retryButton");
            retryButton2.setVisibility(0);
            View view15 = getView();
            View errorTitle2 = view15 == null ? null : view15.findViewById(e.j.a.errorTitle);
            m.f(errorTitle2, "errorTitle");
            errorTitle2.setVisibility(8);
            View view16 = getView();
            View errorLabel3 = view16 == null ? null : view16.findViewById(e.j.a.h2);
            m.f(errorLabel3, "errorLabel");
            errorLabel3.setVisibility(0);
            View view17 = getView();
            ((TextView) (view17 == null ? null : view17.findViewById(e.j.a.h2))).setText(swapConfirmationViewState.getError().getMessage());
            View view18 = getView();
            errorLabel = view18 != null ? view18.findViewById(e.j.a.priceImpactInfoButton) : null;
            m.f(errorLabel, "priceImpactInfoButton");
            errorLabel.setVisibility(8);
            return x.a;
        } else if (error instanceof SwapConfirmationError.InsufficientBalance) {
            View view19 = getView();
            View minerFeeContainer3 = view19 == null ? null : view19.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer3, "minerFeeContainer");
            minerFeeContainer3.setVisibility(8);
            View view20 = getView();
            View coinbaseFeeContainer3 = view20 == null ? null : view20.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer3, "coinbaseFeeContainer");
            coinbaseFeeContainer3.setVisibility(8);
            View view21 = getView();
            View retryButton3 = view21 == null ? null : view21.findViewById(e.j.a.retryButton);
            m.f(retryButton3, "retryButton");
            retryButton3.setVisibility(8);
            View view22 = getView();
            View errorTitle3 = view22 == null ? null : view22.findViewById(e.j.a.errorTitle);
            m.f(errorTitle3, "errorTitle");
            errorTitle3.setVisibility(0);
            View view23 = getView();
            ((TextView) (view23 == null ? null : view23.findViewById(e.j.a.errorTitle))).setText(getString(R.string.miner_fee));
            View view24 = getView();
            View errorLabel4 = view24 == null ? null : view24.findViewById(e.j.a.h2);
            m.f(errorLabel4, "errorLabel");
            errorLabel4.setVisibility(0);
            View view25 = getView();
            ((TextView) (view25 == null ? null : view25.findViewById(e.j.a.h2))).setText(swapConfirmationViewState.getError().getMessage());
            View view26 = getView();
            errorLabel = view26 != null ? view26.findViewById(e.j.a.priceImpactInfoButton) : null;
            m.f(errorLabel, "priceImpactInfoButton");
            errorLabel.setVisibility(8);
            return x.a;
        } else if (error instanceof SwapConfirmationError.HighPriceImpactWarning) {
            View view27 = getView();
            View minerFeeContainer4 = view27 == null ? null : view27.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer4, "minerFeeContainer");
            minerFeeContainer4.setVisibility(0);
            View view28 = getView();
            View coinbaseFeeContainer4 = view28 == null ? null : view28.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer4, "coinbaseFeeContainer");
            coinbaseFeeContainer4.setVisibility(0);
            View view29 = getView();
            View errorTitle4 = view29 == null ? null : view29.findViewById(e.j.a.errorTitle);
            m.f(errorTitle4, "errorTitle");
            errorTitle4.setVisibility(0);
            View view30 = getView();
            ((TextView) (view30 == null ? null : view30.findViewById(e.j.a.errorTitle))).setText(getString(R.string.swap_confirmation_error_high_price_impact));
            View view31 = getView();
            View errorLabel5 = view31 == null ? null : view31.findViewById(e.j.a.h2);
            m.f(errorLabel5, "errorLabel");
            errorLabel5.setVisibility(0);
            View view32 = getView();
            ((TextView) (view32 == null ? null : view32.findViewById(e.j.a.h2))).setText(swapConfirmationViewState.getError().getMessage());
            View view33 = getView();
            View priceImpactInfoButton = view33 == null ? null : view33.findViewById(e.j.a.priceImpactInfoButton);
            m.f(priceImpactInfoButton, "priceImpactInfoButton");
            priceImpactInfoButton.setVisibility(0);
            View view34 = getView();
            ((ProgressBarButton) (view34 == null ? null : view34.findViewById(e.j.a.convertButton))).setClickable(false);
            View view35 = getView();
            View convertButton = view35 == null ? null : view35.findViewById(e.j.a.convertButton);
            m.f(convertButton, "convertButton");
            convertButton.setVisibility(0);
            View view36 = getView();
            ((ProgressBarButton) (view36 == null ? null : view36.findViewById(e.j.a.convertButton))).setAlpha(0.0f);
            View view37 = getView();
            ((ProgressBarButton) (view37 == null ? null : view37.findViewById(e.j.a.convertButton))).setBackgroundResource(R.drawable.button_primary_red);
            Object as = b0.timer(3L, TimeUnit.SECONDS).observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as, "timer(3, TimeUnit.SECONDS)\n                .observeOn(AndroidSchedulers.mainThread())\n                .`as`(autoDisposable(scopeProvider))");
            return SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new SwapConfirmationFragment$handleErrorState$1(this), 1, null);
        } else if (error instanceof SwapConfirmationError.Error) {
            View view38 = getView();
            View minerFeeContainer5 = view38 == null ? null : view38.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer5, "minerFeeContainer");
            minerFeeContainer5.setVisibility(8);
            View view39 = getView();
            View coinbaseFeeContainer5 = view39 == null ? null : view39.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer5, "coinbaseFeeContainer");
            coinbaseFeeContainer5.setVisibility(8);
            View view40 = getView();
            View retryButton4 = view40 == null ? null : view40.findViewById(e.j.a.retryButton);
            m.f(retryButton4, "retryButton");
            retryButton4.setVisibility(8);
            View view41 = getView();
            View errorTitle5 = view41 == null ? null : view41.findViewById(e.j.a.errorTitle);
            m.f(errorTitle5, "errorTitle");
            errorTitle5.setVisibility(8);
            View view42 = getView();
            View errorLabel6 = view42 == null ? null : view42.findViewById(e.j.a.h2);
            m.f(errorLabel6, "errorLabel");
            errorLabel6.setVisibility(0);
            View view43 = getView();
            ((TextView) (view43 == null ? null : view43.findViewById(e.j.a.h2))).setText(swapConfirmationViewState.getError().getMessage());
            View view44 = getView();
            View retryButton5 = view44 == null ? null : view44.findViewById(e.j.a.retryButton);
            m.f(retryButton5, "retryButton");
            retryButton5.setVisibility(0);
            View view45 = getView();
            errorLabel = view45 != null ? view45.findViewById(e.j.a.priceImpactInfoButton) : null;
            m.f(errorLabel, "priceImpactInfoButton");
            errorLabel.setVisibility(8);
            return x.a;
        } else if (error == null) {
            View view46 = getView();
            View minerFeeContainer6 = view46 == null ? null : view46.findViewById(e.j.a.Y3);
            m.f(minerFeeContainer6, "minerFeeContainer");
            minerFeeContainer6.setVisibility(0);
            View view47 = getView();
            View coinbaseFeeContainer6 = view47 == null ? null : view47.findViewById(e.j.a.B0);
            m.f(coinbaseFeeContainer6, "coinbaseFeeContainer");
            coinbaseFeeContainer6.setVisibility(0);
            ColorStateList valueOf2 = ColorStateList.valueOf(this.defaultFeeIconColor);
            m.f(valueOf2, "valueOf(defaultFeeIconColor)");
            View view48 = getView();
            ((ImageView) (view48 == null ? null : view48.findViewById(e.j.a.minerFeeInfoButton))).setImageTintList(valueOf2);
            View view49 = getView();
            ((ImageView) (view49 == null ? null : view49.findViewById(e.j.a.coinbaseFeeInfoButton))).setImageTintList(valueOf2);
            View view50 = getView();
            ((TextView) (view50 == null ? null : view50.findViewById(e.j.a.minerFeeTitle))).setTextColor(this.defaultFeeLabelColor);
            View view51 = getView();
            ((TextView) (view51 == null ? null : view51.findViewById(e.j.a.coinbaseFeeTitle))).setTextColor(this.defaultFeeLabelColor);
            View view52 = getView();
            View retryButton6 = view52 == null ? null : view52.findViewById(e.j.a.retryButton);
            m.f(retryButton6, "retryButton");
            retryButton6.setVisibility(8);
            View view53 = getView();
            View errorTitle6 = view53 == null ? null : view53.findViewById(e.j.a.errorTitle);
            m.f(errorTitle6, "errorTitle");
            errorTitle6.setVisibility(8);
            View view54 = getView();
            errorLabel = view54 != null ? view54.findViewById(e.j.a.h2) : null;
            m.f(errorLabel, "errorLabel");
            errorLabel.setVisibility(8);
            return x.a;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void setElasticity() {
        View view = getView();
        ((LinearLayout) (view == null ? null : view.findViewById(e.j.a.K0))).setHapticFeedbackEnabled(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float f2 = displayMetrics.heightPixels;
        final float f3 = displayMetrics.widthPixels;
        View view2 = getView();
        ((LinearLayout) (view2 != null ? view2.findViewById(e.j.a.K0) : null)).setOnTouchListener(new View.OnTouchListener() { // from class: com.coinbase.wallet.features.swap.views.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return SwapConfirmationFragment.d(f3, this, f2, view3, motionEvent);
            }
        });
    }

    /* renamed from: setElasticity$lambda-2 */
    public static final boolean m1510setElasticity$lambda2(float f2, SwapConfirmationFragment this$0, float f3, View view, MotionEvent motionEvent) {
        m.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.initialMoveLocation.set(motionEvent.getRawX(), motionEvent.getRawY());
            this$0.initialCardLocation.set(view.getX(), view.getY());
        } else if (action == 1) {
            view.animate().setInterpolator(new DecelerateInterpolator()).translationY(0.0f).translationX(0.0f).setDuration(100L).start();
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

    private final void setupObservables() {
        Object as = getViewModel().setup().as(d.a(getScopeProvider()));
        m.f(as, "viewModel.setup()\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, null, 3, null);
        Object as2 = getViewModel().getStateObservable().as(d.a(getScopeProvider()));
        m.f(as2, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new SwapConfirmationFragment$setupObservables$1(this), 3, null);
        Object as3 = getViewModel().getEventObservable().as(d.a(getScopeProvider()));
        m.f(as3, "viewModel.eventObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new SwapConfirmationFragment$setupObservables$2(this), 3, null);
        Object as4 = getViewModel().getPromptObservable().as(d.a(getScopeProvider()));
        m.f(as4, "viewModel.promptObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new SwapConfirmationFragment$setupObservables$3(this), 3, null);
        Object as5 = getViewModel().getDismissObservable().as(d.a(getScopeProvider()));
        m.f(as5, "viewModel.dismissObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as5, null, null, new SwapConfirmationFragment$setupObservables$4(this), 3, null);
        Object as6 = getViewModel().getNavigationObservable().as(d.a(getScopeProvider()));
        m.f(as6, "viewModel.navigationObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as6, null, null, new SwapConfirmationFragment$setupObservables$5(this), 3, null);
    }

    private final void setupViews() {
        View view = getView();
        ColorStateList imageTintList = ((ImageView) (view == null ? null : view.findViewById(e.j.a.minerFeeInfoButton))).getImageTintList();
        this.defaultFeeIconColor = imageTintList == null ? 0 : imageTintList.getDefaultColor();
        View view2 = getView();
        this.defaultFeeLabelColor = ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.minerFeeTitle))).getCurrentTextColor();
        View view3 = getView();
        View detailsTab = view3 == null ? null : view3.findViewById(e.j.a.J1);
        m.f(detailsTab, "detailsTab");
        ViewGroup.LayoutParams layoutParams = detailsTab.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = 1;
        detailsTab.setLayoutParams(layoutParams);
        setElasticity();
        View view4 = getView();
        View closeButton = view4 == null ? null : view4.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SwapConfirmationFragment$setupViews$2(this), 1, null);
        View view5 = getView();
        View estimatedInfoContainer = view5 == null ? null : view5.findViewById(e.j.a.estimatedInfoContainer);
        m.f(estimatedInfoContainer, "estimatedInfoContainer");
        View_CommonKt.setOnSingleClickListener$default(estimatedInfoContainer, 0L, new SwapConfirmationFragment$setupViews$3(this), 1, null);
        View view6 = getView();
        View minerFeeContainer = view6 == null ? null : view6.findViewById(e.j.a.Y3);
        m.f(minerFeeContainer, "minerFeeContainer");
        View_CommonKt.setOnSingleClickListener$default(minerFeeContainer, 0L, new SwapConfirmationFragment$setupViews$4(this), 1, null);
        View view7 = getView();
        View coinbaseFeeContainer = view7 == null ? null : view7.findViewById(e.j.a.B0);
        m.f(coinbaseFeeContainer, "coinbaseFeeContainer");
        View_CommonKt.setOnSingleClickListener$default(coinbaseFeeContainer, 0L, new SwapConfirmationFragment$setupViews$5(this), 1, null);
        View view8 = getView();
        View detailsButton = view8 == null ? null : view8.findViewById(e.j.a.F1);
        m.f(detailsButton, "detailsButton");
        View_CommonKt.setOnSingleClickListener$default(detailsButton, 0L, new SwapConfirmationFragment$setupViews$6(this), 1, null);
        View view9 = getView();
        View retryButton = view9 == null ? null : view9.findViewById(e.j.a.retryButton);
        m.f(retryButton, "retryButton");
        View_CommonKt.setOnSingleClickListener$default(retryButton, 0L, new SwapConfirmationFragment$setupViews$7(this), 1, null);
        View view10 = getView();
        View convertButton = view10 == null ? null : view10.findViewById(e.j.a.convertButton);
        m.f(convertButton, "convertButton");
        View_CommonKt.setOnSingleClickListener$default(convertButton, 0L, new SwapConfirmationFragment$setupViews$8(this), 1, null);
        View view11 = getView();
        View priceImpactInfoButton = view11 != null ? view11.findViewById(e.j.a.priceImpactInfoButton) : null;
        m.f(priceImpactInfoButton, "priceImpactInfoButton");
        View_CommonKt.setOnSingleClickListener$default(priceImpactInfoButton, 0L, new SwapConfirmationFragment$setupViews$9(this), 1, null);
    }

    public final void updateDetailsView(boolean z) {
        b0 collapse$default;
        int height;
        View view = getView();
        Object tag = ((LinearLayout) (view == null ? null : view.findViewById(e.j.a.J1))).getTag(R.id.isAnimating);
        Boolean bool = Boolean.TRUE;
        boolean c2 = m.c(tag, bool);
        View view2 = getView();
        boolean c3 = m.c(((LinearLayout) (view2 == null ? null : view2.findViewById(e.j.a.J1))).getTag(R.id.expanded), bool);
        if (c2) {
            return;
        }
        if (c3 || z) {
            View view3 = getView();
            ((LinearLayout) (view3 == null ? null : view3.findViewById(e.j.a.J1))).setTag(R.id.expanded, Boolean.valueOf(z));
            View view4 = getView();
            ((LinearLayout) (view4 == null ? null : view4.findViewById(e.j.a.J1))).setTag(R.id.isAnimating, bool);
            if (z) {
                if (z != c3) {
                    height = 1;
                } else {
                    View view5 = getView();
                    height = ((LinearLayout) (view5 == null ? null : view5.findViewById(e.j.a.J1))).getHeight();
                }
                View view6 = getView();
                View detailsTab = view6 == null ? null : view6.findViewById(e.j.a.J1);
                m.f(detailsTab, "detailsTab");
                collapse$default = View_CommonKt.expand$default(detailsTab, false, null, height, 0L, 11, null);
            } else {
                View view7 = getView();
                View detailsTab2 = view7 == null ? null : view7.findViewById(e.j.a.J1);
                m.f(detailsTab2, "detailsTab");
                collapse$default = View_CommonKt.collapse$default(detailsTab2, false, 0L, 3, null);
            }
            View view8 = getView();
            ((ImageView) (view8 == null ? null : view8.findViewById(e.j.a.p0))).animate().rotation(z ? 180.0f : 0.0f).setDuration(100L).start();
            Object as = collapse$default.as(d.a(getScopeProvider()));
            m.f(as, "expandAnimSingle\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new SwapConfirmationFragment$updateDetailsView$1(this), 1, null);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final SwapConfirmationViewModel.Factory getViewModelFactory() {
        SwapConfirmationViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_swap_confirmation, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        setupObservables();
    }

    public final void setViewModelFactory(SwapConfirmationViewModel.Factory factory) {
        m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}