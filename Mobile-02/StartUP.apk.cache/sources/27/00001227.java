package com.coinbase.wallet.application.service;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.google.firebase.messaging.FirebaseMessagingService;
import kotlin.Metadata;

/* compiled from: WalletFirebaseMessagingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/application/service/WalletFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "Lcom/google/firebase/messaging/b;", ApiConstants.MESSAGE, "Lkotlin/x;", "onMessageReceived", "(Lcom/google/firebase/messaging/b;)V", "", ApiConstants.TOKEN, "onNewToken", "(Ljava/lang/String;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "getPushNotificationRepository$app_productionRelease", "()Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "setPushNotificationRepository$app_productionRelease", "(Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;)V", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "getAppLockRepository$app_productionRelease", "()Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "setAppLockRepository$app_productionRelease", "(Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;)V", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletFirebaseMessagingService extends FirebaseMessagingService {
    public AppLockRepositoryInterface appLockRepository;
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    public PushNotificationRepository pushNotificationRepository;

    public WalletFirebaseMessagingService() {
        BaseApplication.Companion.getComponent().inject(this);
    }

    public static /* synthetic */ boolean a(Boolean bool) {
        return m687onNewToken$lambda0(bool);
    }

    /* renamed from: onNewToken$lambda-0 */
    public static final boolean m687onNewToken$lambda0(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.booleanValue();
    }

    public final AppLockRepositoryInterface getAppLockRepository$app_productionRelease() {
        AppLockRepositoryInterface appLockRepositoryInterface = this.appLockRepository;
        if (appLockRepositoryInterface != null) {
            return appLockRepositoryInterface;
        }
        kotlin.jvm.internal.m.w("appLockRepository");
        throw null;
    }

    public final PushNotificationRepository getPushNotificationRepository$app_productionRelease() {
        PushNotificationRepository pushNotificationRepository = this.pushNotificationRepository;
        if (pushNotificationRepository != null) {
            return pushNotificationRepository;
        }
        kotlin.jvm.internal.m.w("pushNotificationRepository");
        throw null;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(com.google.firebase.messaging.b message) {
        kotlin.jvm.internal.m.g(message, "message");
        super.onMessageReceived(message);
        getPushNotificationRepository$app_productionRelease().onMessageReceived(message);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        kotlin.jvm.internal.m.g(token, "token");
        super.onNewToken(token);
        h.c.s<Boolean> filter = getAppLockRepository$app_productionRelease().isAppLockedObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.application.service.w
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletFirebaseMessagingService.a((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "appLockRepository.isAppLockedObservable\n            .filter { !it }");
        h.c.t0.a.a(h.c.t0.g.i(Observable_CoreKt.takeSingle(filter), null, new WalletFirebaseMessagingService$onNewToken$2(this, token), 1, null), this.disposeBag);
    }

    public final void setAppLockRepository$app_productionRelease(AppLockRepositoryInterface appLockRepositoryInterface) {
        kotlin.jvm.internal.m.g(appLockRepositoryInterface, "<set-?>");
        this.appLockRepository = appLockRepositoryInterface;
    }

    public final void setPushNotificationRepository$app_productionRelease(PushNotificationRepository pushNotificationRepository) {
        kotlin.jvm.internal.m.g(pushNotificationRepository, "<set-?>");
        this.pushNotificationRepository = pushNotificationRepository;
    }
}