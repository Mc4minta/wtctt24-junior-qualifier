package com.toshi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: OnboardingWizardActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR%\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/toshi/view/activity/OnboardingWizardActivity;", "Ldagger/android/g/b;", "Lkotlin/x;", "setup", "()V", "setupViewModel", "setupObservers", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "", "onSupportNavigateUp", "()Z", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/a2;", "d", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getBannedLocationViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setBannedLocationViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "bannedLocationViewModelFactory", Constants.URL_CAMPAIGN, "Le/j/n/a2;", "bannedLocationViewModel", "Lh/c/a0;", "a", "Lkotlin/h;", "getMainScheduler", "()Lh/c/a0;", "mainScheduler", "Lcom/uber/autodispose/android/lifecycle/b;", "kotlin.jvm.PlatformType", "b", "getScopeProvider", "()Lcom/uber/autodispose/android/lifecycle/b;", "scopeProvider", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class OnboardingWizardActivity extends dagger.android.g.b {
    private final kotlin.h a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f11127b;

    /* renamed from: c  reason: collision with root package name */
    private e.j.n.a2 f11128c;

    /* renamed from: d  reason: collision with root package name */
    public GenericViewModelFactory<e.j.n.a2> f11129d;

    /* compiled from: OnboardingWizardActivity.kt */
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

    /* compiled from: OnboardingWizardActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<com.uber.autodispose.android.lifecycle.b> {
        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final com.uber.autodispose.android.lifecycle.b invoke() {
            return com.uber.autodispose.android.lifecycle.b.d(OnboardingWizardActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnboardingWizardActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean isBanned) {
            List<Number> j2;
            kotlin.jvm.internal.m.f(isBanned, "isBanned");
            if (isBanned.booleanValue()) {
                j2 = kotlin.a0.r.j(32768, 268435456);
                OnboardingWizardActivity onboardingWizardActivity = OnboardingWizardActivity.this;
                Intent intent = new Intent(onboardingWizardActivity, BannedLocationActivity.class);
                for (Number number : j2) {
                    intent.addFlags(number.intValue());
                }
                onboardingWizardActivity.startActivity(intent);
                onboardingWizardActivity.finish();
            }
        }
    }

    public OnboardingWizardActivity() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(a.a);
        this.a = b2;
        b3 = kotlin.k.b(new b());
        this.f11127b = b3;
    }

    private final h.c.a0 getMainScheduler() {
        Object value = this.a.getValue();
        kotlin.jvm.internal.m.f(value, "<get-mainScheduler>(...)");
        return (h.c.a0) value;
    }

    private final com.uber.autodispose.android.lifecycle.b getScopeProvider() {
        return (com.uber.autodispose.android.lifecycle.b) this.f11127b.getValue();
    }

    private final void setup() {
        setupViewModel();
        setupObservers();
    }

    private final void setupObservers() {
        e.j.n.a2 a2Var = this.f11128c;
        if (a2Var != null) {
            h.c.s<Boolean> observeOn = a2Var.a().observeOn(getMainScheduler());
            kotlin.jvm.internal.m.f(observeOn, "bannedLocationViewModel.isBannedLocationObservable\n            .observeOn(mainScheduler)");
            Object as = Observable_AnalyticsKt.logError$default(observeOn, "Error while observing if user in banned location", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "bannedLocationViewModel.isBannedLocationObservable\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing if user in banned location\")\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new c(), 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("bannedLocationViewModel");
        throw null;
    }

    private final void setupViewModel() {
        androidx.lifecycle.b0 a2 = androidx.lifecycle.e0.b(this, getBannedLocationViewModelFactory$app_productionRelease()).a(e.j.n.a2.class);
        kotlin.jvm.internal.m.f(a2, "of(this, viewModelFactory).get(T::class.java)");
        this.f11128c = (e.j.n.a2) a2;
    }

    public final GenericViewModelFactory<e.j.n.a2> getBannedLocationViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<e.j.n.a2> genericViewModelFactory = this.f11129d;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("bannedLocationViewModelFactory");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (e.j.f.m.i(getSupportFragmentManager().Y(R.id.onboardingWizardFragment))) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dagger.android.g.b, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        dagger.android.a.a(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_onboarding_wizard);
        Activity_CommonKt.enableFullscreenWindow(this);
        setup();
    }

    @Override // androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        return e.j.f.c.d(this, R.id.onboardingWizardFragment).r();
    }
}