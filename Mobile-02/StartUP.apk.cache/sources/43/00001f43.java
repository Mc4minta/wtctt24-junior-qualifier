package com.coinbase.wallet.features.pushnotifications.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApi;
import com.coinbase.wallet.features.pushnotifications.interfaces.PushNotification;
import com.coinbase.wallet.features.pushnotifications.interfaces.PushNotificationCreator;
import com.coinbase.wallet.features.pushnotifications.viewmodels.PushNotificationViewModel;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import h.c.m0.p;
import h.c.s;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: PushNotificationRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b<\u0010=J)\u0010\u0007\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\t2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050!¢\u0006\u0004\b#\u0010$R=\u0010%\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u000e0\u000e \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00160\u00168\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00100\u001a\u00020\u00058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R@\u00102\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010!0!018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R$\u00104\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u000e0\u000e018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u00108\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u001a0\u001a018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "", "kotlin.jvm.PlatformType", "getFCMToken", "()Lh/c/b0;", "Lkotlin/x;", "start", "()V", "", "destroy", "Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;", "viewModel", "displayNotification", "(Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;)V", "Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotification;", "T", "Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotificationCreator;", "creator", "Lh/c/s;", "observeNotificationsWith", "(Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotificationCreator;)Lh/c/s;", "observeSelectedNotificationsWith", "Lcom/google/firebase/messaging/b;", ApiConstants.MESSAGE, "onMessageReceived", "(Lcom/google/firebase/messaging/b;)V", ApiConstants.TOKEN, "onFCMTokenReceived", "(Ljava/lang/String;)V", "", "data", "onNotificationSelected", "(Ljava/util/Map;)V", "displayNotificationObservable", "Lh/c/s;", "getDisplayNotificationObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApi;", "api", "Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApi;", "deviceId$delegate", "Lkotlin/h;", "getDeviceId", "()Ljava/lang/String;", "deviceId", "Lh/c/v0/b;", "selectedNotificationSubject", "Lh/c/v0/b;", "displayNotificationSubject", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "remoteMessageSubject", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/features/pushnotifications/apis/PushNotificationApi;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PushNotificationRepository implements Startable, Destroyable {
    private final PushNotificationApi api;
    private final kotlin.h deviceId$delegate;
    private final s<PushNotificationViewModel> displayNotificationObservable;
    private final h.c.v0.b<PushNotificationViewModel> displayNotificationSubject;
    private final h.c.k0.a disposeBag;
    private final h.c.v0.b<com.google.firebase.messaging.b> remoteMessageSubject;
    private final h.c.v0.b<Map<String, String>> selectedNotificationSubject;
    private final StoreInterface store;

    public PushNotificationRepository(PushNotificationApi api, StoreInterface store) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(api, "api");
        kotlin.jvm.internal.m.g(store, "store");
        this.api = api;
        this.store = store;
        h.c.v0.b<com.google.firebase.messaging.b> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<RemoteMessage>()");
        this.remoteMessageSubject = d2;
        h.c.v0.b<Map<String, String>> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Map<String, String?>>()");
        this.selectedNotificationSubject = d3;
        h.c.v0.b<PushNotificationViewModel> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<PushNotificationViewModel>()");
        this.displayNotificationSubject = d4;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(new PushNotificationRepository$deviceId$2(this));
        this.deviceId$delegate = b2;
        this.displayNotificationObservable = d4.hide();
    }

    public static /* synthetic */ boolean b(ConnectionStatus connectionStatus) {
        return m1320start$lambda0(connectionStatus);
    }

    public static /* synthetic */ PushNotification c(Optional optional) {
        return m1319observeSelectedNotificationsWith$lambda13(optional);
    }

    public static /* synthetic */ boolean d(Optional optional) {
        return m1318observeSelectedNotificationsWith$lambda12(optional);
    }

    /* renamed from: destroy$lambda-4 */
    public static final x m1308destroy$lambda4(PushNotificationRepository this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.disposeBag.d();
        return x.a;
    }

    /* renamed from: destroy$lambda-5 */
    public static final h0 m1309destroy$lambda5(PushNotificationRepository this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getFCMToken();
    }

    /* renamed from: destroy$lambda-7 */
    public static final h0 m1310destroy$lambda7(PushNotificationRepository this$0, Optional token) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(token, "token");
        String str = (String) token.toNullable();
        b0<Boolean> unsubscribeFromPushNotifications = str == null ? null : this$0.api.unsubscribeFromPushNotifications(str);
        return unsubscribeFromPushNotifications == null ? b0.just(Boolean.TRUE) : unsubscribeFromPushNotifications;
    }

    public static /* synthetic */ h0 e(PushNotificationRepository pushNotificationRepository, Optional optional) {
        return m1310destroy$lambda7(pushNotificationRepository, optional);
    }

    public static /* synthetic */ void f(d0 d0Var, Exception exc) {
        m1313getFCMToken$lambda16$lambda15(d0Var, exc);
    }

    public static /* synthetic */ x g(PushNotificationRepository pushNotificationRepository) {
        return m1308destroy$lambda4(pushNotificationRepository);
    }

    private final String getDeviceId() {
        return (String) this.deviceId$delegate.getValue();
    }

    private final b0<Optional<String>> getFCMToken() {
        b0<Optional<String>> create = b0.create(new f0() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.g
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                PushNotificationRepository.h(d0Var);
            }
        });
        kotlin.jvm.internal.m.f(create, "create<Optional<String>> { emitter ->\n        FirebaseInstanceId.getInstance().instanceId\n            .addOnCompleteListener {\n                try {\n                    emitter.onSuccess(Optional(it.result?.token))\n                } catch (e: Exception) {\n                    emitter.onError(e)\n                }\n            }\n            .addOnFailureListener { emitter.onError(it) }\n    }");
        return create;
    }

    /* renamed from: getFCMToken$lambda-16 */
    public static final void m1311getFCMToken$lambda16(final d0 emitter) {
        kotlin.jvm.internal.m.g(emitter, "emitter");
        FirebaseInstanceId.c().d().b(new com.google.android.gms.tasks.c() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.h
            @Override // com.google.android.gms.tasks.c
            public final void a(com.google.android.gms.tasks.g gVar) {
                PushNotificationRepository.i(d0.this, gVar);
            }
        }).d(new com.google.android.gms.tasks.d() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.e
            @Override // com.google.android.gms.tasks.d
            public final void c(Exception exc) {
                PushNotificationRepository.f(d0.this, exc);
            }
        });
    }

    /* renamed from: getFCMToken$lambda-16$lambda-14 */
    public static final void m1312getFCMToken$lambda16$lambda14(d0 emitter, com.google.android.gms.tasks.g it) {
        kotlin.jvm.internal.m.g(emitter, "$emitter");
        kotlin.jvm.internal.m.g(it, "it");
        try {
            com.google.firebase.iid.a aVar = (com.google.firebase.iid.a) it.m();
            emitter.onSuccess(new Optional(aVar == null ? null : aVar.a()));
        } catch (Exception e2) {
            emitter.onError(e2);
        }
    }

    /* renamed from: getFCMToken$lambda-16$lambda-15 */
    public static final void m1313getFCMToken$lambda16$lambda15(d0 emitter, Exception it) {
        kotlin.jvm.internal.m.g(emitter, "$emitter");
        kotlin.jvm.internal.m.g(it, "it");
        emitter.onError(it);
    }

    public static /* synthetic */ void h(d0 d0Var) {
        m1311getFCMToken$lambda16(d0Var);
    }

    public static /* synthetic */ void i(d0 d0Var, com.google.android.gms.tasks.g gVar) {
        m1312getFCMToken$lambda16$lambda14(d0Var, gVar);
    }

    public static /* synthetic */ PushNotification j(Optional optional) {
        return m1314observeNotificationsWith$lambda10(optional);
    }

    public static /* synthetic */ Optional k(PushNotificationCreator pushNotificationCreator, Map map) {
        return m1317observeSelectedNotificationsWith$lambda11(pushNotificationCreator, map);
    }

    public static /* synthetic */ h0 l(PushNotificationRepository pushNotificationRepository, x xVar) {
        return m1309destroy$lambda5(pushNotificationRepository, xVar);
    }

    public static /* synthetic */ void m(PushNotificationRepository pushNotificationRepository, Optional optional) {
        m1322start$lambda3(pushNotificationRepository, optional);
    }

    public static /* synthetic */ boolean n(Optional optional) {
        return m1316observeNotificationsWith$lambda9(optional);
    }

    public static /* synthetic */ h0 o(PushNotificationRepository pushNotificationRepository, ConnectionStatus connectionStatus) {
        return m1321start$lambda1(pushNotificationRepository, connectionStatus);
    }

    /* renamed from: observeNotificationsWith$lambda-10 */
    public static final PushNotification m1314observeNotificationsWith$lambda10(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (PushNotification) it.toNullable();
    }

    /* renamed from: observeNotificationsWith$lambda-8 */
    public static final Optional m1315observeNotificationsWith$lambda8(PushNotificationCreator creator, com.google.firebase.messaging.b it) {
        kotlin.jvm.internal.m.g(creator, "$creator");
        kotlin.jvm.internal.m.g(it, "it");
        Map<String, String> i1 = it.i1();
        kotlin.jvm.internal.m.f(i1, "it.data");
        return OptionalKt.toOptional(creator.create(i1));
    }

    /* renamed from: observeNotificationsWith$lambda-9 */
    public static final boolean m1316observeNotificationsWith$lambda9(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.toNullable() != null;
    }

    /* renamed from: observeSelectedNotificationsWith$lambda-11 */
    public static final Optional m1317observeSelectedNotificationsWith$lambda11(PushNotificationCreator creator, Map it) {
        kotlin.jvm.internal.m.g(creator, "$creator");
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(creator.create(it));
    }

    /* renamed from: observeSelectedNotificationsWith$lambda-12 */
    public static final boolean m1318observeSelectedNotificationsWith$lambda12(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.toNullable() != null;
    }

    /* renamed from: observeSelectedNotificationsWith$lambda-13 */
    public static final PushNotification m1319observeSelectedNotificationsWith$lambda13(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (PushNotification) it.toNullable();
    }

    public static /* synthetic */ Optional p(PushNotificationCreator pushNotificationCreator, com.google.firebase.messaging.b bVar) {
        return m1315observeNotificationsWith$lambda8(pushNotificationCreator, bVar);
    }

    /* renamed from: start$lambda-0 */
    public static final boolean m1320start$lambda0(ConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.isOnline();
    }

    /* renamed from: start$lambda-1 */
    public static final h0 m1321start$lambda1(PushNotificationRepository this$0, ConnectionStatus it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getFCMToken();
    }

    /* renamed from: start$lambda-3 */
    public static final void m1322start$lambda3(PushNotificationRepository this$0, Optional optional) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        String str = (String) optional.toNullable();
        if (str == null) {
            return;
        }
        this$0.onFCMTokenReceived(str);
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        b0<Boolean> timeout = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PushNotificationRepository.g(PushNotificationRepository.this);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.l(PushNotificationRepository.this, (x) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.e(PushNotificationRepository.this, (Optional) obj);
            }
        }).timeout(2L, TimeUnit.SECONDS);
        kotlin.jvm.internal.m.f(timeout, "fromCallable { disposeBag.clear() }\n        .flatMap { getFCMToken() }\n        .flatMap { token -> token.toNullable()?.let { api.unsubscribeFromPushNotifications(it) } ?: Single.just(true) }\n        .timeout(2, TimeUnit.SECONDS)");
        return timeout;
    }

    public final void displayNotification(PushNotificationViewModel viewModel) {
        kotlin.jvm.internal.m.g(viewModel, "viewModel");
        this.displayNotificationSubject.onNext(viewModel);
    }

    public final s<PushNotificationViewModel> getDisplayNotificationObservable() {
        return this.displayNotificationObservable;
    }

    public final <T extends PushNotification> s<T> observeNotificationsWith(final PushNotificationCreator<T> creator) {
        kotlin.jvm.internal.m.g(creator, "creator");
        s<T> map = this.remoteMessageSubject.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.p(PushNotificationCreator.this, (com.google.firebase.messaging.b) obj);
            }
        }).filter(new p() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.m
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return PushNotificationRepository.n((Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.j((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "remoteMessageSubject\n        .hide()\n        .map { creator.create(it.data).toOptional() }\n        .filter { it.toNullable() != null }\n        .map { it.toNullable() }");
        return map;
    }

    public final <T extends PushNotification> s<T> observeSelectedNotificationsWith(final PushNotificationCreator<T> creator) {
        kotlin.jvm.internal.m.g(creator, "creator");
        s<T> map = this.selectedNotificationSubject.hide().map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.k(PushNotificationCreator.this, (Map) obj);
            }
        }).filter(new p() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.c
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return PushNotificationRepository.d((Optional) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.c((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "selectedNotificationSubject\n        .hide()\n        .map { creator.create(it).toOptional() }\n        .filter { it.toNullable() != null }\n        .map { it.toNullable() }");
        return map;
    }

    public final void onFCMTokenReceived(String token) {
        kotlin.jvm.internal.m.g(token, "token");
        h.c.k0.b subscribe = Single_AnalyticsKt.logError$default(this.api.subscribeToNotifications(token, getDeviceId()), null, null, 3, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "api.subscribeToNotifications(token = token, deviceId = deviceId)\n            .logError()\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }

    public final void onMessageReceived(com.google.firebase.messaging.b message) {
        kotlin.jvm.internal.m.g(message, "message");
        this.remoteMessageSubject.onNext(message);
    }

    public final void onNotificationSelected(Map<String, String> data) {
        kotlin.jvm.internal.m.g(data, "data");
        this.selectedNotificationSubject.onNext(data);
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        s<ConnectionStatus> filter = Internet.INSTANCE.getStatusChanges().filter(new p() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.a
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return PushNotificationRepository.b((ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "Internet.statusChanges\n            .filter { it.isOnline }");
        b0 flatMap = Observable_CoreKt.takeSingle(filter).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return PushNotificationRepository.o(PushNotificationRepository.this, (ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { getFCMToken() }");
        b0 doOnSuccess = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.features.pushnotifications.repositories.l
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                PushNotificationRepository.m(PushNotificationRepository.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { getFCMToken() }\n            .logError()\n            .doOnSuccess { optionalToken -> optionalToken.toNullable()?.let { onFCMTokenReceived(it) } }");
        h.c.k0.b subscribe = Single_CoreKt.asUnit(doOnSuccess).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "Internet.statusChanges\n            .filter { it.isOnline }\n            .takeSingle()\n            .flatMap { getFCMToken() }\n            .logError()\n            .doOnSuccess { optionalToken -> optionalToken.toNullable()?.let { onFCMTokenReceived(it) } }\n            .asUnit()\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }
}