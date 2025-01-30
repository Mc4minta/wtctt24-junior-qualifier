package com.coinbase.wallet.features.send.prompts;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class HighMinerFeesPrompt_Factory implements d<HighMinerFeesPrompt> {
    private final Provider<StoreInterface> storeProvider;

    public HighMinerFeesPrompt_Factory(Provider<StoreInterface> provider) {
        this.storeProvider = provider;
    }

    public static HighMinerFeesPrompt_Factory create(Provider<StoreInterface> provider) {
        return new HighMinerFeesPrompt_Factory(provider);
    }

    public static HighMinerFeesPrompt newInstance(StoreInterface storeInterface) {
        return new HighMinerFeesPrompt(storeInterface);
    }

    @Override // javax.inject.Provider
    public HighMinerFeesPrompt get() {
        return newInstance(this.storeProvider.get());
    }
}