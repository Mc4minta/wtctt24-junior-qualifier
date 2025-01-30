package com.coinbase.wallet.application.repository;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationRepository_Factory implements f.c.d<NotificationRepository> {
    private final Provider<e.j.j.b> appPrefsProvider;
    private final Provider<Map<Integer, Provider<Notification>>> notificationsProvider;
    private final Provider<StoreInterface> storeProvider;

    public NotificationRepository_Factory(Provider<e.j.j.b> provider, Provider<Map<Integer, Provider<Notification>>> provider2, Provider<StoreInterface> provider3) {
        this.appPrefsProvider = provider;
        this.notificationsProvider = provider2;
        this.storeProvider = provider3;
    }

    public static NotificationRepository_Factory create(Provider<e.j.j.b> provider, Provider<Map<Integer, Provider<Notification>>> provider2, Provider<StoreInterface> provider3) {
        return new NotificationRepository_Factory(provider, provider2, provider3);
    }

    public static NotificationRepository newInstance(e.j.j.b bVar, Map<Integer, Provider<Notification>> map, StoreInterface storeInterface) {
        return new NotificationRepository(bVar, map, storeInterface);
    }

    @Override // javax.inject.Provider
    public NotificationRepository get() {
        return newInstance(this.appPrefsProvider.get(), this.notificationsProvider.get(), this.storeProvider.get());
    }
}