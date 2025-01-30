package com.coinbase.wallet.application.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.m;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import androidx.navigation.fragment.b;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.view.custom.TopAwareMotionLayout;
import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.send.models.SendCoinPickerArgs;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.routing.models.SendArgs;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import com.coinbase.wallet.user.models.User;
import com.google.android.material.tabs.TabLayout;
import com.toshi.qr.view.fragment.UniversalQRScannerFragment;
import com.uber.autodispose.x;
import e.j.h.a.j;
import e.j.m.a.s;
import e.j.n.l2;
import h.c.a0;
import h.c.h0;
import h.c.m0.f;
import h.c.m0.n;
import h.c.m0.p;
import h.c.t0.e;
import h.c.t0.g;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.h;
import kotlin.k;
import kotlin.o;
import kotlin.u;
import org.toshi.R;

/* compiled from: HomeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b]\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005R\u001d\u0010(\u001a\u00020#8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R(\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010B\u001a\n A*\u0004\u0018\u00010@0@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR(\u0010H\u001a\b\u0012\u0004\u0012\u00020)0,8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bH\u0010/\u001a\u0004\bI\u00101\"\u0004\bJ\u00103R(\u0010K\u001a\b\u0012\u0004\u0012\u00020:0,8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bK\u0010/\u001a\u0004\bL\u00101\"\u0004\bM\u00103R\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020D8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010FR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010YR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bZ\u0010/\u001a\u0004\b[\u00101\"\u0004\b\\\u00103¨\u0006^"}, d2 = {"Lcom/coinbase/wallet/application/view/HomeFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "initButtons", "()V", "initViewModel", "initAdapter", "initRefreshListener", "initObservables", "navigateToUniversalQRScannerFragment", "", "isEnabled", "setRefreshEnable", "(Z)V", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navRoute", "showFundActionSheet", "(Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;)V", "setupScanningPill", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "Lkotlin/h;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/application/viewmodel/LoadingPillViewModel;", "loadingPillViewModel", "Lcom/coinbase/wallet/application/viewmodel/LoadingPillViewModel;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/l2;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Le/j/m/a/s;", "walletAdapter", "Le/j/m/a/s;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Le/j/h/a/j;", "qrScannerViewModel", "Le/j/h/a/j;", "Landroidx/navigation/fragment/b$b;", "fragmentNavigatorExtras", "Landroidx/navigation/fragment/b$b;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "loadingPillViewModelFactory", "getLoadingPillViewModelFactory$app_productionRelease", "setLoadingPillViewModelFactory$app_productionRelease", "qrScannerViewModelFactory", "getQrScannerViewModelFactory$app_productionRelease", "setQrScannerViewModelFactory$app_productionRelease", "isLoadingPillAnimating", "Z", "Landroid/graphics/drawable/AnimatedVectorDrawable;", "loadingRingAnimation", "Landroid/graphics/drawable/AnimatedVectorDrawable;", "viewModel", "Le/j/n/l2;", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModel", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModelFactory", "getScrolledToTopViewModelFactory", "setScrolledToTopViewModelFactory", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HomeFragment extends LockedFragment implements StyledFragment {
    private final h attributes$delegate;
    private b.C0036b fragmentNavigatorExtras;
    private boolean isLoadingPillAnimating;
    private LoadingPillViewModel loadingPillViewModel;
    public GenericViewModelFactory<LoadingPillViewModel> loadingPillViewModelFactory;
    private AnimatedVectorDrawable loadingRingAnimation;
    private j qrScannerViewModel;
    public GenericViewModelFactory<j> qrScannerViewModelFactory;
    private ScrolledToTopViewModel scrolledToTopViewModel;
    public GenericViewModelFactory<ScrolledToTopViewModel> scrolledToTopViewModelFactory;
    private l2 viewModel;
    public GenericViewModelFactory<l2> viewModelFactory;
    private s walletAdapter;
    private final a0 mainScheduler = h.c.j0.c.a.b();
    private h.c.k0.a disposeBag = new h.c.k0.a();

    public HomeFragment() {
        h b2;
        b2 = k.b(new HomeFragment$attributes$2(this));
        this.attributes$delegate = b2;
    }

    public static final /* synthetic */ AnimatedVectorDrawable access$getLoadingRingAnimation$p(HomeFragment homeFragment) {
        return homeFragment.loadingRingAnimation;
    }

    public static final /* synthetic */ boolean access$isLoadingPillAnimating$p(HomeFragment homeFragment) {
        return homeFragment.isLoadingPillAnimating;
    }

    public static /* synthetic */ void d(HomeFragment homeFragment, o oVar) {
        m691navigateToUniversalQRScannerFragment$lambda3(homeFragment, oVar);
    }

    public static /* synthetic */ boolean e(Boolean bool) {
        return m688initObservables$lambda1(bool);
    }

    public static /* synthetic */ h0 f(HomeFragment homeFragment, List list) {
        return m690navigateToUniversalQRScannerFragment$lambda2(homeFragment, list);
    }

    public static /* synthetic */ void g(HomeFragment homeFragment) {
        m689initRefreshListener$lambda0(homeFragment);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void initAdapter() {
        List j2;
        j2 = r.j(getString(R.string.coins), getString(R.string.collectibles));
        o[] oVarArr = new o[1];
        View view = getView();
        oVarArr[0] = u.a(view == null ? null : view.findViewById(e.j.a.A7), getString(R.string.shared_element_transition_wallet_card));
        b.C0036b a = androidx.navigation.fragment.c.a(oVarArr);
        this.fragmentNavigatorExtras = a;
        m childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.m.f(childFragmentManager, "childFragmentManager");
        this.walletAdapter = new s(j2, childFragmentManager, a);
        View view2 = getView();
        ViewPager viewPager = (ViewPager) (view2 == null ? null : view2.findViewById(e.j.a.walletViewPager));
        s sVar = this.walletAdapter;
        if (sVar != null) {
            viewPager.setAdapter(sVar);
            View view3 = getView();
            ((ViewPager) (view3 == null ? null : view3.findViewById(e.j.a.walletViewPager))).setPageTransformer(true, new com.toshi.view.fragment.s0.a());
            View view4 = getView();
            TabLayout tabLayout = (TabLayout) (view4 == null ? null : view4.findViewById(e.j.a.walletTabLayout));
            View view5 = getView();
            tabLayout.setupWithViewPager((ViewPager) (view5 == null ? null : view5.findViewById(e.j.a.walletViewPager)));
            View view6 = getView();
            ((TabLayout) (view6 == null ? null : view6.findViewById(e.j.a.walletTabLayout))).setTabIndicatorFullWidth(true);
            View view7 = getView();
            ((TabLayout) (view7 != null ? view7.findViewById(e.j.a.walletTabLayout) : null)).b(new TabLayout.c() { // from class: com.coinbase.wallet.application.view.HomeFragment$initAdapter$1
                @Override // com.google.android.material.tabs.TabLayout.c
                public void onTabReselected(TabLayout.f fVar) {
                }

                @Override // com.google.android.material.tabs.TabLayout.c
                public void onTabSelected(TabLayout.f fVar) {
                    if (fVar == null) {
                        return;
                    }
                    View view8 = HomeFragment.this.getView();
                    ((ViewPager) (view8 == null ? null : view8.findViewById(e.j.a.walletViewPager))).setCurrentItem(fVar.e(), false);
                    if (fVar.e() == 0) {
                        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.coinsTabLanded(AnalyticsEvent.Companion));
                    } else {
                        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.collectibleTabLanded(AnalyticsEvent.Companion));
                    }
                }

                @Override // com.google.android.material.tabs.TabLayout.c
                public void onTabUnselected(TabLayout.f fVar) {
                }
            });
            return;
        }
        kotlin.jvm.internal.m.w("walletAdapter");
        throw null;
    }

    private final void initButtons() {
        View view = getView();
        View walletReceiveButton = view == null ? null : view.findViewById(e.j.a.walletReceiveButton);
        kotlin.jvm.internal.m.f(walletReceiveButton, "walletReceiveButton");
        View_CommonKt.setOnSingleClickListener$default(walletReceiveButton, 0L, new HomeFragment$initButtons$1(this), 1, null);
        View view2 = getView();
        View walletSendButton = view2 == null ? null : view2.findViewById(e.j.a.walletSendButton);
        kotlin.jvm.internal.m.f(walletSendButton, "walletSendButton");
        View_CommonKt.setOnSingleClickListener$default(walletSendButton, 0L, new HomeFragment$initButtons$2(this), 1, null);
        View view3 = getView();
        View walletSwapButton = view3 == null ? null : view3.findViewById(e.j.a.walletSwapButton);
        kotlin.jvm.internal.m.f(walletSwapButton, "walletSwapButton");
        View_CommonKt.setOnSingleClickListener$default(walletSwapButton, 0L, new HomeFragment$initButtons$3(this), 1, null);
        View view4 = getView();
        View universalQrScanner = view4 != null ? view4.findViewById(e.j.a.universalQrScanner) : null;
        kotlin.jvm.internal.m.f(universalQrScanner, "universalQrScanner");
        View_CommonKt.setOnSingleClickListener$default(universalQrScanner, 0L, new HomeFragment$initButtons$4(this), 1, null);
    }

    @SuppressLint({"CheckResult"})
    private final void initObservables() {
        l2 l2Var = this.viewModel;
        if (l2Var != null) {
            h.c.s<User> observeOn = l2Var.e().observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.activeUser\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while fetching user", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.activeUser\n            .observeOn(mainScheduler)\n            .logError(\"Error while fetching user\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, new HomeFragment$initObservables$1(this), null, new HomeFragment$initObservables$2(this), 2, null);
            l2 l2Var2 = this.viewModel;
            if (l2Var2 != null) {
                h.c.s<String> observeOn2 = l2Var2.f().observeOn(this.mainScheduler);
                kotlin.jvm.internal.m.f(observeOn2, "viewModel.balanceObservable\n            .observeOn(mainScheduler)");
                Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, "Error while fetching balance", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.balanceObservable\n            .observeOn(mainScheduler)\n            .logError(\"Error while fetching balance\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new HomeFragment$initObservables$3(this), 3, null);
                View view = getView();
                TopAwareMotionLayout topAwareMotionLayout = (TopAwareMotionLayout) (view == null ? null : view.findViewById(e.j.a.walletConstraintParent));
                ScrolledToTopViewModel scrolledToTopViewModel = this.scrolledToTopViewModel;
                if (scrolledToTopViewModel != null) {
                    Object as3 = topAwareMotionLayout.startIsTouchedListener(scrolledToTopViewModel).as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "walletConstraintParent.startIsTouchedListener(scrolledToTopViewModel)\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as3, null, null, HomeFragment$initObservables$4.INSTANCE, 3, null);
                    l2 l2Var3 = this.viewModel;
                    if (l2Var3 != null) {
                        h.c.s<Boolean> observeOn3 = l2Var3.m().observeOn(this.mainScheduler);
                        kotlin.jvm.internal.m.f(observeOn3, "viewModel.isRefreshing\n            .observeOn(mainScheduler)");
                        Object as4 = Observable_AnalyticsKt.logError$default(observeOn3, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as4, "viewModel.isRefreshing\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as4, null, null, new HomeFragment$initObservables$5(this), 3, null);
                        l2 l2Var4 = this.viewModel;
                        if (l2Var4 != null) {
                            h.c.s<Boolean> observeOn4 = l2Var4.m().distinctUntilChanged().filter(new p() { // from class: com.coinbase.wallet.application.view.b
                                @Override // h.c.m0.p
                                public final boolean test(Object obj) {
                                    return HomeFragment.e((Boolean) obj);
                                }
                            }).observeOn(this.mainScheduler);
                            kotlin.jvm.internal.m.f(observeOn4, "viewModel.isRefreshing\n            .distinctUntilChanged()\n            .filter { !it }\n            .observeOn(mainScheduler)");
                            Object as5 = Observable_AnalyticsKt.logError$default(observeOn4, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                            kotlin.jvm.internal.m.f(as5, "viewModel.isRefreshing\n            .distinctUntilChanged()\n            .filter { !it }\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as5, null, null, new HomeFragment$initObservables$7(this), 3, null);
                            l2 l2Var5 = this.viewModel;
                            if (l2Var5 != null) {
                                h.c.s<List<AnalyticsUserProperty>> observeOn5 = l2Var5.h().observeOn(this.mainScheduler);
                                kotlin.jvm.internal.m.f(observeOn5, "viewModel.hasAssetBalanceObservable\n            .observeOn(mainScheduler)");
                                Object as6 = Observable_AnalyticsKt.logError$default(observeOn5, "Could not report user asset property change to analytics", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                                kotlin.jvm.internal.m.f(as6, "viewModel.hasAssetBalanceObservable\n            .observeOn(mainScheduler)\n            .logError(\"Could not report user asset property change to analytics\")\n            .`as`(autoDisposable(scopeProvider))");
                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as6, null, null, HomeFragment$initObservables$8.INSTANCE, 3, null);
                                l2 l2Var6 = this.viewModel;
                                if (l2Var6 != null) {
                                    h.c.s<Boolean> observeOn6 = l2Var6.k().observeOn(this.mainScheduler);
                                    kotlin.jvm.internal.m.f(observeOn6, "viewModel.userHasActivated\n            .observeOn(mainScheduler)");
                                    Object as7 = Observable_AnalyticsKt.logError$default(observeOn6, "Error could not post 'IS_ACTIVATED' user property to analytics", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                                    kotlin.jvm.internal.m.f(as7, "viewModel.userHasActivated\n            .observeOn(mainScheduler)\n            .logError(\"Error could not post 'IS_ACTIVATED' user property to analytics\")\n            .`as`(autoDisposable(scopeProvider))");
                                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as7, null, null, HomeFragment$initObservables$9.INSTANCE, 3, null);
                                    l2 l2Var7 = this.viewModel;
                                    if (l2Var7 != null) {
                                        h.c.s<Boolean> observeOn7 = l2Var7.g().observeOn(this.mainScheduler);
                                        kotlin.jvm.internal.m.f(observeOn7, "viewModel.collectiblesAreNonZero\n            .observeOn(mainScheduler)");
                                        Object as8 = Observable_AnalyticsKt.logError$default(observeOn7, "Could not report 'HAS_ETH' user property change to analytics", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                                        kotlin.jvm.internal.m.f(as8, "viewModel.collectiblesAreNonZero\n            .observeOn(mainScheduler)\n            .logError(\"Could not report 'HAS_ETH' user property change to analytics\")\n            .`as`(autoDisposable(scopeProvider))");
                                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as8, null, null, HomeFragment$initObservables$10.INSTANCE, 3, null);
                                        l2 l2Var8 = this.viewModel;
                                        if (l2Var8 != null) {
                                            Object as9 = l2Var8.i().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                                            kotlin.jvm.internal.m.f(as9, "viewModel.launchSendFlowObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as9, null, null, new HomeFragment$initObservables$11(this), 3, null);
                                            l2 l2Var9 = this.viewModel;
                                            if (l2Var9 != null) {
                                                Object as10 = l2Var9.j().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                                                kotlin.jvm.internal.m.f(as10, "viewModel.showTransferWalletsActionObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as10, null, null, new HomeFragment$initObservables$12(this), 3, null);
                                                LoadingPillViewModel loadingPillViewModel = this.loadingPillViewModel;
                                                if (loadingPillViewModel != null) {
                                                    h.c.s<Boolean> distinctUntilChanged = loadingPillViewModel.getLoadingPillShownObservable().distinctUntilChanged();
                                                    kotlin.jvm.internal.m.f(distinctUntilChanged, "loadingPillViewModel.loadingPillShownObservable\n            .distinctUntilChanged()");
                                                    Object as11 = Observable_AnalyticsKt.logError$default(distinctUntilChanged, "Could not update showing/not showing Loading Pill", null, 2, null).observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                                                    kotlin.jvm.internal.m.f(as11, "loadingPillViewModel.loadingPillShownObservable\n            .distinctUntilChanged()\n            .logError(\"Could not update showing/not showing Loading Pill\")\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as11, null, null, new HomeFragment$initObservables$13(this), 3, null);
                                                    View view2 = getView();
                                                    TopAwareMotionLayout topAwareMotionLayout2 = (TopAwareMotionLayout) (view2 == null ? null : view2.findViewById(e.j.a.walletConstraintParent));
                                                    ScrolledToTopViewModel scrolledToTopViewModel2 = this.scrolledToTopViewModel;
                                                    if (scrolledToTopViewModel2 != null) {
                                                        Object as12 = topAwareMotionLayout2.startRefreshableListener(scrolledToTopViewModel2).as(com.uber.autodispose.d.a(getScopeProvider()));
                                                        kotlin.jvm.internal.m.f(as12, "walletConstraintParent.startRefreshableListener(scrolledToTopViewModel)\n            .`as`(autoDisposable(scopeProvider))");
                                                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as12, null, null, new HomeFragment$initObservables$14(this), 3, null);
                                                        View view3 = getView();
                                                        TopAwareMotionLayout topAwareMotionLayout3 = (TopAwareMotionLayout) (view3 == null ? null : view3.findViewById(e.j.a.walletConstraintParent));
                                                        ScrolledToTopViewModel scrolledToTopViewModel3 = this.scrolledToTopViewModel;
                                                        if (scrolledToTopViewModel3 != null) {
                                                            Object as13 = topAwareMotionLayout3.startTransitionSwapListener(scrolledToTopViewModel3).as(com.uber.autodispose.d.a(getScopeProvider()));
                                                            kotlin.jvm.internal.m.f(as13, "walletConstraintParent.startTransitionSwapListener(scrolledToTopViewModel)\n            .`as`(autoDisposable(scopeProvider))");
                                                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as13, null, null, HomeFragment$initObservables$15.INSTANCE, 3, null);
                                                            l2 l2Var10 = this.viewModel;
                                                            if (l2Var10 != null) {
                                                                h.c.s<ViewModelNavRoute> observeOn8 = l2Var10.getNavigationObservable().observeOn(this.mainScheduler);
                                                                kotlin.jvm.internal.m.f(observeOn8, "viewModel.navigationObservable\n            .observeOn(mainScheduler)");
                                                                Object as14 = Observable_AnalyticsKt.logError$default(observeOn8, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                                                                kotlin.jvm.internal.m.f(as14, "viewModel.navigationObservable\n            .observeOn(mainScheduler)\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
                                                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as14, null, null, new HomeFragment$initObservables$16(this), 3, null);
                                                                l2 l2Var11 = this.viewModel;
                                                                if (l2Var11 != null) {
                                                                    h.c.s<Boolean> observeOn9 = l2Var11.n().observeOn(h.c.j0.c.a.b());
                                                                    kotlin.jvm.internal.m.f(observeOn9, "viewModel.isSwapEnabled\n            .observeOn(AndroidSchedulers.mainThread())");
                                                                    g.h(observeOn9, null, null, new HomeFragment$initObservables$17(this), 3, null);
                                                                    return;
                                                                }
                                                                kotlin.jvm.internal.m.w("viewModel");
                                                                throw null;
                                                            }
                                                            kotlin.jvm.internal.m.w("viewModel");
                                                            throw null;
                                                        }
                                                        kotlin.jvm.internal.m.w("scrolledToTopViewModel");
                                                        throw null;
                                                    }
                                                    kotlin.jvm.internal.m.w("scrolledToTopViewModel");
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.m.w("loadingPillViewModel");
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
                kotlin.jvm.internal.m.w("scrolledToTopViewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: initObservables$lambda-1 */
    public static final boolean m688initObservables$lambda1(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.booleanValue();
    }

    private final void initRefreshListener() {
        View view = getView();
        ((SwipeRefreshLayout) (view == null ? null : view.findViewById(e.j.a.walletRefreshLayout))).setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.coinbase.wallet.application.view.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                HomeFragment.g(HomeFragment.this);
            }
        });
        View view2 = getView();
        ((SwipeRefreshLayout) (view2 != null ? view2.findViewById(e.j.a.walletRefreshLayout) : null)).setSlingshotDistance(200);
    }

    /* renamed from: initRefreshListener$lambda-0 */
    public static final void m689initRefreshListener$lambda0(HomeFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        l2 l2Var = this$0.viewModel;
        if (l2Var != null) {
            ((com.uber.autodispose.a0) Single_AnalyticsKt.logError$default(l2Var.x(true), null, null, 3, null).as(com.uber.autodispose.d.a(this$0.getOnDestroyScopeProvider()))).subscribe();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void initViewModel() {
        b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(l2.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (l2) a;
        b0 a2 = new d0(requireActivity(), getLoadingPillViewModelFactory$app_productionRelease()).a(LoadingPillViewModel.class);
        kotlin.jvm.internal.m.f(a2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        this.loadingPillViewModel = (LoadingPillViewModel) a2;
        b0 a3 = new d0(requireActivity(), getScrolledToTopViewModelFactory()).a(ScrolledToTopViewModel.class);
        kotlin.jvm.internal.m.f(a3, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        this.scrolledToTopViewModel = (ScrolledToTopViewModel) a3;
        GenericViewModelFactory<j> qrScannerViewModelFactory$app_productionRelease = getQrScannerViewModelFactory$app_productionRelease();
        b0 b2 = new d0(requireActivity(), qrScannerViewModelFactory$app_productionRelease).b(HomeFragment.class.getName(), j.class);
        kotlin.jvm.internal.m.f(b2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(key, T::class.java)\n}");
        this.qrScannerViewModel = (j) b2;
    }

    @SuppressLint({"AutoDispose"})
    public final void navigateToUniversalQRScannerFragment() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.universalQrScannerClicked(AnalyticsEvent.Companion));
        UniversalQRScannerFragment.a aVar = UniversalQRScannerFragment.a;
        String name = HomeFragment.class.getName();
        kotlin.jvm.internal.m.f(name, "HomeFragment::class.java.name");
        Fragment_CommonKt.navigate$default(this, R.id.action_walletFragment_to_universalQRScannerFragment, aVar.a(true, name), Fragment_CommonKt.getVerticalNavOptions(this), null, 8, null);
        j jVar = this.qrScannerViewModel;
        if (jVar != null) {
            h.c.s<R> flatMapSingle = jVar.a().flatMapSingle(new n() { // from class: com.coinbase.wallet.application.view.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return HomeFragment.f(HomeFragment.this, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMapSingle, "qrScannerViewModel.qrScanResultObservable\n            .flatMapSingle { Singles.zip(Single.just(it), qrScannerViewModel.getWallets(it)) }");
            h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(flatMapSingle, null, null, 3, null).observeOn(this.mainScheduler).subscribe(new f() { // from class: com.coinbase.wallet.application.view.a
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    HomeFragment.d(HomeFragment.this, (o) obj);
                }
            });
            kotlin.jvm.internal.m.f(subscribe, "qrScannerViewModel.qrScanResultObservable\n            .flatMapSingle { Singles.zip(Single.just(it), qrScannerViewModel.getWallets(it)) }\n            .logError()\n            .observeOn(mainScheduler)\n            .subscribe { (results, wallets) ->\n                when (wallets.size) {\n                    0 -> qrScannerViewModel.showWarning(getString(R.string.universal_qr_warning))\n                    1 -> {\n                        val wallet = wallets.firstOrNull()\n\n                        if (wallet != null) {\n                            val result = results.first()\n                            val amount = result.amount\n                            if (amount != null) {\n                                val args = SendDestinationPickerArgs.createArguments(\n                                    transferValue = TransferValue.Amount(amount),\n                                    wallet = wallet,\n                                    address = result.address,\n                                    metadataValue = result.walletAccountId,\n                                    stellarMemoType = result.memoType\n                                )\n\n                                navigate(\n                                    resId = R.id.action_universalQRScannerFragment_to_sendDestinationPickerFragment,\n                                    args = args,\n                                    navOptions = verticalNavOptions\n                                )\n                            } else {\n                                val args = SendArgs.createArguments(\n                                    wallet = wallet,\n                                    recipient = result.address,\n                                    metadataValue = result.walletAccountId,\n                                    stellarMemoType = result.memoType,\n                                    viewModelKey = AmountPickerViewModel::class.java.name to\n                                        SendAmountPickerViewModel::class.java\n                                )\n\n                                navigate(\n                                    resId = R.id.action_universalQRScannerFragment_to_sendAmountPickerFragment,\n                                    args = args,\n                                    navOptions = verticalNavOptions\n                                )\n                            }\n                        }\n                    }\n\n                    else -> {\n                        navigate(\n                            resId = R.id.action_universalQRScannerFragment_to_sendCoinPickerFragment,\n                            args = SendCoinPickerArgs.createArguments(\n                                walletFilters = wallets,\n                                qrCodeScanResults = results\n                            ),\n                            navOptions = verticalNavOptions\n                        )\n                    }\n                }\n            }");
            h.c.t0.a.a(subscribe, this.disposeBag);
            return;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModel");
        throw null;
    }

    /* renamed from: navigateToUniversalQRScannerFragment$lambda-2 */
    public static final h0 m690navigateToUniversalQRScannerFragment$lambda2(HomeFragment this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        e eVar = e.a;
        h.c.b0 just = h.c.b0.just(it);
        kotlin.jvm.internal.m.f(just, "just(it)");
        j jVar = this$0.qrScannerViewModel;
        if (jVar != null) {
            return eVar.a(just, jVar.b(it));
        }
        kotlin.jvm.internal.m.w("qrScannerViewModel");
        throw null;
    }

    /* renamed from: navigateToUniversalQRScannerFragment$lambda-3 */
    public static final void m691navigateToUniversalQRScannerFragment$lambda3(HomeFragment this$0, o oVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        List results = (List) oVar.a();
        List wallets = (List) oVar.b();
        int size = wallets.size();
        if (size == 0) {
            j jVar = this$0.qrScannerViewModel;
            if (jVar == null) {
                kotlin.jvm.internal.m.w("qrScannerViewModel");
                throw null;
            }
            String string = this$0.getString(R.string.universal_qr_warning);
            kotlin.jvm.internal.m.f(string, "getString(R.string.universal_qr_warning)");
            jVar.g(string);
        } else if (size != 1) {
            SendCoinPickerArgs sendCoinPickerArgs = SendCoinPickerArgs.INSTANCE;
            kotlin.jvm.internal.m.f(wallets, "wallets");
            kotlin.jvm.internal.m.f(results, "results");
            Fragment_CommonKt.navigate$default(this$0, R.id.action_universalQRScannerFragment_to_sendCoinPickerFragment, SendCoinPickerArgs.createArguments$default(sendCoinPickerArgs, null, wallets, results, 1, null), Fragment_CommonKt.getVerticalNavOptions(this$0), null, 8, null);
        } else {
            kotlin.jvm.internal.m.f(wallets, "wallets");
            Wallet wallet = (Wallet) kotlin.a0.p.a0(wallets);
            if (wallet != null) {
                kotlin.jvm.internal.m.f(results, "results");
                QRCodeScanResult qRCodeScanResult = (QRCodeScanResult) kotlin.a0.p.Y(results);
                BigInteger amount = qRCodeScanResult.getAmount();
                if (amount != null) {
                    Fragment_CommonKt.navigate$default(this$0, R.id.action_universalQRScannerFragment_to_sendDestinationPickerFragment, SendDestinationPickerArgs.INSTANCE.createArguments(new TransferValue.Amount(amount), wallet, qRCodeScanResult.getAddress(), qRCodeScanResult.getWalletAccountId(), qRCodeScanResult.getMemoType()), Fragment_CommonKt.getVerticalNavOptions(this$0), null, 8, null);
                } else {
                    Fragment_CommonKt.navigate$default(this$0, R.id.action_universalQRScannerFragment_to_sendAmountPickerFragment, SendArgs.INSTANCE.createArguments(wallet, qRCodeScanResult.getAddress(), qRCodeScanResult.getWalletAccountId(), qRCodeScanResult.getMemoType(), u.a(AmountPickerViewModel.class.getName(), SendAmountPickerViewModel.class)), Fragment_CommonKt.getVerticalNavOptions(this$0), null, 8, null);
                }
            }
        }
    }

    public final void setRefreshEnable(boolean z) {
        View view = getView();
        if ((view == null ? null : view.findViewById(e.j.a.walletRefreshLayout)) != null) {
            View view2 = getView();
            if (((SwipeRefreshLayout) (view2 == null ? null : view2.findViewById(e.j.a.walletRefreshLayout))).h()) {
                return;
            }
            View view3 = getView();
            ((SwipeRefreshLayout) (view3 != null ? view3.findViewById(e.j.a.walletRefreshLayout) : null)).setEnabled(z);
        }
    }

    private final void setupScanningPill() {
        View view = getView();
        Drawable drawable = ((ImageView) (view == null ? null : view.findViewById(e.j.a.loadingPillOval))).getDrawable();
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimatedVectorDrawable");
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
        this.loadingRingAnimation = animatedVectorDrawable;
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() { // from class: com.coinbase.wallet.application.view.HomeFragment$setupScanningPill$1
                @Override // android.graphics.drawable.Animatable2.AnimationCallback
                public void onAnimationEnd(Drawable drawable2) {
                    if (HomeFragment.access$isLoadingPillAnimating$p(HomeFragment.this)) {
                        AnimatedVectorDrawable access$getLoadingRingAnimation$p = HomeFragment.access$getLoadingRingAnimation$p(HomeFragment.this);
                        if (access$getLoadingRingAnimation$p != null) {
                            access$getLoadingRingAnimation$p.start();
                        } else {
                            kotlin.jvm.internal.m.w("loadingRingAnimation");
                            throw null;
                        }
                    }
                }
            });
        } else {
            kotlin.jvm.internal.m.w("loadingRingAnimation");
            throw null;
        }
    }

    public final void showFundActionSheet(ViewModelNavRoute viewModelNavRoute) {
        Fragment_CommonKt.navigate$default(this, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), null, null, 12, null);
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
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final GenericViewModelFactory<LoadingPillViewModel> getLoadingPillViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory = this.loadingPillViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("loadingPillViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<j> getQrScannerViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<j> genericViewModelFactory = this.qrScannerViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<ScrolledToTopViewModel> getScrolledToTopViewModelFactory() {
        GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory = this.scrolledToTopViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("scrolledToTopViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<l2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<l2> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setAllowReturnTransitionOverlap(true);
        setAllowEnterTransitionOverlap(true);
        if (bundle == null) {
            AnalyticsEvent_ApplicationKt.walletTabLanded(AnalyticsEvent.Companion);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_wallet, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.disposeBag.d();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        initViewModel();
        initAdapter();
        initRefreshListener();
        initObservables();
        initButtons();
        setupScanningPill();
    }

    public final void setLoadingPillViewModelFactory$app_productionRelease(GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.loadingPillViewModelFactory = genericViewModelFactory;
    }

    public final void setQrScannerViewModelFactory$app_productionRelease(GenericViewModelFactory<j> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.qrScannerViewModelFactory = genericViewModelFactory;
    }

    public final void setScrolledToTopViewModelFactory(GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<l2> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}