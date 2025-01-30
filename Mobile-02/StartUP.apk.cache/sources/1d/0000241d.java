package com.coinbase.wallet.lending.di;

import com.coinbase.wallet.lending.apis.LendAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendModule_ProvidesLendAPI$lending_releaseFactory implements d<LendAPI> {
    private final Provider<String> walletApiUrlProvider;

    public LendModule_ProvidesLendAPI$lending_releaseFactory(Provider<String> provider) {
        this.walletApiUrlProvider = provider;
    }

    public static LendModule_ProvidesLendAPI$lending_releaseFactory create(Provider<String> provider) {
        return new LendModule_ProvidesLendAPI$lending_releaseFactory(provider);
    }

    public static LendAPI providesLendAPI$lending_release(String str) {
        LendAPI providesLendAPI$lending_release;
        providesLendAPI$lending_release = LendModule.Companion.providesLendAPI$lending_release(str);
        return (LendAPI) h.f(providesLendAPI$lending_release);
    }

    @Override // javax.inject.Provider
    public LendAPI get() {
        return providesLendAPI$lending_release(this.walletApiUrlProvider.get());
    }
}