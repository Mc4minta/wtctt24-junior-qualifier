package com.coinbase.wallet.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.e0;
import androidx.viewpager.widget.ViewPager;
import c.h.k.d0;
import c.h.k.q;
import c.h.k.v;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.model.AppState;
import com.coinbase.wallet.application.model.CallToAction;
import com.coinbase.wallet.application.model.DappDestination;
import com.coinbase.wallet.application.model.MainTab;
import com.coinbase.wallet.application.model.NavDestination;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.model.NotificationDestination;
import com.coinbase.wallet.application.util.ContactUsLauncher;
import com.coinbase.wallet.application.view.custom.WalletViewPager;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.views.BottomNavigationActivity;
import com.coinbase.wallet.features.applock.exceptions.AppLockException;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.routing.viewmodels.DeepLinkViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.toshi.view.activity.MustUpdateWalletVersionActivity;
import com.toshi.view.activity.OnboardingWizardActivity;
import com.toshi.view.custom.NetworkStatusView;
import com.toshi.view.custom.SpinnerOverlayLayout;
import com.toshi.view.fragment.toplevel.DappsFragment;
import com.uber.autodispose.a0;
import e.j.f.y;
import e.j.n.a2;
import e.j.n.o2;
import h.c.b0;
import h.c.h0;
import h.c.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r*\u0001]\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0001}B\u0007¢\u0006\u0004\b|\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u001d\u0010\u001f\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J;\u0010-\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u0010\u0005J\u000f\u00104\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0003H\u0002¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0003H\u0002¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b8\u0010\u0005J\u0019\u0010:\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0003H\u0014¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0003H\u0014¢\u0006\u0004\b=\u0010\u0005J\u0019\u0010@\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010>H\u0014¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0003H\u0016¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0003H\u0016¢\u0006\u0004\bC\u0010\u0005J\u000f\u0010D\u001a\u00020\u0003H\u0016¢\u0006\u0004\bD\u0010\u0005R%\u0010J\u001a\n \u0017*\u0004\u0018\u00010E0E8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001d\u0010O\u001a\u00020K8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR(\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001d\u0010\\\u001a\u00020X8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010G\u001a\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R(\u0010a\u001a\b\u0012\u0004\u0012\u00020`0P8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\ba\u0010S\u001a\u0004\bb\u0010U\"\u0004\bc\u0010WR(\u0010e\u001a\b\u0012\u0004\u0012\u00020d0P8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\be\u0010S\u001a\u0004\bf\u0010U\"\u0004\bg\u0010WR\"\u0010i\u001a\u00020h8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bz\u0010{¨\u0006~"}, d2 = {"Lcom/coinbase/wallet/application/MainActivity;", "Ldagger/android/g/b;", "", "Lkotlin/x;", "setup", "()V", "setupSession", "setupViewPager", "setupViewModel", "checkAuth", "trySelectTabFromIntent", "setupNavBar", "setupObservers", "setupSignerView", "", "shouldCreateWallets", "Lh/c/c;", "showAppUnlockPromptToCompleteAccountSetup", "(Z)Lh/c/c;", "Lh/c/b0;", "showAppUnlockPrompt", "()Lh/c/b0;", "Lcom/toshi/view/custom/NetworkStatusView;", "kotlin.jvm.PlatformType", "showNetworkUnavailable", "()Lcom/toshi/view/custom/NetworkStatusView;", "setupLockoutNotifications", "checkForUnreadNotifications", "", "Lcom/coinbase/wallet/application/model/Notification;", "notifications", "showUnreadNotifications", "(Ljava/util/List;)V", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "destination", "performAction", "(Lcom/coinbase/wallet/application/model/NotificationDestination;)V", "Lcom/coinbase/wallet/application/model/MainTab;", "tab", "", "destinationResId", "Landroid/os/Bundle;", "args", "Landroidx/navigation/p;", "navOptions", "switchToTabAndNavigate", "(Lcom/coinbase/wallet/application/model/MainTab;ILandroid/os/Bundle;Landroidx/navigation/p;)V", "", "url", "switchToDappBrowser", "(Ljava/lang/String;)V", "showGooglePlayServicesDialogIfUnavailable", "showGooglePlayServicesUnavailableDialog", "refreshOrientationLock", "showEnjoyingTheAppPrompt", "unlockAppSession", "lockAppSessionAndRedirectToOnboarding", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPostResume", "onResume", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "hideBottomNavigation", "showBottomNavigation", "onBackPressed", "Lcom/uber/autodispose/android/lifecycle/b;", "scopeProvider$delegate", "Lkotlin/h;", "getScopeProvider", "()Lcom/uber/autodispose/android/lifecycle/b;", "scopeProvider", "Lh/c/a0;", "mainScheduler$delegate", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/routing/viewmodels/DeepLinkViewModel;", "deepLinkViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getDeepLinkViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setDeepLinkViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Le/j/m/a/g;", "viewPagerAdapter$delegate", "getViewPagerAdapter", "()Le/j/m/a/g;", "viewPagerAdapter", "com/coinbase/wallet/application/MainActivity$onPageChangeListener$1", "onPageChangeListener", "Lcom/coinbase/wallet/application/MainActivity$onPageChangeListener$1;", "Le/j/n/o2;", "viewModelFactory", "getViewModelFactory$app_productionRelease", "setViewModelFactory$app_productionRelease", "Le/j/n/a2;", "bannedLocationViewModelFactory", "getBannedLocationViewModelFactory$app_productionRelease", "setBannedLocationViewModelFactory$app_productionRelease", "Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "contactUsLauncher", "Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "getContactUsLauncher$app_productionRelease", "()Lcom/coinbase/wallet/application/util/ContactUsLauncher;", "setContactUsLauncher$app_productionRelease", "(Lcom/coinbase/wallet/application/util/ContactUsLauncher;)V", "bannedLocationViewModel", "Le/j/n/a2;", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "deepLinkViewModel", "Lcom/coinbase/wallet/routing/viewmodels/DeepLinkViewModel;", "viewModel", "Le/j/n/o2;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity extends dagger.android.g.b implements BottomNavigationActivity {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA__ACTIVE_TAB = "active_tab";
    public AuthenticationHelper authenticationHelper;
    private a2 bannedLocationViewModel;
    public GenericViewModelFactory<a2> bannedLocationViewModelFactory;
    public ContactUsLauncher contactUsLauncher;
    private DeepLinkViewModel deepLinkViewModel;
    public GenericViewModelFactory<DeepLinkViewModel> deepLinkViewModelFactory;
    private final kotlin.h mainScheduler$delegate;
    private final MainActivity$onPageChangeListener$1 onPageChangeListener;
    private final kotlin.h scopeProvider$delegate;
    private o2 viewModel;
    public GenericViewModelFactory<o2> viewModelFactory;
    private final kotlin.h viewPagerAdapter$delegate;

    /* compiled from: MainActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/MainActivity$Companion;", "", "", "EXTRA__ACTIVE_TAB", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.coinbase.wallet.application.MainActivity$onPageChangeListener$1] */
    public MainActivity() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        b2 = kotlin.k.b(MainActivity$mainScheduler$2.INSTANCE);
        this.mainScheduler$delegate = b2;
        b3 = kotlin.k.b(new MainActivity$scopeProvider$2(this));
        this.scopeProvider$delegate = b3;
        b4 = kotlin.k.b(new MainActivity$viewPagerAdapter$2(this));
        this.viewPagerAdapter$delegate = b4;
        this.onPageChangeListener = new ViewPager.n() { // from class: com.coinbase.wallet.application.MainActivity$onPageChangeListener$1
            @Override // androidx.viewpager.widget.ViewPager.n, androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i2) {
                MainActivity.this.refreshOrientationLock();
                if (i2 == 0) {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.walletTabLanded(AnalyticsEvent.Companion));
                } else if (i2 == 1) {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.dappsTabLanded(AnalyticsEvent.Companion));
                } else if (i2 != 2) {
                } else {
                    Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.settingsLanded(AnalyticsEvent.Companion));
                }
            }
        };
    }

    public static /* synthetic */ h.c.f a(boolean z, MainActivity mainActivity, AuthenticationResult authenticationResult) {
        return m645showAppUnlockPromptToCompleteAccountSetup$lambda13(z, mainActivity, authenticationResult);
    }

    public static /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        return m642setupViewPager$lambda1(view, motionEvent);
    }

    public static /* synthetic */ h0 c(MainActivity mainActivity, AppState appState) {
        return m635checkAuth$lambda4(mainActivity, appState);
    }

    private final void checkAuth() {
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            b0<R> flatMap = o2Var.h().observeOn(getMainScheduler()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return MainActivity.c(MainActivity.this, (AppState) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "viewModel.appStateObservable\n            .observeOn(mainScheduler)\n            .flatMap { appState ->\n                when (appState) {\n                    AppState.NoStoredMnemonic -> {\n                        // User has not stored mnemonic, redirect them to onboarding\n                        hideBottomNavigation()\n                        lockAppSessionAndRedirectToOnboarding()\n                        Single.just(Unit)\n                    }\n                    is AppState.UnfinishedAccountSetup -> {\n                        // User has stored mnemonic, but either no active user set and/or wallets did not finish\n                        // creating\n                        showAppUnlockPromptToCompleteAccountSetup(!appState.hasCreatedWallets).toSingleDefault(Unit)\n                            .flatMap {\n                                unlockAppSession()\n                                viewModel.checkIfKeyInvalidated()\n                            }\n                    }\n                    is AppState.AppLocked -> {\n                        // User has enabled setting to require unlock for each app session\n                        rootView.visibility = View.INVISIBLE\n                        showAppUnlockPrompt().flatMap {\n                            unlockAppSession()\n                            viewModel.checkIfKeyInvalidated()\n                        }\n                    }\n                    AppState.AppUnlocked -> {\n                        // User should have access to the app\n                        unlockAppSession()\n                        viewModel.checkIfKeyInvalidated()\n                    }\n                }\n            }");
            ((a0) Single_AnalyticsKt.logError$default(flatMap, "Error while checking if all wallets have been created.", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: checkAuth$lambda-4 */
    public static final h0 m635checkAuth$lambda4(MainActivity this$0, AppState appState) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(appState, "appState");
        if (kotlin.jvm.internal.m.c(appState, AppState.NoStoredMnemonic.INSTANCE)) {
            this$0.hideBottomNavigation();
            this$0.lockAppSessionAndRedirectToOnboarding();
            b0 just = b0.just(x.a);
            kotlin.jvm.internal.m.f(just, "{\n                        // User has not stored mnemonic, redirect them to onboarding\n                        hideBottomNavigation()\n                        lockAppSessionAndRedirectToOnboarding()\n                        Single.just(Unit)\n                    }");
            return just;
        } else if (appState instanceof AppState.UnfinishedAccountSetup) {
            b0 flatMap = this$0.showAppUnlockPromptToCompleteAccountSetup(!((AppState.UnfinishedAccountSetup) appState).getHasCreatedWallets()).x(x.a).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.k
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return MainActivity.g(MainActivity.this, (x) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "{\n                        // User has stored mnemonic, but either no active user set and/or wallets did not finish\n                        // creating\n                        showAppUnlockPromptToCompleteAccountSetup(!appState.hasCreatedWallets).toSingleDefault(Unit)\n                            .flatMap {\n                                unlockAppSession()\n                                viewModel.checkIfKeyInvalidated()\n                            }\n                    }");
            return flatMap;
        } else if (appState instanceof AppState.AppLocked) {
            ((ConstraintLayout) this$0.findViewById(e.j.a.J5)).setVisibility(4);
            h0 flatMap2 = this$0.showAppUnlockPrompt().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return MainActivity.d(MainActivity.this, (x) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap2, "{\n                        // User has enabled setting to require unlock for each app session\n                        rootView.visibility = View.INVISIBLE\n                        showAppUnlockPrompt().flatMap {\n                            unlockAppSession()\n                            viewModel.checkIfKeyInvalidated()\n                        }\n                    }");
            return flatMap2;
        } else if (kotlin.jvm.internal.m.c(appState, AppState.AppUnlocked.INSTANCE)) {
            this$0.unlockAppSession();
            o2 o2Var = this$0.viewModel;
            if (o2Var != null) {
                return o2Var.e();
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: checkAuth$lambda-4$lambda-2 */
    public static final h0 m636checkAuth$lambda4$lambda2(MainActivity this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.unlockAppSession();
        o2 o2Var = this$0.viewModel;
        if (o2Var != null) {
            return o2Var.e();
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: checkAuth$lambda-4$lambda-3 */
    public static final h0 m637checkAuth$lambda4$lambda3(MainActivity this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.unlockAppSession();
        o2 o2Var = this$0.viewModel;
        if (o2Var != null) {
            return o2Var.e();
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void checkForUnreadNotifications() {
        String scheme = getIntent().getScheme();
        if (scheme == null || scheme.length() == 0) {
            o2 o2Var = this.viewModel;
            if (o2Var != null) {
                s<List<Notification>> observeOn = o2Var.k().observeOn(getMainScheduler());
                kotlin.jvm.internal.m.f(observeOn, "viewModel.unreadNotifications\n                .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while checking for unread notifications", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.unreadNotifications\n                .observeOn(mainScheduler)\n                .logError(\"Error while checking for unread notifications\")\n                .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new MainActivity$checkForUnreadNotifications$1(this), 3, null);
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        o2 o2Var2 = this.viewModel;
        if (o2Var2 != null) {
            s<x> observeOn2 = o2Var2.g().observeOn(getMainScheduler());
            kotlin.jvm.internal.m.f(observeOn2, "viewModel.appReviewObservable\n            .observeOn(mainScheduler)");
            Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, "Could not check for app review prompt", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as2, "viewModel.appReviewObservable\n            .observeOn(mainScheduler)\n            .logError(\"Could not check for app review prompt\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new MainActivity$checkForUnreadNotifications$2(this), 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static /* synthetic */ h0 d(MainActivity mainActivity, x xVar) {
        return m637checkAuth$lambda4$lambda3(mainActivity, xVar);
    }

    public static /* synthetic */ boolean e(MainActivity mainActivity, MenuItem menuItem) {
        return m638setupNavBar$lambda5(mainActivity, menuItem);
    }

    public static /* synthetic */ d0 f(View view, d0 d0Var) {
        return m639setupNavBar$lambda7(view, d0Var);
    }

    public static /* synthetic */ h0 g(MainActivity mainActivity, x xVar) {
        return m636checkAuth$lambda4$lambda2(mainActivity, xVar);
    }

    private final h.c.a0 getMainScheduler() {
        Object value = this.mainScheduler$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-mainScheduler>(...)");
        return (h.c.a0) value;
    }

    public final com.uber.autodispose.android.lifecycle.b getScopeProvider() {
        return (com.uber.autodispose.android.lifecycle.b) this.scopeProvider$delegate.getValue();
    }

    private final e.j.m.a.g getViewPagerAdapter() {
        return (e.j.m.a.g) this.viewPagerAdapter$delegate.getValue();
    }

    public static /* synthetic */ void h(Throwable th) {
        m641setupObservers$lambda9(th);
    }

    public static /* synthetic */ h0 i(MainActivity mainActivity, AuthenticationResult authenticationResult) {
        return m643showAppUnlockPrompt$lambda15(mainActivity, authenticationResult);
    }

    public static /* synthetic */ void j(MainActivity mainActivity) {
        m646showAppUnlockPromptToCompleteAccountSetup$lambda14(mainActivity);
    }

    public static /* synthetic */ void k(MainActivity mainActivity, Boolean bool) {
        m640setupObservers$lambda8(mainActivity, bool);
    }

    public static /* synthetic */ void l(MainActivity mainActivity, h.c.k0.b bVar) {
        m644showAppUnlockPromptToCompleteAccountSetup$lambda12(mainActivity, bVar);
    }

    private final void lockAppSessionAndRedirectToOnboarding() {
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            o2Var.u();
            startActivity(new Intent(this, OnboardingWizardActivity.class));
            finishAffinity();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void performAction(NotificationDestination notificationDestination) {
        if (notificationDestination instanceof NavDestination) {
            NavDestination navDestination = (NavDestination) notificationDestination;
            switchToTabAndNavigate(navDestination.getTab(), navDestination.getDestinationResId(), navDestination.getArgs(), navDestination.getNavOptions());
        } else if (notificationDestination instanceof DappDestination) {
            switchToDappBrowser(((DappDestination) notificationDestination).getUrl());
        }
    }

    public final void refreshOrientationLock() {
        if (getViewPagerAdapter().d(((WalletViewPager) findViewById(e.j.a.viewPager)).getCurrentItem()) instanceof DappsFragment) {
            e.j.f.c.i(this);
        } else {
            e.j.f.c.g(this);
        }
    }

    private final void setup() {
        getAuthenticationHelper$app_productionRelease().setActivity(this);
        setupViewModel();
        setupLockoutNotifications();
        showGooglePlayServicesDialogIfUnavailable();
        setupViewPager();
        setupSession();
        setupNavBar();
        trySelectTabFromIntent();
        refreshOrientationLock();
        setupObservers();
    }

    private final void setupLockoutNotifications() {
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            s<Notification> observeOn = o2Var.i().observeOn(getMainScheduler());
            kotlin.jvm.internal.m.f(observeOn, "viewModel.lockoutNotificationsObservable\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while checking for unread notifications", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.lockoutNotificationsObservable\n            .observeOn(mainScheduler)\n            .logError(\"Error while checking for unread notifications\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new MainActivity$setupLockoutNotifications$1(this), 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void setupNavBar() {
        ((BottomNavigationView) findViewById(e.j.a.bottomNavBar)).setOnNavigationItemSelectedListener(new BottomNavigationView.c() { // from class: com.coinbase.wallet.application.i
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.c
            public final boolean a(MenuItem menuItem) {
                return MainActivity.e(MainActivity.this, menuItem);
            }
        });
        v.w0(findViewById(e.j.a.bottomNavBarSpacer), new q() { // from class: com.coinbase.wallet.application.j
            @Override // c.h.k.q
            public final d0 a(View view, d0 d0Var) {
                return MainActivity.f(view, d0Var);
            }
        });
    }

    /* renamed from: setupNavBar$lambda-5 */
    public static final boolean m638setupNavBar$lambda5(MainActivity this$0, MenuItem item) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.action_dapps) {
            ((WalletViewPager) this$0.findViewById(e.j.a.viewPager)).setCurrentItem(MainTab.DAPPS.getPosition(), false);
            return true;
        } else if (itemId == R.id.action_settings) {
            ((WalletViewPager) this$0.findViewById(e.j.a.viewPager)).setCurrentItem(MainTab.SETTINGS.getPosition(), false);
            return true;
        } else if (itemId != R.id.action_wallet) {
            return false;
        } else {
            ((WalletViewPager) this$0.findViewById(e.j.a.viewPager)).setCurrentItem(MainTab.WALLET.getPosition(), false);
            return true;
        }
    }

    /* renamed from: setupNavBar$lambda-7 */
    public static final d0 m639setupNavBar$lambda7(View view, d0 d0Var) {
        c.h.e.b f2 = d0Var.f(d0.m.b());
        kotlin.jvm.internal.m.f(f2, "insets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())");
        kotlin.jvm.internal.m.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = f2.f2928e;
        view.setLayoutParams(marginLayoutParams);
        return d0Var;
    }

    private final void setupObservers() {
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            ((a0) o2Var.n().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.application.o
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    MainActivity.k(MainActivity.this, (Boolean) obj);
                }
            }, new h.c.m0.f() { // from class: com.coinbase.wallet.application.l
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    MainActivity.h((Throwable) obj);
                }
            });
            a2 a2Var = this.bannedLocationViewModel;
            if (a2Var != null) {
                s<Boolean> observeOn = a2Var.a().observeOn(getMainScheduler());
                kotlin.jvm.internal.m.f(observeOn, "bannedLocationViewModel.isBannedLocationObservable\n            .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while observing if user in banned location", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "bannedLocationViewModel.isBannedLocationObservable\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing if user in banned location\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new MainActivity$setupObservers$3(this), 3, null);
                o2 o2Var2 = this.viewModel;
                if (o2Var2 != null) {
                    s<ConnectionStatus> observeOn2 = o2Var2.j().observeOn(getMainScheduler());
                    kotlin.jvm.internal.m.f(observeOn2, "viewModel.networkStatusObservable\n            .observeOn(mainScheduler)");
                    Object as2 = Observable_AnalyticsKt.logError$default(observeOn2, "Couldn't check network status", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as2, "viewModel.networkStatusObservable\n            .observeOn(mainScheduler)\n            .logError(\"Couldn't check network status\")\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new MainActivity$setupObservers$4(this), 3, null);
                    return;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("bannedLocationViewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: setupObservers$lambda-8 */
    public static final void m640setupObservers$lambda8(MainActivity this$0, Boolean bool) {
        List<Number> j2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (bool.booleanValue()) {
            return;
        }
        j2 = r.j(32768, 268435456);
        Intent intent = new Intent(this$0, MustUpdateWalletVersionActivity.class);
        for (Number number : j2) {
            intent.addFlags(number.intValue());
        }
        this$0.startActivity(intent);
        this$0.finish();
    }

    /* renamed from: setupObservers$lambda-9 */
    public static final void m641setupObservers$lambda9(Throwable th) {
        l.a.a.f(th, "Error while observing minimum supported version.", new Object[0]);
    }

    private final void setupSession() {
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            o2Var.C();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0038, code lost:
        if (r3.isEmpty() == true) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setupSignerView() {
        /*
            r6 = this;
            androidx.fragment.app.m r0 = r6.getSupportFragmentManager()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto La
        L8:
            r1 = r2
            goto L3a
        La:
            java.util.List r0 = r0.h0()
            if (r0 != 0) goto L11
            goto L8
        L11:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L34
            java.lang.Object r4 = r0.next()
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r5 = r4 instanceof com.coinbase.wallet.features.signer.views.SignerViewFragment
            if (r5 == 0) goto L2d
            com.coinbase.wallet.features.signer.views.SignerViewFragment r4 = (com.coinbase.wallet.features.signer.views.SignerViewFragment) r4
            goto L2e
        L2d:
            r4 = 0
        L2e:
            if (r4 == 0) goto L1a
            r3.add(r4)
            goto L1a
        L34:
            boolean r0 = r3.isEmpty()
            if (r0 != r1) goto L8
        L3a:
            if (r1 == 0) goto L58
            androidx.fragment.app.m r0 = r6.getSupportFragmentManager()
            androidx.fragment.app.u r0 = r0.j()
            com.coinbase.wallet.features.signer.views.SignerViewFragment r1 = new com.coinbase.wallet.features.signer.views.SignerViewFragment
            r1.<init>()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            java.lang.Class<com.coinbase.wallet.features.signer.views.SignerViewFragment> r3 = com.coinbase.wallet.features.signer.views.SignerViewFragment.class
            java.lang.String r3 = r3.getSimpleName()
            r0.c(r2, r1, r3)
            r0.j()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.application.MainActivity.setupSignerView():void");
    }

    private final void setupViewModel() {
        androidx.lifecycle.b0 a = e0.b(this, getViewModelFactory$app_productionRelease()).a(o2.class);
        kotlin.jvm.internal.m.f(a, "of(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (o2) a;
        androidx.lifecycle.b0 a2 = e0.b(this, getDeepLinkViewModelFactory$app_productionRelease()).a(DeepLinkViewModel.class);
        kotlin.jvm.internal.m.f(a2, "of(this, viewModelFactory).get(T::class.java)");
        this.deepLinkViewModel = (DeepLinkViewModel) a2;
        androidx.lifecycle.b0 a3 = e0.b(this, getBannedLocationViewModelFactory$app_productionRelease()).a(a2.class);
        kotlin.jvm.internal.m.f(a3, "of(this, viewModelFactory).get(T::class.java)");
        this.bannedLocationViewModel = (a2) a3;
    }

    private final void setupViewPager() {
        int i2 = e.j.a.viewPager;
        ((WalletViewPager) findViewById(i2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.coinbase.wallet.application.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MainActivity.b(view, motionEvent);
            }
        });
        ((WalletViewPager) findViewById(i2)).setAdapter(getViewPagerAdapter());
        ((WalletViewPager) findViewById(i2)).addOnPageChangeListener(this.onPageChangeListener);
        ((WalletViewPager) findViewById(i2)).setOffscreenPageLimit(3);
    }

    /* renamed from: setupViewPager$lambda-1 */
    public static final boolean m642setupViewPager$lambda1(View view, MotionEvent motionEvent) {
        return true;
    }

    private final b0<x> showAppUnlockPrompt() {
        b0 flatMap = getAuthenticationHelper$app_productionRelease().unlock(AppLockType.AppAccess.INSTANCE).observeOn(getMainScheduler()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MainActivity.i(MainActivity.this, (AuthenticationResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "authenticationHelper.unlock(AppLockType.AppAccess)\n        .observeOn(mainScheduler)\n        .flatMap { result ->\n            when (result) {\n                is AuthenticationResult.RecoveryPhrase -> {\n                    Single.just(Unit)\n                }\n                is AuthenticationResult.Error -> {\n                    Single.error(result.throwable)\n                }\n                is AuthenticationResult.LockedOut -> {\n                    Single.error(AppLockException.LockedOutException(result.permanent))\n                }\n                is AuthenticationResult.Cancelled -> {\n                    finish()\n                    Single.error(AppLockException.UserCancelledException)\n                }\n                is AuthenticationResult.NoBiometricFound -> {\n                    Single.error(AppLockException.NoBiometricFoundException)\n                }\n            }\n        }");
        return flatMap;
    }

    /* renamed from: showAppUnlockPrompt$lambda-15 */
    public static final h0 m643showAppUnlockPrompt$lambda15(MainActivity this$0, AuthenticationResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (result instanceof AuthenticationResult.RecoveryPhrase) {
            return b0.just(x.a);
        }
        if (result instanceof AuthenticationResult.Error) {
            return b0.error(((AuthenticationResult.Error) result).getThrowable());
        }
        if (result instanceof AuthenticationResult.LockedOut) {
            return b0.error(new AppLockException.LockedOutException(((AuthenticationResult.LockedOut) result).getPermanent()));
        }
        if (result instanceof AuthenticationResult.Cancelled) {
            this$0.finish();
            return b0.error(AppLockException.UserCancelledException.INSTANCE);
        } else if (result instanceof AuthenticationResult.NoBiometricFound) {
            return b0.error(AppLockException.NoBiometricFoundException.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final h.c.c showAppUnlockPromptToCompleteAccountSetup(final boolean z) {
        h.c.c l2 = getAuthenticationHelper$app_productionRelease().unlock(new AppLockType.UnlockIfNeeded(false)).observeOn(getMainScheduler()).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.application.p
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                MainActivity.l(MainActivity.this, (h.c.k0.b) obj);
            }
        }).flatMapCompletable(new h.c.m0.n() { // from class: com.coinbase.wallet.application.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return MainActivity.a(z, this, (AuthenticationResult) obj);
            }
        }).s(getMainScheduler()).l(new h.c.m0.a() { // from class: com.coinbase.wallet.application.n
            @Override // h.c.m0.a
            public final void run() {
                MainActivity.j(MainActivity.this);
            }
        });
        kotlin.jvm.internal.m.f(l2, "authenticationHelper\n            .unlock(AppLockType.UnlockIfNeeded(false))\n            .observeOn(mainScheduler)\n            .doOnSubscribe {\n                hideBottomNavigation()\n                spinnerOverlay.setLoading(true)\n            }\n            .flatMapCompletable { result ->\n                when (result) {\n                    is AuthenticationResult.RecoveryPhrase ->\n                        if (shouldCreateWallets) {\n                            viewModel.setupActiveUserIfNeeded(result.recoveryPhrase)\n                                .concatWith(viewModel.createWallets(result.recoveryPhrase))\n                        } else {\n                            viewModel.setupActiveUserIfNeeded(result.recoveryPhrase)\n                        }\n                    is AuthenticationResult.Error -> {\n                        Completable.error(result.throwable)\n                    }\n                    is AuthenticationResult.LockedOut -> {\n                        Completable.error(Exception(\"Locked out. Permanent? ${result.permanent}\"))\n                    }\n                    is AuthenticationResult.Cancelled -> {\n                        finish()\n                        Completable.error(AppLockException.UserCancelledException)\n                    }\n                    is AuthenticationResult.NoBiometricFound -> {\n                        Completable.error(AppLockException.NoBiometricFoundException)\n                    }\n                }\n            }\n            .observeOn(mainScheduler)\n            .doOnComplete {\n                spinnerOverlay.setLoading(false)\n                showBottomNavigation()\n            }");
        return l2;
    }

    /* renamed from: showAppUnlockPromptToCompleteAccountSetup$lambda-12 */
    public static final void m644showAppUnlockPromptToCompleteAccountSetup$lambda12(MainActivity this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.hideBottomNavigation();
        ((SpinnerOverlayLayout) this$0.findViewById(e.j.a.spinnerOverlay)).setLoading(true);
    }

    /* renamed from: showAppUnlockPromptToCompleteAccountSetup$lambda-13 */
    public static final h.c.f m645showAppUnlockPromptToCompleteAccountSetup$lambda13(boolean z, MainActivity this$0, AuthenticationResult result) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "result");
        if (!(result instanceof AuthenticationResult.RecoveryPhrase)) {
            if (result instanceof AuthenticationResult.Error) {
                return h.c.c.q(((AuthenticationResult.Error) result).getThrowable());
            }
            if (result instanceof AuthenticationResult.LockedOut) {
                return h.c.c.q(new Exception(kotlin.jvm.internal.m.o("Locked out. Permanent? ", Boolean.valueOf(((AuthenticationResult.LockedOut) result).getPermanent()))));
            }
            if (result instanceof AuthenticationResult.Cancelled) {
                this$0.finish();
                return h.c.c.q(AppLockException.UserCancelledException.INSTANCE);
            } else if (result instanceof AuthenticationResult.NoBiometricFound) {
                return h.c.c.q(AppLockException.NoBiometricFoundException.INSTANCE);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (z) {
            o2 o2Var = this$0.viewModel;
            if (o2Var != null) {
                AuthenticationResult.RecoveryPhrase recoveryPhrase = (AuthenticationResult.RecoveryPhrase) result;
                h.c.c A = o2Var.A(recoveryPhrase.getRecoveryPhrase());
                o2 o2Var2 = this$0.viewModel;
                if (o2Var2 != null) {
                    return A.h(o2Var2.f(recoveryPhrase.getRecoveryPhrase()));
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else {
            o2 o2Var3 = this$0.viewModel;
            if (o2Var3 != null) {
                return o2Var3.A(((AuthenticationResult.RecoveryPhrase) result).getRecoveryPhrase());
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    /* renamed from: showAppUnlockPromptToCompleteAccountSetup$lambda-14 */
    public static final void m646showAppUnlockPromptToCompleteAccountSetup$lambda14(MainActivity this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        ((SpinnerOverlayLayout) this$0.findViewById(e.j.a.spinnerOverlay)).setLoading(false);
        this$0.showBottomNavigation();
    }

    public final void showEnjoyingTheAppPrompt() {
        List m;
        List m2;
        List m3;
        CharSequence text = getText(R.string.contact_us);
        kotlin.jvm.internal.m.f(text, "getText(R.string.contact_us)");
        ActionStyle actionStyle = ActionStyle.POSITIVE;
        CharSequence text2 = getText(R.string.no_thanks);
        kotlin.jvm.internal.m.f(text2, "getText(R.string.no_thanks)");
        ActionStyle actionStyle2 = ActionStyle.NEUTRAL;
        m = r.m(new PromptDialogHelper.Action(text, actionStyle, new MainActivity$showEnjoyingTheAppPrompt$feedbackActions$1(this)), new PromptDialogHelper.Action(text2, actionStyle2, MainActivity$showEnjoyingTheAppPrompt$feedbackActions$2.INSTANCE));
        CharSequence text3 = getText(R.string.rate_on_playstore);
        kotlin.jvm.internal.m.f(text3, "getText(R.string.rate_on_playstore)");
        CharSequence text4 = getText(R.string.no_thanks);
        kotlin.jvm.internal.m.f(text4, "getText(R.string.no_thanks)");
        m2 = r.m(new PromptDialogHelper.Action(text3, actionStyle, new MainActivity$showEnjoyingTheAppPrompt$rateItActions$1(this)), new PromptDialogHelper.Action(text4, actionStyle2, MainActivity$showEnjoyingTheAppPrompt$rateItActions$2.INSTANCE));
        CharSequence text5 = getText(R.string.yes);
        kotlin.jvm.internal.m.f(text5, "getText(R.string.yes)");
        CharSequence text6 = getText(R.string.not_really);
        kotlin.jvm.internal.m.f(text6, "getText(R.string.not_really)");
        m3 = r.m(new PromptDialogHelper.Action(text5, actionStyle, new MainActivity$showEnjoyingTheAppPrompt$enjoyingAppActions$1(this, m2)), new PromptDialogHelper.Action(text6, actionStyle2, new MainActivity$showEnjoyingTheAppPrompt$enjoyingAppActions$2(this, m)));
        PromptDialogHelper promptDialogHelper = PromptDialogHelper.INSTANCE;
        CharSequence text7 = getText(R.string.action_rate_app_title);
        kotlin.jvm.internal.m.f(text7, "getText(R.string.action_rate_app_title)");
        promptDialogHelper.show(this, new PromptDialogHelper.Properties(null, text7, null, null, Integer.valueOf((int) R.drawable.illustration_man_with_phone), m3, null, false, null, null, MainActivity$showEnjoyingTheAppPrompt$1.INSTANCE, null, null, false, 15309, null));
    }

    private final void showGooglePlayServicesDialogIfUnavailable() {
        boolean a = e.j.l.q.a.a.a(this);
        o2 o2Var = this.viewModel;
        if (o2Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        boolean m = o2Var.m();
        if (a || m) {
            return;
        }
        showGooglePlayServicesUnavailableDialog();
        o2 o2Var2 = this.viewModel;
        if (o2Var2 != null) {
            o2Var2.y();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void showGooglePlayServicesUnavailableDialog() {
        e.j.f.h.j(this, MainActivity$showGooglePlayServicesUnavailableDialog$1.INSTANCE);
    }

    public final NetworkStatusView showNetworkUnavailable() {
        NetworkStatusView networkStatusView = (NetworkStatusView) findViewById(e.j.a.networkStatusView);
        kotlin.jvm.internal.m.f(networkStatusView, "");
        networkStatusView.setVisibility(0);
        networkStatusView.setBackgroundColor(y.b(networkStatusView, R.color.errorColor));
        networkStatusView.setText(getText(R.string.network_unavailable));
        return networkStatusView;
    }

    public final void showUnreadNotifications(List<Notification> list) {
        Notification notification;
        if ((list == null || list.isEmpty()) || (notification = (Notification) kotlin.a0.p.b0(list, 0)) == null) {
            return;
        }
        String string = list.size() > 1 ? getString(R.string.template_notification_count, new Object[]{1, Integer.valueOf(list.size())}) : null;
        ArrayList arrayList = new ArrayList();
        for (CallToAction callToAction : notification.getCallToActions()) {
            CharSequence text = getText(callToAction.getActionButtonTextResId());
            kotlin.jvm.internal.m.f(text, "getText(callToAction.actionButtonTextResId)");
            arrayList.add(new PromptDialogHelper.Action(text, callToAction.getActionStyle(), new MainActivity$showUnreadNotifications$1$1(callToAction, this, notification, list)));
        }
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            o2Var.v(notification);
            l.a.a.g(kotlin.jvm.internal.m.o("Notification displayed -> ", notification.getTitle()), new Object[0]);
            PromptDialogHelper.INSTANCE.show(this, new PromptDialogHelper.Properties(string, notification.getTitle(), notification.getMessage(), null, notification.getImageResId(), arrayList, null, false, null, null, new MainActivity$showUnreadNotifications$2(notification, this, list), new MainActivity$showUnreadNotifications$3(notification), null, notification.getShowCloseButton(), 5064, null));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void switchToDappBrowser(String str) {
        ((WalletViewPager) findViewById(e.j.a.viewPager)).setCurrentItem(MainTab.DAPPS.getPosition(), false);
        ((BottomNavigationView) findViewById(e.j.a.bottomNavBar)).setSelectedItemId(R.id.action_dapps);
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            o2Var.x(str);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    private final void switchToTabAndNavigate(MainTab mainTab, int i2, Bundle bundle, androidx.navigation.p pVar) {
        if (mainTab != null) {
            ((WalletViewPager) findViewById(e.j.a.viewPager)).setCurrentItem(mainTab.ordinal(), false);
        }
        Integer valueOf = mainTab == null ? null : Integer.valueOf(mainTab.ordinal());
        int currentItem = valueOf == null ? ((WalletViewPager) findViewById(e.j.a.viewPager)).getCurrentItem() : valueOf.intValue();
        ((BottomNavigationView) findViewById(e.j.a.bottomNavBar)).setSelectedItemId(MainTab.Companion.fromPosition(currentItem).getSelectedItemId());
        Fragment d2 = getViewPagerAdapter().d(currentItem);
        if (d2 == null) {
            return;
        }
        Fragment_CommonKt.navigate$default(d2, i2, bundle, pVar, null, 8, null);
    }

    public static /* synthetic */ void switchToTabAndNavigate$default(MainActivity mainActivity, MainTab mainTab, int i2, Bundle bundle, androidx.navigation.p pVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        if ((i3 & 8) != 0) {
            pVar = null;
        }
        mainActivity.switchToTabAndNavigate(mainTab, i2, bundle, pVar);
    }

    private final void trySelectTabFromIntent() {
        Bundle extras = getIntent().getExtras();
        MainTab mainTab = extras == null ? null : (MainTab) extras.getParcelable(EXTRA__ACTIVE_TAB);
        if (mainTab == null) {
            mainTab = MainTab.WALLET;
        }
        ((WalletViewPager) findViewById(e.j.a.viewPager)).setCurrentItem(mainTab.getPosition(), false);
        Bundle extras2 = getIntent().getExtras();
        if (extras2 == null) {
            return;
        }
        extras2.remove(EXTRA__ACTIVE_TAB);
    }

    private final void unlockAppSession() {
        Uri data;
        setupSignerView();
        o2 o2Var = this.viewModel;
        if (o2Var != null) {
            o2Var.D();
            ((WalletViewPager) findViewById(e.j.a.viewPager)).setVisibility(0);
            ConstraintLayout rootView = (ConstraintLayout) findViewById(e.j.a.J5);
            kotlin.jvm.internal.m.f(rootView, "rootView");
            rootView.setVisibility(0);
            checkForUnreadNotifications();
            o2 o2Var2 = this.viewModel;
            if (o2Var2 != null) {
                s<Uri> observeOn = o2Var2.B(this).observeOn(getMainScheduler());
                kotlin.jvm.internal.m.f(observeOn, "viewModel.setupDeepLinks(this)\n            .observeOn(mainScheduler)");
                Object as = Observable_AnalyticsKt.logError$default(observeOn, "Unable to setup deep link router", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.setupDeepLinks(this)\n            .observeOn(mainScheduler)\n            .logError(\"Unable to setup deep link router\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new MainActivity$unlockAppSession$1(this), 3, null);
                Intent intent = getIntent();
                if (intent == null || (data = intent.getData()) == null) {
                    return;
                }
                o2 o2Var3 = this.viewModel;
                if (o2Var3 != null) {
                    o2Var3.l(data);
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

    public void _$_clearFindViewByIdCache() {
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.authenticationHelper;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final GenericViewModelFactory<a2> getBannedLocationViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<a2> genericViewModelFactory = this.bannedLocationViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("bannedLocationViewModelFactory");
        throw null;
    }

    public final ContactUsLauncher getContactUsLauncher$app_productionRelease() {
        ContactUsLauncher contactUsLauncher = this.contactUsLauncher;
        if (contactUsLauncher != null) {
            return contactUsLauncher;
        }
        kotlin.jvm.internal.m.w("contactUsLauncher");
        throw null;
    }

    public final GenericViewModelFactory<DeepLinkViewModel> getDeepLinkViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<DeepLinkViewModel> genericViewModelFactory = this.deepLinkViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("deepLinkViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<o2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<o2> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BottomNavigationActivity
    public void hideBottomNavigation() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(e.j.a.bottomNavBar);
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(8);
        }
        View findViewById = findViewById(e.j.a.bottomNavBarSpacer);
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment d2 = getViewPagerAdapter().d(((WalletViewPager) findViewById(e.j.a.viewPager)).getCurrentItem());
        Objects.requireNonNull(d2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        if (e.j.f.m.i(d2)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // dagger.android.g.b, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        Activity_CommonKt.enableFullscreenWindow(this);
        setup();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onNewIntent(Intent intent) {
        Set<String> keySet;
        int r;
        Map<String, String> r2;
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        setIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null || (keySet = extras.keySet()) == null) {
            r2 = null;
        } else {
            r = kotlin.a0.s.r(keySet, 10);
            ArrayList arrayList = new ArrayList(r);
            for (String str : keySet) {
                arrayList.add(u.a(str, intent.getStringExtra(str)));
            }
            r2 = m0.r(arrayList);
        }
        if (r2 == null) {
            return;
        }
        o2 o2Var = this.viewModel;
        if (o2Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        o2Var.w(r2);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        refreshOrientationLock();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        checkAuth();
    }

    public final void setAuthenticationHelper$app_productionRelease(AuthenticationHelper authenticationHelper) {
        kotlin.jvm.internal.m.g(authenticationHelper, "<set-?>");
        this.authenticationHelper = authenticationHelper;
    }

    public final void setBannedLocationViewModelFactory$app_productionRelease(GenericViewModelFactory<a2> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.bannedLocationViewModelFactory = genericViewModelFactory;
    }

    public final void setContactUsLauncher$app_productionRelease(ContactUsLauncher contactUsLauncher) {
        kotlin.jvm.internal.m.g(contactUsLauncher, "<set-?>");
        this.contactUsLauncher = contactUsLauncher;
    }

    public final void setDeepLinkViewModelFactory$app_productionRelease(GenericViewModelFactory<DeepLinkViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.deepLinkViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<o2> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.commonui.views.BottomNavigationActivity
    public void showBottomNavigation() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(e.j.a.bottomNavBar);
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(0);
        }
        View findViewById = findViewById(e.j.a.bottomNavBarSpacer);
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(0);
    }
}