package com.coinbase.wallet.features.swap.prompts;

import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class UnsupportedSwapAssetPrompt_Factory implements d<UnsupportedSwapAssetPrompt> {
    private final Provider<DeepLinkRepository> deepLinkRepositoryProvider;

    public UnsupportedSwapAssetPrompt_Factory(Provider<DeepLinkRepository> provider) {
        this.deepLinkRepositoryProvider = provider;
    }

    public static UnsupportedSwapAssetPrompt_Factory create(Provider<DeepLinkRepository> provider) {
        return new UnsupportedSwapAssetPrompt_Factory(provider);
    }

    public static UnsupportedSwapAssetPrompt newInstance(DeepLinkRepository deepLinkRepository) {
        return new UnsupportedSwapAssetPrompt(deepLinkRepository);
    }

    @Override // javax.inject.Provider
    public UnsupportedSwapAssetPrompt get() {
        return newInstance(this.deepLinkRepositoryProvider.get());
    }
}