package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class APIModule_Companion_CompoundFinanceAPIFactory implements d<CompoundFinanceAPI> {
    private final Provider<String> walletApiUrlStringProvider;

    public APIModule_Companion_CompoundFinanceAPIFactory(Provider<String> provider) {
        this.walletApiUrlStringProvider = provider;
    }

    public static CompoundFinanceAPI compoundFinanceAPI(String str) {
        return (CompoundFinanceAPI) h.f(APIModule.Companion.compoundFinanceAPI(str));
    }

    public static APIModule_Companion_CompoundFinanceAPIFactory create(Provider<String> provider) {
        return new APIModule_Companion_CompoundFinanceAPIFactory(provider);
    }

    @Override // javax.inject.Provider
    public CompoundFinanceAPI get() {
        return compoundFinanceAPI(this.walletApiUrlStringProvider.get());
    }
}