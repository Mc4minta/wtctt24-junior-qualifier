package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import f.c.d;
import f.c.h;
import java.util.List;

/* loaded from: classes2.dex */
public final class WalletsModule_ProvidesNetworkSettingsFactory implements d<List<NetworkSetting>> {

    /* loaded from: classes2.dex */
    private static final class InstanceHolder {
        private static final WalletsModule_ProvidesNetworkSettingsFactory INSTANCE = new WalletsModule_ProvidesNetworkSettingsFactory();

        private InstanceHolder() {
        }
    }

    public static WalletsModule_ProvidesNetworkSettingsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static List<NetworkSetting> providesNetworkSettings() {
        return (List) h.f(WalletsModule.providesNetworkSettings());
    }

    @Override // javax.inject.Provider
    public List<NetworkSetting> get() {
        return providesNetworkSettings();
    }
}