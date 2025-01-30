package com.coinbase.wallet.application;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.lifecycle.i;
import androidx.lifecycle.w;
import com.coinbase.wallet.application.service.ApplicationService;
import com.coinbase.wallet.application.util.ProcessPhoenix;
import com.coinbase.wallet.common.utilities.Contexts;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.di.AppComponent;
import com.coinbase.wallet.http.connectivity.Internet;
import h.c.a0;
import h.c.s;
import io.reactivex.exceptions.UndeliverableException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;

/* compiled from: BaseApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u0005R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/application/BaseApplication;", "Ldagger/android/c;", "Landroidx/lifecycle/n;", "Lkotlin/x;", "onCreate", "()V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Ldagger/android/b;", "applicationInjector", "()Ldagger/android/b;", "onResumed", "onStop", "Lcom/coinbase/wallet/application/service/ApplicationService;", "applicationService", "Lcom/coinbase/wallet/application/service/ApplicationService;", "getApplicationService$app_productionRelease", "()Lcom/coinbase/wallet/application/service/ApplicationService;", "setApplicationService$app_productionRelease", "(Lcom/coinbase/wallet/application/service/ApplicationService;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BaseApplication extends dagger.android.c implements androidx.lifecycle.n {
    public static final Companion Companion = new Companion(null);
    private static final kotlin.h<AppComponent> component$delegate;
    public static BaseApplication instance;
    private static final s<Boolean> isBackgrounded;
    private static final h.c.v0.a<Boolean> isBackgroundedSubject;
    public ApplicationService applicationService;
    private final a0 concurrentScheduler;
    private final h.c.k0.a disposeBag = new h.c.k0.a();

    /* compiled from: BaseApplication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR=\u0010\u0012\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R$\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/application/BaseApplication$Companion;", "", "Lcom/coinbase/wallet/application/BaseApplication;", "instance", "Lcom/coinbase/wallet/application/BaseApplication;", "getInstance", "()Lcom/coinbase/wallet/application/BaseApplication;", "setInstance", "(Lcom/coinbase/wallet/application/BaseApplication;)V", "Lcom/coinbase/wallet/di/AppComponent;", "component$delegate", "Lkotlin/h;", "getComponent", "()Lcom/coinbase/wallet/di/AppComponent;", "component", "Lh/c/s;", "", "kotlin.jvm.PlatformType", "isBackgrounded", "Lh/c/s;", "()Lh/c/s;", "Lh/c/v0/a;", "isBackgroundedSubject", "Lh/c/v0/a;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ kotlin.j0.m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(Companion.class), "component", "getComponent()Lcom/coinbase/wallet/di/AppComponent;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppComponent getComponent() {
            return (AppComponent) BaseApplication.component$delegate.getValue();
        }

        public final BaseApplication getInstance() {
            BaseApplication baseApplication = BaseApplication.instance;
            if (baseApplication != null) {
                return baseApplication;
            }
            kotlin.jvm.internal.m.w("instance");
            throw null;
        }

        public final s<Boolean> isBackgrounded() {
            return BaseApplication.isBackgrounded;
        }

        public final void setInstance(BaseApplication baseApplication) {
            kotlin.jvm.internal.m.g(baseApplication, "<set-?>");
            BaseApplication.instance = baseApplication;
        }
    }

    static {
        kotlin.h<AppComponent> b2;
        h.c.v0.a<Boolean> e2 = h.c.v0.a.e(Boolean.TRUE);
        kotlin.jvm.internal.m.f(e2, "createDefault(true)");
        isBackgroundedSubject = e2;
        isBackgrounded = e2.hide();
        b2 = kotlin.k.b(BaseApplication$Companion$component$2.INSTANCE);
        component$delegate = b2;
    }

    public BaseApplication() {
        a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.concurrentScheduler = c2;
        Contexts.INSTANCE.setApp(this);
        Companion.setInstance(this);
    }

    public static /* synthetic */ void h(Throwable th) {
        m632onCreate$lambda1(th);
    }

    public static /* synthetic */ a0 i(a0 a0Var, a0 a0Var2) {
        return m631onCreate$lambda0(a0Var, a0Var2);
    }

    /* renamed from: onCreate$lambda-0 */
    public static final a0 m631onCreate$lambda0(a0 a0Var, a0 it) {
        kotlin.jvm.internal.m.g(it, "it");
        return a0Var;
    }

    /* renamed from: onCreate$lambda-1 */
    public static final void m632onCreate$lambda1(Throwable th) {
        if (th instanceof UndeliverableException) {
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            String message = th.getMessage();
            if (message == null) {
                message = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            }
            l.a.a.f(th, kotlin.jvm.internal.m.o("Undeliverable exception received: ", message), new Object[0]);
            return;
        }
        l.a.a.e(th);
    }

    @Override // dagger.android.c
    protected dagger.android.b<? extends dagger.android.c> applicationInjector() {
        return Companion.getComponent();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        c.p.a.l(this);
    }

    public final ApplicationService getApplicationService$app_productionRelease() {
        ApplicationService applicationService = this.applicationService;
        if (applicationService != null) {
            return applicationService;
        }
        kotlin.jvm.internal.m.w("applicationService");
        throw null;
    }

    @Override // dagger.android.c, android.app.Application
    public void onCreate() {
        if (ProcessPhoenix.Companion.isPhoenixProcess(this)) {
            return;
        }
        super.onCreate();
        final a0 a = h.c.j0.c.a.a(Looper.getMainLooper(), true);
        h.c.j0.b.a.f(new h.c.m0.n() { // from class: com.coinbase.wallet.application.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BaseApplication.i(a0.this, (a0) obj);
            }
        });
        h.c.r0.a.D(new h.c.m0.f() { // from class: com.coinbase.wallet.application.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                BaseApplication.h((Throwable) obj);
            }
        });
        h.c.k0.b subscribe = getApplicationService$app_productionRelease().warmUp().subscribe();
        kotlin.jvm.internal.m.f(subscribe, "applicationService.warmUp()\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        Internet internet = Internet.INSTANCE;
        registerReceiver(internet, intentFilter);
        internet.startMonitoring(this);
        androidx.lifecycle.x.h().getLifecycle().a(this);
        h.c.k0.b subscribe2 = getApplicationService$app_productionRelease().start().subscribe();
        kotlin.jvm.internal.m.f(subscribe2, "applicationService.start()\n            .subscribe()");
        h.c.t0.a.a(subscribe2, this.disposeBag);
    }

    @w(i.a.ON_RESUME)
    public final void onResumed() {
        isBackgroundedSubject.onNext(Boolean.FALSE);
    }

    @w(i.a.ON_STOP)
    public final void onStop() {
        isBackgroundedSubject.onNext(Boolean.TRUE);
    }

    public final void setApplicationService$app_productionRelease(ApplicationService applicationService) {
        kotlin.jvm.internal.m.g(applicationService, "<set-?>");
        this.applicationService = applicationService;
    }
}