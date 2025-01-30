package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class APIModule_WatchAddressAPI$wallets_releaseFactory implements d<WatchAddressAPI> {
    private final Provider<t> retrofitProvider;

    public APIModule_WatchAddressAPI$wallets_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static APIModule_WatchAddressAPI$wallets_releaseFactory create(Provider<t> provider) {
        return new APIModule_WatchAddressAPI$wallets_releaseFactory(provider);
    }

    public static WatchAddressAPI watchAddressAPI$wallets_release(t tVar) {
        WatchAddressAPI watchAddressAPI$wallets_release;
        watchAddressAPI$wallets_release = APIModule.Companion.watchAddressAPI$wallets_release(tVar);
        return (WatchAddressAPI) h.f(watchAddressAPI$wallets_release);
    }

    @Override // javax.inject.Provider
    public WatchAddressAPI get() {
        return watchAddressAPI$wallets_release(this.retrofitProvider.get());
    }
}