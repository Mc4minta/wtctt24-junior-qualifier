package com.toshi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.p;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.application.model.AppState;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.NavController_CommonKt;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import e.j.n.o2;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: BannedLocationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J#\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010!\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0&8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/toshi/view/fragment/BannedLocationFragment;", "Lcom/toshi/view/fragment/o0;", "Lkotlin/x;", "setupViewModel", "()V", "setupObservers", "i", "j", "", "resId", "Landroid/os/Bundle;", "args", "f", "(ILandroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lh/c/a0;", "a", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/uber/autodispose/android/lifecycle/b;", "kotlin.jvm.PlatformType", "b", "h", "()Lcom/uber/autodispose/android/lifecycle/b;", "scopeProvider", "Le/j/n/o2;", Constants.URL_CAMPAIGN, "Le/j/n/o2;", "mainViewModel", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "d", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "g", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setMainViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "mainViewModelFactory", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BannedLocationFragment extends o0 {
    private final kotlin.h a = kotlin.j.b(a.a);

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f11245b = kotlin.j.b(new b());

    /* renamed from: c  reason: collision with root package name */
    private o2 f11246c;

    /* renamed from: d  reason: collision with root package name */
    public GenericViewModelFactory<o2> f11247d;

    /* compiled from: BannedLocationFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.a0> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final h.c.a0 invoke() {
            return h.c.j0.c.a.b();
        }
    }

    /* compiled from: BannedLocationFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<com.uber.autodispose.android.lifecycle.b> {
        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final com.uber.autodispose.android.lifecycle.b invoke() {
            return com.uber.autodispose.android.lifecycle.b.d(BannedLocationFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BannedLocationFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AppState, kotlin.x> {
        c() {
            super(1);
        }

        public final void a(AppState appState) {
            if (kotlin.jvm.internal.m.c(appState, AppState.AppUnlocked.INSTANCE) ? true : kotlin.jvm.internal.m.c(appState, AppState.AppLocked.INSTANCE)) {
                BannedLocationFragment.this.i();
            } else if (kotlin.jvm.internal.m.c(appState, AppState.NoStoredMnemonic.INSTANCE)) {
                BannedLocationFragment.this.j();
            }
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(AppState appState) {
            a(appState);
            return kotlin.x.a;
        }
    }

    private final void f(int i2, Bundle bundle) {
        p.a defaultNavOptionsBuilder = NavController_CommonKt.getDefaultNavOptionsBuilder();
        defaultNavOptionsBuilder.g(R.id.bannedLocationFragment, true);
        androidx.navigation.p a2 = defaultNavOptionsBuilder.a();
        kotlin.jvm.internal.m.f(a2, "defaultNavOptionsBuilder.run {\n            setPopUpTo(R.id.bannedLocationFragment, true)\n            build()\n        }");
        Fragment_CommonKt.navigate$default(this, i2, bundle, a2, null, 8, null);
    }

    private final h.c.a0 getMainScheduler() {
        Object value = this.a.getValue();
        kotlin.jvm.internal.m.f(value, "<get-mainScheduler>(...)");
        return (h.c.a0) value;
    }

    private final com.uber.autodispose.android.lifecycle.b h() {
        return (com.uber.autodispose.android.lifecycle.b) this.f11245b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        f(R.id.backup_phrase_nav_graph, BackupRecoveryPhraseFragment.Companion.createArgs$default(BackupRecoveryPhraseFragment.Companion, true, null, BackupRecoveryPhraseViewModel.BackupMode.Ofac, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f(R.id.onboarding_nav_graph, androidx.core.os.b.a(kotlin.u.a("banned_location", Boolean.TRUE)));
    }

    private final void setupObservers() {
        o2 o2Var = this.f11246c;
        if (o2Var != null) {
            Object as = o2Var.h().observeOn(getMainScheduler()).as(com.uber.autodispose.d.a(h()));
            kotlin.jvm.internal.m.f(as, "mainViewModel.appStateObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new c(), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("mainViewModel");
        throw null;
    }

    private final void setupViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, g()).a(o2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11246c = (o2) a2;
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<o2> g() {
        GenericViewModelFactory<o2> genericViewModelFactory = this.f11247d;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("mainViewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        setupViewModel();
        setupObservers();
        return super.onCreateView(inflater, viewGroup, bundle);
    }
}