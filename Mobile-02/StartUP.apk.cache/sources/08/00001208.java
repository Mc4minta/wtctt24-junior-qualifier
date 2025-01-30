package com.coinbase.wallet.application.repository;

import com.coinbase.ciphercore.CipherCoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MnemonicRepository_Factory implements f.c.d<MnemonicRepository> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<e.j.j.h> mnemonicPrefsProvider;

    public MnemonicRepository_Factory(Provider<e.j.j.h> provider, Provider<CipherCoreInterface> provider2) {
        this.mnemonicPrefsProvider = provider;
        this.cipherCoreProvider = provider2;
    }

    public static MnemonicRepository_Factory create(Provider<e.j.j.h> provider, Provider<CipherCoreInterface> provider2) {
        return new MnemonicRepository_Factory(provider, provider2);
    }

    public static MnemonicRepository newInstance(e.j.j.h hVar, CipherCoreInterface cipherCoreInterface) {
        return new MnemonicRepository(hVar, cipherCoreInterface);
    }

    @Override // javax.inject.Provider
    public MnemonicRepository get() {
        return newInstance(this.mnemonicPrefsProvider.get(), this.cipherCoreProvider.get());
    }
}