package com.coinbase.wallet.features.swap.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.fragment.app.z;
import androidx.viewpager.widget.ViewPager;
import c.h.k.d0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.view.custom.ProgressBarButtonWithSubtitle;
import com.coinbase.wallet.application.view.custom.ViewPagerHeader;
import com.coinbase.wallet.common.extensions.FlowableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerArgs;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.uber.autodispose.d;
import com.uber.autodispose.u;
import e.j.f.o;
import h.c.s;
import h.c.t0.c;
import h.c.t0.g;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u001f\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010?R\u001d\u0010H\u001a\u00020D8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010-\u001a\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010?¨\u0006K"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapAmountPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "applyStyle", "()V", "setupPager", "setupListeners", "setupObservers", "", "willBeVisible", "animated", "updateNextButton", "(ZZ)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$Factory;", "swapAmountPickerViewModelFactory", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$Factory;", "getSwapAmountPickerViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$Factory;", "setSwapAmountPickerViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$Factory;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "", "shortAnimDuration$delegate", "Lkotlin/h;", "getShortAnimDuration", "()J", "shortAnimDuration", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "isInitialViewCreation", "Z", "Lcom/coinbase/wallet/features/swap/views/SwapAmountPickerAdapter;", "adapter", "Lcom/coinbase/wallet/features/swap/views/SwapAmountPickerAdapter;", "Lh/c/k0/b;", "quoteTimerDisposable", "Lh/c/k0/b;", "", "nextButtonTranslateY", "I", "Landroid/view/ViewPropertyAnimator;", "nextButtonAnimator", "Landroid/view/ViewPropertyAnimator;", "keyboardBottomMargin", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "viewModel", "nextButtonBottomMargin", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerFragment extends BaseFragment implements StyledFragment {
    private SwapAmountPickerAdapter adapter;
    private boolean isInitialViewCreation;
    private int keyboardBottomMargin;
    private ViewPropertyAnimator nextButtonAnimator;
    private int nextButtonBottomMargin;
    private final int nextButtonTranslateY;
    private h.c.k0.b quoteTimerDisposable;
    private final h shortAnimDuration$delegate;
    public SwapAmountPickerViewModel.Factory swapAmountPickerViewModelFactory;
    private final h viewModel$delegate = z.a(this, e0.b(SwapAmountPickerViewModel.class), new SwapAmountPickerFragment$special$$inlined$viewModel$3(new SwapAmountPickerFragment$special$$inlined$viewModel$2(this)), new SwapAmountPickerFragment$special$$inlined$viewModel$1(this, this));

    public SwapAmountPickerFragment() {
        h b2;
        b2 = k.b(new SwapAmountPickerFragment$shortAnimDuration$2(this));
        this.shortAnimDuration$delegate = b2;
        this.nextButtonTranslateY = o.a(80);
        this.isInitialViewCreation = true;
    }

    private final void applyStyle() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(e.j.a.h3))).setTextColorResId(R.color.primary_black);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getShortAnimDuration() {
        return ((Number) this.shortAnimDuration$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwapAmountPickerViewModel getViewModel() {
        return (SwapAmountPickerViewModel) this.viewModel$delegate.getValue();
    }

    private final void setupListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SwapAmountPickerFragment$setupListeners$1(this), 1, null);
        View view2 = getView();
        View convertAll = view2 == null ? null : view2.findViewById(e.j.a.convertAll);
        m.f(convertAll, "convertAll");
        View_CommonKt.setOnSingleClickListener$default(convertAll, 0L, new SwapAmountPickerFragment$setupListeners$2(this), 1, null);
        View view3 = getView();
        View nextButton = view3 == null ? null : view3.findViewById(e.j.a.s4);
        m.f(nextButton, "nextButton");
        View_CommonKt.setOnSingleClickListener$default(nextButton, 0L, new SwapAmountPickerFragment$setupListeners$3(this), 1, null);
        View view4 = getView();
        ((NumberKeyboardInputView) (view4 == null ? null : view4.findViewById(e.j.a.h3))).setOnDigitPressedListener(new NumberKeyboardInputView.OnDigitPressedListener() { // from class: com.coinbase.wallet.features.swap.views.SwapAmountPickerFragment$setupListeners$4
            @Override // com.coinbase.wallet.commonui.views.NumberKeyboardInputView.OnDigitPressedListener
            public void onDigitPressed(NumberKeyboardDigit digit, boolean z) {
                SwapAmountPickerViewModel viewModel;
                m.g(digit, "digit");
                viewModel = SwapAmountPickerFragment.this.getViewModel();
                viewModel.keyTapped(digit, z);
            }
        });
        View view5 = getView();
        View backgroundLeft = view5 == null ? null : view5.findViewById(e.j.a.backgroundLeft);
        m.f(backgroundLeft, "backgroundLeft");
        View_CommonKt.setOnSingleClickListener$default(backgroundLeft, 0L, new SwapAmountPickerFragment$setupListeners$5(this), 1, null);
        View view6 = getView();
        View backgroundRight = view6 != null ? view6.findViewById(e.j.a.backgroundRight) : null;
        m.f(backgroundRight, "backgroundRight");
        View_CommonKt.setOnSingleClickListener$default(backgroundRight, 0L, new SwapAmountPickerFragment$setupListeners$6(this), 1, null);
    }

    private final void setupObservers() {
        c cVar = c.a;
        s<SwapAmountPickerViewState> stateObservable = getViewModel().getStateObservable();
        SwapAmountPickerAdapter swapAmountPickerAdapter = this.adapter;
        if (swapAmountPickerAdapter != null) {
            s<x> observable = swapAmountPickerAdapter.getAdapterViewsInitializedSingle().toObservable();
            m.f(observable, "adapter.adapterViewsInitializedSingle.toObservable()");
            s a = cVar.a(stateObservable, observable);
            m.f(a, "Observables.combineLatest(viewModel.stateObservable, adapter.adapterViewsInitializedSingle.toObservable())");
            Object as = Observable_AnalyticsKt.logError$default(a, null, null, 3, null).as(d.a(getScopeProvider()));
            m.f(as, "Observables.combineLatest(viewModel.stateObservable, adapter.adapterViewsInitializedSingle.toObservable())\n            .logError()\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new SwapAmountPickerFragment$setupObservers$1(this), 3, null);
            Object as2 = getViewModel().getEventObservable().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as2, "viewModel\n            .eventObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new SwapAmountPickerFragment$setupObservers$2(this), 3, null);
            Object as3 = getViewModel().getNavigationObservable().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as3, "viewModel\n            .navigationObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new SwapAmountPickerFragment$setupObservers$3(this), 3, null);
            Object as4 = getViewModel().getPromptObservable().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as4, "viewModel.promptObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new SwapAmountPickerFragment$setupObservers$4(this), 3, null);
            Object as5 = Fragment_CommonKt.getNavigationResult(this, SwapAssetPickerArgs.Result.sourceSwapAssetKey).as(d.a(getScopeProvider()));
            m.f(as5, "getNavigationResult<SwapAsset>(sourceSwapAssetKey)\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            FlowableSubscribeProxy_CommonKt.subscribeBy$default((u) as5, null, null, new SwapAmountPickerFragment$setupObservers$5(this), 3, null);
            Object as6 = Fragment_CommonKt.getNavigationResult(this, SwapAssetPickerArgs.Result.targetSwapAssetKey).as(d.a(getScopeProvider()));
            m.f(as6, "getNavigationResult<SwapAsset>(targetSwapAssetKey)\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
            FlowableSubscribeProxy_CommonKt.subscribeBy$default((u) as6, null, null, new SwapAmountPickerFragment$setupObservers$6(this), 3, null);
            return;
        }
        m.w("adapter");
        throw null;
    }

    private final void setupPager() {
        View view = getView();
        ViewPager viewPager = (ViewPager) (view == null ? null : view.findViewById(e.j.a.viewPager));
        SwapAmountPickerViewModel viewModel = getViewModel();
        FragmentLifecycleScopeProvider scopeProvider = getScopeProvider();
        View view2 = getView();
        Context context = ((ViewPager) (view2 == null ? null : view2.findViewById(e.j.a.viewPager))).getContext();
        m.f(context, "viewPager.context");
        SwapAmountPickerAdapter swapAmountPickerAdapter = new SwapAmountPickerAdapter(viewModel, scopeProvider, context);
        this.adapter = swapAmountPickerAdapter;
        x xVar = x.a;
        viewPager.setAdapter(swapAmountPickerAdapter);
        View view3 = getView();
        ((ViewPager) (view3 == null ? null : view3.findViewById(e.j.a.viewPager))).setOffscreenPageLimit(2);
        View view4 = getView();
        ViewPagerHeader viewPagerHeader = (ViewPagerHeader) (view4 == null ? null : view4.findViewById(e.j.a.twoButtonSlider));
        View view5 = getView();
        View viewPager2 = view5 == null ? null : view5.findViewById(e.j.a.viewPager);
        m.f(viewPager2, "viewPager");
        viewPagerHeader.setViewPager((ViewPager) viewPager2);
        View view6 = getView();
        ((ViewPagerHeader) (view6 == null ? null : view6.findViewById(e.j.a.twoButtonSlider))).setNumPages(2);
        View view7 = getView();
        ViewPagerHeader viewPagerHeader2 = (ViewPagerHeader) (view7 == null ? null : view7.findViewById(e.j.a.twoButtonSlider));
        View view8 = getView();
        View touchBlocker = view8 == null ? null : view8.findViewById(e.j.a.touchBlocker);
        m.f(touchBlocker, "touchBlocker");
        viewPagerHeader2.setTransitionTouchBlocker(touchBlocker);
        View view9 = getView();
        ViewPager viewPager3 = (ViewPager) (view9 == null ? null : view9.findViewById(e.j.a.viewPager));
        View view10 = getView();
        viewPager3.addOnPageChangeListener((ViewPager.j) (view10 == null ? null : view10.findViewById(e.j.a.twoButtonSlider)));
        View view11 = getView();
        ((ViewPager) (view11 != null ? view11.findViewById(e.j.a.viewPager) : null)).addOnPageChangeListener(new ViewPager.j() { // from class: com.coinbase.wallet.features.swap.views.SwapAmountPickerFragment$setupPager$2
            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i2) {
                SwapAmountPickerViewModel viewModel2;
                viewModel2 = SwapAmountPickerFragment.this.getViewModel();
                viewModel2.switchCurrencyType(SwapCurrencyType.values()[i2]);
            }
        });
    }

    private final void updateNextButton(boolean z, boolean z2) {
        View view = getView();
        if (z == ((ProgressBarButtonWithSubtitle) (view == null ? null : view.findViewById(e.j.a.s4))).isEnabled()) {
            return;
        }
        View view2 = getView();
        ((ProgressBarButtonWithSubtitle) (view2 == null ? null : view2.findViewById(e.j.a.s4))).setEnabled(z);
        float f2 = z ? 1.0f : 0.0f;
        int i2 = z ? 0 : this.nextButtonTranslateY;
        ViewPropertyAnimator viewPropertyAnimator = this.nextButtonAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        View view3 = getView();
        ViewPropertyAnimator animate = ((ProgressBarButtonWithSubtitle) (view3 != null ? view3.findViewById(e.j.a.s4) : null)).animate();
        animate.setDuration(z2 ? getShortAnimDuration() : 0L);
        animate.setInterpolator(new AccelerateDecelerateInterpolator());
        animate.alpha(f2);
        animate.translationY(i2);
        animate.start();
        x xVar = x.a;
        this.nextButtonAnimator = animate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void updateNextButton$default(SwapAmountPickerFragment swapAmountPickerFragment, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        swapAmountPickerFragment.updateNextButton(z, z2);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 insets) {
        m.g(view, "view");
        m.g(insets, "insets");
        View view2 = getView();
        View keyboard = view2 == null ? null : view2.findViewById(e.j.a.h3);
        m.f(keyboard, "keyboard");
        ViewGroup.LayoutParams layoutParams = keyboard.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.keyboardBottomMargin + insets.i();
        keyboard.setLayoutParams(marginLayoutParams);
        View view3 = getView();
        View nextButton = view3 != null ? view3.findViewById(e.j.a.s4) : null;
        m.f(nextButton, "nextButton");
        ViewGroup.LayoutParams layoutParams2 = nextButton.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.bottomMargin = this.nextButtonBottomMargin + insets.i();
        nextButton.setLayoutParams(marginLayoutParams2);
        return insets;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final SwapAmountPickerViewModel.Factory getSwapAmountPickerViewModelFactory$app_productionRelease() {
        SwapAmountPickerViewModel.Factory factory = this.swapAmountPickerViewModelFactory;
        if (factory != null) {
            return factory;
        }
        m.w("swapAmountPickerViewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_swap_amount_picker, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        s<Long> interval = s.interval(5L, TimeUnit.SECONDS);
        m.f(interval, "interval(5, TimeUnit.SECONDS)");
        this.quoteTimerDisposable = g.h(interval, null, null, new SwapAmountPickerFragment$onStart$1(this), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        h.c.k0.b bVar = this.quoteTimerDisposable;
        if (bVar == null) {
            return;
        }
        bVar.dispose();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapAmountPickerLanded(AnalyticsEvent.Companion));
        if (!this.isInitialViewCreation) {
            postponeEnterTransition();
            ViewParent parent = view.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            final ViewGroup viewGroup = (ViewGroup) parent;
            m.f(c.h.k.s.a(viewGroup, new Runnable() { // from class: com.coinbase.wallet.features.swap.views.SwapAmountPickerFragment$onViewCreated$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.startPostponedEnterTransition();
                }
            }), "OneShotPreDrawListener.add(this) { action(this) }");
        }
        this.isInitialViewCreation = false;
        View view2 = getView();
        View keyboard = view2 == null ? null : view2.findViewById(e.j.a.h3);
        m.f(keyboard, "keyboard");
        ViewGroup.LayoutParams layoutParams = keyboard.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.keyboardBottomMargin = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
        View view3 = getView();
        View nextButton = view3 == null ? null : view3.findViewById(e.j.a.s4);
        m.f(nextButton, "nextButton");
        ViewGroup.LayoutParams layoutParams2 = nextButton.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null;
        this.nextButtonBottomMargin = marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0;
        updateNextButton(false, false);
        applyStyle();
        setupListeners();
        setupPager();
        setupObservers();
    }

    public final void setSwapAmountPickerViewModelFactory$app_productionRelease(SwapAmountPickerViewModel.Factory factory) {
        m.g(factory, "<set-?>");
        this.swapAmountPickerViewModelFactory = factory;
    }
}