package com.coinbase.wallet.features.pushnotifications.services;

import android.content.Context;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.pushnotifications.viewmodels.PushNotificationViewModel;
import h.c.a0;
import h.c.b0;
import h.c.k0.b;
import h.c.m0.f;
import h.c.s;
import h.c.t0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PushNotificationDisplayService.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/services/PushNotificationDisplayService;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;", "viewModel", "Lkotlin/x;", "displayNotification", "(Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;)V", "start", "()V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "getPushNotificationRepository", "()Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "<init>", "(Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;Landroid/content/Context;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PushNotificationDisplayService implements Startable {
    private final Context context;
    private final h.c.k0.a disposeBag;
    private final a0 mainScheduler;
    private final PushNotificationRepository pushNotificationRepository;

    public PushNotificationDisplayService(PushNotificationRepository pushNotificationRepository, Context context) {
        m.g(pushNotificationRepository, "pushNotificationRepository");
        m.g(context, "context");
        this.pushNotificationRepository = pushNotificationRepository;
        this.context = context;
        this.mainScheduler = h.c.j0.c.a.b();
        this.disposeBag = new h.c.k0.a();
    }

    public static /* synthetic */ void b(PushNotificationDisplayService pushNotificationDisplayService, PushNotificationViewModel pushNotificationViewModel) {
        m1323start$lambda0(pushNotificationDisplayService, pushNotificationViewModel);
    }

    private final void displayNotification(PushNotificationViewModel pushNotificationViewModel) {
        s<Boolean> isBackgrounded = BaseApplication.Companion.isBackgrounded();
        m.f(isBackgrounded, "BaseApplication.isBackgrounded");
        b0 observeOn = Observable_CoreKt.takeSingle(isBackgrounded).observeOn(this.mainScheduler);
        m.f(observeOn, "BaseApplication.isBackgrounded\n            .takeSingle()\n            .observeOn(mainScheduler)");
        h.c.t0.a.a(g.i(observeOn, null, new PushNotificationDisplayService$displayNotification$1(this, pushNotificationViewModel), 1, null), this.disposeBag);
    }

    /* renamed from: start$lambda-0 */
    public static final void m1323start$lambda0(PushNotificationDisplayService this$0, PushNotificationViewModel it) {
        m.g(this$0, "this$0");
        m.f(it, "it");
        this$0.displayNotification(it);
    }

    public final Context getContext() {
        return this.context;
    }

    public final PushNotificationRepository getPushNotificationRepository() {
        return this.pushNotificationRepository;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        s<PushNotificationViewModel> observeOn = this.pushNotificationRepository.getDisplayNotificationObservable().subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "pushNotificationRepository.displayNotificationObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
        b subscribe = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).subscribe(new f() { // from class: com.coinbase.wallet.features.pushnotifications.services.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                PushNotificationDisplayService.b(PushNotificationDisplayService.this, (PushNotificationViewModel) obj);
            }
        });
        m.f(subscribe, "pushNotificationRepository.displayNotificationObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .subscribe { displayNotification(it) }");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }
}