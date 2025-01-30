package com.coinbase.wallet.features.send.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import com.coinbase.wallet.commonui.utilities.animation.TranslateTransition;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.CurrencyPickerView;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.features.commonui.views.AmountSliderView;
import com.coinbase.wallet.features.send.models.AmountPickerSettings;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bZ\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J-\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0005J\u0017\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u0010;\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010@\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00108\u001a\u0004\bI\u0010JR\u001d\u0010P\u001a\u00020L8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u00108\u001a\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020T8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020G8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010J¨\u0006["}, d2 = {"Lcom/coinbase/wallet/features/send/views/AmountPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "applyStyle", "()V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "handleCoinPicked", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "setupViews", "setupSendAmountView", "setupOnClickListeners", "setupObservers", "", "enabled", "setSwapButtonEnabled", "(Z)V", "isVisible", "animate", "setSliderVisibility", "(ZZ)V", "fadeIn", "", "duration", "", "Landroid/view/View;", "views", "fadeViews", "(ZJLjava/util/List;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Landroidx/fragment/app/Fragment;", "childFragment", "onAttachFragment", "(Landroidx/fragment/app/Fragment;)V", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;)V", "shortAnimDuration$delegate", "Lkotlin/h;", "getShortAnimDuration", "()J", "shortAnimDuration", "Lc/s/b;", "autoTransition$delegate", "getAutoTransition", "()Lc/s/b;", "autoTransition", "Lcom/coinbase/wallet/features/send/views/AmountFragment;", "amountFragment", "Lcom/coinbase/wallet/features/send/views/AmountFragment;", "Lcom/coinbase/wallet/features/commonui/views/AmountSliderView;", "amountSliderView", "Lcom/coinbase/wallet/features/commonui/views/AmountSliderView;", "", "buttonElevation$delegate", "getButtonElevation", "()F", "buttonElevation", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/send/viewmodels/AmountPickerViewModel;", "viewModel", "Lcom/coinbase/wallet/features/send/viewmodels/AmountPickerViewModel;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "getNextButtonTranslateAmount", "nextButtonTranslateAmount", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment extends BaseFragment implements StyledFragment {
    private AmountFragment amountFragment;
    private AmountSliderView amountSliderView;
    private final kotlin.h attributes$delegate;
    private final kotlin.h autoTransition$delegate;
    private final kotlin.h buttonElevation$delegate;
    private final kotlin.h shortAnimDuration$delegate;
    private AmountPickerViewModel viewModel;
    public ViewModelFactoryWithMap viewModelFactory;

    public AmountPickerFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        b2 = kotlin.k.b(new AmountPickerFragment$buttonElevation$2(this));
        this.buttonElevation$delegate = b2;
        b3 = kotlin.k.b(new AmountPickerFragment$shortAnimDuration$2(this));
        this.shortAnimDuration$delegate = b3;
        b4 = kotlin.k.b(new AmountPickerFragment$autoTransition$2(this));
        this.autoTransition$delegate = b4;
        b5 = kotlin.k.b(new AmountPickerFragment$attributes$2(this));
        this.attributes$delegate = b5;
    }

    public static final /* synthetic */ float access$getNextButtonTranslateAmount(AmountPickerFragment amountPickerFragment) {
        return amountPickerFragment.getNextButtonTranslateAmount();
    }

    private final void applyStyle() {
        AmountPickerViewModel amountPickerViewModel = this.viewModel;
        if (amountPickerViewModel != null) {
            AmountPickerSettings settings = amountPickerViewModel.getSettings();
            Context context = getContext();
            if (context != null) {
                View view = getView();
                ((Button) (view == null ? null : view.findViewById(e.j.a.N3))).setBackgroundTintList(androidx.core.content.a.e(context, settings.getButtonColor()));
                View view2 = getView();
                ((Button) (view2 == null ? null : view2.findViewById(e.j.a.s4))).setBackgroundTintList(androidx.core.content.a.e(context, settings.getAmountButtonTextColor()));
                View view3 = getView();
                ((ImageButton) (view3 == null ? null : view3.findViewById(e.j.a.C6))).setBackgroundTintList(androidx.core.content.a.e(context, settings.getButtonColor()));
                View view4 = getView();
                ((ImageButton) (view4 == null ? null : view4.findViewById(e.j.a.C6))).setImageTintList(androidx.core.content.a.e(context, settings.getAmountButtonTextColor()));
                View view5 = getView();
                ((ImageButton) (view5 == null ? null : view5.findViewById(e.j.a.t0))).setImageTintList(androidx.core.content.a.e(context, settings.getTextColor()));
            }
            Integer a = e.j.f.m.a(this, settings.getBackgroundColor());
            if (a != null) {
                int intValue = a.intValue();
                View view6 = getView();
                ((ConstraintLayout) (view6 == null ? null : view6.findViewById(e.j.a.Y5))).setBackgroundColor(intValue);
            }
            Integer a2 = e.j.f.m.a(this, settings.getBackgroundColor());
            if (a2 != null) {
                int intValue2 = a2.intValue();
                View view7 = getView();
                ((Button) (view7 == null ? null : view7.findViewById(e.j.a.s4))).setTextColor(intValue2);
            }
            Integer a3 = e.j.f.m.a(this, settings.getSecondaryTextColor());
            if (a3 != null) {
                int intValue3 = a3.intValue();
                View view8 = getView();
                ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.sendSubHeader))).setTextColor(intValue3);
            }
            Integer a4 = e.j.f.m.a(this, settings.getAmountButtonTextColor());
            if (a4 != null) {
                int intValue4 = a4.intValue();
                View view9 = getView();
                ((Button) (view9 == null ? null : view9.findViewById(e.j.a.N3))).setTextColor(intValue4);
            }
            Integer a5 = e.j.f.m.a(this, settings.getAmountButtonTextColor());
            if (a5 != null) {
                int intValue5 = a5.intValue();
                View view10 = getView();
                ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.sendInterestText))).setTextColor(intValue5);
            }
            View view11 = getView();
            ((NumberKeyboardInputView) (view11 == null ? null : view11.findViewById(e.j.a.h3))).setTextColorResId(settings.getNumpadTextColor());
            View view12 = getView();
            ((Button) (view12 == null ? null : view12.findViewById(e.j.a.s4))).setText(settings.getProceedButtonLabel());
            View view13 = getView();
            ((ImageButton) (view13 == null ? null : view13.findViewById(e.j.a.t0))).setImageResource(settings.getBackButtonResource());
            if (settings.isLend()) {
                View view14 = getView();
                ((LinearLayout) (view14 == null ? null : view14.findViewById(e.j.a.e1))).setVerticalGravity(80);
                View view15 = getView();
                ((CurrencyPickerView) (view15 == null ? null : view15.findViewById(e.j.a.k1))).setVisibility(8);
                View view16 = getView();
                ((TextView) (view16 == null ? null : view16.findViewById(e.j.a.sendInterestText))).setVisibility(0);
                View view17 = getView();
                ((TextView) (view17 == null ? null : view17.findViewById(e.j.a.sendInterestText))).setAlpha(0.0f);
            }
            if (settings.isSliderEnabled()) {
                View view18 = getView();
                ((ImageButton) (view18 == null ? null : view18.findViewById(e.j.a.C6))).setVisibility(4);
                View view19 = getView();
                ((Button) (view19 == null ? null : view19.findViewById(e.j.a.N3))).setVisibility(4);
                View view20 = getView();
                ((NumberKeyboardInputView) (view20 == null ? null : view20.findViewById(e.j.a.h3))).setVisibility(4);
                Context requireContext = requireContext();
                kotlin.jvm.internal.m.f(requireContext, "requireContext()");
                AmountSliderView amountSliderView = new AmountSliderView(requireContext);
                this.amountSliderView = amountSliderView;
                amountSliderView.setId(View.generateViewId());
                amountSliderView.setVisibility(8);
                AmountPickerViewModel amountPickerViewModel2 = this.viewModel;
                if (amountPickerViewModel2 != null) {
                    amountSliderView.setDescriptionVisible(amountPickerViewModel2.isInterestDescriptionVisible());
                    View view21 = getView();
                    ((ConstraintLayout) (view21 == null ? null : view21.findViewById(e.j.a.Y5))).addView(amountSliderView);
                    ViewGroup.LayoutParams layoutParams = amountSliderView.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    View view22 = getView();
                    View keyboard = view22 == null ? null : view22.findViewById(e.j.a.h3);
                    kotlin.jvm.internal.m.f(keyboard, "keyboard");
                    ViewGroup.LayoutParams layoutParams2 = keyboard.getLayoutParams();
                    if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams2 = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams.bottomMargin = marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0;
                    amountSliderView.setLayoutParams(marginLayoutParams);
                    androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                    View view23 = getView();
                    dVar.j((ConstraintLayout) (view23 == null ? null : view23.findViewById(e.j.a.Y5)));
                    dVar.l(amountSliderView.getId(), 4, R.id.sendFragmentConstraintParent, 4);
                    dVar.l(amountSliderView.getId(), 3, R.id.sendFragmentConstraintParent, 3);
                    dVar.F(amountSliderView.getId(), 0.8f);
                    View view24 = getView();
                    dVar.d((ConstraintLayout) (view24 != null ? view24.findViewById(e.j.a.Y5) : null));
                    Object as = amountSliderView.getAmountSliderObservable().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                    kotlin.jvm.internal.m.f(as, "slider.amountSliderObservable\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .`as`(autoDisposable(onDestroyScopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new AmountPickerFragment$applyStyle$1$9(this), 3, null);
                    return;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static /* synthetic */ void d(View view) {
        m1397fadeViews$lambda23$lambda22$lambda20(view);
    }

    public static /* synthetic */ void e(AmountSliderView amountSliderView) {
        m1399setSliderVisibility$lambda16(amountSliderView);
    }

    public static /* synthetic */ void f(AmountSliderView amountSliderView) {
        m1400setSliderVisibility$lambda18(amountSliderView);
    }

    private final void fadeViews(boolean z, long j2, List<? extends View> list) {
        int r;
        r = kotlin.a0.s.r(list, 10);
        ArrayList<ViewPropertyAnimator> arrayList = new ArrayList(r);
        for (final View view : list) {
            ViewPropertyAnimator animate = view.animate();
            animate.setDuration(j2);
            if (z) {
                animate.setInterpolator(new AccelerateDecelerateInterpolator());
                animate.alpha(1.0f);
                animate.withStartAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        AmountPickerFragment.d(view);
                    }
                });
            } else {
                animate.setInterpolator(new DecelerateInterpolator());
                animate.alpha(0.0f);
                animate.withEndAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        AmountPickerFragment.h(view);
                    }
                });
            }
            arrayList.add(animate);
        }
        for (ViewPropertyAnimator viewPropertyAnimator : arrayList) {
            viewPropertyAnimator.start();
        }
    }

    /* renamed from: fadeViews$lambda-23$lambda-22$lambda-20 */
    public static final void m1397fadeViews$lambda23$lambda22$lambda20(View view) {
        kotlin.jvm.internal.m.g(view, "$view");
        view.setAlpha(0.0f);
        view.setVisibility(0);
    }

    /* renamed from: fadeViews$lambda-23$lambda-22$lambda-21 */
    public static final void m1398fadeViews$lambda23$lambda22$lambda21(View view) {
        kotlin.jvm.internal.m.g(view, "$view");
        view.setVisibility(8);
    }

    public static /* synthetic */ h.c.h0 g(AmountPickerFragment amountPickerFragment, String str) {
        return m1401setupObservers$lambda12(amountPickerFragment, str);
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
        int height = ((Button) (view == null ? null : view.findViewById(e.j.a.s4))).getHeight();
        View view2 = getView();
        View nextButton = view2 == null ? null : view2.findViewById(e.j.a.s4);
        kotlin.jvm.internal.m.f(nextButton, "nextButton");
        ViewGroup.LayoutParams layoutParams = nextButton.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        int i2 = height + (marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0);
        View view3 = getView();
        View nextButton2 = view3 == null ? null : view3.findViewById(e.j.a.s4);
        kotlin.jvm.internal.m.f(nextButton2, "nextButton");
        ViewGroup.LayoutParams layoutParams2 = nextButton2.getLayoutParams();
        return (i2 + ((layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null) != null ? marginLayoutParams.bottomMargin : 0)) / 2;
    }

    public final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final long getShortAnimDuration() {
        return ((Number) this.shortAnimDuration$delegate.getValue()).longValue();
    }

    public static /* synthetic */ void h(View view) {
        m1398fadeViews$lambda23$lambda22$lambda21(view);
    }

    public final void handleCoinPicked(Wallet wallet) {
        AmountPickerViewModel amountPickerViewModel = this.viewModel;
        if (amountPickerViewModel != null) {
            amountPickerViewModel.setWallet(wallet);
            AmountFragment amountFragment = this.amountFragment;
            if (amountFragment == null) {
                kotlin.jvm.internal.m.w("amountFragment");
                throw null;
            }
            AmountPickerViewModel amountPickerViewModel2 = this.viewModel;
            if (amountPickerViewModel2 != null) {
                amountFragment.setWallet(wallet, amountPickerViewModel2.isFiatSelected());
                AmountPickerViewModel amountPickerViewModel3 = this.viewModel;
                if (amountPickerViewModel3 != null) {
                    setSwapButtonEnabled(amountPickerViewModel3.getHasFiatRepresentation());
                    View view = getView();
                    ((CurrencyPickerView) (view == null ? null : view.findViewById(e.j.a.k1))).setCoin(wallet);
                    AmountPickerViewModel amountPickerViewModel4 = this.viewModel;
                    if (amountPickerViewModel4 != null) {
                        amountPickerViewModel4.updateSendAmount(Strings.zero, Boolean.FALSE);
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
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

    public final void setSliderVisibility(boolean z, boolean z2) {
        Button button;
        List<? extends View> l2;
        List<? extends View> j2;
        final AmountSliderView amountSliderView = this.amountSliderView;
        if (amountSliderView == null) {
            return;
        }
        long shortAnimDuration = z2 ? getShortAnimDuration() : 0L;
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(shortAnimDuration);
        View view = getView();
        translateTransition.addTarget(view == null ? null : view.findViewById(e.j.a.W5));
        View view2 = getView();
        translateTransition.addTarget(view2 == null ? null : view2.findViewById(e.j.a.N3));
        View view3 = getView();
        translateTransition.addTarget(view3 == null ? null : view3.findViewById(e.j.a.C6));
        if (z) {
            View[] viewArr = new View[4];
            View view4 = getView();
            viewArr[0] = view4 == null ? null : view4.findViewById(e.j.a.N3);
            View view5 = getView();
            viewArr[1] = view5 == null ? null : view5.findViewById(e.j.a.C6);
            View view6 = getView();
            viewArr[2] = view6 == null ? null : view6.findViewById(e.j.a.sliderButton);
            View view7 = getView();
            viewArr[3] = view7 == null ? null : view7.findViewById(e.j.a.h3);
            j2 = kotlin.a0.r.j(viewArr);
            fadeViews(false, shortAnimDuration, j2);
            View view8 = getView();
            View sendInterestText = view8 == null ? null : view8.findViewById(e.j.a.sendInterestText);
            kotlin.jvm.internal.m.f(sendInterestText, "sendInterestText");
            View_CommonKt.fadeOut$default(sendInterestText, shortAnimDuration, null, 2, null);
            amountSliderView.animate().translationY(0.0f).alpha(1.0f).withStartAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.p
                @Override // java.lang.Runnable
                public final void run() {
                    AmountPickerFragment.e(AmountSliderView.this);
                }
            }).setDuration(shortAnimDuration).start();
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            View view9 = getView();
            dVar.j((ConstraintLayout) (view9 == null ? null : view9.findViewById(e.j.a.Y5)));
            dVar.l(R.id.sendAmountContainer, 4, amountSliderView.getId(), 3);
            dVar.l(R.id.sendAmountContainer, 6, R.id.sendFragmentConstraintParent, 6);
            dVar.l(R.id.sendAmountContainer, 7, R.id.sendFragmentConstraintParent, 7);
            dVar.l(R.id.maxButton, 7, R.id.swapButton, 6);
            dVar.l(R.id.swapButton, 6, R.id.maxButton, 7);
            View view10 = getView();
            dVar.d((ConstraintLayout) (view10 == null ? null : view10.findViewById(e.j.a.Y5)));
        } else {
            AmountPickerViewModel amountPickerViewModel = this.viewModel;
            if (amountPickerViewModel != null) {
                boolean isSliderEnabled = amountPickerViewModel.getSettings().isSliderEnabled();
                View[] viewArr2 = new View[4];
                View view11 = getView();
                viewArr2[0] = view11 == null ? null : view11.findViewById(e.j.a.N3);
                View view12 = getView();
                viewArr2[1] = view12 == null ? null : view12.findViewById(e.j.a.C6);
                View view13 = getView();
                viewArr2[2] = view13 == null ? null : view13.findViewById(e.j.a.h3);
                if (isSliderEnabled) {
                    View view14 = getView();
                    button = (Button) (view14 == null ? null : view14.findViewById(e.j.a.sliderButton));
                } else {
                    button = null;
                }
                viewArr2[3] = button;
                l2 = kotlin.a0.r.l(viewArr2);
                fadeViews(true, shortAnimDuration, l2);
                AmountPickerViewModel amountPickerViewModel2 = this.viewModel;
                if (amountPickerViewModel2 != null) {
                    if (amountPickerViewModel2.isInterestDescriptionVisible()) {
                        View view15 = getView();
                        View sendInterestText2 = view15 == null ? null : view15.findViewById(e.j.a.sendInterestText);
                        kotlin.jvm.internal.m.f(sendInterestText2, "sendInterestText");
                        View_CommonKt.fadeIn$default(sendInterestText2, shortAnimDuration, null, 2, null);
                    }
                    amountSliderView.animate().translationY(amountSliderView.getHeight() / 3).alpha(0.0f).withEndAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            AmountPickerFragment.f(AmountSliderView.this);
                        }
                    }).setDuration(shortAnimDuration).start();
                    androidx.constraintlayout.widget.d dVar2 = new androidx.constraintlayout.widget.d();
                    View view16 = getView();
                    dVar2.j((ConstraintLayout) (view16 == null ? null : view16.findViewById(e.j.a.Y5)));
                    dVar2.l(R.id.sendAmountContainer, 4, isSliderEnabled ? R.id.sliderButton : R.id.keyboard, 3);
                    dVar2.l(R.id.sendAmountContainer, 6, R.id.maxButton, 7);
                    dVar2.l(R.id.sendAmountContainer, 7, R.id.swapButton, 6);
                    dVar2.l(R.id.maxButton, 7, R.id.sendAmountContainer, 6);
                    dVar2.l(R.id.swapButton, 6, R.id.sendAmountContainer, 7);
                    View view17 = getView();
                    dVar2.d((ConstraintLayout) (view17 == null ? null : view17.findViewById(e.j.a.Y5)));
                } else {
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        View view18 = getView();
        c.s.a0.b((ViewGroup) (view18 == null ? null : view18.findViewById(e.j.a.Y5)), translateTransition);
    }

    static /* synthetic */ void setSliderVisibility$default(AmountPickerFragment amountPickerFragment, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        amountPickerFragment.setSliderVisibility(z, z2);
    }

    /* renamed from: setSliderVisibility$lambda-16 */
    public static final void m1399setSliderVisibility$lambda16(AmountSliderView slider) {
        kotlin.jvm.internal.m.g(slider, "$slider");
        slider.setVisibility(0);
    }

    /* renamed from: setSliderVisibility$lambda-18 */
    public static final void m1400setSliderVisibility$lambda18(AmountSliderView slider) {
        kotlin.jvm.internal.m.g(slider, "$slider");
        slider.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setSwapButtonEnabled(boolean r12) {
        /*
            r11 = this;
            com.coinbase.wallet.features.commonui.views.AmountSliderView r0 = r11.amountSliderView
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
        L6:
            r0 = r2
            goto L14
        L8:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            if (r0 != r1) goto L6
            r0 = r1
        L14:
            if (r0 == 0) goto L17
            return
        L17:
            android.view.View r0 = r11.getView()
            r3 = 0
            if (r0 != 0) goto L20
            r0 = r3
            goto L26
        L20:
            int r4 = e.j.a.C6
            android.view.View r0 = r0.findViewById(r4)
        L26:
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            r0.setClickable(r12)
            r4 = 300(0x12c, double:1.48E-321)
            if (r12 == 0) goto L3a
            r12 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            float r0 = r11.getButtonElevation()
            goto L41
        L3a:
            r12 = 1061158912(0x3f400000, float:0.75)
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r0 = 0
        L41:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            kotlin.o r12 = kotlin.u.a(r12, r0)
            java.lang.Object r0 = r12.a()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r12 = r12.b()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            android.view.View r6 = r11.getView()
            if (r6 != 0) goto L65
            r6 = r3
            goto L6b
        L65:
            int r7 = e.j.a.C6
            android.view.View r6 = r6.findViewById(r7)
        L6b:
            r7 = 2
            float[] r8 = new float[r7]
            android.view.View r9 = r11.getView()
            if (r9 != 0) goto L76
            r9 = r3
            goto L7c
        L76:
            int r10 = e.j.a.C6
            android.view.View r9 = r9.findViewById(r10)
        L7c:
            android.widget.ImageButton r9 = (android.widget.ImageButton) r9
            float r9 = r9.getAlpha()
            r8[r2] = r9
            r8[r1] = r0
            java.lang.String r0 = "alpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r6, r0, r8)
            r0.setDuration(r4)
            r0.start()
            android.view.View r0 = r11.getView()
            if (r0 != 0) goto L9a
            r0 = r3
            goto La0
        L9a:
            int r6 = e.j.a.C6
            android.view.View r0 = r0.findViewById(r6)
        La0:
            float[] r6 = new float[r7]
            android.view.View r7 = r11.getView()
            if (r7 != 0) goto La9
            goto Laf
        La9:
            int r3 = e.j.a.C6
            android.view.View r3 = r7.findViewById(r3)
        Laf:
            android.widget.ImageButton r3 = (android.widget.ImageButton) r3
            float r3 = r3.getElevation()
            r6[r2] = r3
            r6[r1] = r12
            java.lang.String r12 = "elevation"
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r0, r12, r6)
            r12.setDuration(r4)
            r12.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.AmountPickerFragment.setSwapButtonEnabled(boolean):void");
    }

    private final void setupObservers() {
        AmountPickerViewModel amountPickerViewModel = this.viewModel;
        if (amountPickerViewModel != null) {
            h.c.s<SendBalances> observeOn = amountPickerViewModel.getBalancesObservable().observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "viewModel.balancesObservable\n            .observeOn(AndroidSchedulers.mainThread())");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.balancesObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new AmountPickerFragment$setupObservers$1(this), 3, null);
            AmountPickerViewModel amountPickerViewModel2 = this.viewModel;
            if (amountPickerViewModel2 != null) {
                h.c.s<String> observeOn2 = amountPickerViewModel2.getMaxSendAmountObservable().observeOn(h.c.j0.c.a.b());
                kotlin.jvm.internal.m.f(observeOn2, "viewModel.maxSendAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.views.r
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AmountPickerFragment.g(AmountPickerFragment.this, (String) obj);
                    }
                }).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.maxSendAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .flatMapSingle { amountFragment.updateCryptoAmount(it) }\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new AmountPickerFragment$setupObservers$3(this), 3, null);
                AmountPickerViewModel amountPickerViewModel3 = this.viewModel;
                if (amountPickerViewModel3 != null) {
                    Object as3 = amountPickerViewModel3.getSliderStateObservable().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "viewModel.sliderStateObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new AmountPickerFragment$setupObservers$4(this), 3, null);
                    h.c.t0.c cVar = h.c.t0.c.a;
                    AmountPickerViewModel amountPickerViewModel4 = this.viewModel;
                    if (amountPickerViewModel4 == null) {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                    h.c.s<Boolean> isBalanceSufficientObservable = amountPickerViewModel4.isBalanceSufficientObservable();
                    AmountPickerViewModel amountPickerViewModel5 = this.viewModel;
                    if (amountPickerViewModel5 != null) {
                        h.c.s distinctUntilChanged = cVar.a(isBalanceSufficientObservable, amountPickerViewModel5.isNextButtonHiddenObservable()).distinctUntilChanged();
                        long shortAnimDuration = getShortAnimDuration();
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        h.c.s observeOn3 = distinctUntilChanged.throttleLatest(shortAnimDuration, timeUnit, true).observeOn(h.c.j0.c.a.b());
                        kotlin.jvm.internal.m.f(observeOn3, "Observables.combineLatest(viewModel.isBalanceSufficientObservable, viewModel.isNextButtonHiddenObservable)\n            .distinctUntilChanged()\n            .throttleLatest(shortAnimDuration, TimeUnit.MILLISECONDS, true)\n            .observeOn(AndroidSchedulers.mainThread())");
                        Object as4 = Observable_AnalyticsKt.logError$default(observeOn3, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                        kotlin.jvm.internal.m.f(as4, "Observables.combineLatest(viewModel.isBalanceSufficientObservable, viewModel.isNextButtonHiddenObservable)\n            .distinctUntilChanged()\n            .throttleLatest(shortAnimDuration, TimeUnit.MILLISECONDS, true)\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new AmountPickerFragment$setupObservers$5(this), 3, null);
                        AmountPickerViewModel amountPickerViewModel6 = this.viewModel;
                        if (amountPickerViewModel6 != null) {
                            h.c.s<ViewModelNavRoute> observeOn4 = amountPickerViewModel6.getNavigateObservable().observeOn(h.c.j0.c.a.b());
                            kotlin.jvm.internal.m.f(observeOn4, "viewModel.navigateObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                            Object as5 = Observable_AnalyticsKt.logError$default(observeOn4, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                            kotlin.jvm.internal.m.f(as5, "viewModel.navigateObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as5, null, null, new AmountPickerFragment$setupObservers$6(this), 3, null);
                            AmountPickerViewModel amountPickerViewModel7 = this.viewModel;
                            if (amountPickerViewModel7 != null) {
                                h.c.s<String> observeOn5 = amountPickerViewModel7.getRestoredAmountObservable().observeOn(h.c.j0.c.a.b());
                                kotlin.jvm.internal.m.f(observeOn5, "viewModel.restoredAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                                Object as6 = Observable_AnalyticsKt.logError$default(observeOn5, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                                kotlin.jvm.internal.m.f(as6, "viewModel.restoredAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as6, null, null, new AmountPickerFragment$setupObservers$7(this), 3, null);
                                AmountPickerViewModel amountPickerViewModel8 = this.viewModel;
                                if (amountPickerViewModel8 != null) {
                                    h.c.s<String> observeOn6 = amountPickerViewModel8.getInterestInfoObservable().throttleLatest(getShortAnimDuration(), timeUnit, true).observeOn(h.c.j0.c.a.b());
                                    kotlin.jvm.internal.m.f(observeOn6, "viewModel.interestInfoObservable\n            .throttleLatest(shortAnimDuration, TimeUnit.MILLISECONDS, true)\n            .observeOn(AndroidSchedulers.mainThread())");
                                    Object as7 = Observable_AnalyticsKt.logError$default(observeOn6, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                                    kotlin.jvm.internal.m.f(as7, "viewModel.interestInfoObservable\n            .throttleLatest(shortAnimDuration, TimeUnit.MILLISECONDS, true)\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as7, null, null, new AmountPickerFragment$setupObservers$8(this), 3, null);
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

    /* renamed from: setupObservers$lambda-12 */
    public static final h.c.h0 m1401setupObservers$lambda12(AmountPickerFragment this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        AmountFragment amountFragment = this$0.amountFragment;
        if (amountFragment != null) {
            return amountFragment.updateCryptoAmount(it);
        }
        kotlin.jvm.internal.m.w("amountFragment");
        throw null;
    }

    private final void setupOnClickListeners() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(e.j.a.h3))).setOnDigitPressedListener(new NumberKeyboardInputView.OnDigitPressedListener() { // from class: com.coinbase.wallet.features.send.views.AmountPickerFragment$setupOnClickListeners$1
            @Override // com.coinbase.wallet.commonui.views.NumberKeyboardInputView.OnDigitPressedListener
            public void onDigitPressed(NumberKeyboardDigit digit, boolean z) {
                AmountFragment amountFragment;
                kotlin.jvm.internal.m.g(digit, "digit");
                amountFragment = AmountPickerFragment.this.amountFragment;
                if (amountFragment != null) {
                    amountFragment.updateAmount(digit, z);
                } else {
                    kotlin.jvm.internal.m.w("amountFragment");
                    throw null;
                }
            }
        });
        View view2 = getView();
        View maxButton = view2 == null ? null : view2.findViewById(e.j.a.N3);
        kotlin.jvm.internal.m.f(maxButton, "maxButton");
        View_CommonKt.setOnSingleClickListener$default(maxButton, 0L, new AmountPickerFragment$setupOnClickListeners$2(this), 1, null);
        View view3 = getView();
        View swapButton = view3 == null ? null : view3.findViewById(e.j.a.C6);
        kotlin.jvm.internal.m.f(swapButton, "swapButton");
        View_CommonKt.setOnSingleClickListener$default(swapButton, 0L, new AmountPickerFragment$setupOnClickListeners$3(this), 1, null);
        View view4 = getView();
        View sendAmountContainer = view4 == null ? null : view4.findViewById(e.j.a.W5);
        kotlin.jvm.internal.m.f(sendAmountContainer, "sendAmountContainer");
        View_CommonKt.setOnSingleClickListener$default(sendAmountContainer, 0L, new AmountPickerFragment$setupOnClickListeners$4(this), 1, null);
        View view5 = getView();
        View sliderButton = view5 == null ? null : view5.findViewById(e.j.a.sliderButton);
        kotlin.jvm.internal.m.f(sliderButton, "sliderButton");
        View_CommonKt.setOnSingleClickListener$default(sliderButton, 0L, new AmountPickerFragment$setupOnClickListeners$5(this), 1, null);
        View view6 = getView();
        View currencyPicker = view6 == null ? null : view6.findViewById(e.j.a.k1);
        kotlin.jvm.internal.m.f(currencyPicker, "currencyPicker");
        View_CommonKt.setOnSingleClickListener$default(currencyPicker, 0L, new AmountPickerFragment$setupOnClickListeners$6(this), 1, null);
        View view7 = getView();
        View closeButton = view7 == null ? null : view7.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new AmountPickerFragment$setupOnClickListeners$7(this), 1, null);
        View view8 = getView();
        View nextButton = view8 != null ? view8.findViewById(e.j.a.s4) : null;
        kotlin.jvm.internal.m.f(nextButton, "nextButton");
        View_CommonKt.setOnSingleClickListener$default(nextButton, 0L, new AmountPickerFragment$setupOnClickListeners$8(this), 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x001f, code lost:
        if (r0 == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setupSendAmountView(com.coinbase.wallet.blockchains.models.Wallet r11) {
        /*
            r10 = this;
            com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel r0 = r10.viewModel
            r1 = 0
            if (r0 == 0) goto L98
            boolean r0 = r0.isFiatSelected()
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L21
            com.coinbase.wallet.features.commonui.views.AmountSliderView r0 = r10.amountSliderView
            if (r0 != 0) goto L13
        L11:
            r0 = r2
            goto L1f
        L13:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L1b
            r0 = r3
            goto L1c
        L1b:
            r0 = r2
        L1c:
            if (r0 != r3) goto L11
            r0 = r3
        L1f:
            if (r0 == 0) goto L22
        L21:
            r2 = r3
        L22:
            com.coinbase.wallet.features.send.views.AmountFragment r0 = r10.amountFragment
            java.lang.String r3 = "amountFragment"
            if (r0 == 0) goto L94
            r0.setup(r11, r2)
            com.coinbase.wallet.features.send.views.AmountFragment r11 = r10.amountFragment
            if (r11 == 0) goto L90
            h.c.s r11 = r11.getKeyboardLocaleObservable()
            h.c.a0 r0 = h.c.j0.c.a.b()
            h.c.s r11 = r11.observeOn(r0)
            com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider r0 = r10.getOnDestroyScopeProvider()
            com.uber.autodispose.g r0 = com.uber.autodispose.d.a(r0)
            java.lang.Object r11 = r11.as(r0)
            java.lang.String r0 = "amountFragment.keyboardLocaleObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(onDestroyScopeProvider))"
            kotlin.jvm.internal.m.f(r11, r0)
            r4 = r11
            com.uber.autodispose.x r4 = (com.uber.autodispose.x) r4
            r5 = 0
            r6 = 0
            com.coinbase.wallet.features.send.views.AmountPickerFragment$setupSendAmountView$1 r7 = new com.coinbase.wallet.features.send.views.AmountPickerFragment$setupSendAmountView$1
            r7.<init>(r10)
            r8 = 3
            r9 = 0
            com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt.subscribeBy$default(r4, r5, r6, r7, r8, r9)
            com.coinbase.wallet.features.send.views.AmountFragment r11 = r10.amountFragment
            if (r11 == 0) goto L8c
            h.c.s r11 = r11.getCryptoAmountObservable()
            h.c.a0 r0 = h.c.j0.c.a.b()
            h.c.s r11 = r11.observeOn(r0)
            com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider r0 = r10.getOnDestroyScopeProvider()
            com.uber.autodispose.g r0 = com.uber.autodispose.d.a(r0)
            java.lang.Object r11 = r11.as(r0)
            java.lang.String r0 = "amountFragment.cryptoAmountObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(onDestroyScopeProvider))"
            kotlin.jvm.internal.m.f(r11, r0)
            r1 = r11
            com.uber.autodispose.x r1 = (com.uber.autodispose.x) r1
            r2 = 0
            r3 = 0
            com.coinbase.wallet.features.send.views.AmountPickerFragment$setupSendAmountView$2 r4 = new com.coinbase.wallet.features.send.views.AmountPickerFragment$setupSendAmountView$2
            r4.<init>(r10)
            r5 = 3
            r6 = 0
            com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt.subscribeBy$default(r1, r2, r3, r4, r5, r6)
            return
        L8c:
            kotlin.jvm.internal.m.w(r3)
            throw r1
        L90:
            kotlin.jvm.internal.m.w(r3)
            throw r1
        L94:
            kotlin.jvm.internal.m.w(r3)
            throw r1
        L98:
            java.lang.String r11 = "viewModel"
            kotlin.jvm.internal.m.w(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.AmountPickerFragment.setupSendAmountView(com.coinbase.wallet.blockchains.models.Wallet):void");
    }

    private final void setupViews() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.N3))).setClickable(false);
        View view2 = getView();
        ((ImageButton) (view2 == null ? null : view2.findViewById(e.j.a.C6))).setClickable(false);
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.s4))).setVisibility(0);
        View view4 = getView();
        ((Button) (view4 == null ? null : view4.findViewById(e.j.a.s4))).setEnabled(false);
        View view5 = getView();
        ((Button) (view5 == null ? null : view5.findViewById(e.j.a.s4))).setAlpha(0.0f);
        View view6 = getView();
        View ctaContainer = view6 != null ? view6.findViewById(e.j.a.e1) : null;
        kotlin.jvm.internal.m.f(ctaContainer, "ctaContainer");
        ctaContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coinbase.wallet.features.send.views.AmountPickerFragment$setupViews$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view7, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                kotlin.jvm.internal.m.g(view7, "view");
                view7.removeOnLayoutChangeListener(this);
                View view8 = AmountPickerFragment.this.getView();
                ((LinearLayout) (view8 == null ? null : view8.findViewById(e.j.a.e1))).setTranslationY(AmountPickerFragment.access$getNextButtonTranslateAmount(AmountPickerFragment.this));
            }
        });
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

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment childFragment) {
        kotlin.jvm.internal.m.g(childFragment, "childFragment");
        super.onAttachFragment(childFragment);
        if (getView() != null && (childFragment instanceof AmountFragment)) {
            AmountPickerFragment$onAttachFragment$setupWallet$1 amountPickerFragment$onAttachFragment$setupWallet$1 = new AmountPickerFragment$onAttachFragment$setupWallet$1(this);
            AmountFragment amountFragment = (AmountFragment) childFragment;
            this.amountFragment = amountFragment;
            if (amountFragment != null) {
                Object as = Single_AnalyticsKt.logError$default(amountFragment.isViewLoadedSingle(), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "amountFragment.isViewLoadedSingle\n                .logError()\n                .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new AmountPickerFragment$onAttachFragment$1(this, amountPickerFragment$onAttachFragment$setupWallet$1), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("amountFragment");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        AnalyticsEvent sendCoinAmountLanded;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String name = AmountPickerViewModel.class.getName();
        kotlin.jvm.internal.m.f(name, "AmountPickerViewModel::class.java.name");
        Serializable c2 = e.j.f.e.c(arguments, name);
        if (c2 != null) {
            if (c2 instanceof Class) {
                Class cls = (Class) c2;
                if (AmountPickerViewModel.class.isAssignableFrom(cls)) {
                    androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(cls);
                    kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory)\n            .get(clazz)");
                    AmountPickerViewModel amountPickerViewModel = (AmountPickerViewModel) a;
                    Bundle requireArguments = requireArguments();
                    kotlin.jvm.internal.m.f(requireArguments, "requireArguments()");
                    amountPickerViewModel.setArgs(requireArguments);
                    kotlin.x xVar = kotlin.x.a;
                    this.viewModel = amountPickerViewModel;
                    if (amountPickerViewModel != null) {
                        if (amountPickerViewModel.getSettings().isLend()) {
                            sendCoinAmountLanded = AnalyticsEvent_ApplicationKt.lendAmountPickerLanded(AnalyticsEvent.Companion);
                        } else {
                            sendCoinAmountLanded = AnalyticsEvent_ApplicationKt.sendCoinAmountLanded(AnalyticsEvent.Companion);
                        }
                        Analytics.INSTANCE.log(sendCoinAmountLanded);
                        AmountPickerViewModel amountPickerViewModel2 = this.viewModel;
                        if (amountPickerViewModel2 != null) {
                            amountPickerViewModel2.clearCachedCryptoAmount();
                            return;
                        } else {
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
            }
            throw new IllegalStateException("Class " + c2 + " is not assignable from " + AmountPickerViewModel.class);
        }
        throw new IllegalStateException("Class this is null");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        androidx.fragment.app.u j2 = getChildFragmentManager().j();
        AmountFragment amountFragment = new AmountFragment();
        this.amountFragment = amountFragment;
        if (amountFragment != null) {
            j2.t(R.id.sendAmountContainer, amountFragment, kotlin.jvm.internal.e0.b(AmountFragment.class).getSimpleName());
            j2.j();
            return inflater.inflate(R.layout.fragment_amount_picker, viewGroup, false);
        }
        kotlin.jvm.internal.m.w("amountFragment");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AmountPickerViewModel amountPickerViewModel = this.viewModel;
        if (amountPickerViewModel != null) {
            amountPickerViewModel.onResume();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setupViews();
        setupOnClickListeners();
        setupObservers();
        applyStyle();
    }

    public final void setViewModelFactory$app_productionRelease(ViewModelFactoryWithMap viewModelFactoryWithMap) {
        kotlin.jvm.internal.m.g(viewModelFactoryWithMap, "<set-?>");
        this.viewModelFactory = viewModelFactoryWithMap;
    }
}