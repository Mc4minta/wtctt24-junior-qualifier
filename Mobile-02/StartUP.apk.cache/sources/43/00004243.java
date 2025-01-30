package com.toshi.view.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.c;
import androidx.lifecycle.i;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;
import com.toshi.view.activity.pin.SwitchPinLockFragment;
import com.toshi.view.fragment.AuthenticationFragment;
import e.j.n.y1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: AuthenticationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001gB\u0007¢\u0006\u0004\bf\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J-\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u0010-J!\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0006J)\u00107\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<R\u001e\u0010A\u001a\n >*\u0004\u0018\u00010=0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R(\u0010J\u001a\b\u0012\u0004\u0012\u00020C0B8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Y\u001a\u00020R8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010a\u001a\u00020Z8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006h"}, d2 = {"Lcom/toshi/view/fragment/AuthenticationFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initClickListeners", "initViews", "m", "q", "t", "s", "Lkotlin/Function1;", "Le/j/d/c;", "callback", "r", "(Lkotlin/e0/c/l;)V", "", "throwable", "k", "(Ljava/lang/Throwable;)V", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "authenticationMethod", "u", "(Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "n", "o", "", "pin", "p", "(Ljava/lang/String;)V", "Le/j/d/a;", "permit", "l", "(Ljava/lang/String;Le/j/d/a;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "", "onBackPressed", "()Z", "Lh/c/a0;", "kotlin.jvm.PlatformType", "b", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/y1;", "f", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", Constants.URL_CAMPAIGN, "Le/j/n/y1;", "viewModel", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "d", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "Le/j/l/n/b;", "e", "Le/j/l/n/b;", "j", "()Le/j/l/n/b;", "setBiometricHelper$app_productionRelease", "(Le/j/l/n/b;)V", "biometricHelper", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AuthenticationFragment extends LockedFragment implements StyledFragment, BackableFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    private final h.c.a0 f11238b = h.c.j0.c.a.b();

    /* renamed from: c */
    private y1 f11239c;

    /* renamed from: d */
    public AuthenticationHelper f11240d;

    /* renamed from: e */
    public e.j.l.n.b f11241e;

    /* renamed from: f */
    public GenericViewModelFactory<y1> f11242f;

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AuthenticationMethod.values().length];
            iArr[AuthenticationMethod.BIOMETRIC.ordinal()] = 1;
            iArr[AuthenticationMethod.PIN.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.key_invalidated_dialog_title);
            showDialog.f(R.string.key_invalidated_dialog_info);
            e.j.f.k.b(showDialog, R.string.ok);
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.fatal_authentication_dialog_title);
            showDialog.f(R.string.fatal_authentication_dialog_message);
            e.j.f.k.b(showDialog, R.string.ok);
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AuthenticationMethod, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        public final void a(AuthenticationMethod it) {
            AuthenticationFragment authenticationFragment = AuthenticationFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            authenticationFragment.u(it);
            Fragment_CommonKt.navigateUp(AuthenticationFragment.this);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(AuthenticationMethod authenticationMethod) {
            a(authenticationMethod);
            return kotlin.x.a;
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(AuthenticationFragment.this);
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            AuthenticationFragment.this.m();
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            AuthenticationFragment.this.s();
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        public static final void a(AuthenticationFragment this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            Fragment_CommonKt.navigateUp(this$0);
        }

        public static /* synthetic */ void b(AuthenticationFragment authenticationFragment, DialogInterface dialogInterface) {
            a(authenticationFragment, dialogInterface);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.authentication_switching_error_title);
            showDialog.f(R.string.authentication_switching_error_message);
            e.j.f.k.b(showDialog, R.string.ok);
            final AuthenticationFragment authenticationFragment = AuthenticationFragment.this;
            showDialog.j(new DialogInterface.OnDismissListener() { // from class: com.toshi.view.fragment.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AuthenticationFragment.i.b(AuthenticationFragment.this, dialogInterface);
                }
            });
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends AuthenticationCallback {

        /* renamed from: b */
        final /* synthetic */ String f11243b;

        j(String str) {
            AuthenticationFragment.this = r1;
            this.f11243b = str;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.a) {
                Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.deviceLockAuthMethodBiometricSet(AnalyticsEvent.Companion));
                AuthenticationFragment.this.l(this.f11243b, (e.j.d.a) permit);
                return;
            }
            onAuthenticationFailed();
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c.a, kotlin.x> {
        public static final k a = new k();

        k() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c.a aVar) {
            invoke2(aVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            kotlin.jvm.internal.m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.set_up_device_lock_title);
            showDialog.f(R.string.set_up_device_lock_info);
            e.j.f.k.a(showDialog, R.string.ok);
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends AuthenticationCallback {

        /* renamed from: b */
        final /* synthetic */ kotlin.e0.c.l<e.j.d.c, kotlin.x> f11244b;

        /* JADX WARN: Multi-variable type inference failed */
        l(kotlin.e0.c.l<? super e.j.d.c, kotlin.x> lVar) {
            AuthenticationFragment.this = r1;
            this.f11244b = lVar;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationError(Throwable th, CharSequence charSequence, Integer num) {
            AuthenticationFragment.this.k(th);
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            this.f11244b.invoke(permit);
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<e.j.d.c, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        public final void a(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.d) {
                Fragment_CommonKt.navigate$default(AuthenticationFragment.this, R.id.action_authenticationFragment_to_switchPinLockFragment, SwitchPinLockFragment.a.a(((e.j.d.d) permit).a()), Fragment_CommonKt.getVerticalNavOptions(AuthenticationFragment.this), null, 8, null);
                return;
            }
            throw new IllegalStateException("Pin permit expected.");
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(e.j.d.c cVar) {
            a(cVar);
            return kotlin.x.a;
        }
    }

    /* compiled from: AuthenticationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n extends kotlin.jvm.internal.o implements kotlin.e0.c.l<e.j.d.c, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n() {
            super(1);
            AuthenticationFragment.this = r1;
        }

        public final void a(e.j.d.c permit) {
            kotlin.jvm.internal.m.g(permit, "permit");
            if (permit instanceof e.j.d.d) {
                AuthenticationFragment.this.p(((e.j.d.d) permit).a());
                return;
            }
            throw new IllegalStateException("Pin permit expected.");
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(e.j.d.c cVar) {
            a(cVar);
            return kotlin.x.a;
        }
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final void init() {
        e.j.f.m.o(this, getAuthenticationHelper$app_productionRelease());
        initViewModel();
        initClickListeners();
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new f(), 1, null);
        View view2 = getView();
        View biometricLockOption = view2 == null ? null : view2.findViewById(e.j.a.biometricLockOption);
        kotlin.jvm.internal.m.f(biometricLockOption, "biometricLockOption");
        View_CommonKt.setOnSingleClickListener$default(biometricLockOption, 0L, new g(), 1, null);
        View view3 = getView();
        View pinLockOption = view3 != null ? view3.findViewById(e.j.a.pinLockOption) : null;
        kotlin.jvm.internal.m.f(pinLockOption, "pinLockOption");
        View_CommonKt.setOnSingleClickListener$default(pinLockOption, 0L, new h(), 1, null);
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(y1.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11239c = (y1) a2;
    }

    private final void initViews() {
        View view = getView();
        View biometricLockOption = view == null ? null : view.findViewById(e.j.a.biometricLockOption);
        kotlin.jvm.internal.m.f(biometricLockOption, "biometricLockOption");
        biometricLockOption.setVisibility(j().b() ? 0 : 8);
    }

    public final void k(Throwable th) {
        l.a.a.e(th);
        if (e.j.f.w.b(th)) {
            e.j.f.m.p(this, c.a);
        } else {
            e.j.f.m.p(this, d.a);
        }
    }

    public final void l(String str, e.j.d.a aVar) {
        y1 y1Var = this.f11239c;
        if (y1Var != null) {
            h.c.b0<AuthenticationMethod> observeOn = y1Var.c(str, aVar).observeOn(this.f11238b);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.switchAuthenticationMethodToBiometric(pin, permit)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error while updating authentication method", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.switchAuthenticationMethodToBiometric(pin, permit)\n            .observeOn(mainScheduler)\n            .logError(\"Error while updating authentication method\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new e(), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void m() {
        if (e.j.f.m.h(this) && j().c()) {
            t();
        } else {
            q();
        }
    }

    private final void n() {
        View view = getView();
        View biometricLockStatus = view == null ? null : view.findViewById(e.j.a.biometricLockStatus);
        kotlin.jvm.internal.m.f(biometricLockStatus, "biometricLockStatus");
        biometricLockStatus.setVisibility(0);
        View view2 = getView();
        View pinLockStatus = view2 != null ? view2.findViewById(e.j.a.pinLockStatus) : null;
        kotlin.jvm.internal.m.f(pinLockStatus, "pinLockStatus");
        pinLockStatus.setVisibility(8);
    }

    private final void o() {
        View view = getView();
        View pinLockStatus = view == null ? null : view.findViewById(e.j.a.pinLockStatus);
        kotlin.jvm.internal.m.f(pinLockStatus, "pinLockStatus");
        pinLockStatus.setVisibility(0);
        View view2 = getView();
        View biometricLockStatus = view2 != null ? view2.findViewById(e.j.a.biometricLockStatus) : null;
        kotlin.jvm.internal.m.f(biometricLockStatus, "biometricLockStatus");
        biometricLockStatus.setVisibility(8);
    }

    public final void p(String str) {
        getAuthenticationHelper$app_productionRelease().authenticateWithBiometricPrompt(EncryptionMethod.ENCRYPTION, new j(str), Boolean.FALSE);
    }

    private final void q() {
        e.j.f.m.p(this, k.a);
    }

    private final void r(kotlin.e0.c.l<? super e.j.d.c, kotlin.x> lVar) {
        getAuthenticationHelper$app_productionRelease().showPinDialog(new l(lVar));
    }

    public final void s() {
        y1 y1Var = this.f11239c;
        if (y1Var != null) {
            if (y1Var.a() == AuthenticationMethod.PIN) {
                r(new m());
                return;
            } else {
                Fragment_CommonKt.navigate$default(this, R.id.action_authenticationFragment_to_switchPinLockFragment, null, Fragment_CommonKt.getVerticalNavOptions(this), null, 8, null);
                return;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void t() {
        y1 y1Var = this.f11239c;
        if (y1Var != null) {
            if (y1Var.a() == AuthenticationMethod.PIN) {
                r(new n());
                return;
            }
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void u(AuthenticationMethod authenticationMethod) {
        int i2 = b.a[authenticationMethod.ordinal()];
        if (i2 == 1) {
            n();
        } else if (i2 != 2) {
        } else {
            o();
        }
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
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.f11240d;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final GenericViewModelFactory<y1> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<y1> genericViewModelFactory = this.f11242f;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    public final e.j.l.n.b j() {
        e.j.l.n.b bVar = this.f11241e;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.m.w("biometricHelper");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            Fragment_CommonKt.navigateUp(this);
        } else {
            e.j.f.m.p(this, new i());
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_authentication, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        y1 y1Var = this.f11239c;
        if (y1Var == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        AuthenticationMethod a2 = y1Var.a();
        if (a2 == null) {
            return;
        }
        u(a2);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}