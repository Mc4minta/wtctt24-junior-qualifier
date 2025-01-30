package com.coinbase.wallet.application.repository;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.StoreKeys_ApplicationKt;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.model.NotificationDestination;
import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.Map_CommonKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: NotificationRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u0019\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b1\u00102J\u001d\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R0\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \u0004*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00160\u00160\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160'8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R0\u0010,\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \u0004*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00160\u00160+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/coinbase/wallet/application/repository/NotificationRepository;", "Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "Lh/c/b0;", "Lkotlin/x;", "kotlin.jvm.PlatformType", "reloadNotifications", "()Lh/c/b0;", "start", "()V", "Lcom/coinbase/wallet/application/model/Notification;", "notification", "notificationSeen", "(Lcom/coinbase/wallet/application/model/Notification;)V", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "action", "actionPerformed", "(Lcom/coinbase/wallet/application/model/Notification;Lcom/coinbase/wallet/application/model/NotificationDestination;)V", "showNotification", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/v0/b;", "", "spontaneousPromptSubject", "Lh/c/v0/b;", "", "", "Ljavax/inject/Provider;", "notifications", "Ljava/util/Map;", "Lh/c/a0;", "concurrentScheduler$delegate", "Lkotlin/h;", "getConcurrentScheduler", "()Lh/c/a0;", "concurrentScheduler", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/s;", "getUnreadNotificationsObservable", "()Lh/c/s;", "unreadNotificationsObservable", "Lh/c/v0/c;", "unreadLaunchNotificationsSubject", "Lh/c/v0/c;", "Le/j/j/b;", "appPrefs", "Le/j/j/b;", "<init>", "(Le/j/j/b;Ljava/util/Map;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NotificationRepository implements NotificationRepositoryInterface {
    private final e.j.j.b appPrefs;
    private final kotlin.h concurrentScheduler$delegate;
    private final h.c.k0.a disposeBag;
    private final Map<Integer, Provider<Notification>> notifications;
    private final h.c.v0.b<List<Notification>> spontaneousPromptSubject;
    private final StoreInterface store;
    private final h.c.v0.c<List<Notification>> unreadLaunchNotificationsSubject;

    public NotificationRepository(e.j.j.b appPrefs, Map<Integer, Provider<Notification>> notifications, StoreInterface store) {
        kotlin.h b2;
        m.g(appPrefs, "appPrefs");
        m.g(notifications, "notifications");
        m.g(store, "store");
        this.appPrefs = appPrefs;
        this.notifications = notifications;
        this.store = store;
        this.disposeBag = new h.c.k0.a();
        b2 = kotlin.k.b(NotificationRepository$concurrentScheduler$2.INSTANCE);
        this.concurrentScheduler$delegate = b2;
        h.c.v0.c<List<Notification>> d2 = h.c.v0.c.d(1);
        m.f(d2, "createWithSize<List<Notification>>(1)");
        this.unreadLaunchNotificationsSubject = d2;
        h.c.v0.b<List<Notification>> d3 = h.c.v0.b.d();
        m.f(d3, "create<List<Notification>>()");
        this.spontaneousPromptSubject = d3;
    }

    /* renamed from: _get_unreadNotificationsObservable_$lambda-3 */
    public static final h0 m661_get_unreadNotificationsObservable_$lambda3(NotificationRepository this$0, final List notifications) {
        int r;
        b0 zip;
        List g2;
        m.g(this$0, "this$0");
        m.g(notifications, "notifications");
        r = s.r(notifications, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = notifications.iterator();
        while (it.hasNext()) {
            arrayList.add(((Notification) it.next()).getShouldShowNotification());
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.application.repository.NotificationRepository$_get_unreadNotificationsObservable_$lambda-3$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof Boolean) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.subscribeOn(this$0.getConcurrentScheduler()).map(new n() { // from class: com.coinbase.wallet.application.repository.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return NotificationRepository.e(notifications, (List) obj);
            }
        });
    }

    /* renamed from: _get_unreadNotificationsObservable_$lambda-3$lambda-2 */
    public static final List m662_get_unreadNotificationsObservable_$lambda3$lambda2(List notifications, List shouldShowNotificationsList) {
        m.g(notifications, "$notifications");
        m.g(shouldShowNotificationsList, "shouldShowNotificationsList");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : notifications) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            Notification notification = (Notification) obj;
            if (((Boolean) shouldShowNotificationsList.get(i2)).booleanValue()) {
                arrayList.add(obj);
            }
            i2 = i3;
        }
        return arrayList;
    }

    public static /* synthetic */ List b(List list) {
        return m663reloadNotifications$lambda7(list);
    }

    public static /* synthetic */ h0 c(NotificationRepository notificationRepository, List list) {
        return m661_get_unreadNotificationsObservable_$lambda3(notificationRepository, list);
    }

    public static /* synthetic */ x d(NotificationRepository notificationRepository, List list) {
        return m664reloadNotifications$lambda8(notificationRepository, list);
    }

    public static /* synthetic */ List e(List list, List list2) {
        return m662_get_unreadNotificationsObservable_$lambda3$lambda2(list, list2);
    }

    private final a0 getConcurrentScheduler() {
        return (a0) this.concurrentScheduler$delegate.getValue();
    }

    private final b0<x> reloadNotifications() {
        b0<x> map = b0.just(Map_CommonKt.mapToSortedList(this.notifications)).map(new n() { // from class: com.coinbase.wallet.application.repository.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return NotificationRepository.b((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.application.repository.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return NotificationRepository.d(NotificationRepository.this, (List) obj);
            }
        });
        m.f(map, "just(notifications.mapToSortedList())\n        .map { notificationProviders -> notificationProviders.map { it.get() } }\n        .map { notifications -> unreadLaunchNotificationsSubject.onNext(notifications) }");
        return map;
    }

    /* renamed from: reloadNotifications$lambda-7 */
    public static final List m663reloadNotifications$lambda7(List notificationProviders) {
        int r;
        m.g(notificationProviders, "notificationProviders");
        r = s.r(notificationProviders, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = notificationProviders.iterator();
        while (it.hasNext()) {
            arrayList.add((Notification) ((Provider) it.next()).get());
        }
        return arrayList;
    }

    /* renamed from: reloadNotifications$lambda-8 */
    public static final x m664reloadNotifications$lambda8(NotificationRepository this$0, List notifications) {
        m.g(this$0, "this$0");
        m.g(notifications, "notifications");
        this$0.unreadLaunchNotificationsSubject.onNext(notifications);
        return x.a;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface
    public void actionPerformed(Notification notification, NotificationDestination action) {
        m.g(notification, "notification");
        m.g(action, "action");
        String id = notification.getId();
        if (id != null) {
            this.store.set(StoreKeys_ApplicationKt.lastNotificationAction(StoreKeys.INSTANCE, id), action.getActionType());
        }
        for (AnalyticsEvent analyticsEvent : action.getAnalyticsEvents()) {
            Analytics.INSTANCE.log(analyticsEvent);
        }
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface
    public h.c.s<List<Notification>> getUnreadNotificationsObservable() {
        h.c.s<List<Notification>> mergeWith = this.unreadLaunchNotificationsSubject.flatMapSingle(new n() { // from class: com.coinbase.wallet.application.repository.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return NotificationRepository.c(NotificationRepository.this, (List) obj);
            }
        }).mergeWith(this.spontaneousPromptSubject);
        m.f(mergeWith, "unreadLaunchNotificationsSubject\n            .flatMapSingle { notifications ->\n                val list: List<Single<Boolean>> = notifications\n                    .map { notification -> notification.shouldShowNotification }\n                list\n                    .zipOrEmpty()\n                    .subscribeOn(concurrentScheduler)\n                    .map { shouldShowNotificationsList ->\n                        notifications.filterIndexed { index, _ -> shouldShowNotificationsList[index] }\n                    }\n            }\n            .mergeWith(spontaneousPromptSubject)");
        return mergeWith;
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface
    public void notificationSeen(Notification notification) {
        m.g(notification, "notification");
        if (notification.getId() == null) {
            return;
        }
        this.appPrefs.i(notification.getId());
        this.store.set(StoreKeys_ApplicationKt.lastNotificationSession(StoreKeys.INSTANCE, notification.getId()), Integer.valueOf(this.appPrefs.l()));
    }

    @Override // com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface
    public void showNotification(Notification notification) {
        List<Notification> b2;
        m.g(notification, "notification");
        h.c.v0.b<List<Notification>> bVar = this.spontaneousPromptSubject;
        b2 = q.b(notification);
        bVar.onNext(b2);
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = reloadNotifications().subscribeOn(getConcurrentScheduler()).subscribe();
        m.f(subscribe, "reloadNotifications()\n            .subscribeOn(concurrentScheduler)\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
    }
}