package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.navigation.NavController;
import androidx.navigation.k;
import androidx.navigation.t;
import c.h.k.d0;
import c.h.k.q;
import c.h.k.v;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.navigator.CustomNavigator;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import h.c.b0;
import h.c.t0.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: BaseNavHostFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001:\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b=\u0010\u001bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001e\u0010\u001bJ)\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020!H\u0016¢\u0006\u0004\b'\u0010(R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010\u0007\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R$\u00104\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\b0\b028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010(R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/commonui/views/BaseNavHostFragment;", "Landroidx/fragment/app/Fragment;", "T", "Landroidx/navigation/fragment/d;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lkotlin/x;", "refreshFragmentStyles", "(Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;)V", "refreshStatusBarIconColor", "refreshBottomNavigationVisibility", "refreshNavBarColor", "Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "behavior", "setScreenshotProtectionBehavior", "(Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;)V", "Landroidx/navigation/NavController;", "navController", "onCreateNavController", "(Landroidx/navigation/NavController;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "onPause", "onResume", "initializeNavGraph", "", "transit", "", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "(IZI)Landroid/view/animation/Animation;", "onBackPressed", "()Z", "Ljava/lang/Class;", "getBaseFragment", "()Ljava/lang/Class;", "baseFragment", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getNavGraph", "()I", "navGraph", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "isReadySubject", "Lh/c/v0/b;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "isLazy", "com/coinbase/wallet/commonui/views/BaseNavHostFragment$fragmentLifecycleCallbacks$1", "fragmentLifecycleCallbacks", "Lcom/coinbase/wallet/commonui/views/BaseNavHostFragment$fragmentLifecycleCallbacks$1;", "<init>", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BaseNavHostFragment<T extends Fragment> extends androidx.navigation.fragment.d implements BackableFragment, StyledFragment {
    private final h.c.k0.a disposeBag;
    private final BaseNavHostFragment$fragmentLifecycleCallbacks$1 fragmentLifecycleCallbacks;
    private final h.c.v0.b<x> isReadySubject;

    /* compiled from: BaseNavHostFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenshotProtection.Behavior.values().length];
            iArr[ScreenshotProtection.Behavior.BLOCK.ordinal()] = 1;
            iArr[ScreenshotProtection.Behavior.ALLOW.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.coinbase.wallet.commonui.views.BaseNavHostFragment$fragmentLifecycleCallbacks$1] */
    public BaseNavHostFragment() {
        h.c.v0.b<x> d2 = h.c.v0.b.d();
        m.f(d2, "create<Unit>()");
        this.isReadySubject = d2;
        this.disposeBag = new h.c.k0.a();
        this.fragmentLifecycleCallbacks = new m.f(this) { // from class: com.coinbase.wallet.commonui.views.BaseNavHostFragment$fragmentLifecycleCallbacks$1
            final /* synthetic */ BaseNavHostFragment<T> this$0;
            private ScreenshotProtection.Behavior toFragmentBehavior = ScreenshotProtection.Behavior.ALLOW;

            /* compiled from: BaseNavHostFragment.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ScreenshotProtection.Behavior.values().length];
                    iArr[ScreenshotProtection.Behavior.BLOCK.ordinal()] = 1;
                    iArr[ScreenshotProtection.Behavior.ALLOW.ordinal()] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.fragment.app.m.f
            public void onFragmentViewCreated(androidx.fragment.app.m fm, Fragment f2, View v, Bundle bundle) {
                kotlin.jvm.internal.m.g(fm, "fm");
                kotlin.jvm.internal.m.g(f2, "f");
                kotlin.jvm.internal.m.g(v, "v");
                super.onFragmentViewCreated(fm, f2, v, bundle);
                ScreenshotProtection.Behavior screenshotProtectionBehavior = Fragment_CommonKt.getScreenshotProtectionBehavior(f2);
                this.toFragmentBehavior = screenshotProtectionBehavior;
                if (WhenMappings.$EnumSwitchMapping$0[screenshotProtectionBehavior.ordinal()] == 1) {
                    this.this$0.setScreenshotProtectionBehavior(screenshotProtectionBehavior);
                }
                if (f2 instanceof StyledFragment) {
                    final StyledFragment styledFragment = (StyledFragment) f2;
                    this.this$0.refreshFragmentStyles(styledFragment.getAttributes());
                    if (!styledFragment.getAttributes().isFullScreen() || (v instanceof KeyboardInsetting)) {
                        return;
                    }
                    v.w0(v, new q() { // from class: com.coinbase.wallet.commonui.views.d
                        @Override // c.h.k.q
                        public final d0 a(View view, d0 d0Var) {
                            return StyledFragment.this.applyWindowInsets(view, d0Var);
                        }
                    });
                }
            }

            @Override // androidx.fragment.app.m.f
            public void onFragmentViewDestroyed(androidx.fragment.app.m fm, Fragment f2) {
                kotlin.jvm.internal.m.g(fm, "fm");
                kotlin.jvm.internal.m.g(f2, "f");
                super.onFragmentViewDestroyed(fm, f2);
                ScreenshotProtection.Behavior behavior = this.toFragmentBehavior;
                if (WhenMappings.$EnumSwitchMapping$0[behavior.ordinal()] == 2) {
                    this.this$0.setScreenshotProtectionBehavior(behavior);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m813onCreate$lambda0(BaseNavHostFragment this$0, NavController noName_0, k destination, Bundle bundle) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(noName_0, "$noName_0");
        kotlin.jvm.internal.m.g(destination, "destination");
        l.a.a.g(((Object) this$0.getClass().getSimpleName()) + " destination change: destination=" + ((Object) destination.s()), new Object[0]);
    }

    private final void refreshBottomNavigationVisibility(StyledFragment.Attributes attributes) {
        androidx.fragment.app.d activity = getActivity();
        BottomNavigationActivity bottomNavigationActivity = activity instanceof BottomNavigationActivity ? (BottomNavigationActivity) activity : null;
        if (bottomNavigationActivity == null) {
            return;
        }
        if (attributes.isFullScreen()) {
            bottomNavigationActivity.hideBottomNavigation();
        } else {
            bottomNavigationActivity.showBottomNavigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshFragmentStyles(StyledFragment.Attributes attributes) {
        refreshStatusBarIconColor(attributes);
        refreshBottomNavigationVisibility(attributes);
        refreshNavBarColor(attributes);
    }

    private final void refreshNavBarColor(StyledFragment.Attributes attributes) {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        Activity_CommonKt.setHasDarkNavBar(activity, attributes.getHasDarkNavBar());
    }

    private final void refreshStatusBarIconColor(StyledFragment.Attributes attributes) {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        if (attributes.isDarkTheme()) {
            Activity_CommonKt.enableLightStatusBarIcons(activity);
        } else {
            Activity_CommonKt.enableDarkStatusBarIcons(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setScreenshotProtectionBehavior(ScreenshotProtection.Behavior behavior) {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[behavior.ordinal()];
        if (i2 == 1) {
            activity.getWindow().addFlags(PKIFailureInfo.certRevoked);
        } else if (i2 != 2) {
        } else {
            activity.getWindow().clearFlags(PKIFailureInfo.certRevoked);
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        Fragment currentVisibleFragment = Fragment_CommonKt.getCurrentVisibleFragment(this);
        StyledFragment styledFragment = currentVisibleFragment instanceof StyledFragment ? (StyledFragment) currentVisibleFragment : null;
        StyledFragment.Attributes attributes = styledFragment != null ? styledFragment.getAttributes() : null;
        return attributes == null ? StyledFragment.DefaultImpls.getAttributes(this) : attributes;
    }

    public abstract Class<T> getBaseFragment();

    public abstract int getNavGraph();

    public final void initializeNavGraph() {
        if (!isLazy() || this.disposeBag.f() <= 0) {
            return;
        }
        this.disposeBag.d();
        getNavController().y(getNavGraph());
    }

    public abstract boolean isLazy();

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        l.a.a.g(kotlin.jvm.internal.m.o(getClass().getSimpleName(), " onBackPressed"), new Object[0]);
        List<Fragment> h0 = getChildFragmentManager().h0();
        kotlin.jvm.internal.m.f(h0, "childFragmentManager.fragments");
        for (Fragment fragment : h0) {
            if ((fragment instanceof BackableFragment) && fragment.isVisible() && ((BackableFragment) fragment).onBackPressed()) {
                return true;
            }
        }
        return getNavController().t();
    }

    @Override // androidx.navigation.fragment.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dagger.android.g.a.b(this);
        if (isLazy()) {
            b0 observeOn = Observable_CoreKt.takeSingle(this.isReadySubject).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "isReadySubject\n                .takeSingle()\n                .observeOn(AndroidSchedulers.mainThread())");
            h.c.t0.a.a(g.i(observeOn, null, new BaseNavHostFragment$onCreate$1(this), 1, null), this.disposeBag);
        } else {
            getNavController().y(getNavGraph());
        }
        getNavController().a(new NavController.b() { // from class: com.coinbase.wallet.commonui.views.a
            @Override // androidx.navigation.NavController.b
            public final void a(NavController navController, k kVar, Bundle bundle2) {
                BaseNavHostFragment.m813onCreate$lambda0(BaseNavHostFragment.this, navController, kVar, bundle2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return Fragment_CommonKt.fixOnCreateAnimation(this, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.fragment.d
    public void onCreateNavController(NavController navController) {
        kotlin.jvm.internal.m.g(navController, "navController");
        t m = navController.m();
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        androidx.fragment.app.m childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.m.f(childFragmentManager, "childFragmentManager");
        m.a(new CustomNavigator(requireContext, childFragmentManager, getId()));
        super.onCreateNavController(navController);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposeBag.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getChildFragmentManager().d1(this.fragmentLifecycleCallbacks);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getChildFragmentManager().M0(this.fragmentLifecycleCallbacks, false);
        Fragment currentVisibleFragment = Fragment_CommonKt.getCurrentVisibleFragment(this);
        ScreenshotProtection.Behavior screenshotProtectionBehavior = currentVisibleFragment == null ? null : Fragment_CommonKt.getScreenshotProtectionBehavior(currentVisibleFragment);
        if (screenshotProtectionBehavior == null) {
            screenshotProtectionBehavior = ScreenshotProtection.Behavior.ALLOW;
        }
        setScreenshotProtectionBehavior(screenshotProtectionBehavior);
        refreshFragmentStyles(getAttributes());
        if (isLazy()) {
            this.isReadySubject.onNext(x.a);
        }
    }
}