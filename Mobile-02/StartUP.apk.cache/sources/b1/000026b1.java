package com.coinbase.wallet.swap.di;

import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.swap.apis.SwapAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapModule_SwapAPI$swap_releaseFactory implements d<SwapAPI> {
    private final Provider<HTTPService> swapHTTPServiceProvider;

    public SwapModule_SwapAPI$swap_releaseFactory(Provider<HTTPService> provider) {
        this.swapHTTPServiceProvider = provider;
    }

    public static SwapModule_SwapAPI$swap_releaseFactory create(Provider<HTTPService> provider) {
        return new SwapModule_SwapAPI$swap_releaseFactory(provider);
    }

    public static SwapAPI swapAPI$swap_release(HTTPService hTTPService) {
        SwapAPI swapAPI$swap_release;
        swapAPI$swap_release = SwapModule.Companion.swapAPI$swap_release(hTTPService);
        return (SwapAPI) h.f(swapAPI$swap_release);
    }

    @Override // javax.inject.Provider
    public SwapAPI get() {
        return swapAPI$swap_release(this.swapHTTPServiceProvider.get());
    }
}