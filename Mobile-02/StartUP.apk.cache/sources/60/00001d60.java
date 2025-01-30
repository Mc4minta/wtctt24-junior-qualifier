package com.coinbase.wallet.features.cloudbackup.prompts;

import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CloudBackupPrompt_Factory implements d<CloudBackupPrompt> {
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;
    private final Provider<NotificationRepositoryInterface> notificationRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;

    public CloudBackupPrompt_Factory(Provider<e.j.i.i2.d> provider, Provider<StoreInterface> provider2, Provider<NotificationRepositoryInterface> provider3) {
        this.mnemonicBackupRepositoryProvider = provider;
        this.storeProvider = provider2;
        this.notificationRepositoryProvider = provider3;
    }

    public static CloudBackupPrompt_Factory create(Provider<e.j.i.i2.d> provider, Provider<StoreInterface> provider2, Provider<NotificationRepositoryInterface> provider3) {
        return new CloudBackupPrompt_Factory(provider, provider2, provider3);
    }

    public static CloudBackupPrompt newInstance(e.j.i.i2.d dVar, StoreInterface storeInterface, NotificationRepositoryInterface notificationRepositoryInterface) {
        return new CloudBackupPrompt(dVar, storeInterface, notificationRepositoryInterface);
    }

    @Override // javax.inject.Provider
    public CloudBackupPrompt get() {
        return newInstance(this.mnemonicBackupRepositoryProvider.get(), this.storeProvider.get(), this.notificationRepositoryProvider.get());
    }
}