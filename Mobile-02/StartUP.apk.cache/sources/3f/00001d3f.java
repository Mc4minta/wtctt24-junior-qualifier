package com.coinbase.wallet.features.applock.legacy;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import e.j.d.g.w;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AuthenticationHelper_Factory implements f.c.d<AuthenticationHelper> {
    private final Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private final Provider<e.j.l.o.a> base64UtilProvider;
    private final Provider<e.j.l.n.a> biometricHelperProvider;
    private final Provider<w> masterSeedHandlerProvider;
    private final Provider<MnemonicRepositoryInterface> mnemonicRepositoryProvider;

    public AuthenticationHelper_Factory(Provider<e.j.l.o.a> provider, Provider<MnemonicRepositoryInterface> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<w> provider4, Provider<e.j.l.n.a> provider5) {
        this.base64UtilProvider = provider;
        this.mnemonicRepositoryProvider = provider2;
        this.appLockRepositoryProvider = provider3;
        this.masterSeedHandlerProvider = provider4;
        this.biometricHelperProvider = provider5;
    }

    public static AuthenticationHelper_Factory create(Provider<e.j.l.o.a> provider, Provider<MnemonicRepositoryInterface> provider2, Provider<AppLockRepositoryInterface> provider3, Provider<w> provider4, Provider<e.j.l.n.a> provider5) {
        return new AuthenticationHelper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AuthenticationHelper newInstance(e.j.l.o.a aVar, MnemonicRepositoryInterface mnemonicRepositoryInterface, AppLockRepositoryInterface appLockRepositoryInterface, w wVar, e.j.l.n.a aVar2) {
        return new AuthenticationHelper(aVar, mnemonicRepositoryInterface, appLockRepositoryInterface, wVar, aVar2);
    }

    @Override // javax.inject.Provider
    public AuthenticationHelper get() {
        return newInstance(this.base64UtilProvider.get(), this.mnemonicRepositoryProvider.get(), this.appLockRepositoryProvider.get(), this.masterSeedHandlerProvider.get(), this.biometricHelperProvider.get());
    }
}