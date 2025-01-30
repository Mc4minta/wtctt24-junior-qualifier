package com.coinbase.wallet.application.service;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletFirebaseMessagingService_MembersInjector implements f.b<WalletFirebaseMessagingService> {
    private final Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;

    public WalletFirebaseMessagingService_MembersInjector(Provider<PushNotificationRepository> provider, Provider<AppLockRepositoryInterface> provider2) {
        this.pushNotificationRepositoryProvider = provider;
        this.appLockRepositoryProvider = provider2;
    }

    public static f.b<WalletFirebaseMessagingService> create(Provider<PushNotificationRepository> provider, Provider<AppLockRepositoryInterface> provider2) {
        return new WalletFirebaseMessagingService_MembersInjector(provider, provider2);
    }

    public static void injectAppLockRepository(WalletFirebaseMessagingService walletFirebaseMessagingService, AppLockRepositoryInterface appLockRepositoryInterface) {
        walletFirebaseMessagingService.appLockRepository = appLockRepositoryInterface;
    }

    public static void injectPushNotificationRepository(WalletFirebaseMessagingService walletFirebaseMessagingService, PushNotificationRepository pushNotificationRepository) {
        walletFirebaseMessagingService.pushNotificationRepository = pushNotificationRepository;
    }

    public void injectMembers(WalletFirebaseMessagingService walletFirebaseMessagingService) {
        injectPushNotificationRepository(walletFirebaseMessagingService, this.pushNotificationRepositoryProvider.get());
        injectAppLockRepository(walletFirebaseMessagingService, this.appLockRepositoryProvider.get());
    }
}