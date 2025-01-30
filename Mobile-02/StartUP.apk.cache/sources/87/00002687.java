package com.coinbase.wallet.swap.apis;

import com.coinbase.wallet.http.models.HTTPService;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapAPI_Factory implements f.c.d<SwapAPI> {
    private final Provider<HTTPService> swapHTTPServiceProvider;

    public SwapAPI_Factory(Provider<HTTPService> provider) {
        this.swapHTTPServiceProvider = provider;
    }

    public static SwapAPI_Factory create(Provider<HTTPService> provider) {
        return new SwapAPI_Factory(provider);
    }

    public static SwapAPI newInstance(HTTPService hTTPService) {
        return new SwapAPI(hTTPService);
    }

    @Override // javax.inject.Provider
    public SwapAPI get() {
        return newInstance(this.swapHTTPServiceProvider.get());
    }
}