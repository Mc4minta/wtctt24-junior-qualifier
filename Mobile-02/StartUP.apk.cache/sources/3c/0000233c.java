package com.coinbase.wallet.features.walletlink.viewmodels;

import f.c.d;

/* loaded from: classes.dex */
public final class WalletLinkCompleteViewModel_Factory implements d<WalletLinkCompleteViewModel> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final WalletLinkCompleteViewModel_Factory INSTANCE = new WalletLinkCompleteViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static WalletLinkCompleteViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WalletLinkCompleteViewModel newInstance() {
        return new WalletLinkCompleteViewModel();
    }

    @Override // javax.inject.Provider
    public WalletLinkCompleteViewModel get() {
        return newInstance();
    }
}