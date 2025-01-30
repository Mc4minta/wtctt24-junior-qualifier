package com.coinbase.wallet.consumer.views;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.fragment.app.z;
import androidx.lifecycle.i;
import c.h.k.d0;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u0010/\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010 \u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u00020:8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010 \u001a\u0004\b<\u0010=R\u0016\u0010@\u001a\u0002008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u00103¨\u0006B"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAmountPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupViews", "()V", "setupOnClickListeners", "setupObservers", "", "enabled", "setSwapButtonEnabled", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "isNextButtonShown", "Z", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lc/s/b;", "autoTransition$delegate", "Lkotlin/h;", "getAutoTransition", "()Lc/s/b;", "autoTransition", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel$Factory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel$Factory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel$Factory;)V", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAmountPickerViewModel;", "viewModel", "", "buttonElevation$delegate", "getButtonElevation", "()F", "buttonElevation", "", "shortAnimDuration$delegate", "getShortAnimDuration", "()J", "shortAnimDuration", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "getNextButtonTranslateAmount", "nextButtonTranslateAmount", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAmountPickerFragment extends BaseFragment implements StyledFragment {
    private final kotlin.h attributes$delegate;
    private final kotlin.h autoTransition$delegate;
    private final kotlin.h buttonElevation$delegate;
    private boolean isNextButtonShown;
    private final kotlin.h shortAnimDuration$delegate;
    private final kotlin.h viewModel$delegate;
    public ConsumerAmountPickerViewModel.Factory viewModelFactory;

    public ConsumerAmountPickerFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        b2 = kotlin.k.b(new ConsumerAmountPickerFragment$buttonElevation$2(this));
        this.buttonElevation$delegate = b2;
        b3 = kotlin.k.b(new ConsumerAmountPickerFragment$shortAnimDuration$2(this));
        this.shortAnimDuration$delegate = b3;
        this.viewModel$delegate = z.a(this, e0.b(ConsumerAmountPickerViewModel.class), new ConsumerAmountPickerFragment$special$$inlined$viewModel$3(new ConsumerAmountPickerFragment$special$$inlined$viewModel$2(this)), new ConsumerAmountPickerFragment$special$$inlined$viewModel$1(this, this));
        b4 = kotlin.k.b(new ConsumerAmountPickerFragment$autoTransition$2(this));
        this.autoTransition$delegate = b4;
        b5 = kotlin.k.b(new ConsumerAmountPickerFragment$attributes$2(this));
        this.attributes$delegate = b5;
    }

    public static final /* synthetic */ float access$getNextButtonTranslateAmount(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
        return consumerAmountPickerFragment.getNextButtonTranslateAmount();
    }

    public final c.s.b getAutoTransition() {
        return (c.s.b) this.autoTransition$delegate.getValue();
    }

    private final float getButtonElevation() {
        return ((Number) this.buttonElevation$delegate.getValue()).floatValue();
    }

    public final float getNextButtonTranslateAmount() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = getView();
        int height = ((ProgressBarButton) (view == null ? null : view.findViewById(R.id.nextButton))).getHeight();
        View view2 = getView();
        View nextButton = view2 == null ? null : view2.findViewById(R.id.nextButton);
        kotlin.jvm.internal.m.f(nextButton, "nextButton");
        ViewGroup.LayoutParams layoutParams = nextButton.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        int i2 = height + (marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0);
        View view3 = getView();
        View nextButton2 = view3 == null ? null : view3.findViewById(R.id.nextButton);
        kotlin.jvm.internal.m.f(nextButton2, "nextButton");
        ViewGroup.LayoutParams layoutParams2 = nextButton2.getLayoutParams();
        return (i2 + ((layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null) != null ? marginLayoutParams.bottomMargin : 0)) / 2;
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final long getShortAnimDuration() {
        return ((Number) this.shortAnimDuration$delegate.getValue()).longValue();
    }

    public final ConsumerAmountPickerViewModel getViewModel() {
        return (ConsumerAmountPickerViewModel) this.viewModel$delegate.getValue();
    }

    public final void setSwapButtonEnabled(boolean z) {
        Float valueOf;
        float f2;
        View view = getView();
        ((ImageButton) (view == null ? null : view.findViewById(R.id.swapButton))).setClickable(z);
        if (z) {
            valueOf = Float.valueOf(1.0f);
            f2 = getButtonElevation();
        } else {
            valueOf = Float.valueOf(0.75f);
            f2 = 0.0f;
        }
        kotlin.o a = kotlin.u.a(valueOf, Float.valueOf(f2));
        float floatValue = ((Number) a.a()).floatValue();
        float floatValue2 = ((Number) a.b()).floatValue();
        View view2 = getView();
        View findViewById = view2 == null ? null : view2.findViewById(R.id.swapButton);
        float[] fArr = new float[2];
        View view3 = getView();
        fArr[0] = ((ImageButton) (view3 == null ? null : view3.findViewById(R.id.swapButton))).getAlpha();
        fArr[1] = floatValue;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "alpha", fArr);
        ofFloat.setDuration(300L);
        ofFloat.start();
        View view4 = getView();
        View findViewById2 = view4 == null ? null : view4.findViewById(R.id.swapButton);
        float[] fArr2 = new float[2];
        View view5 = getView();
        fArr2[0] = ((ImageButton) (view5 != null ? view5.findViewById(R.id.swapButton) : null)).getElevation();
        fArr2[1] = floatValue2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, "elevation", fArr2);
        ofFloat2.setDuration(300L);
        ofFloat2.start();
    }

    private final void setupObservers() {
        Object as = Observable_AnalyticsKt.logError$default(getViewModel().getEventObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.eventObservable\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerAmountPickerFragment$setupObservers$1(this), 3, null);
        a0 a0Var = new a0();
        Object as2 = Observable_AnalyticsKt.logError$default(getViewModel().getStateObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "viewModel.stateObservable\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerAmountPickerFragment$setupObservers$2(a0Var, this), 3, null);
        Object as3 = Observable_AnalyticsKt.logError$default(getViewModel().getNavigateObservable(), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "viewModel.navigateObservable\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerAmountPickerFragment$setupObservers$3(this), 3, null);
    }

    public final void setupOnClickListeners() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(R.id.keyboard))).setOnDigitPressedListener(new NumberKeyboardInputView.OnDigitPressedListener() { // from class: com.coinbase.wallet.consumer.views.ConsumerAmountPickerFragment$setupOnClickListeners$1
            @Override // com.coinbase.wallet.commonui.views.NumberKeyboardInputView.OnDigitPressedListener
            public void onDigitPressed(NumberKeyboardDigit digit, boolean z) {
                ConsumerAmountPickerViewModel viewModel;
                kotlin.jvm.internal.m.g(digit, "digit");
                viewModel = ConsumerAmountPickerFragment.this.getViewModel();
                viewModel.inputDigit(digit, z);
            }
        });
        View view2 = getView();
        View uiMaskView = view2 == null ? null : view2.findViewById(R.id.uiMaskView);
        kotlin.jvm.internal.m.f(uiMaskView, "uiMaskView");
        View_CommonKt.setOnSingleClickListener$default(uiMaskView, 0L, ConsumerAmountPickerFragment$setupOnClickListeners$2.INSTANCE, 1, null);
        View view3 = getView();
        View swapButton = view3 == null ? null : view3.findViewById(R.id.swapButton);
        kotlin.jvm.internal.m.f(swapButton, "swapButton");
        View_CommonKt.setOnSingleClickListener$default(swapButton, 0L, new ConsumerAmountPickerFragment$setupOnClickListeners$3(this), 1, null);
        View view4 = getView();
        View nextButton = view4 == null ? null : view4.findViewById(R.id.nextButton);
        kotlin.jvm.internal.m.f(nextButton, "nextButton");
        View_CommonKt.setOnSingleClickListener$default(nextButton, 0L, new ConsumerAmountPickerFragment$setupOnClickListeners$4(this), 1, null);
        View view5 = getView();
        View maxButton = view5 == null ? null : view5.findViewById(R.id.maxButton);
        kotlin.jvm.internal.m.f(maxButton, "maxButton");
        View_CommonKt.setOnSingleClickListener$default(maxButton, 0L, new ConsumerAmountPickerFragment$setupOnClickListeners$5(this), 1, null);
        View view6 = getView();
        View currencyPicker = view6 != null ? view6.findViewById(R.id.currencyPicker) : null;
        kotlin.jvm.internal.m.f(currencyPicker, "currencyPicker");
        View_CommonKt.setOnSingleClickListener$default(currencyPicker, 0L, new ConsumerAmountPickerFragment$setupOnClickListeners$6(this), 1, null);
    }

    private final void setupViews() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(R.id.keyboard))).setTextColorResId(R.color.primary_black);
        View view2 = getView();
        ((ImageButton) (view2 == null ? null : view2.findViewById(R.id.swapButton))).setClickable(false);
        View view3 = getView();
        ((ProgressBarButton) (view3 == null ? null : view3.findViewById(R.id.nextButton))).setEnabled(false);
        View view4 = getView();
        ((ProgressBarButton) (view4 == null ? null : view4.findViewById(R.id.nextButton))).setVisibility(0);
        View view5 = getView();
        ((ProgressBarButton) (view5 == null ? null : view5.findViewById(R.id.nextButton))).setAlpha(0.0f);
        this.isNextButtonShown = false;
        View view6 = getView();
        View ctaContainer = view6 != null ? view6.findViewById(R.id.ctaContainer) : null;
        kotlin.jvm.internal.m.f(ctaContainer, "ctaContainer");
        ctaContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coinbase.wallet.consumer.views.ConsumerAmountPickerFragment$setupViews$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view7, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                kotlin.jvm.internal.m.g(view7, "view");
                view7.removeOnLayoutChangeListener(this);
                View view8 = ConsumerAmountPickerFragment.this.getView();
                ((LinearLayout) (view8 == null ? null : view8.findViewById(R.id.ctaContainer))).setTranslationY(ConsumerAmountPickerFragment.access$getNextButtonTranslateAmount(ConsumerAmountPickerFragment.this));
            }
        });
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
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final ConsumerAmountPickerViewModel.Factory getViewModelFactory$consumer_productionRelease() {
        ConsumerAmountPickerViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_amount_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerAmountPickerFragment$onViewCreated$1(this), 1, null);
        setupObservers();
        h.c.s<ConsumerTransferMethodResult> transferMethodsObservable = Fragment_CommonKt.getNavigationResult(this, ConsumerTransferMethodsArgs.INSTANCE.getResultKey()).toObservable();
        h.c.s<ConsumerCardCDVResult> cardCDVResultObservable = Fragment_CommonKt.getNavigationResult(this, ConsumerCardCDVArgs.RESULT_KEY).toObservable();
        ConsumerAmountPickerViewModel viewModel = getViewModel();
        kotlin.jvm.internal.m.f(transferMethodsObservable, "transferMethodsObservable");
        kotlin.jvm.internal.m.f(cardCDVResultObservable, "cardCDVResultObservable");
        Object as = Single_AnalyticsKt.logError$default(viewModel.setup(transferMethodsObservable, cardCDVResultObservable), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.setup(transferMethodsObservable, cardCDVResultObservable)\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, ConsumerAmountPickerFragment$onViewCreated$2.INSTANCE, 1, null);
    }

    public final void setViewModelFactory$consumer_productionRelease(ConsumerAmountPickerViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}