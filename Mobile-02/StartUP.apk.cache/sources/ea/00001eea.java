package com.coinbase.wallet.features.lend.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.b0;
import androidx.viewpager.widget.ViewPager;
import c.h.k.d0;
import c.h.k.s;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.lend.viewmodels.LendUserAgreementViewModel;
import com.coinbase.wallet.features.lend.views.adapters.LendUserAgreementAdapter;
import com.uber.autodispose.x;
import h.c.a0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: LendUserAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendUserAgreementFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupClickListeners", "()V", "setupViewPager", "setupObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/lend/viewmodels/LendUserAgreementViewModel;", "userAgreementViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getUserAgreementViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setUserAgreementViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModel", "Lcom/coinbase/wallet/features/lend/viewmodels/LendUserAgreementViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/lend/viewmodels/LendUserAgreementViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/lend/viewmodels/LendUserAgreementViewModel;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/a0;", "mainScheduler$delegate", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendUserAgreementFragment extends BaseFragment implements StyledFragment {
    private static final long BUTTON_ANIMATION_DURATION = 300;
    public static final Companion Companion = new Companion(null);
    private static final float DISABLED_ALPHA = 0.5f;
    private static final float ENABLED_ALPHA = 1.0f;
    private final h mainScheduler$delegate;
    public GenericViewModelFactory<LendUserAgreementViewModel> userAgreementViewModelFactory;
    public LendUserAgreementViewModel viewModel;

    /* compiled from: LendUserAgreementFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/LendUserAgreementFragment$Companion;", "", "", "BUTTON_ANIMATION_DURATION", "J", "", "DISABLED_ALPHA", "F", "ENABLED_ALPHA", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LendUserAgreementFragment() {
        h b2;
        b2 = k.b(LendUserAgreementFragment$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b2;
    }

    public static /* synthetic */ void d(View view, float f2) {
        m1294setupViewPager$lambda1(view, f2);
    }

    public final a0 getMainScheduler() {
        Object value = this.mainScheduler$delegate.getValue();
        m.f(value, "<get-mainScheduler>(...)");
        return (a0) value;
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void setupClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new LendUserAgreementFragment$setupClickListeners$1(this), 1, null);
        View view2 = getView();
        View startLendingButton = view2 != null ? view2.findViewById(e.j.a.startLendingButton) : null;
        m.f(startLendingButton, "startLendingButton");
        View_CommonKt.setOnSingleClickListener$default(startLendingButton, 0L, new LendUserAgreementFragment$setupClickListeners$2(this), 1, null);
    }

    private final void setupObservers() {
        Object as = getViewModel().getStateObservable().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as, "viewModel.stateObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new LendUserAgreementFragment$setupObservers$1(this), 3, null);
        Object as2 = getViewModel().getNavigationObservable().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()));
        m.f(as2, "viewModel.navigationObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new LendUserAgreementFragment$setupObservers$2(this), 3, null);
    }

    private final void setupViewPager() {
        View view = getView();
        ((ViewPager) (view == null ? null : view.findViewById(e.j.a.introViewPager))).setAdapter(new LendUserAgreementAdapter(getViewModel().getData(), new LendUserAgreementFragment$setupViewPager$1(this)));
        View view2 = getView();
        ((ViewPager) (view2 == null ? null : view2.findViewById(e.j.a.introViewPager))).addOnPageChangeListener(new ViewPager.j() { // from class: com.coinbase.wallet.features.lend.views.LendUserAgreementFragment$setupViewPager$2
            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i2) {
                LendUserAgreementFragment.this.getViewModel().onPageChanged(i2);
            }
        });
        e eVar = new ViewPager.k() { // from class: com.coinbase.wallet.features.lend.views.e
            @Override // androidx.viewpager.widget.ViewPager.k
            public final void a(View view3, float f2) {
                LendUserAgreementFragment.d(view3, f2);
            }
        };
        View view3 = getView();
        ((ViewPager) (view3 != null ? view3.findViewById(e.j.a.introViewPager) : null)).setPageTransformer(true, eVar);
    }

    /* renamed from: setupViewPager$lambda-1 */
    public static final void m1294setupViewPager$lambda1(View page, float f2) {
        m.g(page, "page");
        float f3 = 0.0f;
        if (f2 > -1.0f && f2 < ENABLED_ALPHA) {
            f3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? 1.0f : ENABLED_ALPHA - Math.abs(f2);
        }
        page.setAlpha(f3);
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

    public final GenericViewModelFactory<LendUserAgreementViewModel> getUserAgreementViewModelFactory() {
        GenericViewModelFactory<LendUserAgreementViewModel> genericViewModelFactory = this.userAgreementViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("userAgreementViewModelFactory");
        throw null;
    }

    public final LendUserAgreementViewModel getViewModel() {
        LendUserAgreementViewModel lendUserAgreementViewModel = this.viewModel;
        if (lendUserAgreementViewModel != null) {
            return lendUserAgreementViewModel;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_lend_user_agreement, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        postponeEnterTransition();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendUserAgreementLanded(AnalyticsEvent.Companion));
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) parent;
        m.f(s.a(viewGroup, new Runnable() { // from class: com.coinbase.wallet.features.lend.views.LendUserAgreementFragment$onViewCreated$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                this.startPostponedEnterTransition();
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        b0 a = new androidx.lifecycle.d0(this, getUserAgreementViewModelFactory()).a(LendUserAgreementViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((LendUserAgreementViewModel) a);
        setupClickListeners();
        setupObservers();
        setupViewPager();
    }

    public final void setUserAgreementViewModelFactory(GenericViewModelFactory<LendUserAgreementViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.userAgreementViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModel(LendUserAgreementViewModel lendUserAgreementViewModel) {
        m.g(lendUserAgreementViewModel, "<set-?>");
        this.viewModel = lendUserAgreementViewModel;
    }
}