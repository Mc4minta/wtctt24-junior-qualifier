package com.coinbase.wallet.features.walletlink.models;

import f.c.d;

/* loaded from: classes.dex */
public final class WalletLinkPushNotificationCreator_Factory implements d<WalletLinkPushNotificationCreator> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final WalletLinkPushNotificationCreator_Factory INSTANCE = new WalletLinkPushNotificationCreator_Factory();

        private InstanceHolder() {
        }
    }

    public static WalletLinkPushNotificationCreator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WalletLinkPushNotificationCreator newInstance() {
        return new WalletLinkPushNotificationCreator();
    }

    @Override // javax.inject.Provider
    public WalletLinkPushNotificationCreator get() {
        return newInstance();
    }
}