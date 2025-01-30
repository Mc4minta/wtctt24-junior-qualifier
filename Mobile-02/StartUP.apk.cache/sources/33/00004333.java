package com.toshi.view.fragment.onboarding.authMethod;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.c;
import c.h.k.d0;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.application.service.ApplicationService;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.toshi.view.activity.pin.SetupPinLockActivity;
import com.toshi.view.fragment.o0;
import e.j.f.k;
import h.c.a0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bD\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0004H$¢\u0006\u0004\b\u001c\u0010\u0006R\"\u0010$\u001a\u00020\u001d8\u0004@\u0004X\u0085.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010/\u001a\n ,*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0004@\u0004X\u0085.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0004@\u0004X\u0085.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/toshi/view/fragment/onboarding/authMethod/g;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setup", "()V", "m", "k", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "onBackPressed", "()Z", "onDestroyView", "l", "setupClickListeners", "j", "Le/j/l/n/b;", "d", "Le/j/l/n/b;", "i", "()Le/j/l/n/b;", "setBiometricHelper", "(Le/j/l/n/b;)V", "biometricHelper", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "b", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", Constants.URL_CAMPAIGN, "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "h", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "Lcom/coinbase/wallet/application/service/ApplicationService;", "e", "Lcom/coinbase/wallet/application/service/ApplicationService;", "g", "()Lcom/coinbase/wallet/application/service/ApplicationService;", "setApplicationService", "(Lcom/coinbase/wallet/application/service/ApplicationService;)V", "applicationService", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class g extends o0 implements BackableFragment, StyledFragment {
    private final a0 a = h.c.j0.c.a.b();

    /* renamed from: b  reason: collision with root package name */
    private final StyledFragment.Attributes f11365b = new StyledFragment.Attributes(true, false, false, 6, null);

    /* renamed from: c  reason: collision with root package name */
    protected AuthenticationHelper f11366c;

    /* renamed from: d  reason: collision with root package name */
    protected e.j.l.n.b f11367d;

    /* renamed from: e  reason: collision with root package name */
    protected ApplicationService f11368e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements l<View, x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
        /* renamed from: com.toshi.view.fragment.onboarding.authMethod.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0245a extends o implements l<x, x> {
            final /* synthetic */ g a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0245a(g gVar) {
                super(1);
                this.a = gVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(x xVar) {
                invoke2(xVar);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(x xVar) {
                this.a.j();
            }
        }

        a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            Object as = g.this.g().reset().observeOn(g.this.a).as(com.uber.autodispose.d.a(g.this.getScopeProvider()));
            m.f(as, "applicationService.reset()\n                .observeOn(mainScheduler)\n                .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new C0245a(g.this), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends o implements l<View, x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends o implements l<x, x> {
            final /* synthetic */ g a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.a = gVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(x xVar) {
                invoke2(xVar);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(x xVar) {
                this.a.k();
            }
        }

        b() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            Object as = g.this.g().reset().observeOn(g.this.a).as(com.uber.autodispose.d.a(g.this.getScopeProvider()));
            m.f(as, "applicationService.reset()\n                .observeOn(mainScheduler)\n                .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new a(g.this), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseWalletAuthenticationOnboardingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements l<c.a, x> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(c.a aVar) {
            invoke2(aVar);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(c.a showDialog) {
            m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.set_up_device_lock_title);
            showDialog.f(R.string.set_up_device_lock_info);
            k.a(showDialog, R.string.ok);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        startActivityForResult(new Intent(getActivity(), SetupPinLockActivity.class), 102);
    }

    private final void m() {
        View view = getView();
        View setUpBiometric = view == null ? null : view.findViewById(e.j.a.setUpBiometric);
        m.f(setUpBiometric, "setUpBiometric");
        setUpBiometric.setVisibility(i().a() ? 0 : 8);
    }

    private final void setup() {
        e.j.f.m.o(this, h());
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    protected final ApplicationService g() {
        ApplicationService applicationService = this.f11368e;
        if (applicationService != null) {
            return applicationService;
        }
        m.w("applicationService");
        throw null;
    }

    public StyledFragment.Attributes getAttributes() {
        return this.f11365b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AuthenticationHelper h() {
        AuthenticationHelper authenticationHelper = this.f11366c;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        m.w("authenticationHelper");
        throw null;
    }

    protected final e.j.l.n.b i() {
        e.j.l.n.b bVar = this.f11367d;
        if (bVar != null) {
            return bVar;
        }
        m.w("biometricHelper");
        throw null;
    }

    protected abstract void j();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        e.j.f.m.p(this, c.a);
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_authentication_onboarding, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        h().clear();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        setup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setupClickListeners() {
        View view = getView();
        View setUpBiometric = view == null ? null : view.findViewById(e.j.a.setUpBiometric);
        m.f(setUpBiometric, "setUpBiometric");
        View_CommonKt.setOnSingleClickListener$default(setUpBiometric, 0L, new a(), 1, null);
        View view2 = getView();
        View setUpPin = view2 != null ? view2.findViewById(e.j.a.setUpPin) : null;
        m.f(setUpPin, "setUpPin");
        View_CommonKt.setOnSingleClickListener$default(setUpPin, 0L, new b(), 1, null);
    }
}