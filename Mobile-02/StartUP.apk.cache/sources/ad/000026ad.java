package com.coinbase.wallet.swap.di;

import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.swap.apis.SwapAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapModule_Companion_SwapAPI$swap_releaseFactory implements d<SwapAPI> {
    private final Provider<HTTPService> swapHTTPServiceProvider;

    public SwapModule_Companion_SwapAPI$swap_releaseFactory(Provider<HTTPService> provider) {
        this.swapHTTPServiceProvider = provider;
    }

    public static SwapModule_Companion_SwapAPI$swap_releaseFactory create(Provider<HTTPService> provider) {
        return new SwapModule_Companion_SwapAPI$swap_releaseFactory(provider);
    }

    public static SwapAPI swapAPI$swap_release(HTTPService hTTPService) {
        return (SwapAPI) h.f(SwapModule.Companion.swapAPI$swap_release(hTTPService));
    }

    @Override // javax.inject.Provider
    public SwapAPI get() {
        return swapAPI$swap_release(this.swapHTTPServiceProvider.get());
    }
}